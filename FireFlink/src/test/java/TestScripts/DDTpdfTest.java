package TestScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class DDTpdfTest {
@Test
public void test() throws IOException, SAXException, TikaException {
	 BodyContentHandler ch = new BodyContentHandler();
	 FileInputStream fis=new FileInputStream("./src/test/resources/TestData/VIJAY CV.pdf");
	 Metadata meta = new Metadata();
	 ParseContext parse=new ParseContext();
	 PDFParser pdf=new PDFParser();
	 pdf.parse(fis, ch, meta, parse);
	 System.out.println(ch.toString());
}
}