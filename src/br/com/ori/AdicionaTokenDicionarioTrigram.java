package br.com.ori;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class AdicionaTokenDicionarioTrigram {

	private ArrayList<DicionarioTrigram> dicionario;
	ArrayList<String> docsID;

	public AdicionaTokenDicionarioTrigram() {
		dicionario = new ArrayList<DicionarioTrigram>();
	}

	public void add(ArrayList<TokenTrigram> documento) {

		DicionarioTrigram d = new DicionarioTrigram();
		String termo = null;

		for (TokenTrigram t : documento) {

			if (termo == null) {

				termo = t.getTermo();
				docsID = new ArrayList<String>();
				docsID.add(t.getDocID());

			} else if (termo.equals(t.getTermo()))
				docsID.add(t.getDocID());
			else {

				SortedSet<String> aux = new TreeSet<>();
				aux.addAll(docsID);
				d.addDicionario(termo, aux);
				dicionario.add(d);
				d = new DicionarioTrigram();
				docsID = new ArrayList<String>();
				termo = t.getTermo();
				docsID.add(t.getDocID());

			}

		}

	}

	public ArrayList<DicionarioTrigram> getDicionario() {
		return this.dicionario;
	}
}