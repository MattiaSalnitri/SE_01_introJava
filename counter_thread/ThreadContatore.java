package it.polimi.deib.se.ex05.concurrent.counter;

/**
 * @author Mattia Salnitri
 * classe per l'uso mulithread della lasse contatore
 *
 */
public class ThreadContatore extends Thread 
{
	//il contatore utilizzato
	Contatore contatore;
	//booleano per il comportamento del thread
	boolean incrementa;
	
	/**
	 * costruttire della classe
	 * 
	 * @param contatore ref al contatore utilizzato
	 * @param incrementa se TRUE incrementa il contatore, se FALSE lo decrementa
	 */
	public ThreadContatore(Contatore contatore, boolean incrementa) 
	{
		this.contatore = contatore;
		this.incrementa = incrementa;
	};

	@Override
	public void run()
	{
		
		//lancio reset solo nel thread che decrementa 
		if (!incrementa)
			contatore.reset();
		
		for (int i =0; i<15; i++)
			if (incrementa)
				contatore.incrementa();
			else
				contatore.decrementa();
	}

}
