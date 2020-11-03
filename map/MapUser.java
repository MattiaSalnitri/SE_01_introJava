package it.polimi.deib.se.ex05.concurrent.map;

/**
 * @author Mattia Salnitri
 * 
 * classe che estenede Runnable, usata per la generazione di threads
 *
 */
public class MapUser implements Runnable {

	CustomMap customMap;
	boolean add;
	
	/**
	 * costruttore
	 * 
	 * @param customMap mappa custom che venite usata
	 * @param add booleano, se TRUE il thread aggiunge elementi, altrimenti rimuove elementi
	 */
	public MapUser(CustomMap customMap, boolean add) 
	{
		this.customMap = customMap;
		this.add = add;
	}

	@Override
	public void run() 
	{
		for (Integer i =0; i<100; i++)
			if (add)
				customMap.insert(1, i.toString());
			else
				customMap.searchAndGet(1);

	}

}
