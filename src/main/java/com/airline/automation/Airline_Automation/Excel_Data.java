package com.airline.automation.Airline_Automation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class Excel_Data {
	static String mobile_number;
	public void excel_sheet() throws EncryptedDocumentException, IOException {
		FileInputStream location=new FileInputStream("C:\\Users\\ashwathnpj\\javaprograms\\Airline_Automation\\src\\excel\\excel_data.xlsx");
		Workbook w1=WorkbookFactory.create(location);
		mobile_number=NumberToTextConverter.toText(w1.getSheet("Sheet1").getRow(1).getCell(0).getNumericCellValue());
	}
}
