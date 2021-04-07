package br.com.zup;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.model.ModelEmpresa;
import br.com.zup.util.ClasseBanco;

@WebServlet("/listaEmpresasServlet")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClasseBanco banco = new ClasseBanco();
		List<ModelEmpresa> listaEmpresas = banco.getEmpresas();
		
		RequestDispatcher retorno = request.getRequestDispatcher("/ListaEmpresa.jsp");
		request.setAttribute("empresas", listaEmpresas);
		retorno.forward(request, response);
		
	}


}
