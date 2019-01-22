package br.com.ori;

public class PontuacaoDocumento implements Comparable<PontuacaoDocumento>{

	private int docID;
	private double pontuacao;

	public PontuacaoDocumento(int docID, double pontuacao) {
		super();
		this.docID = docID;
		this.pontuacao = pontuacao;
	}
	
	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public int compareTo(PontuacaoDocumento o) {
		
		if(this.pontuacao < o.pontuacao)
			return -1;
		if(this.pontuacao > o.pontuacao)
			return 1;
		
		return 0;
	}	
	
}
