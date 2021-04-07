package br.com.zup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/inicial")
public class HelloWorldServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		PrintWriter resposta =  response.getWriter();
		resposta.println("<html>");
		resposta.println("<body>");
		resposta.println("Retonando a Resposta para o navegador");
		resposta.println("</body");
		resposta.println("</html>");
		
		
	}

}
