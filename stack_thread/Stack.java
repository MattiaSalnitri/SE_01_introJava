package it.polimi.deib.se.ex05.concurrent.stack;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 * classe per la gestione di uno stack tread safe
 *
 */
public class Stack implements Stack_interface{
	
	/**
	 * @author Alessandro Rizzi, Mattia Salnitri
	 * innerclass per la gestione degli elementi dello stack
	 *
	 */
	private class Element {
		int info;
		Element next;
		
		/**
		 * costruttore della classe
		 * per una lista linkata
		 * @param n elemento
		 * @param e referenza all'elemento precedente
		 */
		Element(int n, Element e){
			info = n;
			next = e;
		}
	}
	
	/**
	 * primo elemento dello stack
	 */
	private Element first;
	
	/**
	 * costruttore
	 */
	public Stack(){
		first = null;
	}	
	
	public synchronized void push(int n){
		first = new Element(n, first);
		notifyAll();
	}
	
	public synchronized int pop(){
		while(first == null){
			try {
				wait();
			} catch (InterruptedException e) {				
			}
		}
		Element element = first;
		first = first.next;
		return element.info;
	}
	
	public synchronized boolean is_empty(){
		return (first == null);
	}

}
