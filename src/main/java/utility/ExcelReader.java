package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {
	String pathOfWorkBook;

	public ExcelReader(String pathOfworkBook) {
		this.pathOfWorkBook = pathOfworkBook;
	}

	public Object[][] getTestDataForDataprovider() {

		HSSFWorkbook workbook = null;
		String xlFilePath = pathOfWorkBook;
		FileInputStream xlFile = null;
		try {
			xlFile = new FileInputStream(xlFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = new HSSFWorkbook(xlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//		int[][] arr=new int[3][3];//3 row and 3 column  
		HSSFSheet sheet = workbook.getSheetAt(0);
		int totalRows = getRows(sheet);	
		int totalColumns=getColumns(sheet);
		int rowIndexOfanArray=totalRows-1;	//-1 because  1st row is an header
		int clmnIndexOfanArray=totalColumns;
		Object[][] arr = new Object[rowIndexOfanArray][];
		for (int k = 0; k <rowIndexOfanArray; k++) {
			Row currentRow = sheet.getRow(k+1);
			arr[k]=new Object[clmnIndexOfanArray];
			for (int m = 0; m <clmnIndexOfanArray; m++) {
				if (currentRow.getCell(m).getCellTypeEnum().toString().equals("STRING"))
				{
					arr[k][m] = currentRow.getCell(m).getStringCellValue().trim();
				}
				else if (currentRow.getCell(m).getCellTypeEnum().toString().equals("NUMERIC"))
				{
					arr[k][m] = Integer.toString((int) currentRow.getCell(m).getNumericCellValue());
				}				
			}
		}
		return arr;
	}
	
	public int getColumns(HSSFSheet sheet)
	{
		return sheet.getRow(0).getLastCellNum();	// this will give you index of last column start from 1
	}
	
	public int getRows(HSSFSheet sheet)
	{
		return sheet.getLastRowNum()+1;			//sheet.getLastRowNum() -- will give you last row number starts from 0 and hence doing +1 
	}
	

}
