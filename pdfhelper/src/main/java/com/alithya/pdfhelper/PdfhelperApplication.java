package com.alithya.pdfhelper; 
//import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
 

@SpringBootApplication
public class PdfhelperApplication {
	
	 

	public static void main(String[] args) {
        final ConfigurableApplicationContext context = new SpringApplicationBuilder(
        		PdfhelperApplication.class).headless(false).run(args);   
      String inputURL = "http://localhost:8080/hello";
      String filePath = "C:/Users/mzouihed/Desktop/resultPdf/myPDF.pdf";
      PdfUtil  pdf = context.getBean("pdfUtil" , PdfUtil.class);
       pdf.createPDFForm(inputURL,filePath);
	}
}
