package it.polimi.deib.se.ex05.concurrent.counter;

/**
 * @author Mattia Salnitri
 *
 * Classe di test che lancia i thread che usano la classe Contatore
 *
 */
public class TestContatore {

	public static void main(String[] args) 
	{
		Contatore contatore = new Contatore();
		ThreadContatore t1 = new ThreadContatore(contatore, true);
		ThreadContatore t2 = new ThreadContatore(contatore, false);
		
		t1.start();
		t2.start();

	}

}
