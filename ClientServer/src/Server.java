import java.net.*;
import java.nio.channels.FileChannel;
import java.io.*;


public class Server {
	
		public static void main(String[] zero){
		
		ServerSocket socket;
		try {
		socket = new ServerSocket(2009);
		Thread t = new Thread(new Accepter_clients(socket));
		t.start();
		System.out.println("Mes employeurs sont prêts !");
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	
		
		public void ListerRepertoire(string sourcepath) {
			
				File myDir = new File (sourcepath); // Avec source contenant le chemin d'un dossier
				File[] file=myDir.listFiles();
				System.out.println ("Liste des fichiers");
				for (File element : file)
				{
					System.out.println (element.getName());					
				}

			
			
		}
		
		public void creerRepertoire(string sourcepath)
		{
			File repertoire = new File(sourcepath);
			repertoire.mkdir();
		}
		
		
		private void copyFile (File source, File destination) throws IOException
		{
			
			FileChannel in = null; // canal d'entrée
			FileChannel out = null; // canal de sortie

			try {
				destination.createNewFile();
			} catch (IOException e1) {
				// TODO Bloc catch auto-généré
				e1.printStackTrace();
				try {
					System.out.println ("Erreur: Impossible de copier le fichier " + source.getCanonicalPath()+ " vers " + destination.getCanonicalPath() + "(pb. sur la destination (droits/destination absente)");
				} catch (IOException e) {
					// TODO Bloc catch auto-généré
					e.printStackTrace();
				}
			}

			try {
				in = new FileInputStream(source).getChannel();
				out = new FileOutputStream(destination).getChannel();
			 
				// Lancer la copie...
				in.transferTo(0, in.size(), out);
			} catch (IOException e) {
				try {
					System.out.println ("Erreur durant la copie du fichier " + source.getCanonicalPath() + " vers " + destination.getCanonicalPath());
				} catch (IOException e1) {
					// TODO Bloc catch auto-généré
					e1.printStackTrace();
				}
				
				throw (IOException) e;
				
			} finally { // Dans tous les cas, fermeture des flux
				if (in != null)
				{
					try {
						in.close();
					} catch (IOException e)
					{
						System.out.println ("Erreur durant la copie du fichier, impossible de fermer le flux en entrée.");
					}
				}
				if (out != null) 
				{
					try {
						out.close();
					} catch (IOException e)
					{
						System.out.println ("Erreur durant la copie du fichier, impossible de fermer le flux en sortie.");
					}
				}
				
			}
		}
	}
	}
}


	   

