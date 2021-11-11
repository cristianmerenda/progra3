package tpo.principal;

public class Jugada {
	private String mov;
	private int pos;
	
		
	
	public Jugada(String mov, int pos) {
		this.mov = mov;
		this.pos = pos;
	}
	public String getMov() {
		return mov;
	}
	public void setMov(String mov) {
		this.mov = mov;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	} 
	
	
}
