package service;

import domaine.Agence;
import domaine.Banque;
import domaine.Bourse;
import domaine.CB;
import domaine.Client;
import domaine.Compte;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import domaine.Conseille;
import domaine.Gerant;
import domaine.Placement;
import exceptions.ClientPauvreException;
import exceptions.CompteExistantException;
import exceptions.DureeNegativeExeption;
import exceptions.MontantNegatifException;
import exceptions.MontantSuperieurSoldeException;
import exceptions.TxNegatifException;

/**
 * Interface de la couche service
* @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public interface IService {
	
	//Banque
	public void createBanque(Banque b);
	public void readBanque(Banque b);
	public void updateBanque(Banque b);
	public void deleteBanque(Banque b);
	
	
	//Agence
	public void createAgence(Agence a);
	public void readAgence(Agence a);
	public void updateAgence(Agence a);
	public void deleteAgence(Agence a);
	/**
	 * Lie un agence à une banque
	 * @param a Agence à lier à la banque
	 * @param b Banque à lier à l'agence
	 */
	public void attribuerBanque(Agence a, Banque b);
	
	//Gerant
	public void createGerant(Gerant g);
	public void readGerant(Gerant g);
	public void updateGerant(Gerant g);
	public void deleteGerant(Gerant g);
	/**
	 * Lie un gérant à une agence
	 * @param g Gérant  à lier à l'agence
	 * @param a Agence  à lier au gérant
	 */
	public void attribuerAgence(Gerant g, Agence a);
	
	//Conseille
	public void createConseille(Conseille c);
	public void readConseille(Conseille c);
	public void updateConseille(Conseille c);
	public void deleteConseille(Conseille c);
	/**
	 * Lie un conseillé à un gérant
	 * @param c Conseille à lier au gérant
	 * @param g Gérant à lier au conseille
	 */
	public void attribuerGerant(Conseille c,Gerant g);
	/**
	 * Liste l'ensemble des client d'un conseillé
	 * @param c Conseillé dont les client sont listés
	 */
	public void listerClient(Conseille c);
	/**
	 * Liste uniquement les clients fortunés (supérieur à 500 000) d'un conseillé
	 * @param c Conseillé dont les client fortunés sont listés
	 */
	public void listerClientFortunes(Conseille c);
	
	//Client
	public void createClient(Client clt);
	public void readClient(Client clt);
	/**
	 * Met à jour l'ensemble des attributs d'un client
	 * @param clt Client à mettre à jour
	 * @param prenom Prénom du client
	 * @param nom Nom du client
	 * @param tel Telephone du client
	 * @param adresse Adresse du client
	 * @param codePostal Code Postale du client
	 * @param Ville Ville du client
	 * @param typeClient Type de client (Particulier ou Entreprise)
	 */
	public void updateClient(Client clt, String prenom, String nom, String tel, String adresse, int codePostal, String Ville, String typeClient);
	public void deleteClient(Client clt);
	/**
	 * Lie un client à un conseillé
	 * @param clt Client à lier au conseillé
	 * @param c Conseillé à lier au client
	 */
	public void attribuerConseille(Client clt,Conseille c);
	
	//Compte
	/**
	 * Lie un compte à un conseillé
	 * @param cpt Compte à lier au conseillé
	 * @param csl Conseillé à lier au compte
	 */
	public void attribuerCpt(Compte cpt, Conseille csl);

	//CompteCourant
	public void createCpteCourant(CompteCourant cpt);
	public void readCpteCourant(CompteCourant cpt);
	public void updateCpteCourant(CompteCourant cpt);
	public void deleteCpteCourant(CompteCourant cpt);
	/**
	 * Lie un compte courant à un client
	 * @param cpt Compte à lier au client
	 * @param clt Client à lier au compte
	 * @throws CompteExistantException Exception destiné à ne pas créer de nouveaux si le client en possède déjà un
	 */
	public void attribuerCptCourant(CompteCourant cpt, Client clt) throws CompteExistantException;
	
	//CompteEpargne
	public void createCpteEpargne(CompteEpargne cpt);
	public void readCpteEpargne(CompteEpargne cpt);
	public void updateCpteEpargne(CompteEpargne cpt);
	public void deleteCpteEpargne(CompteEpargne cpt);
	/**
	 * Lie un compte epargne à un client
	 * @param cpt Compte à lier au client
	 * @param clt Client à lier au compte
	 * @throws CompteExistantException Exception destiné à ne pas créer de nouveaux si le client en possède déjà un
	 */
	public void attribuerCptEpargne(CompteEpargne cpt, Client clt) throws CompteExistantException;
	
	//Bourse
	public void createBourse(Bourse brs);
	public void readBourse(Bourse brs);
	public void updateBourse(Bourse brs);
	public void deleteBourse(Bourse brs);
	
	//CB
	public void createCB(CB cb);
	public void readCB(CB cb);
	public void updateCB(CB cb);
	public void deleteCB(CB cb);
	/**
	 * Lie une carte bancaire à un compte
	 * @param cb Carte banquaire à lier au compte
	 * @param cpt Compte à lier à la carte banquaire
	 */
	public void attribuerCompte(CB cb, Compte cpt);
	
	//Placement
	public void createPlacement(Placement p);
	public void readPlacement(Placement p);
	public void updatePlacement(Placement p);
	public void deletePlacement(Placement p);
	
	//Methode Conseille
	/**
	 * Methode permetant de virer une somme entre deux comptes
	 * @param idEmeteur N°id du compte débiteur
	 * @param idBenificiare N°id du compte créditeur
	 * @param mt Montant de la transaction
	 * @param csl Conseille effectuant le virement 
	 * @throws MontantNegatifException Exception gérant les montants négatifs
	 * @throws MontantSuperieurSoldeException Exception gérant les montants supérieurs au solde du débiteur
	 */
	public void virement(int idEmeteur, int idBenificiare, double mt,Conseille csl)throws MontantNegatifException, MontantSuperieurSoldeException;
	/**
	 * Methode permettant de réaliser une simulation de crédit à partir de son montant, son taux et sa durée
	 * @param mt Montant du crédit
	 * @param tx Taux du crédit
	 * @param dureeMois Durée du crédit
	 * @return	Mensualités estimées
	 * @throws MontantNegatifException Exception gérant les montants négatifs
	 * @throws TxNegatifException Exception gérant les taux négatifs
	 * @throws DureeNegativeExeption Exception gérant les nombres de mois négatifs
	 */
	public Double simulationCredit(double mt, double tx, int dureeMois)throws MontantNegatifException,TxNegatifException, DureeNegativeExeption;
	/**
	 * Methode destinée à lister uniquement les comptes en defaut de l'agence
	 * @param agence Agence soumise à l'audit
	 */
	public void auditer(Agence agence);
	/**
	 * Methode permetant la réalisation de placement en bourse d'une partie des comptes les plus fortunés
	 * @param idCompte N° d'identification du compte
	 * @param b Bourse choisie pour le placement
	 * @param mt Montant placé à la bourse
	 * @param csl Conseillé responsable du placement
	 * @throws MontantNegatifException Exception gérant les montants négatifs
	 * @throws MontantSuperieurSoldeException Exception gérant les montants supérieurs au solde du débiteur
	 * @throws ClientPauvreException Exception gérant la selection par erreur d'un client non-elligible au placement en bourse
	 */
	public void placerEnBourse(int idCompte, Bourse b, double mt,Conseille csl) throws MontantNegatifException, MontantSuperieurSoldeException, ClientPauvreException;
	
	
	
	

}
