package be.beniben.cruciblereport.util;

import org.apache.poi.ss.usermodel.*;

import java.util.HashMap;
import java.util.Map;

public class StyleLibrary {

    private static final String CELL_B = "cell_b";
    private static final String CELL_B_CENTERED = "cell_b_centered";
    private static final String CELL_B_DATE = "cell_b_date";
    private static final String CELL_G = "cell_g";
    private static final String CELL_BB = "cell_bb";
    private static final String DATE_D_MMM = "d-mmm";
    private static final String CELL_BG = "cell_bg";
    private static final String CELL_H = "cell_h";
    private static final String CELL_NORMAL = "cell_normal";
    private static final String CELL_NORMAL_DATE = "cell_normal_date";
    private static final String CELL_INDENTED = "cell_indented";
    private static final String CELL_BLUE = "cell_blue";
    public static final String HEADER = "header";
    public static final String CELL_NORMAL_CENTERED = "cell_normal_centered";
    public static final String CELL_NORMAL_CENTERED_WITH_BORDER_MEDIUM = "cell_normal_centered_border_medium";
    public static final String CELL_NORMAL_CENTERED_WITH_BORDER_HARD = "cell_normal_centered_border_hard";

    public static Map<String, CellStyle> STYLES = new HashMap<>();

    public static void initializeStyles(Workbook wb) {
        STYLES = createStyles(wb);
    }
    /**
     * create a library of cell STYLES
     */
    private static Map<String, CellStyle> createStyles(Workbook wb) {
        DataFormat df = wb.createDataFormat();

        CellStyle style;
        Font headerFont = wb.createFont();
        headerFont.setBold(true);
        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerFont.setColor(IndexedColors.OLIVE_GREEN.getIndex());
        style.setFont(headerFont);

        STYLES.put(HEADER, style);

        Font font1 = wb.createFont();
        font1.setBold(true);
        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font1);
        STYLES.put(CELL_B, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font1);
        STYLES.put(CELL_B_CENTERED, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setFont(font1);
        style.setDataFormat(df.getFormat(DATE_D_MMM));
        STYLES.put(CELL_B_DATE, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat(DATE_D_MMM));
        STYLES.put(CELL_G, style);

        Font font2 = wb.createFont();
        font2.setColor(IndexedColors.BLUE.getIndex());
        font2.setBold(true);
        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font2);
        STYLES.put(CELL_BB, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setFont(font1);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setDataFormat(df.getFormat(DATE_D_MMM));
        STYLES.put(CELL_BG, style);

        Font font3 = wb.createFont();
        font3.setFontHeightInPoints((short) 14);
        font3.setColor(IndexedColors.PALE_BLUE.getIndex());
        font3.setBold(true);
        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setFont(font3);
        style.setWrapText(true);
        STYLES.put(CELL_H, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setWrapText(true);
        STYLES.put(CELL_NORMAL, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setWrapText(true);
        STYLES.put(CELL_NORMAL_CENTERED, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.PALE_BLUE.getIndex());

        style.setWrapText(true);
        STYLES.put(CELL_NORMAL_CENTERED_WITH_BORDER_MEDIUM, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderTop(BorderStyle.DOUBLE);
        style.setTopBorderColor(IndexedColors.SKY_BLUE.getIndex());

        style.setWrapText(true);
        STYLES.put(CELL_NORMAL_CENTERED_WITH_BORDER_HARD, style);


        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setWrapText(true);
        style.setDataFormat(df.getFormat(DATE_D_MMM));
        STYLES.put(CELL_NORMAL_DATE, style);

        style = createBorderedStyle(wb);
        style.setAlignment(HorizontalAlignment.LEFT);
        style.setIndention((short) 1);
        style.setWrapText(true);
        STYLES.put(CELL_INDENTED, style);

        style = createBorderedStyle(wb);
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        STYLES.put(CELL_BLUE, style);

        return STYLES;
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
