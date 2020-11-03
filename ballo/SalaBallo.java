package it.polimi.deib.se.ex05.concurrent.ballo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 *
 * classe che gestisce la sala da ballo
 *
 */
public class SalaBallo {
	
	//lista dame disponibili
	private List<Dama> dameDisponibili = new ArrayList<Dama>();
	
	//lista dame in crisi.
	//una dama e' in crisi se non ha una dma con cui parlare. quindi questa lista conterra' sempre, al massimo due dame.
	private List<Dama> dameInCrisi = new ArrayList<Dama>();
	
	private final Random random = new Random();
	
	/**
	 * costruttore, crea dame e cavalieri
	 * 
	 * @param numCavalieri
	 * @param numDame
	 */
	public SalaBallo(int numCavalieri, int numDame){
		for(int i=0;i < numDame; i++){
			dameDisponibili.add(new Dama(i));			
		}
		for(int i=0;i < numCavalieri; i++){
			new Cavaliere(i, random, this).start();
		}
	}
	
	/**
	 * Metodo che restutuisce una dama libera e la rimuove dalla lista delle dame libere 
	 * @return dama rimossa dalla lista delle dame
	 */
	public synchronized Dama prendiDamaLibera(){
		while(dameDisponibili.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		Dama result = dameDisponibili.remove(random.nextInt(dameDisponibili.size()));
		return result;
	}
	
	/**
	 * metodo che prende una dama, e la aggiunge alla lista delle dame libere
	 * 
	 * @param dama dama da aggiungere alla lista di dame libere
	 */
	public synchronized void riconsegnaDama(Dama dama){
		dameInCrisi.add(dama);
		
		//se la dama riconsegnata appartiene alle dame incrisi e il numero delle dame in crisi e' dispari 
		while(dameInCrisi.size() % 2 != 0 && 
				(dameInCrisi.contains(dama))//se la dama e' tra quelle in crisi, quindi non e' gia' stata riconsegnata da un altra istanza di cavaliere 
				)
		{
			try {
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		//se la dame appartiene alle dame in crisi (falso quando qualcun altro ha messo la dama tra quelle disponibili)
		if(dameInCrisi.contains(dama))
		{
			dameInCrisi.remove(dama);
			dameDisponibili.add(dama);
			//aggiungi un altra dame (tra quelle in crisi) a quelle disponibili
			dameDisponibili.add(dameInCrisi.remove(new Random().nextInt(dameInCrisi.size())));//questa va bene per il controlllo sopra per cui le dame incrisi devono essere pari ( quindi almeno un altra ce ne sara')		
			notifyAll();		
		}
	}
	
	public static void main(String[] args) {
		new SalaBallo(5, 3);
		
	}
	
	

}
