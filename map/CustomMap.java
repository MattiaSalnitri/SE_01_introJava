package it.polimi.deib.se.ex05.concurrent.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 *
 * classe per definizione di map custom 
 *
 */
public class CustomMap {
	
	private final int MAX_SIZE = 100;
	
	private int currentSize = 0;
	
	private final Map<Integer, List<String>> table = new HashMap<Integer, List<String>>();
	
	/**
	 * ricerca una chiave e ritorna tutti gli elementi memorizzati con quella chiave. canvcella tutti gli elementi e la chiave dalla mappa
	 * 
	 * @param key chiave da cercare
	 * @return lista di stringhe corrisponenti alla chiave
	 */
	public synchronized List<String> searchAndGet(int key){
		List<String> values = table.remove(key);
		if(values == null){
			return null;//giusto cosi' o meglio lanciare eccezione?
		}
		currentSize -= values.size();
		System.out.println("rimossi gli elementi: " + values);
		
		notifyAll();
		return values;	
	}
	
	/**
	 * inserisce elemento in map
	 * 
	 * @param key chiave dell'elemento
	 * @param value valore dell'elemento
	 */
	public synchronized void insert(int key, String value)
	{	
		while(currentSize == MAX_SIZE)
		{
			try {
				wait();
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		if(!table.containsKey(key)){
			table.put(key, new ArrayList<String>());
		}
		
		table.get(key).add(value);
		currentSize++;
		System.out.println("aggiunto elemento "+ value );
	}
	

}
