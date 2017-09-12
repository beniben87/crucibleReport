package be.beniben.cruciblereport;

import be.beniben.cruciblereport.model.CruReview;
import be.beniben.cruciblereport.repository.CruReviewRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ReportCreatorService {

    private static final String APPLICATION_CONTEXT = "classpath:application-context.xml";
    private static final String FILE_NAME = "c:/temp/rapportCodeReview";
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportCreatorService.class);
    private static final String HEADER = "header";
    private static final String CELL_B = "cell_b";
    private static final String CELL_B_CENTERED = "cell_b_centered";
    private static final String CELL_B_DATE = "cell_b_date";
    private static final String CELL_G = "cell_g";
    private static final String CELL_BB = "cell_bb";
    private static final String DATE_D_MMM = "d-mmm";
    private static final String CELL_BG = "cell_bg";
    private static final String CELL_H = "cell_h";
    private static final String CELL_NORMAL = "cell_normal";
    private static final String CELL_NORMAL_CENTERED = "cell_normal_centered";
    private static final String  CELL_NORMAL_CENTERED_WITH_BORDER_MEDIUM = "cell_normal_centered_border_medium";
    private static final String CELL_NORMAL_DATE = "cell_normal_date";
    private static final String CELL_INDENTED = "cell_indented";
    private static final String CELL_BLUE = "cell_blue";
    private static final String NB_TOTAL_REVIEWS_TITLE = "Nombre de reviews créées sur le mois :";
    private static final String MOIS = "2017-08";
    private static final String XLSX = ".xlsx";
    public static final String RAPPORT_POUR_LE_MOIS_DE = "Rapport pour le mois de :";
    private static final String CELL_NORMAL_CENTERED_WITH_BORDER_HARD = "cell_normal_centered_border_hard";
    private static Map<String, CellStyle> styles;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT);
        CruReviewRepository cruReviewRepository = applicationContext.getBean(CruReviewRepository.class);
        LocalDateTime firstDate = LocalDateTime.of(Integer.valueOf(MOIS.substring(0,4)), Integer.valueOf(MOIS.substring(5)), 1, 0, 0);
        LocalDateTime secondDate = firstDate.with(TemporalAdjusters.lastDayOfMonth()).withHour(23);
        List<CruReview> reviews = cruReviewRepository.findAllBycruCreateDateBetween(firstDate
                , secondDate);
        BigDecimal nbReview = BigDecimal.valueOf(reviews.size());
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statSheet = workbook.createSheet("Statistiques");
        XSSFSheet jiraSheet = workbook.createSheet("Jiras");

        String[] tabDoneReview = {"Reviewer", "Reviews réalisées", "% de participation"};
        String[] tabDoneComments = {"Reviewer", "Commentaires laissés", "Moyenne de commentaire par review"};
        String[] tabPassedTime = {"Reviewer", "Temps total passé sur les reviews (en min.)"};
        String[] tabDoneDefects = {"Reviewer", "Defects détectés"};
        String[] tabJiras = {"Auteur", "ID du review",	"Statut review",	"Jira",	"Reviewers"	,"Remarques",	"Temps consacré par le reviewer"};

        styles = createStyles(workbook);

        constructStatSheet(cruReviewRepository, reviews, nbReview, statSheet, tabDoneReview, tabDoneComments, tabPassedTime, tabDoneDefects);
        contructJiraSheet(cruReviewRepository, jiraSheet, tabJiras);
        autoAjustColumnSize(statSheet, jiraSheet);
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

    private static void autoAjustColumnSize(XSSFSheet statSheet, XSSFSheet jiraSheet) {
        for (int i = 0; i < 10; i++) {
            statSheet.autoSizeColumn(i);
            jiraSheet.autoSizeColumn(i);
        }
    }

    private static void contructJiraSheet(CruReviewRepository cruReviewRepository, XSSFSheet jiraSheet, String[] tabJiras) {
        int rowNum = 0;
        List<Object[]> reviewByTicket = cruReviewRepository.findReviewByTicket(MOIS);

        Row row = jiraSheet.createRow(rowNum++);
        int colNum = 0;
        for (String field : tabJiras) {
            createCell(row, colNum++, field, HEADER);
        }
        String lastReviewId = null ;
        String style = null;
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
            createCell(row, colNum++, entry[0].equals(lastAuthor) ? "" : (String) entry[0], style);
            lastAuthor = (String) entry[0];
            createCell(row, colNum++, String.valueOf(entry[1]).equals(lastReviewId) ? "" : String.valueOf(entry[1]), style);
            createCell(row, colNum++, String.valueOf(entry[1]).equals(lastReviewId) ? "" : (String) entry[2], style);
            createCell(row, colNum++, String.valueOf(entry[1]).equals(lastReviewId) ? "" : (String) entry[3], style);
            createCell(row, colNum++, (String) entry[4], style);
            createCell(row, colNum++, String.valueOf(entry[5]), style);
            createCell(row, colNum++, (String) entry[6], style);
            lastReviewId = String.valueOf(entry[1]);

        }
    }


    private static void constructStatSheet(CruReviewRepository cruReviewRepository, List<CruReview> reviews, BigDecimal nbReview, XSSFSheet sheet1, String[] tabDoneReview, String[] tabDoneComments, String[] tabPassedTime, String[] tabDoneDefects) {
        int rowNum = 0;
        // Nb Review sur le mois
        Row row1 = sheet1.createRow(rowNum++);
        createCell(row1, 0, RAPPORT_POUR_LE_MOIS_DE, HEADER);
        createCell(row1, 1, Month.of(Integer.valueOf(MOIS.substring(5))).getDisplayName(TextStyle.SHORT, Locale.FRENCH) +" " + MOIS.substring(0,4), CELL_NORMAL_CENTERED);
        row1 = sheet1.createRow(rowNum++);
        createCell(row1, 0, NB_TOTAL_REVIEWS_TITLE, HEADER);
        createCell(row1, 1, String.valueOf(reviews.size()), CELL_NORMAL_CENTERED);
        rowNum++;
        rowNum++;

        // Reviewes réalisées par reviewer avec pourcentage de participation
        Row row = sheet1.createRow(rowNum++);
        int colNum = 2;
        List<Object[]> reviewsByUserOnAMonth = cruReviewRepository.findNbReviewsByUserOnAMonth(MOIS);
        for (String field : tabDoneReview) {
            createCell(row, colNum++, field, HEADER);
        }
        Map<String, BigDecimal> commetsByUser = new HashMap<>();
        for (Object[] entry : reviewsByUserOnAMonth) {
            colNum = 2;
            row = sheet1.createRow(rowNum++);
            createCell(row, colNum++, (String) entry[0], CELL_NORMAL_CENTERED);
            createCell(row, colNum++, String.valueOf(entry[1]), CELL_NORMAL_CENTERED);
            commetsByUser.put((String) entry[0], (BigDecimal) entry[1]);
            BigDecimal pourcentage = ((BigDecimal) entry[1]).divide(nbReview, 4, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
            createCell(row, colNum++, String.valueOf(pourcentage.setScale(2)), CELL_NORMAL_CENTERED);

        }

        // temps total passé
        List<Object[]> timeByReviewer = cruReviewRepository.getTotalTimePassedByMonthByReviewer(MOIS);

        rowNum++;
        row = sheet1.createRow(rowNum++);

        colNum = 2;
        for (String field : tabPassedTime) {
            createCell(row, colNum++, field, HEADER);

        }
        for (Object[] entry : timeByReviewer) {
            colNum = 2;
            row = sheet1.createRow(rowNum++);
            createCell(row, colNum++, (String) entry[0], CELL_NORMAL_CENTERED);
            createCell(row, colNum++, String.valueOf(entry[1]), CELL_NORMAL_CENTERED);
        }

        //Nb commmentaires laissés par le reviewer sur un mois
        List<Object[]> commentsByUserByReviewOnAMonth = cruReviewRepository.findNbCommentsByUserByReviewOnAMonth(MOIS);

        rowNum++;
        row = sheet1.createRow(rowNum++);

        colNum = 2;
        for (String field : tabDoneComments) {
            createCell(row, colNum++, field, HEADER);

        }
        for (Object[] entry : commentsByUserByReviewOnAMonth) {
            colNum = 2;
            row = sheet1.createRow(rowNum++);
            createCell(row, colNum++, (String) entry[0], CELL_NORMAL_CENTERED);
            createCell(row, colNum++, String.valueOf(entry[1]), CELL_NORMAL_CENTERED);
            BigDecimal moyenne = ((BigDecimal) entry[1]).divide(commetsByUser.get(entry[0]), 4, RoundingMode.HALF_UP);
            createCell(row, colNum++, String.valueOf(moyenne.setScale(2,RoundingMode.HALF_UP)), CELL_NORMAL_CENTERED);
        }

        // Nb defects par reviewer
        List<Object[]> detectedDefectsByUser = cruReviewRepository.findDetectedDefectsByReviewerOnAMonth(MOIS);

        rowNum++;
        row = sheet1.createRow(rowNum++);
        colNum = 2;
        for (String field : tabDoneDefects) {
            createCell(row, colNum++, field, HEADER);

        }
        colNum = 2;
        if(CollectionUtils.isNotEmpty(detectedDefectsByUser)) {
            for (Object[] entry : detectedDefectsByUser) {
                row = sheet1.createRow(rowNum++);
                createCell(row, colNum++, (String) entry[0], CELL_NORMAL_CENTERED);
                createCell(row, colNum++, String.valueOf(entry[1]), CELL_NORMAL_CENTERED);
            }
        } else {
            row = sheet1.createRow(rowNum++);
            createCell(row, colNum++, "/", CELL_NORMAL_CENTERED);
            createCell(row, colNum++, "Pas de defects remontés par l'équipe", CELL_NORMAL_CENTERED);
        }
    }

    private static void createCell(Row row1, int pos, String cellValue, String cellStyle) {
        Cell cell1 = row1.createCell(pos);
        cell1.setCellValue(cellValue);
        cell1.setCellStyle(styles.get(cellStyle));
    }


    /**
     * create a library of cell styles
     */
    private static Map<String, CellStyle> createStyles(Workbook wb) {
        DataFormat df = wb.createDataFormat();
        Map<String, CellStyle> styles = new HashMap<>();

        CellStyle style;
        Font headerFont = wb.createFont();
        headerFont.setBold(true);
        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerFont.setColor(IndexedColors.OLIVE_GREEN.getIndex());
        style.setFont(headerFont);

        styles.put(HEADER, style);

        Font font1 = wb.createFont();
        font1.setBold(true);
        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font1);
        styles.put(CELL_B, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font1);
        styles.put(CELL_B_CENTERED, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setFont(font1);
        style.setDataFormat(df.getFormat(DATE_D_MMM));
        styles.put(CELL_B_DATE, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat(DATE_D_MMM));
        styles.put(CELL_G, style);

        Font font2 = wb.createFont();
        font2.setColor(IndexedColors.BLUE.getIndex());
        font2.setBold(true);
        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font2);
        styles.put(CELL_BB, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat(DATE_D_MMM));
        styles.put(CELL_BG, style);

        Font font3 = wb.createFont();
        font3.setFontHeightInPoints((short) 14);
        font3.setColor(IndexedColors.PALE_BLUE.getIndex());
        font3.setBold(true);
        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font3);
        style.setWrapText(true);
        styles.put(CELL_H, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setWrapText(true);
        styles.put(CELL_NORMAL, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setWrapText(true);
        styles.put(CELL_NORMAL_CENTERED, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.PALE_BLUE.getIndex());

        style.setWrapText(true);
        styles.put(CELL_NORMAL_CENTERED_WITH_BORDER_MEDIUM, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderTop(BorderStyle.DOUBLE);
        style.setTopBorderColor(IndexedColors.SKY_BLUE.getIndex());

        style.setWrapText(true);
        styles.put(CELL_NORMAL_CENTERED_WITH_BORDER_HARD, style);


        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setWrapText(true);
        style.setDataFormat(df.getFormat(DATE_D_MMM));
        styles.put(CELL_NORMAL_DATE, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setIndention((short) 1);
        style.setWrapText(true);
        styles.put(CELL_INDENTED, style);

        style = createBorderedStyle(wb);
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styles.put(CELL_BLUE, style);

        return styles;
    }

    private static CellStyle createBorderedStyle(Workbook wb) {
        BorderStyle thin = BorderStyle.THIN;
        short black = IndexedColors.BLACK.getIndex();

        CellStyle style = wb.createCellStyle();
        style.setBorderRight(thin);
        style.setRightBorderColor(black);
        style.setBorderBottom(thin);
        style.setBottomBorderColor(black);
        style.setBorderLeft(thin);
        style.setLeftBorderColor(black);
        style.setBorderTop(thin);
        style.setTopBorderColor(black);
        return style;
    }
}
