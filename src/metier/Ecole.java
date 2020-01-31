package metier;


public class Ecole {

	private String nomEcole;
	private String adresseEcole;
	private String emailEcole;
	private String numeroEcole;
	private String directeurEcole;
	
	
	

	public Ecole(String nomEcole, String adresseEcole, String emailEcole, String numeroEcole, String directeurEcole) {
		super();
		this.nomEcole = nomEcole;
		this.adresseEcole = adresseEcole;
		this.emailEcole = emailEcole;
		this.numeroEcole = numeroEcole;
		this.directeurEcole = directeurEcole;
	}

	
	
	public String getEmailEcole() {
		return emailEcole;
	}



	public void setEmailEcole(String emailEcole) {
		this.emailEcole = emailEcole;
	}



	public String getNumeroEcole() {
		return numeroEcole;
	}



	public void setNumeroEcole(String numeroEcole) {
		this.numeroEcole = numeroEcole;
	}



	public String getDirecteurEcole() {
		return directeurEcole;
	}



	public void setDirecteurEcole(String directeurEcole) {
		this.directeurEcole = directeurEcole;
	}



	public String getNomEcole() {
		return nomEcole;
	}

	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}

	public String getAdresseEcole() {
		return adresseEcole;
	}

	public void setAdresseEcole(String adresseEcole) {
		this.adresseEcole = adresseEcole;
	}



	@Override
	public String toString() {
		return "Ecole [nomEcole=" + nomEcole + ", adresseEcole=" + adresseEcole + ", emailEcole=" + emailEcole
				+ ", numeroEcole=" + numeroEcole + ", directeurEcole=" + directeurEcole + "]";
	}
	
	
	
}
