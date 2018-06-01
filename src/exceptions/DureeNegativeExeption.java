package exceptions;

/**
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 * Classe Exception veillant � la valeur positive du nombre de mois lorsqu'elle est demand�e � l'utilisateur
 */
public class DureeNegativeExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message Message indiquant qu'il est interdit de renseigner un nombre de mois n�gatif
	 */
	public DureeNegativeExeption(String message) {
		super(message);
	}
	

}
