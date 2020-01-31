package metier;

public class Enseignant extends Personne{

	
	private String matiere;

	

	public Enseignant() {
		super();
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "Enseignant [matiere=" + matiere + "]";
	}
	
	
}
