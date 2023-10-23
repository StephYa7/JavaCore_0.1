package Test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;


public class ExcelRedactor {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        File file = new File("src/main/java/Test/1.xlsx");
        File file3 = new File("src/main/java/Test/3.xlsx");

        editXlsx(file, file3);
    }

    public static void editXlsx(File file, File file3) throws IOException {
        XSSFWorkbook book = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream(file3);
        XSSFSheet sheet = book.createSheet("1");
        XSSFWorkbook inputFile = new XSSFWorkbook(new FileInputStream(file));
        XSSFSheet myExcelSheet = inputFile.getSheet("Лист1");
        int index = 0;
        int indexNew = 0;

        try {
            while (true) {
                XSSFRow row = sheet.createRow(indexNew++);
                XSSFRow rowIn = myExcelSheet.getRow(index);
                String name = rowIn.getCell(0).getStringCellValue();
                row.createCell(0).setCellValue(name);
                name = rowIn.getCell(1).getStringCellValue();
                row.createCell(1).setCellValue(name);
                name = rowIn.getCell(2).getStringCellValue();
                row.createCell(2).setCellValue(name);
                name = rowIn.getCell(3).getStringCellValue();
                row.createCell(3).setCellValue(name);
                row = sheet.createRow(indexNew++);
                name = rowIn.getCell(4).getStringCellValue();
                row.createCell(3).setCellValue(name);


                rowIn = myExcelSheet.getRow(index++);
            }
        } catch (Exception e) {
            System.out.println("Exception");
        }
        inputFile.close();
        book.write(fileOut);
        fileOut.close();
    }
}