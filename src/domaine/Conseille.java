package domaine;

import java.util.Hashtable;
import java.util.Map;
/**
 * Conseill� est la classe repr�sentant un conseill� d'une agence de la banque BroxiBanque
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public class Conseille extends Personne {

	/**
	 * La liste des clients 
	 */
	private Map<Integer, Client> liClient = new Hashtable<Integer, Client>();
	/**
	 * La liste des comptes
	 */
	private Map<Integer, Compte> liCompte = new Hashtable<Integer, Compte>();
	/**
	 * La liste des placemnts
	 */
	private Map<Integer, Placement> liPlacement = new Hashtable<Integer, Placement>();
	/**
	 * Le g�rant de l'agence 
	 */
	private Gerant gerant;
	
	/**
	 * Le constructeur par d�faut 
	 */
	public Conseille() {
		super();
	}
	/**
	 *  Le constructeur d'un objet conseill�
	 * @param nom du conseill�
	 * @param prenom du conseill�
	 */
	public Conseille(String nom, String prenom) {
		super( nom,prenom);
	}


	/**
	 * Retourne la liste des clients .
	 * @return le client
	 */
	
	public Map<Integer, Client> getLiClient() {
		return liClient;
	}
	/**
	 * Retourne le liste des comptes.
	 * @return la liste des comptes
	 */
	public Map<Integer, Compte> getLiCompte() {
		return liCompte;
	}
	/**
	 * Met � jour la liste des clients
	 * @param liCompte la liste des clients
	 */
	public void setLiCompte(Map<Integer, Compte> liCompte) {
		this.liCompte = liCompte;
	}
	/**
	 * Retourne la liste des placements.
	 * @return la liste de placements
	 */
	public Map<Integer, Placement> getLiPlacement() {
		return liPlacement;
	}
	/**
	 * Met � jour la liste des placements.
	 * @param liPlacement la liste de placements.
	 */
	public void setLiPlacement(Map<Integer, Placement> liPlacement) {
		this.liPlacement = liPlacement;
	}
	/**
	 * Met � jour la liste des clients
	 * @param liClient la liste de clients.
	 */
	public void setLiClient(Map<Integer, Client> liClient) {
		this.liClient = liClient;
	}
	/**
	 * Retourne le g�rant de l'agence
	 * @return le g�rant.
	 */
	public Gerant getGerant() {
		return gerant;
	}
	/**
	 * Met � jour le g�rant de l'agence
	 * @param gerant de l'agence
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	/**
	 * D�crit l'instanciation d'un conseill�.
	 */
	public String toString() {
		return super.toString() + " | Agence :" + this.gerant.getAgence().getId()+ " | Manager : " + this.gerant.toString();
	}

}
