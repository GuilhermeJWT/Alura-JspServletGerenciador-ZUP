package br.com.zup.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.zup.model.ModelEmpresa;

public class ClasseBanco {

	private static List<ModelEmpresa> listaEmpresas = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	
	static {
		ModelEmpresa modelEmpresa = new ModelEmpresa();
		modelEmpresa.setId(chaveSequencial++);
		modelEmpresa.setNome("Zup");
		
		ModelEmpresa modelEmpresa2 = new ModelEmpresa();
		modelEmpresa2.setId(chaveSequencial++);
		modelEmpresa2.setNome("Systems GS");
		
		listaEmpresas.add(modelEmpresa);
		listaEmpresas.add(modelEmpresa2);
		
	}
	
	public void adiciona(ModelEmpresa modelEmpresa) {
		modelEmpresa.setId(ClasseBanco.chaveSequencial++);
		listaEmpresas.add(modelEmpresa);
	}
	
	public List<ModelEmpresa> getEmpresas(){
		return ClasseBanco.listaEmpresas;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<ModelEmpresa> it = listaEmpresas.iterator();
		
		while(it.hasNext()) {
			ModelEmpresa empresa = it.next();
			
			if(empresa.getId() == id) {
				it.remove();
			}
			
		}
		
	}

	public ModelEmpresa buscaEmpresaPorId(Integer id) {
		
		for (ModelEmpresa modelEmpresa : listaEmpresas) {
			if(modelEmpresa.getId() == id) {
				return modelEmpresa;
			}
		}
		
		return null;
	}

}
