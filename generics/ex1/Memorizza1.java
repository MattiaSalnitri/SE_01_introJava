package it.polimi.deib.se.ex02.generics.ex1;

/**
 * @author Mattia Salnitri
 * 
 * Classe con un generic
 *
 * @param <tipo_memorizzato> il generic che verra' usato come tipo per laclasse memorizzata 
 */
public class Memorizza1 <tipo_memorizzato> 
{
	private tipo_memorizzato stored;

	/**
	 * costruttore della classe
	 * 
	 * @param stored parametro da memorizzare
	 */
	public Memorizza1(tipo_memorizzato stored) 
	{
		this.stored= stored;
	}
	
	

	/**
	 * ritorna contenuto della classe formattato, pronto per essere stampato
	 * 
	 * @return output formattato
	 */
	public String toString()
	{
		return stored.toString();//posso perche tutte le classi estendono object
	}
	

	public static void main(String[] args) 
	{
		Memorizza1<String> memorizza1 = new Memorizza1<String>("ciao");
		System.out.println(memorizza1);
		
		Memorizza1<Integer> memorizza12 = new Memorizza1<Integer>(3);
		System.out.println(memorizza12);
		
	}

}
