package it.polimi.deib.se.ex02.persona;

/**
 * @author Alessandro Rizzi, Mattia Salnitri
 * 
 * classe di test per clase persona e tutta classe che la estendono
 *
 */
public class Saluta {

	public static void main(String[] args) 
	{
		Persona p = new Persona();
		PersonaEducata pe =new PersonaEducata();
		PersonaMaleducata pm =new PersonaMaleducata();
		PersonaMaleducatissima pmm=new PersonaMaleducatissima();
		
		System.out.println(p.saluto());
		//pe = p; 						//non posso, p e' un supertipo di pe. 
		p = pe;
		System.out.println(p.saluto());
		//pe = pm; 						//non posso, non sono collegate gerarchicamente
		System.out.println(pe.saluto());
		System.out.println(pm.saluto());
		p = new PersonaMaleducata();	//ok perche' pm e' un sottotipo (quindi implementa tutti i metodi di p)
		System.out.println(p.saluto());
		//pm =  p;						//p e' supertipo, quindi il comnpilatore mi da errore. ma io dalla riga sopra so che p contiene pm, quindi posso forszare con il casting, e verra' controllata a runtime 
		//pmm = (PersonaMaleducatissima) pm; //errore (a runtime) perche' forzo casting, perche' pm e' supertipo di pmm 
		System.out.println(pmm.saluto());

	}

}
