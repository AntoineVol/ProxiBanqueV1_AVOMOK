package domaine;

import java.util.Hashtable;
import java.util.Map;
/**
 * Conseillé est la classe représentant un conseillé d'une agence de la banque BroxiBanque
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
	 * Le gérant de l'agence 
	 */
	private Gerant gerant;
	
	/**
	 * Le constructeur par défaut 
	 */
	public Conseille() {
		super();
	}
	/**
	 *  Le constructeur d'un objet conseillé
	 * @param nom du conseillé
	 * @param prenom du conseillé
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
	 * Met à jour la liste des clients
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
	 * Met à jour la liste des placements.
	 * @param liPlacement la liste de placements.
	 */
	public void setLiPlacement(Map<Integer, Placement> liPlacement) {
		this.liPlacement = liPlacement;
	}
	/**
	 * Met à jour la liste des clients
	 * @param liClient la liste de clients.
	 */
	public void setLiClient(Map<Integer, Client> liClient) {
		this.liClient = liClient;
	}
	/**
	 * Retourne le gérant de l'agence
	 * @return le gérant.
	 */
	public Gerant getGerant() {
		return gerant;
	}
	/**
	 * Met à jour le gérant de l'agence
	 * @param gerant de l'agence
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	/**
	 * Décrit l'instanciation d'un conseillé.
	 */
	public String toString() {
		return super.toString() + " | Agence :" + this.gerant.getAgence().getId()+ " | Manager : " + this.gerant.toString();
	}

}
