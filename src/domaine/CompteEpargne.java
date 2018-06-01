package domaine;
/**
 * CompteEpargne est la classe repr�sentant un compte cr��e par  la banque BroxiBanque
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
 
public class CompteEpargne extends  Compte {
	/**
	 * Le taux de r�mun�ration du compte �pargne.
	 */
	private double tx;

	/**
	 * Le constructeur d'un objet compteEpargne
	 * @param solde du compteEpargne
	 * @param tx de r�mun�ration du compteEpargne
	 */
	public CompteEpargne(double solde,double tx) {
		super(solde);
		this.tx = tx;
	}

	/**
	 * Retourne un taux de r�mun�ration du compteEpargne
	 * @return Taux de r�mun�ration du compteEpargne
	 */
	public double getTx() {
		return tx;
	}
	/**
	 * Met � jour le taux de r�mun�ration du compteEpargne
	 * @param tx Taux de r�mun�ration du compteEpargne
	 */
	public void setTx(double tx) {
		this.tx = tx;
	}
	/**
	 * D�crit l'instanciation d'un compteEpargne.
	 */
	public String toString() {
		return "Compte Epargne : " + this.getId() + " | solde :" + this.getSolde() + " | Taux : "+ this.tx +" | cr�ee le :" +this.getDate(); 
	}
}
