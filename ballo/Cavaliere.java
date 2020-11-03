package it.polimi.deib.se.ex05.concurrent.ballo;

import java.util.Random;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 *
 */
public class Cavaliere extends Thread{
	
	private Stato stato = Stato.SENZA_DAMA;
	
	private Dama dama = null;
	
	private final SalaBallo salaBallo;
	
	private final Random random;
	
	private final int id;
	
	/**
	 * costruttore di cavaliere
	 * 
	 * @param id id del cavaliere
	 * @param random generatore
	 * @param salaBallo ref ad oggetto sala da ballo
	 */
	public Cavaliere(int id, Random random, SalaBallo salaBallo) {
		this.id = id;
		this.random = random;
		this.salaBallo = salaBallo;
	}
	
	
	/**
	 * metodo richiamato continuamete, che gestisce il cavaliere a seconda del suo stato
	 */
	private void iterate()
	{
		switch(stato){
		case IN_COPPIA:
			System.out.println("Sono " + id + ". Ballo con " + dama.getId());
			try {
				Thread.sleep(5000*random.nextInt(5));
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			stato = Stato.IN_CRISI;						
			break;
		case IN_CRISI:
			System.out.println("Sono " + id + ". Sono in crisi con " + dama.getId());
			salaBallo.riconsegnaDama(dama);
			stato = Stato.SENZA_DAMA;
			break;
		case SENZA_DAMA:
			System.out.println("Sono " + id + ". Aspetto!");
			dama = salaBallo.prendiDamaLibera();
			stato = Stato.IN_COPPIA;
			break;
		default:
			break;
		
		}
	}
	
	@Override
	public void run() {
		while(true){
			iterate();			
		}		
	}
	
}
