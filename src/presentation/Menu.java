package presentation;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe permettant la création automatique de Menu"Console" à partir de la liste de choix et d'un titre
 * La largeur du menu est un de ses attribut
 * @author VOLATRON
 *
 */
public class Menu {
	private Map<Integer, String> liste = new HashMap<Integer,String>();
	private String titre;
	private int largeurMenu = 61;
	
	/**
	 * Constructeur du menu
	 * @param liste Liste des choix du menu
	 * @param titre	Titre du menu
	 */
	public Menu(Map<Integer, String> liste, String titre) {
		super();
		this.liste = liste;
		this.titre=titre;
	}
	
	/**
	 * Methode affichant le menu designé dans la console
	 */
	public void afficherMenu() {
		String rptM = new String(new char[(this.largeurMenu-this.titre.length())/2]).replace("\0", "-");
		System.out.println("/"+rptM + this.titre +rptM+"\\");

		
		for (Map.Entry<Integer, String> ent : this.liste.entrySet()) {
			String valC = "|  "+ ent.getKey() + " ---> " + ent.getValue();
			String rptL = new String(new char[largeurMenu - valC.length()]).replace("\0", " ");
			System.out.println(valC + rptL + "|");
		}
		
		String valQ = "|  0 ---> Quitter";
		String rptQ = new String(new char[largeurMenu - valQ.length()]).replace("\0", " ");
		System.out.println(valQ+rptQ +"|");
		
		String valA = "|  Que souhaitez vous faire : ";
		String rptA = new String(new char[largeurMenu - valA.length()]).replace("\0", " ");
		System.out.println(valA +rptA + "|");
		
		String rptF = new String(new char[largeurMenu-1]).replace("\0", "_");
		System.out.println( "|" +rptF + "|");
	}
	

}
