package service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

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
 * @author Adminl
 *	Classe d'implémentation de l'interface IService
 */
public class ServiceImpl implements IService {

	@Override
	public void createBanque(Banque b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readBanque(Banque b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBanque(Banque b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBanque(Banque b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAgence(Agence a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readAgence(Agence a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAgence(Agence a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAgence(Agence a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attribuerBanque(Agence a, Banque b) {
		a.setBanque(b);
		b.getLiAgence().put(b.getLiAgence().size(), a);
	}

	@Override
	public void createGerant(Gerant g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readGerant(Gerant g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateGerant(Gerant g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGerant(Gerant g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attribuerAgence(Gerant g, Agence a) {
		g.setAgence(a);
		a.setGerant(g);
	}

	@Override
	public void createConseille(Conseille c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readConseille(Conseille c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateConseille(Conseille c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConseille(Conseille c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attribuerGerant(Conseille c, Gerant g) {
		c.setGerant(g);
		g.getLiConseille().put(g.getLiConseille().size(), c);
	}
	
	@Override
	public void listerClient(Conseille c) {
		for(Map.Entry<Integer, Client> clt : c.getLiClient().entrySet()) {
			System.out.println("\n"+clt.toString());
			if(clt.getValue().getCompteCourant()!=null) {System.out.println("\t" +clt.getValue().getCompteCourant().toString());}
			if(clt.getValue().getCompteEpargne()!=null) {System.out.println("\t" +clt.getValue().getCompteEpargne().toString());}
		}
	}
	public void listerClientFortunes(Conseille c) {
		for(Map.Entry<Integer, Client> clt : c.getLiClient().entrySet()) {
			
			if(clt.getValue().getCompteCourant()!=null && clt.getValue().getCompteCourant().getSolde()>500000) {System.out.println("\n"+clt.toString());System.out.println("\t" +clt.getValue().getCompteCourant().toString());}
			if(clt.getValue().getCompteEpargne()!=null && clt.getValue().getCompteEpargne().getSolde()>500000) {System.out.println("\n"+clt.toString());System.out.println("\t" +clt.getValue().getCompteEpargne().toString());}
		}
	}
	
	@Override
	public void createClient(Client clt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readClient(Client clt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClient(Client clt, String prenom, String nom, String tel, String adresse, int codePostal, String ville, String typeClient) {
		clt.setPrenom(prenom);
		clt.setNom(nom);
		clt.setTel(tel);
		clt.setAdresse(adresse);
		clt.setCodePostal(codePostal);
		clt.setVille(ville);
		clt.setTypeClient(typeClient);
		
	}

	@Override
	public void deleteClient(Client clt) {
		if(clt.getCompteCourant().getCb()!=null) {clt.getCompteCourant().getCb().setStatus("Desactivee");}
		if(clt.getCompteCourant().getCb()!=null) {clt.getCompteEpargne().getCb().setStatus("Desactivee");}
		if(clt.getCompteCourant()!=null) {clt.getCompteCourant().setClient(null);clt.getConseille().getLiCompte().remove(clt.getCompteCourant().getId());}
		if(clt.getCompteEpargne()!=null) {clt.getCompteEpargne().setClient(null);clt.getConseille().getLiCompte().remove(clt.getCompteEpargne().getId());}
		clt.setCompteEpargne(null);
		clt.setCompteCourant(null);
		clt.getConseille().getLiClient().remove(clt.getId());
		clt.setConseille(null);
	}

	@Override
	public void attribuerConseille(Client clt, Conseille c) {
		clt.setConseille(c);
		c.getLiClient().put(c.getLiClient().size(), clt);
	}

	@Override
	public void attribuerCpt(Compte cpt, Conseille csl) {
		csl.getLiCompte().put(csl.getLiCompte().size(), cpt);
	}
	
	@Override
	public void createCpteCourant(CompteCourant cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readCpteCourant(CompteCourant cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCpteCourant(CompteCourant cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCpteCourant(CompteCourant cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attribuerCptCourant(CompteCourant cpt, Client clt) throws CompteExistantException{
		if(clt.getCompteCourant()!=null) {throw new CompteExistantException("Le client ne peut pas posseder deux comptes courant");}
		cpt.setClient(clt);
		clt.setCompteCourant(cpt);
	}

	@Override
	public void createCpteEpargne(CompteEpargne cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readCpteEpargne(CompteEpargne cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCpteEpargne(CompteEpargne cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCpteEpargne(CompteEpargne cpt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attribuerCptEpargne(CompteEpargne cpt, Client clt)throws CompteExistantException {
		if(clt.getCompteEpargne()!=null) {throw new CompteExistantException("Le client ne peut pas posseder deux comptes epargne");}
		cpt.setClient(clt);
		clt.setCompteEpargne(cpt);
	}

	@Override
	public void createBourse(Bourse brs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readBourse(Bourse brs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBourse(Bourse brs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBourse(Bourse brs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCB(CB cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readCB(CB cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCB(CB cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCB(CB cb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attribuerCompte(CB cb, Compte cpt) {
		cb.setCompte(cpt);
		cpt.setCb(cb);
	}
	@Override
	public void createPlacement(Placement p) {
		
	}
	
	public void readPlacement(Placement p) {};
	public void updatePlacement(Placement p) {};
	public void deletePlacement(Placement p) {};
	
	@Override
	public void virement(int idEmeteur, int idBeneficiare, double mt, Conseille csl)throws MontantNegatifException,MontantSuperieurSoldeException {
		if(mt<0){throw new MontantNegatifException("Le montant ne peut pas être négatif");};
		
		Compte compteEmeteur=null, compteBeneficiaire=null;
			for(Map.Entry<Integer,Client> clt : csl.getLiClient().entrySet()) {
				if(clt.getValue().getCompteCourant()!=null) {
					if(clt.getValue().getCompteCourant().getId()==idEmeteur) {
						compteEmeteur=clt.getValue().getCompteCourant();
						if(mt>(compteEmeteur.getSolde()+clt.getValue().getCompteCourant().getDec())) {throw new MontantSuperieurSoldeException("Montant supérieur au montant maximum authorisé");}
						clt.getValue().getCompteCourant().setSolde(clt.getValue().getCompteCourant().getSolde()-mt);
						}
					if(clt.getValue().getCompteCourant().getId()==idBeneficiare) {
						compteBeneficiaire=clt.getValue().getCompteCourant();
						clt.getValue().getCompteCourant().setSolde(clt.getValue().getCompteCourant().getSolde()+mt);
						}
				}
				if (clt.getValue().getCompteEpargne()!=null) {
					if(clt.getValue().getCompteEpargne().getId()==idEmeteur) {
						compteEmeteur=clt.getValue().getCompteEpargne();
						if(mt>compteEmeteur.getSolde()) {throw new MontantSuperieurSoldeException("Montant supérieur au montant maximum authorisé");}
						clt.getValue().getCompteEpargne().setSolde(clt.getValue().getCompteEpargne().getSolde()-mt);
						}
					if(clt.getValue().getCompteEpargne().getId()==idBeneficiare) {compteBeneficiaire=clt.getValue().getCompteEpargne();clt.getValue().getCompteEpargne().setSolde(clt.getValue().getCompteEpargne().getSolde()+mt);}
				}
			}
			
			System.out.println("Virement effectuee : compte " + compteEmeteur.getId() +" ---" + mt +"--->" + " compte "+compteBeneficiaire.getId() );
	}

	@Override
	public Double simulationCredit(double mt, double tx, int dureeMois)throws MontantNegatifException,TxNegatifException, DureeNegativeExeption {
		if(mt<0){throw new MontantNegatifException("Le montant ne peut pas être négatif");};
		if(tx<0.0){throw new TxNegatifException("Le taux ne peut pas être négatif");};
		if(dureeMois<0){throw new DureeNegativeExeption("Le nombre de mois ne peut pas être négatif");};
		return ((mt*tx)+(mt))/dureeMois;
	}

	@Override
	public void auditer(Agence agence) {
		List<Compte> cptDebiteur = new Vector<Compte>();
		int nbCptVerifie=0;
		
		for(Map.Entry<Integer,Conseille> csl : agence.getGerant().getLiConseille().entrySet()) {
			for(Map.Entry<Integer,Client> clt : csl.getValue().getLiClient().entrySet()) {
				if(clt.getValue().getCompteCourant()!=null) {
					nbCptVerifie++;
					if((clt.getValue().getCompteCourant().getSolde()<-5000 && clt.getValue().getTypeClient()=="Particulier")||(clt.getValue().getCompteCourant().getSolde()<-50000 && clt.getValue().getTypeClient()=="Entreprise")) {
						cptDebiteur.add(clt.getValue().getCompteCourant());
					}
				}
				
			}
		}
		
		System.out.println(cptDebiteur.size() + " compte(s) courant sur "+nbCptVerifie+" trouvï¿½(s) en anomalie");
		for(Compte cpt:cptDebiteur) {
			System.out.println("Le comtpe courant " + cpt.getId() + " du client \""+cpt.getClient().getTypeClient() + "\" " + cpt.getClient().toString() + " a un solde de "+cpt.getSolde());
		}
		System.out.println("\n");
		
	}
	public void placerEnBourse(int idCompte, Bourse b, double mt, Conseille csl) throws MontantNegatifException,MontantSuperieurSoldeException,ClientPauvreException {
		if(mt<0){throw new MontantNegatifException("Le montant ne peut pas être négatif");};
		Compte cpt = null;
		for(Map.Entry<Integer,Client> clt : csl.getLiClient().entrySet()) {
			if(clt.getValue().getCompteCourant()!=null) {
				if(clt.getValue().getCompteCourant().getId()==idCompte) {
					cpt=clt.getValue().getCompteCourant();
					if(mt>cpt.getSolde()+clt.getValue().getCompteCourant().getDec()) {throw new MontantSuperieurSoldeException("Montant supérieur au montant maximum authorisé");}
					}
				}
			if (clt.getValue().getCompteEpargne()!=null) {
				if(clt.getValue().getCompteEpargne().getId()==idCompte) {
					cpt=clt.getValue().getCompteEpargne();
					if(mt>cpt.getSolde()) {throw new MontantSuperieurSoldeException("Montant supérieur au montant maximum authorisé");}
					}
				}
			
		}
		if(cpt.getSolde()<500000) {throw new ClientPauvreException("Le client n'est pas assez fortuné pour prétendre à un investissement");}
		csl.getLiPlacement().put(csl.getLiPlacement().size(), new Placement(cpt.getClient(), cpt, b, mt));
		cpt.setSolde(cpt.getSolde()-mt);
		System.out.println("Placement cree  !");
	}


}
