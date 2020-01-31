package metier;

public class Personne {

	private String nomPersonne;
	private String prenomPersonne;
	private String adressePersonne;
	private String emailPersonne;
	private String numeroPersonne;
	
	
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public String getAdressePersonne() {
		return adressePersonne;
	}
	public void setAdressePersonne(String adressePersonne) {
		this.adressePersonne = adressePersonne;
	}
	public String getEmailPersonne() {
		return emailPersonne;
	}
	public void setEmailPersonne(String emailPersonne) {
		this.emailPersonne = emailPersonne;
	}
	public String getNumeroPersonne() {
		return numeroPersonne;
	}
	public void setNumeroPersonne(String numeroPersonne) {
		this.numeroPersonne = numeroPersonne;
	}
	@Override
	public String toString() {
		return "Personne [nomPersonne=" + nomPersonne + ", prenomPersonne=" + prenomPersonne + ", adressePersonne="
				+ adressePersonne + ", emailPersonne=" + emailPersonne + ", numeroPersonne=" + numeroPersonne + "]";
	}
	
	
}
