package ramonix;

import java.util.ArrayList;
public class Principal {
        
        static final String HACKERS[] = { "Neo", "P4q1T0", "PaU3T", "Ab4$t0$" };
    
	public static void main(String[] args) {
		Hacker neo = new Hacker("Neo","Neo",20,2,true);
                Hacker morfeo = new Hacker("Mofeo","P4q1T0",10,1,true);
                Hacker triniti = new Hacker("Triniti","PaU3T",10,1,true);
                Hacker smith = new Hacker("Smith","Ab4$t0$",10,1,false);
                
                SalaReunions salaReunions = new SalaReunions();
                
                salaReunions.addHacker(neo);
                salaReunions.addHacker(morfeo);
                salaReunions.addHacker(triniti);
                salaReunions.addHacker(smith);
                
                Ramonix ramonix = new Ramonix(500, salaReunions);
	}
}
