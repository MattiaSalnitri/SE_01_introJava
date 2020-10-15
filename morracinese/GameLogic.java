package it.polimi.deib.se.ex01.morracinese;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 * 
 * Classe per la gestione della logica di gioco ed I/O
 *
 */
public class GameLogic {	
	
	private final Scanner scanner;
	
	/**
	 * Costruttore della classe
	 * 
	 * @param input input stream per leggere le scelte dell;'utente
	 */
	public GameLogic(InputStream input) {
		this.scanner = new Scanner(input);
	}

	/**
	 * Chiude input stream
	 */
	public void close() {
		scanner.close();		
	}
	
	/**
	 * gestisce generazione di scelta random e output risultato
	 * 
	 * @param userChoice la scelta dell'utente
	 * @return Outcome risultato del gioco
	 */
	private Outcome choiceSubmitted(Choice userChoice){
		Choice computerChoice = Choice.getRandomChoice(new Random());
		System.out.println("Ho scelto " + computerChoice + "!");
		return userChoice.resultAgainst(computerChoice);
	}

	/**
	 * classe che gestisce un turno di gioco
	 * 
	 * @return TRUE, sempre ( vedi ultimo commento in questa funzione
	 */
	public boolean round() {
		System.out.println("Che scelta fai?");
		String input = scanner.next();
		try{
			Choice choice = Choice.parseInput(input);
			System.out.println("Hai scelto " + choice + "!");
			System.out.println(choiceSubmitted(choice));//parte "AI"
		}catch(IllegalArgumentException e){
			System.out.println("Scelta non valida!");
		}
		return true; //Attualmente il gioco va avanti all'infinito
					 //TODO Modificare l'implementazione per chiedere all'utente se continuare o meno.
	}
	
	public static void main(String[] args) {
		GameLogic gameLogic = new GameLogic(System.in);
		boolean cont;
		do{
			cont = gameLogic.round();
		}while(cont);
		gameLogic.close();
	}

}
