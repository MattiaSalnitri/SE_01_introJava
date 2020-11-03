package it.polimi.deib.se.ex05.concurrent.map;

/**
 * @author Mattia Salnitri
 * 
 * classe che testa la mappa creando 2 thread
 *
 */
public class TestCustomMap {

	public static void main(String[] args) 
	{
		CustomMap t = new CustomMap();
		MapUser mu1 = new MapUser(t, false);
		MapUser mu2 = new MapUser(t, true);
		
		Thread  t1 =new Thread(mu1);
		Thread  t2 =new Thread(mu2);

		t1.start();
		t2.start();


		

	}

}
