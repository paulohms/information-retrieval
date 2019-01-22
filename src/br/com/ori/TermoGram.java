package br.com.ori;

import java.util.ArrayList;

public class TermoGram {

	ArrayList<TokenTrigram> att = new ArrayList<>();

	public void trigrama(String termo) {

		char[] trigram = new char[3];
		ArrayList<char[]> termos = new ArrayList<char[]>();
		int indice = 0;

		for (int i = 0; i < termo.length(); i++) {

			if (indice != 3 && i != termo.length() - 1)
				trigram[indice] = termo.charAt(i);
			else {
				termos.add(trigram);
				trigram = new char[3];
				indice = 0;
				trigram[indice] = termo.charAt(i);
			}
			indice++;
		}

		for (char[] s : termos) {
			TokenTrigram tt = new TokenTrigram(s[0] + "" + s[1] + "" + s[2],
					termo);
			att.add(tt);
		}

	}

	public void bigrama(String termo) {

		termo = "$" + termo + "$";

	}

	public ArrayList<TokenTrigram> getArray() {
		return this.att;
	}

}
