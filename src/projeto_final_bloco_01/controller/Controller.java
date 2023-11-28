package projeto_final_bloco_01.controller;

import java.util.ArrayList;
import java.util.Optional;

import projeto_final_bloco_01.model.Monitor;
import projeto_final_bloco_01.repository.Repository;

public class Controller implements Repository {
	
	private ArrayList<Monitor> listaMonitores = new ArrayList<Monitor>();

	int numero = 0;
	
	@Override
	public void procurarPorNumero(int id) {
		
		Optional<Monitor> monitor = buscarNaCollection(id);

		if (monitor.isPresent())
			monitor.get().visualizar();
		else
			System.out.println("O monitor com id " + id + " não foi encontrado!");
		
	}

	@Override
	public void listarTodas() {
		for (var monitor : listaMonitores) {
			monitor.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Monitor monitor) {
		listaMonitores.add(monitor);
		System.out.println("O monitor com id: " + monitor.getId() + " foi criado com Sucesso!");
		
	}

	@Override
	public void atualizar(Monitor monitor) {
		
		Optional<Monitor> buscaMonitor = buscarNaCollection(monitor.getId());

		if (buscaMonitor.isPresent()) {
			listaMonitores.set(listaMonitores.indexOf(buscaMonitor.get()), monitor);
			System.out.println("O monitor número: " + monitor.getId() + " foi atualizado com sucesso!");
		} else
			System.out.println("O monitor número: " + monitor.getId() + " não foi encontrado!");
	}

	@Override
	public void deletar(int numero) {
		
		Optional<Monitor> monitor = buscarNaCollection(numero);

		if (monitor.isPresent()) {
			if (listaMonitores.remove(monitor.get()) == true) {
				System.out.println("O monitor número: " + numero + " foi excluído com sucesso!");
			}
		} else {
			System.out.println("O monitor número: " + numero + " não foi encontrado!");
		}
		
	}
	
	public Optional<Monitor> buscarNaCollection(int numero) {

		for (var monitor : listaMonitores) {
			if (monitor.getId() == numero)
				return Optional.of(monitor);
		}

		return Optional.empty();
	}

}
