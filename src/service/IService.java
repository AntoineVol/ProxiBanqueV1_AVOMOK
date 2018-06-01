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
	 * Lie un agence � une banque
	 * @param a Agence � lier � la banque
	 * @param b Banque � lier � l'agence
	 */
	public void attribuerBanque(Agence a, Banque b);
	
	//Gerant
	public void createGerant(Gerant g);
	public void readGerant(Gerant g);
	public void updateGerant(Gerant g);
	public void deleteGerant(Gerant g);
	/**
	 * Lie un g�rant � une agence
	 * @param g G�rant  � lier � l'agence
	 * @param a Agence  � lier au g�rant
	 */
	public void attribuerAgence(Gerant g, Agence a);
	
	//Conseille
	public void createConseille(Conseille c);
	public void readConseille(Conseille c);
	public void updateConseille(Conseille c);
	public void deleteConseille(Conseille c);
	/**
	 * Lie un conseill� � un g�rant
	 * @param c Conseille � lier au g�rant
	 * @param g G�rant � lier au conseille
	 */
	public void attribuerGerant(Conseille c,Gerant g);
	/**
	 * Liste l'ensemble des client d'un conseill�
	 * @param c Conseill� dont les client sont list�s
	 */
	public void listerClient(Conseille c);
	/**
	 * Liste uniquement les clients fortun�s (sup�rieur � 500 000) d'un conseill�
	 * @param c Conseill� dont les client fortun�s sont list�s
	 */
	public void listerClientFortunes(Conseille c);
	
	//Client
	public void createClient(Client clt);
	public void readClient(Client clt);
	/**
	 * Met � jour l'ensemble des attributs d'un client
	 * @param clt Client � mettre � jour
	 * @param prenom Pr�nom du client
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
	 * Lie un client � un conseill�
	 * @param clt Client � lier au conseill�
	 * @param c Conseill� � lier au client
	 */
	public void attribuerConseille(Client clt,Conseille c);
	
	//Compte
	/**
	 * Lie un compte � un conseill�
	 * @param cpt Compte � lier au conseill�
	 * @param csl Conseill� � lier au compte
	 */
	public void attribuerCpt(Compte cpt, Conseille csl);

	//CompteCourant
	public void createCpteCourant(CompteCourant cpt);
	public void readCpteCourant(CompteCourant cpt);
	public void updateCpteCourant(CompteCourant cpt);
	public void deleteCpteCourant(CompteCourant cpt);
	/**
	 * Lie un compte courant � un client
	 * @param cpt Compte � lier au client
	 * @param clt Client � lier au compte
	 * @throws CompteExistantException Exception destin� � ne pas cr�er de nouveaux si le client en poss�de d�j� un
	 */
	public void attribuerCptCourant(CompteCourant cpt, Client clt) throws CompteExistantException;
	
	//CompteEpargne
	public void createCpteEpargne(CompteEpargne cpt);
	public void readCpteEpargne(CompteEpargne cpt);
	public void updateCpteEpargne(CompteEpargne cpt);
	public void deleteCpteEpargne(CompteEpargne cpt);
	/**
	 * Lie un compte epargne � un client
	 * @param cpt Compte � lier au client
	 * @param clt Client � lier au compte
	 * @throws CompteExistantException Exception destin� � ne pas cr�er de nouveaux si le client en poss�de d�j� un
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
	 * Lie une carte bancaire � un compte
	 * @param cb Carte banquaire � lier au compte
	 * @param cpt Compte � lier � la carte banquaire
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
	 * @param idEmeteur N�id du compte d�biteur
	 * @param idBenificiare N�id du compte cr�diteur
	 * @param mt Montant de la transaction
	 * @param csl Conseille effectuant le virement 
	 * @throws MontantNegatifException Exception g�rant les montants n�gatifs
	 * @throws MontantSuperieurSoldeException Exception g�rant les montants sup�rieurs au solde du d�biteur
	 */
	public void virement(int idEmeteur, int idBenificiare, double mt,Conseille csl)throws MontantNegatifException, MontantSuperieurSoldeException;
	/**
	 * Methode permettant de r�aliser une simulation de cr�dit � partir de son montant, son taux et sa dur�e
	 * @param mt Montant du cr�dit
	 * @param tx Taux du cr�dit
	 * @param dureeMois Dur�e du cr�dit
	 * @return	Mensualit�s estim�es
	 * @throws MontantNegatifException Exception g�rant les montants n�gatifs
	 * @throws TxNegatifException Exception g�rant les taux n�gatifs
	 * @throws DureeNegativeExeption Exception g�rant les nombres de mois n�gatifs
	 */
	public Double simulationCredit(double mt, double tx, int dureeMois)throws MontantNegatifException,TxNegatifException, DureeNegativeExeption;
	/**
	 * Methode destin�e � lister uniquement les comptes en defaut de l'agence
	 * @param agence Agence soumise � l'audit
	 */
	public void auditer(Agence agence);
	/**
	 * Methode permetant la r�alisation de placement en bourse d'une partie des comptes les plus fortun�s
	 * @param idCompte N� d'identification du compte
	 * @param b Bourse choisie pour le placement
	 * @param mt Montant plac� � la bourse
	 * @param csl Conseill� responsable du placement
	 * @throws MontantNegatifException Exception g�rant les montants n�gatifs
	 * @throws MontantSuperieurSoldeException Exception g�rant les montants sup�rieurs au solde du d�biteur
	 * @throws ClientPauvreException Exception g�rant la selection par erreur d'un client non-elligible au placement en bourse
	 */
	public void placerEnBourse(int idCompte, Bourse b, double mt,Conseille csl) throws MontantNegatifException, MontantSuperieurSoldeException, ClientPauvreException;
	
	
	
	

}
