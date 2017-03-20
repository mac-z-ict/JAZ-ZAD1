package zad1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;

import servlets.InstallmentsServlet;

public class TestInstallmentsServlet extends Mockito {

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_kwota_in_form_is_invalid() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("kwota")).thenReturn(null);

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_kwota_in_form_is_empty() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("kwota")).thenReturn("");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_ilosc_in_form_is_invalid() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("ilosc")).thenReturn(null);

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_ilosc_in_form_is_empty() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("ilosc")).thenReturn("");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_procent_in_form_is_invalid() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("procent")).thenReturn(null);

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_procent_in_form_is_empty() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("procent")).thenReturn("");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_oplata_in_form_is_invalid() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("oplata")).thenReturn(null);

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_oplata_in_form_is_empty() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("oplata")).thenReturn("");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_rodzaj_in_form_is_invalid() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("rodzaj")).thenReturn(null);

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_rodzaj_in_form_is_empty() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("rodzaj")).thenReturn("");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_kwota_in_form_is_too_low_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("0");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("1");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_kwota_in_form_is_too_high_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("1000001");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("1");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_ilosc_in_form_is_too_low_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("0");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("1");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_ilosc_in_form_is_too_high_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("361");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("1");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_procent_in_form_is_too_low_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("0");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("1");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_procent_in_form_is_too_high_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("101");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("1");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_oplata_in_form_is_too_high_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("1001");
			when(request.getParameter("rodzaj")).thenReturn("1");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}

		@Test
		public void servlet_should_not_show_the_installments_if_the_field_oplata_in_form_is_too_low_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("-1");
			when(request.getParameter("rodzaj")).thenReturn("1");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_rodzaj_in_form_is_too_low_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();
			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("0");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_not_show_the_installments_if_the_field_rodzaj_in_form_is_too_high_value() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			when(response.getWriter()).thenReturn(writer);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("3");

			servlet.doPost(request, response);

			verify(response).sendRedirect("/");
		}
		
		@Test
		public void servlet_should_show_the_installments_if_the_for_is_properly_filled() throws IOException {
			HttpServletRequest request = mock(HttpServletRequest.class);
			HttpServletResponse response = mock(HttpServletResponse.class);
			PrintWriter writer = mock(PrintWriter.class);
			InstallmentsServlet servlet = new InstallmentsServlet();

			when(response.getWriter()).thenReturn(writer);
			when(request.getParameter("kwota")).thenReturn("100");
			when(request.getParameter("ilosc")).thenReturn("1");
			when(request.getParameter("procent")).thenReturn("0.1");
			when(request.getParameter("oplata")).thenReturn("0");
			when(request.getParameter("rodzaj")).thenReturn("1");//stala

			servlet.doPost(request, response);

			verify(writer).println("<br>Wprowadzone dane:<br><br>");
			verify(writer).println("<table border=1>");
			verify(writer).println("<tr><td>Parametr</td><td>Wartość</td></tr>");
			verify(writer).println("<tr><td>kwota</td><td>100</td></tr>");
			verify(writer).println("<tr><td>ilosc</td><td>1</td></tr>");
			verify(writer).println("<tr><td>procent</td><td>0.1</td></tr>");
			verify(writer).println("<tr><td>oplata</td><td>0</td></tr>");
			verify(writer).println("<tr><td>rodzaj</td><td>stala</td></tr>");
			verify(writer).println("</table>");
			verify(writer).println("<hr>");
			verify(writer).println("<br>Harmonogram rat:<br><br><table border=1>");
			verify(writer).println("<tr><td>LP</td><td>Kapitał</td><td>Odsetki</td><td>Opłaty stałe</td><td>Rata stala</td></tr>");
			verify(writer).println("<tr><td>1</td><td>100,00</td><td>0,01</td><td>0.0</td><td>100,01</td></tr>");
			verify(writer).println("<tr><td colspan=4>Całkowity koszt kredytu</td><td>100,01</td></tr>");
			verify(writer).println(" </table>");
			verify(writer).println("<hr><form action=\"/raty.pdf\"><input type=\"submit\" value=\"Pobierz plik PDF z harmonogramem rat\"></form>");
		}
}
