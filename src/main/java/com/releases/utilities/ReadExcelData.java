package com.releases.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public List<Map<String, String>> getTestData(String FileName) throws Exception{

		List<Map<String, String>>  testDataRows = null;
		Map<String, String>  testData = null;
		//getting file path
		FileInputStream fis =  new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\ReleasesData.xlsx");
		Workbook wb=null;
		//extracting extension of file name
        String fileExtensionName = FileName.substring(FileName.indexOf("."));
		//selecting the file extension type to select the workbook type
		if(fileExtensionName.equalsIgnoreCase(".xlsx")) {
			wb = new XSSFWorkbook(fis);
		}else if(fileExtensionName.equalsIgnoreCase(".xls")) {
			wb = new HSSFWorkbook(fis);
		}

		Sheet sheet=wb.getSheetAt(0);
		//no of data rows
		int lastRowNum = 1;
		// storing number of header rows
		int lastColumnNum = 7;


		//to store head row values
		List<String> list = new ArrayList<String>();

		//iterating through the column to get Heading values
		for(int i = 0;i<lastColumnNum;i++) {
			//to get the row
			Row row = sheet.getRow(0);
			//navigating through the cell
			Cell cell = row.getCell(i);
			String rowHeaderValue = null;
			if(cell.getCellType()==CellType.STRING) 
			    rowHeaderValue = cell.getStringCellValue(); 
			else if(cell.getCellType()==CellType.NUMERIC) 
			    rowHeaderValue = String.valueOf(cell.getNumericCellValue());
			//adding header values to list
			list.add(rowHeaderValue); 

		}

		testDataRows = new ArrayList<Map<String, String>>();
		//getting row values under each heading
		//storing key and respective values in list
		for(int j=1;j<=lastRowNum;j++) {
			Row row = sheet.getRow(j);	
			testData = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER); //tree map preserves insertion order
			for(int k =0;k<lastColumnNum;k++) {
				Cell cell = row.getCell(k);
				String columnValue = null;
				if(cell==null) {

				}
				else{
					if(cell.getCellType()==CellType.STRING) 
					    columnValue = cell.getStringCellValue().trim(); 
					else if(cell.getCellType()==CellType.NUMERIC) 
					    columnValue = String.valueOf(cell.getNumericCellValue()).trim();
				}
				// assigning values to key
				testData.put((String) list.get(k), columnValue);
				
			}
			testDataRows.add(testData);
		}
		return testDataRows;



	}


}
