package presentation;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import domaine.Agence;
import domaine.Banque;
import domaine.Bourse;
import domaine.Client;
import domaine.CompteCourant;
import domaine.CompteEpargne;
import domaine.Conseille;
import domaine.Gerant;
import domaine.VisaElectron;
import domaine.VisaPremier;
import exceptions.ClientPauvreException;
import exceptions.CompteExistantException;
import exceptions.DureeNegativeExeption;
import exceptions.MontantNegatifException;
import exceptions.MontantSuperieurSoldeException;
import exceptions.TxNegatifException;
import service.IService;
import service.ServiceImpl;

public class Lanceur {

	public static void main(String[] args) {
		//=============================================D�claration des variables==================================================
		Scanner sc = new Scanner(System.in);
		IService service = new ServiceImpl();
		int idClient,codePostalClient, idCompte;
		String typeClient = null, nomClient,prenomClient,telClient, adresseClient,  villeClient;
		String prenomConseille, nomConseille;
		double soldeCompte, decouvertCompte, mt;
		int cB,idBeneficiaire,idEmetteur;
		int dureeEmprunt;
		double mtEmprunt, txEmprunt,mtPlacement;
		Bourse bourse=null;
		int input, inputM1;
		String str0="";
		//===============================================Creation des menus===================================================
		Map<Integer,String> liMenu1 = new HashMap<Integer, String>();
		liMenu1.put(1, "Acceder a la base de donnee client");
		liMenu1.put(2, "Effectuer un virement");
		liMenu1.put(3, "Effectuer une simulation de credit");
		liMenu1.put(4, "Effectuer un placement en bourse");
		liMenu1.put(5, "Auditer votre agence");
		Menu menu1 = new Menu(liMenu1, "Acces aux services");
		
		Map<Integer,String> liMenu2 = new HashMap<Integer, String>();
		liMenu2.put(1, "Creer client");
		liMenu2.put(2, "Creer un compte client");
		liMenu2.put(3, "Modifier client");
		liMenu2.put(4, "Consulter les fiches client");
		liMenu2.put(5, "Supprimer client");
		Menu menu2 = new Menu(liMenu2, "BBD client");
		
		Map<Integer,String> liMenu3 = new HashMap<Integer, String>();
		liMenu3.put(1, "Prenom");
		liMenu3.put(2, "Nom");
		liMenu3.put(3, "Telelphone");
		liMenu3.put(4, "Type de client");
		liMenu3.put(5, "Adresse");
		liMenu3.put(6, "Code Postal");
		liMenu3.put(7, "Ville");
		Menu menu3 = new Menu(liMenu3, "Modification client");
		//==============================================Navigation Menu======================================================		
		try {
			System.out.println("=========================== ExaBanqueSI ===========================");
			//Initialisation de la banque
			Banque proxiBanque = new Banque("ProxiBanque");
			Agence a1 = new Agence("GLAC1","10/10/2010");
			service.attribuerBanque(a1, proxiBanque);
			Gerant g1 = new Gerant("Willis", "Bruce");
			service.attribuerAgence(g1, a1);
			
			// Initialisation des bourses
			Bourse bParis = new Bourse("Paris");
			Bourse bTokyo = new Bourse("Tokyo");
			Bourse bNY = new Bourse("New-York");
			
			//Identification du conseillé
			System.out.println("Identifiez vous : \nPrenom :");
			prenomConseille = sc.nextLine();
			System.out.println("Nom :");
			nomConseille = sc.nextLine();
			Conseille c1 = new Conseille(nomConseille, prenomConseille);
			
			//Initialisation des clients du conseillé
			service.attribuerGerant(c1, g1);
			Client clt1 =new Client("Particulier","Dupont", "Jean-Jacques","0450461313","51 chemin des bouleaux",74330,"Poisy");
			Client clt2 =new Client("Particulier","Cruise", "Tom","0379567344","32 rue Boisnet",49100,"Angers");
			Client clt3 =new Client("Entreprise","Wallace", "William","0603017867","Villa lourcine",75014,"Paris");
			service.attribuerConseille(clt1, c1);
			service.attribuerConseille(clt2, c1);
			service.attribuerConseille(clt3, c1);
			CompteCourant cpt1 = new CompteCourant(1000000, 500);
			CompteCourant cpt2 = new CompteCourant(-5500, -1000);
			CompteCourant cpt5 = new CompteCourant(-60000, -100000);
			CompteEpargne cpt6 =new CompteEpargne(3265, 0.05);
			CompteEpargne cpt7 =new CompteEpargne(3265, 0.03);
			service.attribuerCptCourant(cpt1, clt1);
			service.attribuerCptCourant(cpt2, clt2);
			service.attribuerCptCourant(cpt5, clt3);
			service.attribuerCptEpargne(cpt6, clt1);
			service.attribuerCptEpargne(cpt7, clt3);
			service.attribuerCpt(cpt1, c1);
			service.attribuerCpt(cpt2, c1);
			service.attribuerCpt(cpt5, c1);
			service.attribuerCpt(cpt6, c1);
			service.attribuerCpt(cpt7, c1);
			
			//Entrée dans le menu
			System.out.println("\nBienvenue " + c1.toString());
			do {
				//Niveau menu principale----------------------------------------------------------------------------------------------------
				menu1.afficherMenu();
				inputM1 = sc.nextInt();
				if(inputM1==1) {
					//Niveau menu secondaire "BBD Client"----------------------------------------------------------------------------------
					do {
						menu2.afficherMenu();
						input = sc.nextInt();
						if(input==1) {
							//Fonction Cr�erClient----------------------------------------------------------------------------------
							str0 = sc.nextLine();
							System.out.println("Prenom :"); prenomClient=sc.nextLine();
							System.out.println("Nom :"); nomClient=sc.nextLine();
							do {
								System.out.println("type client : \n1 = Particulier \n2 = Entreprise");
								input = sc.nextInt();
								if(input == 1) {typeClient="Particulier";}
								else if (input == 2) {typeClient="Entreprise";}
								else if (input!= 2 && input!= 1) {System.out.println("Valeur non reconnue");}
							}while(input!= 2 && input!= 1);
							System.out.println("Telephone :");str0=sc.nextLine(); telClient=sc.nextLine();	
							System.out.println("n� et rue :"); adresseClient=sc.nextLine();
							System.out.println("Code postale :"); codePostalClient=sc.nextInt();str0 = sc.nextLine();
							System.out.println("Ville :"); villeClient=sc.nextLine();
							service.attribuerConseille(new Client(typeClient,nomClient, prenomClient, telClient, adresseClient, codePostalClient, villeClient), c1);
							System.out.println("Client cree avec succees !" + c1.getLiClient().get(c1.getLiClient().size()-1));
							input =-1;
						}
						else if(input==2) {
							//Fonction AjouterCompte----------------------------------------------------------------------------------
							do {
								System.out.println("\n Liste de vos clients : ");
								service.listerClient(c1);
								System.out.println("\n A quel client souhaitez-vous ajouter un compte ? (renseignez son id)");
								str0 =sc.nextLine();
								input =sc.nextInt();
								if(input<0 || input>c1.getLiClient().size()-1) {System.out.println("ID client inconnu");}
							}while(input<0 || input>c1.getLiClient().size()-1);
							Client clt = c1.getLiClient().get(input);
							do {
								System.out.println("Type de compte a creer : \n1 = Compte Courant \n2 = Compte Epargne");
								input = sc.nextInt();
								if (input!= 2 && input!= 1) {System.out.println("Valeur non reconnue");}
							}while(input!= 2 && input!= 1);
							System.out.println("Solde initial : ");
							soldeCompte = sc.nextDouble();
							
							do {
								do {
									System.out.println("Ajouter vous une CB ? \n1 = VisaElectron \n2 = VisaPremier \n3 = non");
									cB = sc.nextInt();
									if(cB!=1 && cB!=2 && cB!=3) {System.out.println("Valeur non reconnu");}	
								}while(cB!=1 && cB!=2 && cB!=3); 
								if(input == 1) {
									System.out.println("Decouvert authorise : ");
									decouvertCompte = sc.nextDouble();	
									service.attribuerCptCourant(new CompteCourant(soldeCompte,decouvertCompte), clt);
									if(cB==1) {service.attribuerCompte(new VisaElectron(), clt.getCompteCourant());}
									else if(cB==2) {service.attribuerCompte(new VisaPremier(), clt.getCompteCourant());}
									System.out.println("Compte cree avec succees !" + clt.getCompteCourant());
								}
								else if (input == 2) {
									System.out.println("Taux d'epargne (ex 0,05): ");
									decouvertCompte = sc.nextDouble();	
									service.attribuerCptEpargne(new CompteEpargne(soldeCompte,decouvertCompte), clt);
									if(cB==1) {service.attribuerCompte(new VisaElectron(), clt.getCompteCourant());}
									else if(cB==2) {service.attribuerCompte(new VisaPremier(), clt.getCompteCourant());}
									System.out.println("Compte Epargne cree avec succees !" + clt.getCompteEpargne());
								}
								else if(input!=1 && input!=2) {System.out.println("Valeur non reconnu");}												
							}while(input!= 2 && input!= 1);
						}
						else if(input==3) {
							//Fonction Modifier Client----------------------------------------------------------------------------------
							do {
								System.out.println("\n Liste de vos clients : ");
								service.listerClient(c1);
								System.out.println("\n De quel client souhaitez-vous modifier les donnees ? (renseignez son id)");
								str0 =sc.nextLine();
								input =sc.nextInt();
								if((input<0 || input>c1.getLiClient().size()-1)) {System.out.println("ID client non reconnu");}
							}while(input<0 || input>c1.getLiClient().size()-1);
							Client clt = c1.getLiClient().get(input);
							do {
								menu3.afficherMenu();
								input = sc.nextInt();
								if(input!=0) {System.out.println(clt.toString());}
								if(input==1) {System.out.println("Nouveau prenom :");prenomClient = sc.nextLine();prenomClient = sc.nextLine();service.updateClient(clt, prenomClient, clt.getNom(), clt.getTel(), clt.getAdresse(),clt.getCodePostal(),clt.getVille(),clt.getTypeClient());System.out.println("Modification effectuée : "+ clt.toString());}
								if(input==2) {System.out.println("Nouveau Nom :");nomClient = sc.nextLine();nomClient = sc.nextLine();service.updateClient(clt, clt.getPrenom(), nomClient, clt.getTel(), clt.getAdresse(),clt.getCodePostal(),clt.getVille(),clt.getTypeClient());System.out.println("Modification effectuée : "+ clt.toString());}
								if(input==3) {System.out.println("Nouveau n° telephone :");telClient = sc.nextLine();telClient = sc.nextLine();service.updateClient(clt, clt.getPrenom(), clt.getNom(), telClient, clt.getAdresse(),clt.getCodePostal(),clt.getVille(),clt.getTypeClient());System.out.println("Modification effectuée : "+ clt.toString());}
								if(input==4) {
									do {
										System.out.println("type client : \n1 = Particulier \n2 = Entreprise");
										input = sc.nextInt();
										if(input == 1) {typeClient="Particulier";}
										else if (input == 2) {typeClient="Entreprise";}
										else if(input!=1 && input!=2) {System.out.println("Valeur non reconnu");}
									}while(input!= 2 && input!= 1);
									service.updateClient(clt, clt.getPrenom(), clt.getNom(), clt.getTel(), clt.getAdresse(),clt.getCodePostal(),clt.getVille(),typeClient);System.out.println("Modification effectuée : "+ clt.toString());}
								if(input==5) {System.out.println("Nouveau n� et rue :");adresseClient = sc.nextLine();adresseClient = sc.nextLine();service.updateClient(clt, clt.getPrenom(), clt.getNom(), clt.getTel(), adresseClient,clt.getCodePostal(),clt.getVille(),clt.getTypeClient());System.out.println("Modification effectuée : "+ clt.toString());}
								if(input==6) {System.out.println("Nouveau code postal :");codePostalClient = sc.nextInt();service.updateClient(clt, clt.getPrenom(), clt.getNom(), clt.getTel(), clt.getAdresse(),codePostalClient,clt.getVille(),clt.getTypeClient());System.out.println("Modification effectuée : "+ clt.toString());}
								if(input==7) {System.out.println("Nouvelle ville :");villeClient = sc.nextLine();villeClient = sc.nextLine();service.updateClient(clt, clt.getPrenom(), clt.getNom(), clt.getTel(), clt.getAdresse(),clt.getCodePostal(),villeClient,clt.getTypeClient());System.out.println("Modification effectuée : "+ clt.toString());}
								if(input<0 ||input>7) {System.out.println("Valeur non reconnu");};
							}while(input!=0);
							input =-1;
						}
						//Fonction Afficher Fiches Client----------------------------------------------------------------------------------
						else if(input==4) {service.listerClient(c1);}
						//Fonction Supprimer Client----------------------------------------------------------------------------------------
						else if(input==5) {						
							do {
									System.out.println("\n Liste de vos clients : ");
									service.listerClient(c1);
									System.out.println("\n Quel client souhaitez vous supprimer ? (renseignez son id)");
									str0 =sc.nextLine();
									input =sc.nextInt();
									if((input<0 || input>c1.getLiClient().size()-1)) {System.out.println("ID client non reconnu");}
								}while(input<0 || input>c1.getLiClient().size()-1);
								Client clt = c1.getLiClient().get(input);
								System.out.println("\n Client selectionee :" + clt.toString());
								do {
									System.out.println("\n Confirmez vous la suppression du client ? \n1 Supprimer le client \n2 Annuler");
									str0 =sc.nextLine();
									input = sc.nextInt();
									if(input==1) {service.deleteClient(clt); System.out.println("Client supprime !");}
									if (input!=1 && input!=2){System.out.println("Valeur non reconnu");}
								}while(input!=1 && input!=2);
							}
						else if(input!=0) {
							System.out.println("Valeur non reconnu");
						}
						}while(input!=0);
					}
				//Niveau menu principale---------------------------------------------------------------------------------------------------
				else if(inputM1==2) {
					//Fonction Virement----------------------------------------------------------------------------------
					do {
						System.out.println("\n Liste de vos clients : ");
						service.listerClient(c1);
						System.out.println("\n Quel compte souhaitez vous prelever ? (renseignez l'ID du compte)");
						idEmetteur =sc.nextInt();
						if((idEmetteur<0 || idEmetteur>c1.getLiCompte().size()-1)) {System.out.println("ID compte non reconnu");}
						}while(idEmetteur<0 || idEmetteur>c1.getLiCompte().size()-1);
					do {
						System.out.println("\n Quel compte souhaitez vous crediter ? (renseignez l'ID du compte)");
						idBeneficiaire =sc.nextInt();
						if((idBeneficiaire<0 || idBeneficiaire>c1.getLiCompte().size()-1)) {System.out.println("ID compte non reconnu" + c1.getLiClient().size());}
						}while(idBeneficiaire<0 || idBeneficiaire>c1.getLiCompte().size()-1);
					System.out.println("\n Quel montant souhaitez vous transferer ?");
					mt = sc.nextDouble();
					service.virement(idEmetteur, idBeneficiaire, mt,c1);
				}
				else if(inputM1==3) {
					//Fonction Simulation emprunt----------------------------------------------------------------------------------
					System.out.println("\n Montant emprunte :");
					mtEmprunt =sc.nextDouble();
					System.out.println("\n Taux (ex 0,05) :");
					txEmprunt =sc.nextDouble();
					System.out.println("\n Duree de l'emprunt (en mois) :");
					dureeEmprunt =sc.nextInt();
					System.out.println("Les mensualites seront de : " + service.simulationCredit(mtEmprunt, txEmprunt, dureeEmprunt)+" Euros/mois \n");
				}
				else if(inputM1==4) {
					//Fonction Placement bourse----------------------------------------------------------------------------------
					do {
						System.out.println("\n Liste de vos clients fortunes: ");
						service.listerClientFortunes(c1);
						System.out.println("\n Sur quel compte souhaitez vous investir ? (renseignez l'ID du compte)");
						idCompte = sc.nextInt();
						if((idCompte<0 || idCompte>c1.getLiCompte().size()-1)) {System.out.println("ID client non reconnu");}
					}while(idCompte<0 || idCompte>c1.getLiCompte().size()-1);
					do {
						System.out.println("\n Pour quelle bourse souhaitez vous investir ? \n1 Paris \n2 Tokyo \n3 New-York");
						input = sc.nextInt();
						if(input == 1) {bourse =bParis;}
						else if (input == 2) {bourse =bTokyo;}
						else if (input==3) {bourse =bNY;}
					}while(input!= 2 && input!= 1);
					System.out.println("\n Quel Montant souhaitez vous investir ? ");
					mtPlacement = sc.nextDouble();
					service.placerEnBourse(idCompte, bourse, mtPlacement, c1);
				}
				else if(inputM1==5) {
					//Fonction Audit agence----------------------------------------------------------------------------------
					service.auditer(c1.getGerant().getAgence());
				}
				else if(inputM1!=0) {
					System.out.println("Valeur non reconnu");
				}
			}while(inputM1!=0);
			System.out.println("====================== Au revoir et à bientot ! ===========================");
			//==============================================Gestion des erreurs======================================================			
		} catch (InputMismatchException e) {
			System.out.println("La valeur renseignee n'est pas du bon type. Veuillez recommencer");
		} catch (MontantNegatifException e) {
			System.out.println(e.getMessage());
		} catch (MontantSuperieurSoldeException e) {
			System.out.println(e.getMessage());
		}	catch (TxNegatifException e) {
			System.out.println(e.getMessage());
		}
		catch (DureeNegativeExeption e) {
			System.out.println(e.getMessage());
		}catch (ClientPauvreException e) {
			System.out.println(e.getMessage());
		}catch (CompteExistantException e) {
			System.out.println(e.getMessage());
		}finally {sc.close();};
	}
}
