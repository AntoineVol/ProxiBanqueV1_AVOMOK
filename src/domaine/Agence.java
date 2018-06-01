package domaine;

/**
 * 
 * Agence est la classe repr�sentant une agence de la banque BroxiBanque
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 */
public class Agence {
	/**
	 * L'ID de l'Agence. Il contient 5 caract�res alphanum�rique.
	 */
	private String id;
	/**
	 * La date de cr�ation de l'Agence.
	 */
	private String date;
	/**
	 * La Banque � laquelle fait partie l'Agence
	 */
	private Banque banque;
	/**
	 * Le G�rant qui dirige l'Agence.
	 */
	private Gerant gerant;

	/**
	 * Le constructeur sans param�tres
	 */
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Le contructeur d'un objet Agence.
	 * @param id l'identifiant de l'agence.
	 * @param date date de cr�ation de l'Agence.
	 */

	public Agence(String id, String date) {
		super();
		this.id = id;
		this.date = date;
	}

	/**
	 * Retourne L'ID de l'Agence.
	 * @return  L'ID de l'Agence.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Met � jour l'ID de l'Agence
	 * 
	 * @param id
	 *            le nouveau id de l'Agence
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Retourne la date de cr�ation de l'Agence
	 * 
	 * @return la date de cr�ation de l'Agence
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Met � jour la nouvelle date de cr�ation.
	 * 
	 * @param date de cr�ation de l'Agence
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Retourne la classe Banque.
	 * @return la classe Banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * Met � jour la classe Banque.
	 * 
	 * @param banque BroxiBanque
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * Retourne la classe G�rant.
	 * 
	 * @return la classe G�rant.
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * Met � jour la classe G�rant.
	 * @param gerant G�rant de l'Agence.
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

}
