package br.com.ori;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Dicionario {

	private Token token;
	private int termID;
	private ArrayList<DocId> docIds;
	private ArrayList<Dicionario> dicionario ;

	public void addDicionario(Token token, int termID, ArrayList<DocId> aux) {

		this.token = token;
		this.termID = termID;
		this.docIds = aux;

	}

	@Override
	public String toString() {
		return "\n token -> " + this.token.getTermo() + "  termoID->  "
				+ this.termID + "  Documentos ->  " + docIds + " Df -> "
				+ token.getDf();
	}

	public void setTermID(int termId) {
		this.termID = termId;
	}

	public void setDocsID(ArrayList<DocId> docIds) {
		this.docIds = docIds;
	}

	public String getToken() {
		return this.token.getTermo();
	}

	public ArrayList<DocId> getDocIDs() {
		return this.docIds;
	}

	public SortedSet<Integer> buscaTokens(String token,ArrayList<Dicionario> list) {
		SortedSet<Integer> d = new TreeSet<>();
		for (Dicionario t : list) {

			if (t.getToken().equals(token)) {
				for (DocId diD : t.getDocIDs()) {
					d.add(diD.getDocID());
				}
				return d;
			}
		}

		return null;

	}

	public SortedSet<Integer> insercecaoArrays(SortedSet<Integer> result1,
			SortedSet<Integer> result2) {

		SortedSet<Integer> result = new TreeSet<Integer>();

		if (result1 != null && result2 != null) {

			for (Integer i1 : result1)
				for (Integer i2 : result2) {

					if (i1 == i2)
						result.add(i1);

				}
			return result;
		} else
			return null;

	}

	public ArrayList<Dicionario> getDicionario() {
		try {

			Leitura l = new Leitura();
			ComparaTokens ct = new ComparaTokens();

			l.processarDoc(Path.getPath());

			Collections.sort(l.documento, ct);

			AdicionaTokenDicionario ad = new AdicionaTokenDicionario();

			ad.add(l.documento);

			return ad.getDicionario();

		} catch (Exception e) {
			System.out.println("Erro ao obter o dicionário!");
		}

		return null;

	}

	public Dicionario getDicionatioByToken(String token) {

		if(dicionario == null)
			dicionario =  getDicionario();
		
		
		for (Dicionario d : dicionario) {
			if (d.getToken().equals(token))
				return d;
		}

		return new Dicionario();

	}

}
