package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {

	
	 public static String readExcel(String sheetName, int rowNo , int colNo) throws IOException 
	 {
		    //Create an object of File class to open xlsx file
            String excelPath = TestBase.excelPath;
		    File file =    new File(excelPath);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook workbook = null;
		    
		    String fileExtensionName = excelPath.substring(excelPath.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    //	workbook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of HSSFWorkbook class

		    	workbook = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    Sheet s = workbook.getSheet(sheetName);

		    //Find number of rows in excel file

		   // int rowCount = s.getLastRowNum()-s.getFirstRowNum();
		    
		    Row row = s.getRow(rowNo);
		   String cellData = row.getCell(colNo).getStringCellValue();
          
		   return cellData;
	 }
	
	public static void excelToMap() throws IOException 
	{
		
		Map<String,String> m = new HashMap<String, String>();
		 String excelPath = TestBase.excelPath;
		    File file =    new File(excelPath);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		    Workbook workbook = null;
		    
		    String fileExtensionName = excelPath.substring(excelPath.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    //	workbook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of HSSFWorkbook class

		    	workbook = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    Sheet s = workbook.getSheet("new");

		    //Find number of rows in excel file

		    int rowCount = s.getLastRowNum();
		  System.out.println("no of rows : "+rowCount);
		    for(int i=0;i <=rowCount;i++) {
		    Row row = s.getRow(i);
		   String k= row.getCell(0).getStringCellValue();
		   String v = row.getCell(1).getStringCellValue();
		   m.put(k,v);
		   
		    }
		    System.out.println(m);
		    System.out.println("getting base url"+m.get("baseUrl"));
	}
}
