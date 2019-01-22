package br.com.ori;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import br.com.ori.Dicionario;

public class EscreveHashTable {

	private static String path = "/media/ph/DADOS/hashCorpus/hashtable.ris";

	public void escreverHashTable(ArrayList<Dicionario> dic) {
		
		try{

		Writer writer = new FileWriter(path);

		for (Dicionario d : dic) {
			writer.write("\nToken:\t" + d.getToken() + "\tdocID:\t" + d.getDocIDs());
		}
		writer.close();
		}catch(IOException io){
			System.out.println("Error: O diretório não existe :"+ path.replace("hashtable.ris", ""));
			System.exit(0);
		}
	}

}
