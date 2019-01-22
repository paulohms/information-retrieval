package br.com.ori;

public class DocId {

	private int docID;
	private int tf;
	private double idf;
	private double pontuacao;

	public DocId(int docID, int tf, double idf) {
		this.docID = docID;
		this.tf = tf;
		this.idf = idf;
	}

	@Override
	public String toString() {
		return "DocId [docID=" + docID + ", tf=" + tf + ", idf=" + idf + "]";
	}

	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	public int getTf() {
		return tf;
	}

	public void setTf(int tf) {
		this.tf = tf;
	}

	public double getIdf() {
		return idf;
	}

	public void setIdf(double idf) {
		this.idf = idf;
	}

	public double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(double pontuacao) {
		if(pontuacao == 0.0)
			this.pontuacao = 0.00;
		else
		this.pontuacao = pontuacao;
	}

}
