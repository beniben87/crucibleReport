package be.beniben.cruciblereport;

import be.beniben.cruciblereport.model.CruReview;
import be.beniben.cruciblereport.repository.CruReviewRepository;
import be.beniben.cruciblereport.util.SheetUtils;
import be.beniben.cruciblereport.util.StyleLibrary;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static be.beniben.cruciblereport.util.StyleLibrary.*;

public class ReportCreatorService {

    private static final String APPLICATION_CONTEXT = "classpath:application-context.xml";
    private static final String FILE_NAME = "c:/temp/rapportCodeReview";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportCreatorService.class);


    private static final String NB_TOTAL_REVIEWS_TITLE = "Nombre de reviews créées sur le mois :";
    private static final String MOIS = "2018-08";
    private static final String XLSX = ".xlsx";
    private static final String RAPPORT_POUR_LE_MOIS_DE = "Rapport pour le mois de :";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT);
        CruReviewRepository cruReviewRepository = applicationContext.getBean(CruReviewRepository.class);
        LocalDateTime firstDate = LocalDateTime.of(Integer.valueOf(MOIS.substring(0,4)), Integer.valueOf(MOIS.substring(5)), 1, 0, 0);
        LocalDateTime secondDate = firstDate.with(TemporalAdjusters.lastDayOfMonth()).withHour(23);
        List<CruReview> reviews = cruReviewRepository.findAllBycruCreateDateBetween(firstDate
                , secondDate);
        BigDecimal nbReview = BigDecimal.valueOf(reviews.size());
        XSSFWorkbook workbook = new XSSFWorkbook();
        StyleLibrary.initializeStyles(workbook);
        XSSFSheet statSheet = workbook.createSheet("Statistiques");
        XSSFSheet jiraSheet = workbook.createSheet("Jiras");
        XSSFSheet graphSheet = workbook.createSheet("Tendances");

        String[] tabDoneReview = {"Reviewer", "Reviews réalisées", "% de participation"};
        String[] tabDoneComments = {"Reviewer", "Commentaires laissés", "Moyenne de commentaire par review"};
        String[] tabPassedTime = {"Reviewer", "Temps total passé sur les reviews (en min.)"};
        String[] tabDoneDefects = {"Reviewer", "Defects détectés"};
        String[] tabJiras = {"Auteur", "ID du review",	"Statut review",	"Jira",	"Reviewers"	,"Remarques",	"Temps consacré par le reviewer"};

        constructStatSheet(cruReviewRepository, reviews, nbReview, statSheet, tabDoneReview, tabDoneComments, tabPassedTime, tabDoneDefects);
        contructJiraSheet(cruReviewRepository, jiraSheet, tabJiras);

        buildGraphEvoTimeByMois(  buildGraphEvoNbReviews(1, cruReviewRepository, graphSheet)+1, cruReviewRepository, graphSheet);
        autoAjustColumnSize(statSheet, jiraSheet,graphSheet);
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME +  "-" + MOIS + XLSX);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found", e);
        } catch (IOException e) {
            LOGGER.error("Error input", e);
        }

    }

    private static int buildGraphEvoNbReviews(int start, CruReviewRepository cruReviewRepository, XSSFSheet sheet) {
        LocalDateTime lastDate = LocalDateTime.of(Integer.valueOf(MOIS.substring(0,4)), Integer.valueOf(MOIS.substring(5)), 1, 0, 0).with(TemporalAdjusters.lastDayOfMonth()).withHour(23);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Object[]> nbreviewsByMonth = cruReviewRepository.findTotalReviewsByMonth(lastDate.format(formatter));
        int rowNum = start;
        Row row = sheet.createRow(rowNum++);
        SheetUtils.createCell(row, 0, "Mois", HEADER);
        SheetUtils.createCell(row, 1, "Nombre de revue", HEADER);
        for (Object[] entry : nbreviewsByMonth) {
            row = sheet.createRow(rowNum++);
            SheetUtils.createCell(row, 0, (String) entry[0], CELL_NORMAL_CENTERED);
            SheetUtils.createCell(row, 1, ((BigDecimal)entry[1]).doubleValue(), CELL_NORMAL_CENTERED);
        }
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 3, start, 10, rowNum++);

        Chart chart = drawing.createChart(anchor);
        ((XSSFChart)chart).setTitleText("évolution mensuelle du nombre \r\n de code reviews effectués");
        CTChart ctChart = ((XSSFChart) chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        CTBarChart ctBarChart = ctPlotArea.addNewBarChart();
        CTBoolean ctBoolean = ctBarChart.addNewVaryColors();
        ctBoolean.setVal(true);
        ctBarChart.addNewBarDir().setVal(STBarDir.COL);
        constructChart(start, sheet, rowNum, ctBarChart);
        finalizeGraph(ctChart, ctPlotArea, ctBarChart);
        return rowNum;

    }

    private static void constructChart(int start, XSSFSheet sheet, int rowNum, CTBarChart ctBarChart) {
        for (int r = start + 2; r < rowNum; r++) {
            CTBarSer ctBarSer = ctBarChart.addNewSer();
            CTSerTx ctSerTx = ctBarSer.addNewTx();
            CTStrRef ctStrRef = ctSerTx.addNewStrRef();
            ctStrRef.setF(sheet.getSheetName() + "!$A$" + r);
            ctBarSer.addNewIdx().setVal(r);
            CTAxDataSource cttAxDataSource = ctBarSer.addNewCat();
            ctStrRef = cttAxDataSource.addNewStrRef();
            ctStrRef.setF(sheet.getSheetName() + "!$A$1");
            CTNumDataSource ctNumDataSource = ctBarSer.addNewVal();
            CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
            ctNumRef.setF(sheet.getSheetName() + "!$B$" + r);


            //at least the border lines in Libreoffice Calc ;-)
            ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0, 0, 0});

        }
    }

    private static int buildGraphEvoTimeByMois(int start, CruReviewRepository cruReviewRepository, XSSFSheet sheet) {
        LocalDateTime lastDate = LocalDateTime.of(Integer.valueOf(MOIS.substring(0,4)), Integer.valueOf(MOIS.substring(5)), 1, 0, 0).with(TemporalAdjusters.lastDayOfMonth()).withHour(23);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Object[]> nbreviewsByMonth = cruReviewRepository.findTotalSpentTimeByMonth(lastDate.format(formatter));
        int rowNum = start;
        Row row = sheet.createRow(rowNum++);
        SheetUtils.createCell(row, 0, "Mois", HEADER);
        SheetUtils.createCell(row, 1, "Temps consacré (en heure)", HEADER);
        for (Object[] entry : nbreviewsByMonth) {
            row = sheet.createRow(rowNum++);
            SheetUtils.createCell(row, 0, (String) entry[0], CELL_NORMAL_CENTERED);
            double time = ((BigDecimal)entry[1]).divide(BigDecimal.valueOf(60.),2,RoundingMode.HALF_UP).doubleValue();
            SheetUtils.createCell(row, 1, time, CELL_NORMAL_CENTERED);
        }
        Drawing drawing = sheet.createDrawingPatriarch();
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 3, start, 10, rowNum++);

        Chart chart = drawing.createChart(anchor);
        ((XSSFChart)chart).setTitleText("évolution mensuelle du temps passé sur les reviews");
        CTChart ctChart = ((XSSFChart) chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        CTBarChart ctBarChart = ctPlotArea.addNewBarChart();
        CTBoolean ctBoolean = ctBarChart.addNewVaryColors();
        ctBoolean.setVal(true);
        ctBarChart.addNewBarDir().setVal(STBarDir.COL);

        constructChart(start, sheet, rowNum, ctBarChart);
        finalizeGraph(ctChart, ctPlotArea, ctBarChart);
        return rowNum;

    }

    private static void finalizeGraph(CTChart ctChart, CTPlotArea ctPlotArea, CTBarChart ctBarChart) {
        //telling the BarChart that it has axes and giving them Ids
        ctBarChart.addNewAxId().setVal(123456);
        ctBarChart.addNewAxId().setVal(123457);

        //cat axis
        CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
        ctCatAx.addNewAxId().setVal(123456); //id of the cat axis
        CTScaling ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx.addNewDelete().setVal(false);
        ctCatAx.addNewAxPos().setVal(STAxPos.B);
        ctCatAx.addNewCrossAx().setVal(123457); //id of the val axis
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //val axis
        CTValAx ctValAx = ctPlotArea.addNewValAx();
        ctValAx.addNewAxId().setVal(123457); //id of the val axis
        ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx.addNewDelete().setVal(false);
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(123456); //id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        //legend
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(false);
    }

    private static void autoAjustColumnSize(XSSFSheet... sheets) {
        for (int i = 0; i < 10; i++) {
            for (XSSFSheet sheet:sheets) {
                sheet.autoSizeColumn(i);
           }
        }
    }

    private static void contructJiraSheet(CruReviewRepository cruReviewRepository, XSSFSheet jiraSheet, String[] tabJiras) {
        int rowNum = 0;
        List<Object[]> reviewByTicket = cruReviewRepository.findReviewByTicket(MOIS);

        Row row = jiraSheet.createRow(rowNum++);
        int colNum = 0;
        for (String field : tabJiras) {
            SheetUtils.createCell(row, colNum++, field, HEADER);
        }
        String lastReviewId = null ;
        String style;
        String lastAuthor = null ;
        for (Object[] entry : reviewByTicket) {
            if(lastReviewId!= null && !lastReviewId.equals(String.valueOf(entry[1])) ){
                style = CELL_NORMAL_CENTERED_WITH_BORDER_MEDIUM;
            } else {
                style = CELL_NORMAL_CENTERED;
            }
            if(lastAuthor!= null && !entry[0].equals(lastAuthor)){
                style = CELL_NORMAL_CENTERED_WITH_BORDER_HARD;
            }
            colNum = 0;
            row = jiraSheet.createRow(rowNum++);
            SheetUtils.createCell(row, colNum++, entry[0].equals(lastAuthor) ? "" : (String) entry[0], style);
            lastAuthor = (String) entry[0];
            SheetUtils.createCell(row, colNum++, String.valueOf(entry[1]).equals(lastReviewId) ? "" : String.valueOf(entry[1]), style);
            SheetUtils.createCell(row, colNum++, String.valueOf(entry[1]).equals(lastReviewId) ? "" : (String) entry[2], style);
            SheetUtils.createCell(row, colNum++, String.valueOf(entry[1]).equals(lastReviewId) ? "" : (String) entry[3], style);
            SheetUtils.createCell(row, colNum++, (String) entry[4], style);
            SheetUtils.createCell(row, colNum++, String.valueOf(entry[5]), style);
            SheetUtils.createCell(row, colNum++, (String) entry[6], style);
            lastReviewId = String.valueOf(entry[1]);

        }
    }


    private static void constructStatSheet(CruReviewRepository cruReviewRepository, List<CruReview> reviews, BigDecimal nbReview, XSSFSheet sheet1, String[] tabDoneReview, String[] tabDoneComments, String[] tabPassedTime, String[] tabDoneDefects) {
        int rowNum = 0;
        // Nb Review sur le mois
        Row row1 = sheet1.createRow(rowNum++);
        SheetUtils.createCell(row1, 0, RAPPORT_POUR_LE_MOIS_DE, HEADER);
        SheetUtils.createCell(row1, 1, Month.of(Integer.valueOf(MOIS.substring(5))).getDisplayName(TextStyle.SHORT, Locale.FRENCH) +" " + MOIS.substring(0,4), CELL_NORMAL_CENTERED);
        row1 = sheet1.createRow(rowNum++);
        SheetUtils.createCell(row1, 0, NB_TOTAL_REVIEWS_TITLE, HEADER);
        SheetUtils.createCell(row1, 1, String.valueOf(reviews.size()), CELL_NORMAL_CENTERED);
        rowNum++;
        rowNum++;

        // Reviewes réalisées par reviewer avec pourcentage de participation
        Row row = sheet1.createRow(rowNum++);
        int colNum = 2;
        List<Object[]> reviewsByUserOnAMonth = cruReviewRepository.findNbReviewsByUserOnAMonth(MOIS);
        for (String field : tabDoneReview) {
            SheetUtils.createCell(row, colNum++, field, HEADER);
        }
        Map<String, BigDecimal> commetsByUser = new HashMap<>();
        for (Object[] entry : reviewsByUserOnAMonth) {
            colNum = 2;
            row = sheet1.createRow(rowNum++);
            SheetUtils.createCell(row, colNum++, (String) entry[0], CELL_NORMAL_CENTERED);
            SheetUtils.createCell(row, colNum++, String.valueOf(entry[1]), CELL_NORMAL_CENTERED);
            commetsByUser.put((String) entry[0], (BigDecimal) entry[1]);
            BigDecimal pourcentage = ((BigDecimal) entry[1]).divide(nbReview, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
            SheetUtils.createCell(row, colNum++, String.valueOf(pourcentage.setScale(2)), CELL_NORMAL_CENTERED);

        }

        // temps total passé
        List<Object[]> timeByReviewer = cruReviewRepository.getTotalTimePassedByMonthByReviewer(MOIS);

        rowNum++;
        row = sheet1.createRow(rowNum++);

        colNum = 2;
        for (String field : tabPassedTime) {
            SheetUtils.createCell(row, colNum++, field, HEADER);

        }
        for (Object[] entry : timeByReviewer) {
            colNum = 2;
            row = sheet1.createRow(rowNum++);
            SheetUtils.createCell(row, colNum++, (String) entry[0], CELL_NORMAL_CENTERED);
            SheetUtils.createCell(row, colNum++, String.valueOf(entry[1]), CELL_NORMAL_CENTERED);
        }

        //Nb commmentaires laissés par le reviewer sur un mois
        List<Object[]> commentsByUserByReviewOnAMonth = cruReviewRepository.findNbCommentsByUserByReviewOnAMonth(MOIS);

        rowNum++;
        row = sheet1.createRow(rowNum++);

        colNum = 2;
        for (String field : tabDoneComments) {
            SheetUtils.createCell(row, colNum++, field, HEADER);

        }
        for (Object[] entry : commentsByUserByReviewOnAMonth) {
            colNum = 2;
            row = sheet1.createRow(rowNum++);
            SheetUtils.createCell(row, colNum++, (String) entry[0], CELL_NORMAL_CENTERED);
            SheetUtils.createCell(row, colNum++, String.valueOf(entry[1]), CELL_NORMAL_CENTERED);
            BigDecimal moyenne = ((BigDecimal) entry[1]).divide(commetsByUser.get(entry[0]), 4, RoundingMode.HALF_UP);
            SheetUtils.createCell(row, colNum++, String.valueOf(moyenne.setScale(2,RoundingMode.HALF_UP)), CELL_NORMAL_CENTERED);
        }

        // Nb defects par reviewer
        List<Object[]> detectedDefectsByUser = cruReviewRepository.findDetectedDefectsByReviewerOnAMonth(MOIS);

        rowNum++;
        row = sheet1.createRow(rowNum++);
        colNum = 2;
        for (String field : tabDoneDefects) {
            SheetUtils.createCell(row, colNum++, field, HEADER);

        }
        colNum = 2;
        if(CollectionUtils.isNotEmpty(detectedDefectsByUser)) {
            for (Object[] entry : detectedDefectsByUser) {
                row = sheet1.createRow(rowNum++);
                SheetUtils.createCell(row, colNum++, (String) entry[0], CELL_NORMAL_CENTERED);
                SheetUtils.createCell(row, colNum++, String.valueOf(entry[1]), CELL_NORMAL_CENTERED);
            }
        } else {
            row = sheet1.createRow(rowNum++);
            SheetUtils.createCell(row, colNum++, "/", CELL_NORMAL_CENTERED);
            SheetUtils.createCell(row, colNum++, "Pas de defects remontés par l'équipe", CELL_NORMAL_CENTERED);
        }
    }

}
