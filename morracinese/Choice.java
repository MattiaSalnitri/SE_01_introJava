package it.polimi.deib.se.ex01.morracinese;

import java.util.Random;


/**
 * @author Alessandro Rizzi, Mattia Salnitri
 * 
 * Classe enum per la gestione delle opzioni di Ggioco 
 *
 */
public enum Choice {
	CARTA, FORBICE, SASSO; 	//TODO: Estendere questa classe includendo i casi aggiuntivi LIZARD e SPOCK
							//NUOVE COMBINAZIONI:
							//	  
							//	Le forbici tagliano la carta
							//	La carta avvolge il sasso
							//	Il sasso rompe le forbici
							//	Le forbici decapitano Lizard
							//	Lizard mangia la carta
							//	La carta invalida Spock
							//	Spock vaporizza il sasso
							//	Il sasso schiaccia Lizard
							//	Lizard avvelena Spock
							//	Spock rompe le forbici
	 
	
	/**
	 * calcola se la scelta in input e' vincente/perdente rispetto a quella rappresentata dall'istanza di questa classe, da cui viene chiamato questo metodo
	 * esempio, se THIS e' CARTA e parametro e' SASSO, allora outcome e' WIN
	 * 
	 * @param other altra scelta da confrontare
	 * @return Outcome bassato sul confronto di paramentro e istanza rappresentata dall'istanza di questa classe.
	 */
	public Outcome resultAgainst(Choice other){
		if(this==other){//ATTENZIONE: posso usare operatore di confronto e confrontare puntatori, oerche sono in emun, e quindi ho solo 1 istanza per tipo.
			return Outcome.DRAW;
		}
		switch(this){//vedi sopra
		case CARTA:
			return Outcome.winsIfTrue(other==Choice.SASSO);		
		case FORBICE:
			return Outcome.winsIfTrue(other==Choice.CARTA);		
		case SASSO:
			return Outcome.winsIfTrue(other==Choice.FORBICE);	
		default:
			throw new RuntimeException("Unexpected case!");		
		}		
	}
	
	/**
	 * parsa una stringa e ritorna l'appropriata istanza di questa classe
	 * 
	 * @param input stringa da parsare
	 * @return l'istanza corretta rappresentata dalla classe
	 */
	public static Choice parseInput(String input){
		return Enum.valueOf(Choice.class, input.toUpperCase());
	}
	
	/**
	 * genera un istanza casuale di questa classe
	 * 
	 * @param random oggetto per la generazione di numeri random
	 * @return istanza di questa classe
	 */
	public static Choice getRandomChoice(Random random){
		Choice[] values = Choice.values();
		return values[random.nextInt(values.length)];
	}
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}

}
