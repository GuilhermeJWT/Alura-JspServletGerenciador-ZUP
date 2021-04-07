package br.com.zup.util;

import java.util.ArrayList;
import java.util.List;

import br.com.zup.model.ModelEmpresa;

public class ClasseBanco {

	private static List<ModelEmpresa> listaEmpresas = new ArrayList<>();
	
	
	static {
		ModelEmpresa modelEmpresa = new ModelEmpresa();
		modelEmpresa.setNome("Zup");
		
		ModelEmpresa modelEmpresa2 = new ModelEmpresa();
		modelEmpresa2.setNome("Systems GS");
		
		listaEmpresas.add(modelEmpresa);
		listaEmpresas.add(modelEmpresa2);
		
	}
	
	public void adiciona(ModelEmpresa modelEmpresa) {
		listaEmpresas.add(modelEmpresa);
	}
	
	public List<ModelEmpresa> getEmpresas(){
		return ClasseBanco.listaEmpresas;
	}

}
