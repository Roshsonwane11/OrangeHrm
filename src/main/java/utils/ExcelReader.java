package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	 public static List<Map<String, String>> getLoginData(String filePath, String sheetName) throws IOException {
	        List<Map<String, String>> dataList = new ArrayList<>();

	        // Use try-with-resources to automatically close FileInputStream and Workbook
	        try (FileInputStream fis = new FileInputStream(new File(filePath));
	             Workbook workbook = new XSSFWorkbook(fis)) {

	            Sheet sheet = workbook.getSheet(sheetName);

	            if (sheet == null) {
	                throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist in the Excel file.");
	            }

	            // Get the header row
	            Row headerRow = sheet.getRow(0);
	            if (headerRow == null) {
	                throw new IllegalArgumentException("The first row in the sheet is empty or missing.");
	            }
	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                if (row == null) continue; // Skip empty rows

	                Map<String, String> rowData = new HashMap<>();
	                for (int j = 0; j < row.getLastCellNum(); j++) {
	                    String key = headerRow.getCell(j) != null ? headerRow.getCell(j).getStringCellValue() : "";
	                    String value = row.getCell(j) != null ? row.getCell(j).getStringCellValue() : "";
	                    rowData.put(key, value);
	                }

	                dataList.add(rowData);
	            }
	        } catch (IOException e) {
	            throw new IOException("Error reading the Excel file: " + filePath, e);
	        }

	        return dataList;
	    }
}
