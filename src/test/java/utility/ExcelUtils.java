package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {

	static String  writeExcelPath;
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
	
	public static void createExcel(String sheetName,Map<Integer, Object[]> data) throws IOException 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date = new Date();  
		String dateTime =  formatter.format(date);
		System.out.println(dateTime);  
		//Create Blank workbook
		HSSFWorkbook workbook = new HSSFWorkbook();

		//Create file system using specific name
		writeExcelPath =System.getProperty("user.dir")+"\\"+dateTime+".xls";
		FileOutputStream out = new FileOutputStream(new File(writeExcelPath));
		workbook.createSheet(sheetName);
		workbook.write(out); 
		out.close();

		File   file =    new File(writeExcelPath);
		//Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbookWrite = new HSSFWorkbook(inputStream);
		Sheet sheet = workbookWrite.getSheet(sheetName);

		// This data needs to be written (Object[]) 
		// Iterate over data and write to sheet 
		Set<Integer> keyset = data.keySet(); 
		int rownum = 0; 
		for (Integer key : keyset) { 
			// this creates a new row in the sheet 
			Row row = sheet.createRow(rownum++); 
			Object[] objArr = data.get(key); 
			int cellnum = 0; 
			for (Object obj : objArr) { 
				// this line creates a cell in the next column of that row 
				Cell cell = row.createCell(cellnum++); 
				if (obj instanceof String) 
					cell.setCellValue((String)obj); 
				else if (obj instanceof Integer) 
					cell.setCellValue((Integer)obj); 
			} 
		} 
		try { 
			// this Writes the workbook gfgcontribute 
			FileOutputStream outWrite = new FileOutputStream(new File(writeExcelPath)); 
			workbook.write(outWrite); 
			outWrite.close(); 
			System.out.println("gfgcontribute.xlsx written successfully on disk."); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
} 

	
	
	
	
	
	
	
	
}
