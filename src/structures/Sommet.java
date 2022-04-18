package structures;

public class Sommet {
	private int etiquette ;
	private int marque ;
	public Sommet(int etiquette, int marque) {
		super();
		this.etiquette = etiquette;
		this.marque = marque;
	}
	public Sommet() {
		super();
	}
	public int getEtiquette() {
		return etiquette;
	}
	public void setEtiquette(int etiquette) {
		this.etiquette = etiquette;
	}
	public int getMarque() {
		return marque;
	}
	public void setMarque(int marque) {
		this.marque = marque;
	}
	

}