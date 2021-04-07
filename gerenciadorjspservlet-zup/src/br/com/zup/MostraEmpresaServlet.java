package br.com.zup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.model.ModelEmpresa;
import br.com.zup.util.ClasseBanco;

@WebServlet("/mostrarEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramid = request.getParameter("id");
		Integer id = Integer.valueOf(paramid);
		
		ClasseBanco banco = new ClasseBanco();
		
		ModelEmpresa modelEmpresa = banco.buscaEmpresaPorId(id);
		
		request.setAttribute("empresa", modelEmpresa);
		RequestDispatcher retorno = request.getRequestDispatcher("/AlterarEmpresa.jsp");
		retorno.forward(request, response);
		
	}
	
	

}
