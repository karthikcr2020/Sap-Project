package platform_Sign_up;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileLibrary {

	
	public String getCellData(String excelfile ,String sheet,int row ,int cell) throws Throwable{
		
		       FileInputStream fis = new FileInputStream(excelfile);
		       Workbook wb = WorkbookFactory.create(fis);
		       String excelvalue = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		       return excelvalue;	       
	}

}
