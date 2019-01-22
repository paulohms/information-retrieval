package br.com.ori;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;

public class Leitura {

	private static File diretorio;
	static int totalArquivos;

	ArrayList<Token> documento = new ArrayList<Token>();
	ArrayList<TokenTrigram> documentoTrigram = new ArrayList<>();

	public void processarDoc(String path) throws FileNotFoundException,IOException {

		diretorio = new File(path);
		String nomesDir[] = diretorio.list();
		totalArquivos = nomesDir.length;

		for (String nomes : nomesDir) {
			
			BufferedReader buffer = new BufferedReader(new FileReader(path + nomes));

			while (buffer.ready()) {
				
				String aux = buffer.readLine();

				if (aux.startsWith("T1")) {

					String[] tokens = aux.split(" ");
					
					for (String a : tokens) {

						Token t = new Token(a.toLowerCase().trim().replaceAll("\\W\\n+\\s+\\t.&amp;-,()0-9//",""), Integer.parseInt(nomes.replace(".ris", "")));
						TermoGram tg = new TermoGram();
						tg.trigrama(a.toLowerCase().trim().replaceAll("\\W\\n+\\s+\\t.&amp;-,()0-9//", ""));
						documento.add(t);
						documentoTrigram.addAll(tg.getArray());

					}
				}
			}
			buffer.close();
		}

	}

	public ArrayList<Token> getDocumento() {
		return documento;
	}

	public ArrayList<TokenTrigram> getDocumentoTrigram() {
		return documentoTrigram;
	}

	public void imprimeIntersessao(SortedSet<Integer> intersessao, String path)
			throws IOException {

		if (intersessao != null && !intersessao.isEmpty()) {
			int indice = 0 ;

			System.out.println("\nDocumentos que satisfazem a pesquisa:\n ");

			for (Integer nomes : intersessao) {

				BufferedReader buffer = new BufferedReader(new FileReader(path + nomes + ".ris"));

				while (buffer.ready()) {
					String aux = buffer.readLine();

					if (aux.startsWith("T1")){
						System.out.println("Ref: "+indice+" DocID: " + nomes + ".ris\t" + " Texto: " + aux);
						indice++;
					}
				}

				buffer.close();
			}
		} else
			System.out.println("Não existem registros que satisfazem a pesquisa !");
	}

}
