package br.com.ori;

import java.util.ArrayList;
import java.util.HashMap;

public class PontuacaoConsulta {

	public HashMap<String, Double> pontuaConsulta(String[] busca) {

		HashMap<String, Double> pontuacao = new HashMap<>();
		for (String str : busca) {
			if (!(str.equalsIgnoreCase("and") || str.equalsIgnoreCase("OR"))) {
				double w = 0.0;
				ArrayList<DocId> auxD = new Dicionario().getDicionatioByToken(str).getDocIDs();
				if(auxD != null && !auxD.isEmpty()){
				for (DocId did : auxD ) {
					w += (1 + Math.log10(did.getTf()));
				}}
				w = 1 / w;
				w = 1 + Math.log10(1) + w;
				pontuacao.put(str, w);
			}
		}
		return pontuacao;
	}

	public HashMap<Integer,Double> pontuaArquivo(String[] busca) {

		HashMap<Integer,Double> pontuacaoDocumento = new HashMap<Integer, Double>();
		
		for (String str : busca) {
			if (!(str.equalsIgnoreCase("and") || str.equalsIgnoreCase("OR"))) {
				ArrayList<DocId> auxD = new Dicionario().getDicionatioByToken(str).getDocIDs();
				if(auxD != null && !auxD.isEmpty())
				for (DocId did : auxD) {

					double tf = (1 + Math.log(did.getTf()));
					double w = tf * did.getIdf();

					if (pontuacaoDocumento.get(did.getDocID()) == null){
						pontuacaoDocumento.put(did.getDocID(), w);
						did.setPontuacao(w);
					}
					else{
						pontuacaoDocumento.put(did.getDocID(),pontuacaoDocumento.get(did.getDocID())+w);
						did.setPontuacao(pontuacaoDocumento.get(did.getDocID())+w);
					}

				}
			}
			}
		return pontuacaoDocumento;
	}
}
	
