package br.com.zup;

import java.io.IOException;
import java.io.PrintWriter;

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
		ModelEmpresa modelEmpresa = new ModelEmpresa();
		
		ClasseBanco banco = new ClasseBanco();
		modelEmpresa.setNome(nomeEmpresa);
		
		banco.adiciona(modelEmpresa);
		
		RequestDispatcher retorno =  request.getRequestDispatcher("/NovaEmpresa.jsp");	
		request.setAttribute("empresa", modelEmpresa.getNome());
		retorno.forward(request, response);
		
	}

}
