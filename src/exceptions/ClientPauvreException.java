package exceptions;

/**
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 * Classe Exception veillant � l'elligibilit� d'un compte pour les placements en bourse
 */
public class ClientPauvreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message Message d'erreur de l'exception pour indiquer la non-l'elligibilit� du compte
	 */
	public ClientPauvreException(String message) {
		super(message);
		
	}

}
