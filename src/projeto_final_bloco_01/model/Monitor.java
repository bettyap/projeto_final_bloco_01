package projeto_final_bloco_01.model;

public abstract class Monitor {

	// Definir os Atributos da Classe

	private int id;
	private String marca;
	private int categoria;
	private float polegadas;
	private float valor;

	public Monitor (int id, String marca, int categoria, float polegadas, float valor) {
		this.id = id;
		this.marca = marca;
		this.categoria = categoria;
		this.polegadas = polegadas;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public float getPolegadas() {
		return polegadas;
	}

	public void setPolegadas(float polegadas) {
		this.polegadas = polegadas;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	// Método auxiliar visualizar()
	public void visualizar() {

		String tipo = "";

		switch (this.categoria) {
		case 1 -> tipo = "Tradicional";
		case 2 -> tipo = "Gamer";
		}

		System.out.println("\n*****************************************");
		System.out.println("          Dados do Produto                 ");
		System.out.println("*******************************************");
		System.out.println("Número do id: " + this.id);
		System.out.println("Marca: " + this.marca);
		System.out.println("Categoria do Monitor: " + tipo);
		System.out.println("Polegadas: " + this.polegadas);
		System.out.println("Valor do Monitor: " + this.valor);
	}

}
