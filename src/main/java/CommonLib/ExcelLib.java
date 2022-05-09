package CommonLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	XSSFWorkbook wb;
	FileInputStream fis;
	public ExcelLib(String excelPath){
		File fl = new File(excelPath);
		try {
			fis = new FileInputStream(fl);
			wb= new XSSFWorkbook(fis);
		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public int getRowCount(int sheetNum) {
		int count= wb.getSheetAt(sheetNum).getLastRowNum()+1;
		return count;
		 
	}
	
	public String getCellData(int sheetnum, int row, int col) {
		String data=wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();
		return data;
	}
	

}
