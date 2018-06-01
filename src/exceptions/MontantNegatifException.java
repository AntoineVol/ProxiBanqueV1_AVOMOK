package exceptions;

/**
 * @author KHEZNADJI et VOLATRON
 * @version 1.0
 * Classe Exception veillant � la valeur positive du montant lorsqu'elle est demand�e � l'utilisateur
 */
public class MontantNegatifException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message Message indiquant qu'il est interdit de renseigner un montant n�gatif
	 */
	public MontantNegatifException(String message) {
		super(message);
	}
	
}
