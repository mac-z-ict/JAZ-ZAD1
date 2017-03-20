package servlets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/installments")
public class InstallmentsServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		double ikwota = 0;
		int iilosc = 0;
		double iprocent = 0;
		double ioplata = 0;
		int irodzaj = 0;
		double suma = 0;

		String[] rataOpis = new String[10];
		rataOpis[1] = "stala";
		rataOpis[2] = "malejaca";
		String wiersz[][] = new String[100][5];
		
		java.text.DecimalFormat df=new java.text.DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		String kwota = request.getParameter("kwota");
		String ilosc = request.getParameter("ilosc");
		String procent = request.getParameter("procent");
		String oplata = request.getParameter("oplata");
		String rodzaj = request.getParameter("rodzaj");

		try {
			ikwota = Double.valueOf(kwota);
			iilosc = Integer.valueOf(ilosc);
			iprocent = Double.valueOf(procent);
			ioplata = Double.valueOf(oplata);
			irodzaj = Integer.valueOf(rodzaj);
		}
		catch (Exception e) {
			response.sendRedirect("/");
			return;
		}
		
		if (
			kwota == null || kwota.equals("") || ikwota < 1 || ikwota > 1000000 ||
			ilosc == null || ilosc.equals("") || iilosc < 1 || iilosc > 360 ||
			procent == null || procent.equals("") || iprocent == 0 || iprocent < 0 || iprocent > 100 ||
			oplata == null || oplata.equals("") || ioplata < 0 || ioplata > 1000 ||
			rodzaj == null || rodzaj.equals("") || irodzaj < 1 || irodzaj > 2
			) {
			response.sendRedirect("/");
			return;
		}

		response.setContentType("text/html");
//		response.setContentType("text/plain");
		printDataInput(response, kwota, ilosc, procent, oplata, irodzaj, rataOpis);
		response.getWriter().println("<hr>");
		wiersz = printTableHeader(response, irodzaj, rataOpis, wiersz);

		if (irodzaj==2) {
			wiersz = printRatyMalejace(response, ikwota, iilosc, iprocent, ioplata, suma, df, wiersz);
		}
		else {
			wiersz = printRatyStale(response, ikwota, iilosc, iprocent, ioplata, df, wiersz);
		}
		
		doPdf(wiersz);
		response.getWriter().println("<hr><form action=\"/raty.pdf\"><input type=\"submit\" value=\"Pobierz plik PDF z harmonogramem rat\"></form>");
	}

	private String[][] printRatyStale(HttpServletResponse response, double ikwota,
			int iilosc, double iprocent, double ioplata,
			java.text.DecimalFormat df, String[][] ret) throws IOException {
		double suma = 0;
		double kapital = 0;
		double odsetki = 0;
		double q = (iprocent / 100.0) / 12.0 + 1.0;
		double wynik = (ikwota * Math.pow(q , iilosc) * (q - 1.0)) / (Math.pow(q , iilosc) - 1.0) + ioplata;
		int q2 = findFirstNullInStringTable(ret);

		for (int i=1; i<=iilosc; i++) {
			kapital = ikwota / iilosc;
			odsetki = (wynik - ioplata) - kapital;
			
			response.getWriter().println("<tr>"
					+ "<td>" + i + "</td>"
					+ "<td>" + df.format(kapital) + "</td>" //kapitał
					+ "<td>" + df.format(odsetki) + "</td>" //odsetki
					+ "<td>" + ioplata + "</td>" //opłata stała
					+ "<td>" + df.format(wynik) + "</td>"
					+ "</tr>");
			ret[q2+i-1][0] = ""+i;
			ret[q2+i-1][1] = df.format(kapital);
			ret[q2+i-1][2] = df.format(odsetki);
			ret[q2+i-1][3] = ""+ioplata;
			ret[q2+i-1][4] = df.format(wynik);
			suma += wynik;
		}
		response.getWriter().println("<tr><td colspan=4>Całkowity koszt kredytu</td><td>" + df.format(suma) + "</td></tr>");
		response.getWriter().println(" </table>");
		ret[q2+iilosc][0] = "Calkowity koszt kredytu = " + df.format(suma);
		return ret;
	}

	private String[][] printRatyMalejace(HttpServletResponse response, double ikwota,
			int iilosc, double iprocent, double ioplata, double suma,
			java.text.DecimalFormat df, String[][] ret) throws IOException {
		int q = findFirstNullInStringTable(ret);
		double kapital = 0;
		double odsetki = 0;
		double rataN = 0.0;
		
		for (int i=1; i<=iilosc; i++) {
			rataN = (ikwota / iilosc) * ( 1.0 + (iilosc - i + 1.0) * ((iprocent / 100.0) / 12.0) ) + ioplata;
			kapital = ikwota / iilosc;
			odsetki = (rataN - ioplata) - kapital;

			response.getWriter().println("<tr>"
					+ "<td>" + i + "</td>"
					+ "<td>" + df.format(kapital) + "</td>" //kapitał
					+ "<td>" + df.format(odsetki) + "</td>" //odsetki
					+ "<td>" + ioplata + "</td>" //opł stała
					+ "<td>" + df.format(rataN) + "</td>"
				+ "</tr>");
			ret[q+i-1][0] = ""+i;
			ret[q+i-1][1] = df.format(kapital);
			ret[q+i-1][2] = df.format(odsetki);
			ret[q+i-1][3] = ""+ioplata;
			ret[q+i-1][4] = df.format(rataN);
			suma += rataN;
		}
		response.getWriter().println("<tr><td colspan=4>Całkowity koszt kredytu</td><td>" + df.format(suma) + "</td></tr>");
		response.getWriter().println(" </table>");
		ret[q+iilosc][0] = "Calkowity koszt kredytu = " + df.format(suma);
		return ret;
	}

	private String[][] printTableHeader(HttpServletResponse response, int irodzaj,
			String[] rataOpis, String[][] ret) throws IOException {
		int q = findFirstNullInStringTable(ret);
		
		response.getWriter().println("<br>Harmonogram rat:<br><br><table border=1>");
		response.getWriter().println("<tr>"
				+ "<td>LP</td>"
				+ "<td>Kapitał</td>"
				+ "<td>Odsetki</td>"
				+ "<td>Opłaty stałe</td>"
				+ "<td>Rata " + rataOpis[irodzaj] + "</td>"
				+ "</tr>");
		 ret[q][0] = "LP";
		 ret[q][1] = "Kapital";
		 ret[q][2] = "Odsetki";
		 ret[q][3] = "Oplaty stale";
		 ret[q][4] = "Rata " + rataOpis[irodzaj];
		 return ret;
	}

	private void printDataInput(HttpServletResponse response, String kwota,
		String ilosc, String procent, String oplata, int irodzaj,
		String[] rataOpis) throws IOException {
			response.getWriter().println("<br>Wprowadzone dane:<br><br>");
			response.getWriter().println("<table border=1>");
			response.getWriter().println("<tr><td>Parametr</td><td>Wartość</td></tr>");
			response.getWriter().println("<tr><td>kwota</td><td>" + kwota + "</td></tr>");
			response.getWriter().println("<tr><td>ilosc</td><td>" + ilosc + "</td></tr>");
			response.getWriter().println("<tr><td>procent</td><td>" + procent + "</td></tr>");
			response.getWriter().println("<tr><td>oplata</td><td>" + oplata + "</td></tr>");
			response.getWriter().println("<tr><td>rodzaj</td><td>" + rataOpis[irodzaj] + "</td></tr>");
			response.getWriter().println("</table>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
	
	public void doPdf(String[][] wiersz) throws IOException {
      Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/main/webapp/raty.pdf"));
         document.open();
//         document.add(new Paragraph(pdfBody));
         document.add(createPdfTable(wiersz));
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
	}
	
	public PdfPTable createPdfTable(String[][] wiersz) {
        PdfPTable table = new PdfPTable(5);
        PdfPCell cell;
        for(int i=0; i < wiersz.length; i++) {
        	if (wiersz[i][1] == null) {
        		cell = new PdfPCell(new Phrase(wiersz[i][0]));
        		cell.setColspan(5);
        		table.addCell(cell);
        		break;
        	}
        	else {
	            for(int j=0; j< wiersz[i].length; j++) {
	            	if (wiersz[i][j] != null) {
	            		cell = new PdfPCell(new Phrase(wiersz[i][j]));
	            		table.addCell(cell);
	            	}
	            }
        	}
        }

        return table;
    }
	
	public int findFirstNullInStringTable(String[][] wiersz) {
		int ret = 0;
        for(int i=0; i < wiersz.length; i++) {
        	if (wiersz[i][1] == null) {
        		ret = i;
        		break;
        	}
        }
        return ret;
	}
}
