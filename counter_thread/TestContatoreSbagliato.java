package it.polimi.deib.se.ex05.concurrent.counter;

/**
 * @author Mattia Salnitri
 *
 * Classe di test che lancia i thread che usano la classe Contatore
 *
 */
public class TestContatoreSbagliato {

	public static void main(String[] args) 
	{
		ContatoreSbagliato contatore = new ContatoreSbagliato();
		ThreadContatoreSbagliato t1 = new ThreadContatoreSbagliato(contatore, true);
		ThreadContatoreSbagliato t2 = new ThreadContatoreSbagliato(contatore, false);
		
		t1.start();
		t2.start();

	}

}
