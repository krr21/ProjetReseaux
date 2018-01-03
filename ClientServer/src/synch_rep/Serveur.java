package synch_rep;

import java.net.*;
import java.io.*;



public class Serveur {
		
	public void serveur(String[] zero){
		
		ServerSocket socket;
		try {
		socket = new ServerSocket(2009);
		Thread t = new Thread(new Accepter_clients(socket));
		t.start();
		System.out.println("Mes employeurs sont prêts !");
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	//Liste les repertoires et sous repertoire
	public void ListerRepertoire(String sourcepath) {
			
		File myDir = new File (sourcepath); // Avec source contenant le chemin d'un dossier
		File[] file = myDir.listFiles();
		System.out.println (""+sourcepath);
		for (File element : file)
		{
			System.out.println ("  >"+element.getName());					
		}		
			
	}
		
	//Cree un repertoire
	//Pour creer un sous repertoire/fichier, il faut mettre en parametre le chemin du repertoire pere
	public File creerRepertoire(String sourcepath)
	{
		File repertoire = new File(sourcepath);
		repertoire.mkdir();
		return repertoire;
	}
			
}
		

		



	   

