package projeto_final_bloco_01.repository;

import projeto_final_bloco_01.model.Monitor;

public interface Repository {

	// CRUD dos monitores
	
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Monitor monitor);
	public void atualizar(Monitor monitor);
	public void deletar(int numero);
}
