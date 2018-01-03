package synch_rep;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Serveur serv = new Serveur();
	
		serv.creerRepertoire("mes cours");
		serv.creerRepertoire("mes cours./histoire.txt");
		serv.creerRepertoire("mes cours./histoire");
		serv.creerRepertoire("mes cours./maths");
		serv.creerRepertoire("mes cours./francais");
		serv.creerRepertoire("mes cours./anglais");
		serv.creerRepertoire("mes cours./philo");
		serv.creerRepertoire("mes cours./musique");
		serv.creerRepertoire("mes cours./musique./regae");
		serv.creerRepertoire("mes cours./musique./classique");
		serv.creerRepertoire("mes cours./musique./RNB");
		
		serv.ListerRepertoire("mes cours");
		serv.ListerRepertoire("mes cours./musique");
		
			
		
		

	}

}
