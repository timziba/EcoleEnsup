package metier;

public class Cours {

	private String theme;
	private int nombreHeure;
	public Cours() {
		super();
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getNombreHeure() {
		return nombreHeure;
	}
	public void setNombreHeure(int nombreHeure) {
		this.nombreHeure = nombreHeure;
	}
	@Override
	public String toString() {
		return "Cours [theme=" + theme + ", nombreHeure=" + nombreHeure + "]";
	}
	
	
}
