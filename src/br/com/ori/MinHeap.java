package br.com.ori;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class MinHeap {

	public SortedSet<Integer> getMoreImportantResults(String[] busca,int qtdRegistros) {

		HashMap<Integer, Double> pontuacaoDocumento = new PontuacaoConsulta().pontuaArquivo(busca);
		SortedSet<Integer> result = new TreeSet<>();

		PriorityQueue<PontuacaoDocumento> minHeap = new PriorityQueue<>(qtdRegistros);

		for (Entry<Integer, Double> entry : pontuacaoDocumento.entrySet()) {

			if (minHeap.size() >= qtdRegistros) {
				if (minHeap.peek().getPontuacao() < entry.getValue()) {
					minHeap.poll();
					minHeap.add(new PontuacaoDocumento(entry.getKey(),entry.getValue()));
				}
			} else {
				minHeap.add(new PontuacaoDocumento(entry.getKey(),entry.getValue()));
			}

		}
		for (PontuacaoDocumento d : minHeap) {
			result.add(d.getDocID());
		}
		return result;
	}

}
