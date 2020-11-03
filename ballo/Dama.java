package it.polimi.deib.se.ex05.concurrent.ballo;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 *
 */
public class Dama {
	
	private final int id;
	
	/**
	 * costruttore della classe
	 * @param id
	 */
	public Dama(int id) {
		this.id = id;
	}
	
	/**
	 * getter dell'id della dama
	 * 
	 * @return
	 */
	public int getId(){
		return id;
	}

}
