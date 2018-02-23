package com.alithya.pdfhelper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Component
public class PdfUtil {

	private static final Logger log = LoggerFactory.getLogger(PdfUtil.class);

	/** create a pdf file from an html page Attention if there a non closed tag in the html page it'll not work
	 * @param filePath
	 * @param inputURL
	 */
	public void createPDFForm(String inputURL , String filePath) {
		
		if (filePath == null || inputURL ==  null){
			log.error("No url or file output path was passsed in the parametres");
			return;
		}
			
		Document document = new Document();
		PdfWriter writer;
		OutputStream oFile;
		InputStream input;  
		
		try {
			oFile = new FileOutputStream(filePath);
			writer = PdfWriter.getInstance(document, oFile);
			document.open();
			// URL(fullUrl+"/webform/pdfForm.do?formNumber="+emp.getFormNumber()+"&toPDF=true").openStream();
			input = new URL(inputURL).openStream();
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, input, Charset.forName(StandardCharsets.UTF_8.name()));
			document.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("File not found", e);
		} catch (DocumentException e) {
			e.printStackTrace();
			log.error("PDF Document error", e);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("IO problem ", e);
		}

	}

}
