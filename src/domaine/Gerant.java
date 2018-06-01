package domaine;
/**
 * G�rant est la classe repr�sentant un g�rant d'une agence BroxiBanque.
 * @author KHEZNADJI et VOLATRON.
 * @version 1.0.
 */
import java.util.Hashtable;
import java.util.Map;

public class Gerant extends Personne {
	/**
	 * La cr�ation de la liste des conseill�s appartenant � l'agence.
	 */
	private Map<Integer, Conseille> liConseille = new Hashtable<Integer, Conseille>();
	private Agence agence;

	/**
	 * constructeur d'un objet G�rant.
	 * @param nom nom de g�rant. 
	 * @param prenom de g�rant .
	 */
	public Gerant(String nom, String prenom) {
		super( nom,prenom);
	}
	/**
	 * Retourne la liste des conseill�s de l'agence.
	 * @return la liste des conseill�s
	 */
	public Map<Integer, Conseille> getLiConseille() {
		return liConseille;
	}
	/**
 	* Met � jour la liste des conseill�s de l'agence.
 	* @param liConseille liste des consill�s.
 	*/
	public void setLiConseille(Map<Integer, Conseille> liConseille) {
		this.liConseille = liConseille;
	}
	/**
	 * Retourne la classe Agence.
	 * @return la classe Agence.
	 */
	public Agence getAgence() {
		return agence;
	}
	/**
	 * Met � jour la classe Agence
	 * @param agence de la banque BroxiBanque.
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

}
