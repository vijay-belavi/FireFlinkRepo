package TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDT_practiceTest {
	static Object readExcel(String SheetName) throws EncryptedDocumentException, IOException
	{
		File f = new File("./TestData1/Book1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int row = sh.getPhysicalNumberOfRows();
		int cell = sh.getRow(0).getPhysicalNumberOfCells();
		Object [][] arr = new Object [row-1][cell];
		for (int i = 1; i < row; i++)
			for (int j = 0; j < cell; j++) {
				arr[i-1][j]=wb.getSheet("Sheet1").getRow(i).getCell(j).toString();
			}
		return arr;
	}	
	@Test
	public void test() throws EncryptedDocumentException, IOException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--headless");
		readExcel("Sheet1");
	}
}