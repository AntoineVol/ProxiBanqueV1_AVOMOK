package exceptions;

/**
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 * Classe Exception veillant � ce que le montant retir� soit inferieur au montant disponible (Decouvert authoris� pris en compte)
 */
public class MontantSuperieurSoldeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message Message alertant dans le cas o� le solde n'est pas suffisant
	 */
	public MontantSuperieurSoldeException(String message) {
		super(message);
	}
	
}
