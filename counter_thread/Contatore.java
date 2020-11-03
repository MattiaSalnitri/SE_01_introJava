package it.polimi.deib.se.ex05.concurrent.counter;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 * 
 * classe che gesticse un contatore, thread safe
 *
 */
public class Contatore {
	
	private int contatore;
	
	/**
	 * metodo che resetta il contatore, solo nel caso che il contatore sia dieci
	 * 
	 * ATTENZIONE: questo metodo blocca sempre la classe se non viene chiamato quando e' a 10
	 */
	public synchronized void reset()
	{
		//se il contatore e' diverso da dieci non resetto, il metodo aspetta che qualcun altro ci arrivi
		while(contatore != 10){
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("errore wait contatore");
			}
		}
		
		contatore = 0;
		System.out.println("Reset");
		notifyAll();//riattiva tutti i thread in wait
	}
	
	/**
	 * metodo che decrementa il contatore
	 */
	public synchronized void decrementa()
	{
		//se il contatore e' a zero non posso decrementare, aspetto finche' qyalcun altro non lo incrementa
		while(contatore == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("errore wait contatore");
			}			
		}
		contatore = contatore - 1;
		System.out.println("decremento, valore attuale : " + contatore);
		notifyAll();
	}
	
	/**
	 * metodo che incrementa il contatore
	 */
	public synchronized void incrementa()
	{
		//se il contatore e' a 10 non posso incrementare, aspetto finche qualcuno non decrementa
		while(contatore == 10){
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("errore wait contatore");
			}			
		}
		contatore = contatore + 1;
		System.out.println("incremento, valore attuale : " + contatore);
		notifyAll();
	}
	
	
	
	

}
