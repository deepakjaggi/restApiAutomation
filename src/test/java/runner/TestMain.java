package runner;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.junit.runner.JUnitCore;

public class TestMain
{
	public static void main(String[] args) throws IOException
	{
		JUnitCore jUnitCore = new JUnitCore();
		HSSFWorkbook workbook = null;
		String driverFilePath = System.getProperty("user.dir") + "/src/test/resources/Driver.xls";
		System.out.println(driverFilePath);
		FileInputStream xlFile = new FileInputStream(driverFilePath);
		workbook = new HSSFWorkbook(xlFile);
		HSSFSheet sheet = workbook.getSheetAt(0);
		int firstRow = sheet.getFirstRowNum();
		// in POI -- row number starts from 0
		//Hi
		int lastRow = sheet.getLastRowNum();
		int totalRows = lastRow - firstRow + 1;
		for (int k = 1; k < totalRows; k++)
		{
			Row currentRow = sheet.getRow(k);
			String moduleName = currentRow.getCell(1).getStringCellValue().trim().toUpperCase();
			String status=currentRow.getCell(0).getStringCellValue().trim().toUpperCase();
			switch (moduleName) {
			case "TESTSUMEXECUTION":
				if (status.equals("Y"))
				{
					System.out.println("Executing SUM Module");
					//jUnitCore.run(TestSumExecution.class);
					//sysoRaniNew
				}
				break;
			case "TESTMULEXECUTION":
				if (status.equals("Y"))
				{
					System.out.println("Executing Mul Module");
					//jUnitCore.run(TestMulExecution.class);
					//syso
				}				
				break;
			default:
				break;
			}
		}
		workbook.close();
	}
}
