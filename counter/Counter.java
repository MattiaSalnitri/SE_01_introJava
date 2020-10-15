package it.polimi.deib.se.ex01.counter;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 * 
 * Classe che usa una variabile statica per contare le istanze (oggetti) che vengono generate con il costruttore
 *
 */
public class Counter {
	
	//Contatore condiviso tra tutte le istanze
	private static int counter = 0;
	
	//Numero della specifica istanza
	private final int number;

	
	/**
	 * costruttore della classe
	 * incrementa di 1 l'a variabile statica counter
	 */
	public Counter(){
		number = counter;
		counter=counter+1;
	}
	
	/**
	 * getter della variabile contenente il numero dell'istanza 
	 * 
	 * @return
	 */
	public int getNum() {
		return number;
	}
    
	// nota il metodo toString puo' essere generato automaticamente in eclipse sfruttando source > generateToString();
	@Override
	public String toString(){
        	return number + " of " + counter;
	}
}