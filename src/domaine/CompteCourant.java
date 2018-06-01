package domaine;
/**
 * CompteCourant  est la classe représentant le compte courant d'un client de la banque BroxiBanque
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public class CompteCourant extends Compte {
	/**
	 * Le découvert autorisé par la banque 
	 */
	private double dec;

	/**
	 * Le constructeur d'un objet compteCourant d'un client.
	 * @param solde du compteCourant
	 * @param dec du compteCourant
	 */
	public CompteCourant(double solde, double dec) {
		super(solde);
		this.dec = dec;
	}

	



	/**
	 * Retourne le découvert autorisé pour le client
	 * @return le découvert
	 */
	public double getDec() {
		return dec;
	}
	/**
	 * Met à jour le découvert autorisé par la banque.
	 * @param dec autorisé
	 */
	public void setDec(double dec) {
		this.dec = dec;
	}
	/**
	 * Décrit l'instanciation d'un compteCourant
	 */
	public String toString() {
		return "Compte Courant : " + this.getId() + " | solde :" + this.getSolde() + " | decouvert authorisée : "+ this.dec +" | créee le :" +this.getDate(); 
	}
}
