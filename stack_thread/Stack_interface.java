package it.polimi.deib.se.ex05.concurrent.stack;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 *
 * interfaccia per uno stack, LIFO
 */
public interface Stack_interface {
	
	/**
	 * inserisce un elemento nello stack
	 * 
	 * @param n elemento da inserire
	 */
	void push(int n);
	
	/**
	 * estrare il primo elemento
	 * 
	 * @return elemento estratto
	 */
	int pop();
	
	/**
	 * controlla se lo stack e' vuoto 
	 * 
	 * @return
	 */
	boolean is_empty();

}
