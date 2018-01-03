package synch_rep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class Client {

	//Copie un fichier source pour l'envoyer dans un fichier destination
	public void copyFile(File source, File destination) throws IOException
	{

		FileChannel in = null; // canal d'entrée
		FileChannel out = null; // canal de sortie

		//Creation du fichier destination
		try {
			destination.createNewFile();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
			try {
				System.out.println ("Erreur: Impossible de copier le fichier " + source.getCanonicalPath()+ " vers " + destination.getCanonicalPath() + "(Probleme sur la destination (droits/destination absente)");
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}

		//Ouverture des flux
		try {
			
			in = new FileInputStream(source).getChannel();
			out = new FileOutputStream(destination).getChannel();

			in.transferTo(0, in.size(), out); // Lancer la copie du fichier

		} 
		catch (IOException e) {
			try {
				System.out.println ("Erreur durant la copie du fichier " + source.getCanonicalPath() + " vers " + destination.getCanonicalPath());
			} 
			catch (IOException e1) {

				e1.printStackTrace();
			}

			throw (IOException) e;

		} 

		// Dans tous les cas, fermeture des flux
		finally { 
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
