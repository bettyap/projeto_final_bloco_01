package projeto_final_bloco_01.model;

public class MonitorGamer extends Monitor{

	private int fps;

	public MonitorGamer(int id, String marca, int categoria, float polegadas, float valor, int fps) {
		super(id, marca, categoria, polegadas, valor);
		this.fps = fps;
	}

	public int getFps() {
		return fps;
	}

	public void setFps(int fps) {
		this.fps = fps;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Monitor Gamer FPS: " + this.getFps());
	}
	
}
