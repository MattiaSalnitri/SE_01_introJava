package it.polimi.deib.se.ex05.concurrent.counter;

/**
 * @author Mattia Salnitri
 * 
 * classe che implementa un contatore, thread safe
 *
 */
public class ContatoreSbagliato {
	
	
	//variabile interna per memorizzare lo stato del contatore
	private int contatore;
	
	/**
	 * resetta il contatore
	 */
	public void reset()
	{
		contatore = 0;
		System.err.println("Reset");
	}
	
	/**
	 * decrementa il contatore
	 */
	public void decrementa()
	{
		contatore = contatore - 1;
		System.out.println("decremento, valore attuale : " + contatore);
	}
	
	/**
	 * incrementa il contatore
	 */
	public void incrementa()
	{
		contatore = contatore + 1;
		System.out.println("incremento, valore attuale : " + contatore);
	}
	
	
	
	

}
