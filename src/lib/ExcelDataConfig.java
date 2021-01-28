package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	
	XSSFSheet sheet1;
	
	FileOutputStream fout;
	String filePath = "";
	
	
	public ExcelDataConfig(String excelpath)
	{
	
	try {
		File src = new File(excelpath);
		
		FileInputStream fis= new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);
		
		//fout = new FileOutputStream(src);
		filePath=excelpath;
		
		
		
		
		
	} 
	catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}
	
	public String getData(int sheetnumber, int row, int column) {
		
		sheet1= wb.getSheetAt(sheetnumber);
		
		String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		
		return data;
		
		
		
	}
	
	
	
	public String getNumericData(int sheetnumber, int row, int column) {
	
	sheet1= wb.getSheetAt(sheetnumber);
	
	String data=String.valueOf((int) sheet1.getRow(row).getCell(column).getNumericCellValue());
	
	return data;
	
	
	
}
	
public String getDateData(int sheetnumber, int row, int column) {
		
		sheet1= wb.getSheetAt(sheetnumber);
		
		Date data=sheet1.getRow(row).getCell(column).getDateCellValue();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
		
        String strDate = dateFormat.format(data);
				
		return strDate;
		
		
		
	}
	
	public int getrownum(int sheetnumber){
		
		sheet1= wb.getSheetAt(sheetnumber);
		
		int rowcount=sheet1.getLastRowNum();
		
		return rowcount;
		
	}
	
	public int getcolnum(int sheetnumber, int row) {
		
		sheet1= wb.getSheetAt(sheetnumber);
		
		int colcount=sheet1.getRow(row).getLastCellNum();
		
		return colcount;
	}
	
	
	
	public void  writeData(int sheetnumber, int row, int column, String message) throws Exception {
		
	
		
	    
		sheet1= wb.getSheetAt(sheetnumber);
		
		sheet1.getRow(row).createCell(column).setCellValue(message);
		
		//fout= new FileOutputStream(src);
		fout=new FileOutputStream(filePath);
		wb.write(fout);
		
		fout.close();
		
		System.out.println("Excel write completed");
		
	
			
		}
		
	
}
