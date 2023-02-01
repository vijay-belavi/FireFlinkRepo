package TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DDtsTest {
@Test
public void test() throws EncryptedDocumentException, IOException
{
	File file=new File("./TestData1/Book1.xlsx");
	FileInputStream fis=new FileInputStream(file);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row r=sh.getRow(0);
	Cell c = r.getCell(0);
	System.out.println(c.toString());
	
}
}
