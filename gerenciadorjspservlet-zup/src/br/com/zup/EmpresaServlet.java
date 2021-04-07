package br.com.zup;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.model.ModelEmpresa;
import br.com.zup.util.ClasseBanco;

@WebServlet("/empresaServlet")
public class EmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Caindo na Requisição");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		
		Date data = null;
		
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			data = formatador.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		ModelEmpresa modelEmpresa = new ModelEmpresa();
		modelEmpresa.setNome(nomeEmpresa);
		modelEmpresa.setDataAbertura(data);
		
		ClasseBanco banco = new ClasseBanco();
		banco.adiciona(modelEmpresa);
		
		response.sendRedirect("listaEmpresasServlet");
		
//		RequestDispatcher retorno =  request.getRequestDispatcher("/listaEmpresasServlet");	
//		request.setAttribute("empresa", modelEmpresa.getNome());
//		retorno.forward(request, response);
		
	}

}
