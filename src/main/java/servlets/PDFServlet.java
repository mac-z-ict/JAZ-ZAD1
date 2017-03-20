package servlets;
//
//import java.awt.Color;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
//@WebServlet("/pdf")
//public class PDFServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//
//
//	public static void createSamplePDF(String header[], String body[][]) throws Exception{
//	    Document documento = new Document();
//	    //Create new File
//	    File file = new File("/opt/devel/workspace/newFileName.pdf");
//	    file.createNewFile();
//	    FileOutputStream fop = new FileOutputStream(file);
//	    PdfWriter.getInstance(documento, fop);
//	    documento.open(); 
//	    //Fonts
//	    Font fontHeader = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
//	    Font fontBody = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL);
//	    //Table for header
//	    PdfPTable cabetabla = new PdfPTable(header.length);
//	    for (int j = 0; j < header.length; j++) {
//	        Phrase frase = new Phrase(header[j], fontHeader);
//	        PdfPCell cell = new PdfPCell(frase);
//	        cell.setBackgroundColor(new BaseColor(Color.lightGray.getRGB()));
//	        cabetabla.addCell(cell);
//	    }
//	    documento.add(cabetabla);
//	    //Tabla for body
//	    PdfPTable tabla = new PdfPTable(header.length);
//	    for (int i = 0; i < body.length; i++) {
//	        for (int j = 0; j < body[i].length; j++) {
//	            tabla.addCell(new Phrase(body[i][j], fontBody));
//	        }
//	    }
//	    documento.add(tabla);
//	    documento.close();
//	    fop.flush();
//	    fop.close();
//	}
//	
//	
//	
//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String name = request.getParameter("name");
//		if (name == null || name.equals("")) {
//			response.sendRedirect("/");
//		}
////		response.setContentType("text/html");
//		response.setContentType("application/pdf");
////		response.getWriter().println("Hell World " + name + " :] - doGet2");
////////STAD
//		
//		
//		String header[] = new String[2];
//		header[1] = "h1";
//		header[0] = "h0";
//		
//		String base[][] = new String[2][2];
//		base[0][0] = "b00";
//		base[0][1] = "b01";
//		base[1][0] = "b10";
//		base[1][1] = "b11";
//		
//		try {
//			createSamplePDF(header, base);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
///////DOTAD
//		
//		
//		
//		
//
//	}
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		this.doGet(request, response);
//	}
//
////	public void createPdf(boolean shapes) {
////	    Document document = new Document(null, null);
////	    try {
////	        PdfWriter writer; 
////	        writer = PdfWriter.getInstance(document, 
////	                         new FileOutputStream("nameOfFile.pdf")); 
////	        document.open(); 
////	        PdfContentByte cb = writer.getDirectContent();
////	        PdfTemplate tp = cb.createTemplate(1000, 1000);
////	        Graphics2D g2; 
////	        if (shapes) 
////	            g2 = tp.createGraphicsShapes(1000,1000); //as image 
////	        else 
////	            g2 = tp.createGraphics(1000, 1000); //as text
////	        scrollPaneOfTableData.print(g2); 
////	        g2.dispose(); 
////	        cb.addTemplate(tp, 30, 300); 
////	 
////	        } catch (Exception e) { 
////	            System.err.println(e.getMessage()); 
////	        }
////	        document.close(); 
////	}
//}



//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//
//@WebServlet("/PDF")
//public class PDFServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//      Document document = new Document();
//      try
//      {
//         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/webapp/raty.pdf"));
//         document.open();
//         document.add(new Paragraph("AAA Hello World PDF document."));
//         document.close();
//         writer.close();
//      } catch (DocumentException e)
//      {
//         e.printStackTrace();
//      } catch (FileNotFoundException e)
//      {
//         e.printStackTrace();
//      }
//      response.getWriter().println("OK");
//   }
//}