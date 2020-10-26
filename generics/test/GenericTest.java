package it.polimi.deib.se.ex02.generics.test;

import java.util.ArrayList;

/**
 * @author Mattia Salnitri
 * 
 * Classe di test per generics
 *
 * @param <G> il tipo della variabile interna
 */
public class GenericTest<G> {
	private G var;

	/**
	 * Costruttoire della classe che usa il generic definito a livello di classe, nel parametro
	 * 
	 * @param var
	 */
	public GenericTest(G var) 
	{
		this.var= var;
	}
	
	/**
	 * Stter che usa un generic come parametro
	 * 
	 * @param var variabile di tipo sconosiuto a livello di classe
	 */
	public void setVar(G var)
	{
		this.var = var;
	}
	
	/**
	 * Setter che usa un generic come tipo di output
	 * 
	 * @return tipo sconosiuto a livello di classe
	 */
	public G setVar()
	{
		return var;
	}
	
	/**
	 * funzione che usa due generics, uno per definire il tipo di input
	 * 
	 * @param element elemento di tipo sconoscoito a livello di classe
	 */
	public <E,F> void setArray (E element)
	{
		 ArrayList<E> elements = new ArrayList<E>(12);
		 ArrayList<F> elements2 = new ArrayList<F>(10);
		 F var2;
		 
		 elements.add(element);

		 
		 elements.size();
		 elements2.size();
		
	}

}
