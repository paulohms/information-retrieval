package br.com.ori;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class VerificaPalavraErrada {

	private ArrayList<String> referencia = new ArrayList<String>();
	private String PalavraCorreta = null;
	private BufferedReader buffer;

	public ArrayList<String> populaReferencias() throws IOException {

		buffer = new BufferedReader(new FileReader("/media/ph/DADOS/palavras.txt"));

		while (buffer.ready()) {
			String aux = buffer.readLine();
			String vet[] = aux.split(" ");

			for (String a : vet) {
				referencia.add(a);
			}

		}

		return referencia;

	}

	public String verifica(ArrayList<String> a, String palavra) {

		int min = Integer.MAX_VALUE;

		for (String aux : a) {
			int tam = computeLevenshteinDistance(aux, palavra);
			if (tam < min) {
				min = tam;
				PalavraCorreta = aux;
			}
		}

		return PalavraCorreta;

	}

	private int minimum(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	public int computeLevenshteinDistance(String str1, String str2) {
		int[][] distance = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i <= str1.length(); i++)
			distance[i][0] = i;
		for (int j = 1; j <= str2.length(); j++)
			distance[0][j] = j;

		for (int i = 1; i <= str1.length(); i++)
			for (int j = 1; j <= str2.length(); j++)
				distance[i][j] = minimum(
						distance[i - 1][j] + 1,
						distance[i][j - 1] + 1,
						distance[i - 1][j - 1]
								+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
										: 1));

		return distance[str1.length()][str2.length()];
	}

	public ArrayList<String> getReferencia() {
		return this.referencia;
	}

	public String getPalavraCorreta() {
		return this.PalavraCorreta;
	}

}
