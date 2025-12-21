//package com.pages;
//
//import java.io.FileInputStream;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.utils.ExcelReader;
//
//public class ReadExcelData {
//	
//	
//	public static Map<String, String> getTestData(
//            String filePath,
//            String sheetName,
//            String testCaseId) {
//
//        Map<String, String> dataMap = new HashMap<>();
//
//        try (FileInputStream fis = new FileInputStream(filePath);
//        		Workbook wb = new XSSFWorkbook(fis)) {
//        	
//        	
//            Sheet sheet = wb.getSheet(sheetName);
//            if (sheet == null) {
//                throw new RuntimeException("Sheet not found: " + sheetName);
//            }
//
//            Row headerRow = sheet.getRow(0);
//
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//                Row currentRow = sheet.getRow(i);
//                if (currentRow == null) continue;
//
//                Cell tcCell = currentRow.getCell(0);
//                if (tcCell == null) continue;
//
//                if (tcCell.getStringCellValue().equalsIgnoreCase(testCaseId)) {
//
//                    for (int j = 1; j < headerRow.getLastCellNum(); j++) {
//                        String key = headerRow.getCell(j).getStringCellValue();
//                        String value = currentRow.getCell(j).toString();
//                        dataMap.put(key, value);
//                    }
//                    break;
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dataMap;
//    }
//
//	public static void main(String[] args) {
//		
//		
//		String filePath = "/Users/prakashmohanraopatil/Desktop/Worksheet.xls";
//        String sheetName = "Sheet1";
//        String testCaseId = "TC01";
//
//        Map<String, String> testData =ReadExcelData.getTestData(filePath, sheetName, testCaseId);
//
//        System.out.println("Username: " + testData.get("username"));
//        System.out.println("Password: " + testData.get("password"));
//      //  System.out.println("Role: " + testData.get("Role"));
//    }
//		
//		
//		
//
//	}
//
//
