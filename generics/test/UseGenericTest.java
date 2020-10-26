package it.polimi.deib.se.ex02.generics.test;

import it.polimi.deib.se.ex02.persona.Persona;

/**
 * @author Mattia Salnitri
 * 
 * Classe di test per classe "GenericTest"
 *
 */
public class UseGenericTest {

	public static void main(String[] args) 
	{
		GenericTest<String> v1 = new GenericTest<String>("ciao");
		GenericTest<Persona> v2 = new GenericTest<Persona>(new Persona());
		
		v2.<String, String>setArray("ciao"); // uso di generics esplicito
		
		v1.setArray("ciao"); //uso di generics implicito
		
	}
}
