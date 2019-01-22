package br.com.ori;

import java.util.ArrayList;

public class AdicionaTokenDicionario {

	private ArrayList<Dicionario> dicionario;

	public AdicionaTokenDicionario() {
		dicionario = new ArrayList<Dicionario>();
	}

	public void add(ArrayList<Token> documento) {

		Dicionario d = new Dicionario();
		Token termo = documento.get(0);
		int termID = 0, tf = 0, auxDocID = termo.getDocID();
		ArrayList<DocId> docIds = new ArrayList<>();
		double idf = 0.0, df = 0.0;

		for (Token t : documento) {

			if (termo.getTermo().equals(t.getTermo())) {
				if (auxDocID == t.getDocID()) {
					tf++;
				} else {
					idf = Math.log10(Leitura.totalArquivos / df);
					DocId did = new DocId(auxDocID, tf, idf);
					docIds.add(did);
					auxDocID = t.getDocID();
					tf = 1;
				}
				df++;

			} else {
				idf = Math.log10(Leitura.totalArquivos / df);
				DocId did = new DocId(termo.getDocID(), tf, idf);
				docIds.add(did);
				termo.setDf(df);
				d.addDicionario(termo, termID, docIds);
				dicionario.add(d);
				docIds = new ArrayList<>();
				termo = t;
				auxDocID = t.getDocID();
				termID++;
				d = new Dicionario();
				df = 1;
				tf = 1;
			}

		}
		
	}

	public ArrayList<Dicionario> getDicionario() {
		return this.dicionario;
	}

}