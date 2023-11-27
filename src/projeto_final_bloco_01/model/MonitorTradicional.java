package projeto_final_bloco_01.model;

public class MonitorTradicional extends Monitor{
	
	private int numeroSerie;

	public MonitorTradicional(int id, String marca, int categoria, float polegadas, float valor, int numeroSerie) {
		super(id, marca, categoria, polegadas, valor);
		this.numeroSerie = numeroSerie;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Número de série do Monitor Tradicional: " + this.getNumeroSerie()); // Chama o Método get
	}
	

}
