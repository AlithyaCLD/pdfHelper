package com.alithya.pdfhelper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;

@Component
public class PdfUtilItext7 {

	private static final Logger log = (Logger) LoggerFactory.getLogger(PdfUtilItext7.class);

	/**
	 * @param inputURL
	 *            the html url from we ll create the pdf
	 * @param outputFileLocation
	 *            the path to the location where the pdf file well be saved
	 * @param ResourcesBaseURI
	 *            The path to the folder resources which used in the html file, css,img etc.
	 */
	public void createPDFForm(String inputURL, String outputFileLocation, String ResourcesBaseURI) {
		
		if (inputURL == null || outputFileLocation == null ){
			log.error("No url or file output path passsed in the parametres");
			return;
		}
			
		ConverterProperties props = new ConverterProperties();

		// Set base resources folder uri the hardCoding just for test
		if (ResourcesBaseURI != null)
			props.setBaseUri(ResourcesBaseURI);

		try { 
			OutputStream oFile = new FileOutputStream(outputFileLocation);
			InputStream input = new URL(inputURL).openStream();
			HtmlConverter.convertToPdf(input,oFile ,props); 
			
		} catch (FileNotFoundException e) {
			log.error("File not found", e);
			//e.printStackTrace();
		} catch (MalformedURLException e) {
			log.error("PDF Document error", e);
			//e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
