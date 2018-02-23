package com.alithya.pdfhelper;
 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

 

@SpringBootApplication
public class PdfhelperApplication {
	
	public static void main(String[] args) {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder(
        		PdfhelperApplication.class).headless(false).run(args);   
       PdfUtilItext7  pdf = context.getBean("pdfUtilItext7" , PdfUtilItext7.class);
       String ResourcesBaseURI = "C:/Users/mzouihed/Desktop/teluse";
       String outputFileLocation = "C:/Users/mzouihed/Desktop/resultPdf/myPDFItext7.pdf";
      // String inputURL = "file:///C:/Users/mzouihed/Desktop/teluse/templat.html";
       String inputURL = "http://localhost:8080/hello";
        pdf.createPDFForm(inputURL , outputFileLocation, ResourcesBaseURI );
	}
}
