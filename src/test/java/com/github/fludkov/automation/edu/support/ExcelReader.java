package com.github.fludkov.automation.edu.support;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    private XSSFSheet excelWSheet;
    private XSSFWorkbook excelWBook;
    private XSSFCell cell;

    // This method is to set the File path and to open the Excel file
    public void setExcelFile(String Path, String SheetName) {
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(SheetName);
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }

public List getRowContains(String testCaseName, int colNum){
        List list = new ArrayList();
        int rowCount = getRowUsed();
        for (int i = 0; i <= rowCount; i++) {
        String cellData = getCellData(i, colNum);
        if (cellData.equalsIgnoreCase(testCaseName)) {
        list.add(i);
        }
        }
        return list;
        }

public int getRowUsed() {
    return excelWSheet.getLastRowNum();
    }


    public String getCellData(int rowNum, int colNum) {
        cell = excelWSheet.getRow(rowNum).getCell(colNum);
        return cell.getStringCellValue();
    }

    public List[] getRowData(int rowNo) {
        List[] arr = new List[1];
        List list = new ArrayList();
        int startCol = 1;
        int totalCols = excelWSheet.getRow(rowNo)
                .getPhysicalNumberOfCells();
        for (int i = startCol; i < totalCols; i++) {
            String cellData = getCellData(rowNo, i);
            list.add(cellData);
        }
        arr[0] = list;
        return arr;
    }


    public Object[][] getTableArray(List<Integer> rowsNo) {
        Object[][] tabArray = new Object[rowsNo.size()][];
        for (int i = 0; i < rowsNo.size(); i++) {
            tabArray[i] = getRowData(rowsNo.get(i));
        }
        return tabArray;
    }
}