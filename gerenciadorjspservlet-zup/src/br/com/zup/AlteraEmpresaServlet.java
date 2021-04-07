package br.com.zup;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zup.model.ModelEmpresa;
import br.com.zup.util.ClasseBanco;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Alterando a Empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		
		Date data = null;
		
		try {
			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
			data = formatador.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		ClasseBanco banco = new ClasseBanco();
		ModelEmpresa modelEmpresa = banco.buscaEmpresaPorId(id);
		modelEmpresa.setNome(nomeEmpresa);
		modelEmpresa.setDataAbertura(data);
		
		response.sendRedirect("listaEmpresasServlet");
		
	}

}
