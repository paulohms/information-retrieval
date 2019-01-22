package br.com.ori;

import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class DicionarioTrigram {

	private String token;
	private SortedSet<String> docs;

	public DicionarioTrigram() {
		docs = new TreeSet<>();
	}

	public void addDicionario(String token, SortedSet<String> aux) {

		this.token = token;
		this.docs = aux;

	}

	@Override
	public String toString() {
		return "\n token -> " + this.token + "  Palavras ->  " + docs;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setDocsID(SortedSet<String> docs) {
		this.docs = docs;
	}

	public String getToken() {
		return this.token;
	}

	public SortedSet<String> getDocs() {
		return this.docs;
	}

	public SortedSet<String> buscaTokens(String token,
			ArrayList<DicionarioTrigram> list) {

		for (DicionarioTrigram t : list) {

			if (t.getToken().equals(token))
				return t.getDocs();
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
	
	public ArrayList<DicionarioTrigram> getDicionarioTrigram(){
		try{
			Leitura l = new Leitura();
			ComparaTokenTrigram ct = new ComparaTokenTrigram();
			l.processarDoc(Path.getPath());

			Collections.sort(l.documentoTrigram, ct);

			AdicionaTokenDicionarioTrigram ad = new AdicionaTokenDicionarioTrigram();

			ad.add(l.documentoTrigram);
		
			return ad.getDicionario();
		}catch(Exception e){
			System.out.println("Erro ao obter o dicionário trigram!");
		}
		return null;
	}
	

}
