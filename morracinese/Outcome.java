package it.polimi.deib.se.ex01.morracinese;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 *
 * Classe enum per la gestione del risultato delle partitre
 */
public enum Outcome {
	WINNER("Hai vinto!"), LOSER("Hai perso!"), DRAW("Parita'!");
	
	private final String message;

	/**
	 * Costruttore PRIVATO. il costruttore setta una variabile interna per stampare un messaggio leggibile dall'utente
	 * 
	 * @param message
	 */
	private Outcome(String message){
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}
	

	/**
	 * Classe che ritorna istanza WINNER o LOSER
	 * 
	 * @param condition booleano
	 * @return WINNER se parametro e' TRUE, LOSER se parametro e FALSE
	 */
	public static Outcome winsIfTrue(boolean condition){
		return (condition)?Outcome.WINNER:Outcome.LOSER;
	}


}
