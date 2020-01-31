package metier;

import java.sql.Date;

public class Etudiant extends Personne{
	
	private Date datenaissance;

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	@Override
	public String toString() {
		return "Etudiant [datenaissance=" + datenaissance + ", getNomPersonne()=" + getNomPersonne()
				+ ", getPrenomPersonne()=" + getPrenomPersonne() + ", getAdressePersonne()=" + getAdressePersonne()
				+ ", getEmailPersonne()=" + getEmailPersonne() + ", getNumeroPersonne()=" + getNumeroPersonne() + "]";
	}

	

	
	
}
