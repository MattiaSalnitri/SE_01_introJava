package it.polimi.deib.se.ex02.generics.ex1;

/**
 * @author Mattia Salnitri
 *
 * @param <Tipo1> tipo della prima variabile da memorizzare
 * @param <Tipo2> tipo della seconda variabile da memorizzare
 */
public class Memorizza2 <Tipo1, Tipo2> {

	Tipo1 storedVar1;
	Tipo2 storedVar2;
	
	/**
	 * Costruttire della classe
	 * 
	 * @param storedVar1 prima variabile da memorizzare
	 * @param storedVar2 seconda variabile da memorizzare
	 */
	public Memorizza2(	Tipo1 storedVar1, Tipo2 storedVar2) 
	{
		this.storedVar1 = storedVar1;
		this.storedVar2 = storedVar2;
	}
	
	/**
	 * ritorna contenuto della classe formattato, pronto per essere stampato
	 * 
	 * @return output formattato
	 */
	public String toString()
	{
		return "" + storedVar1 + storedVar2;
	}

	public static void main(String[] args) 
	{
		Memorizza2<String, Integer> memorizza2 = new Memorizza2<String, Integer>("ciao", 4);
	
	}
	

}
