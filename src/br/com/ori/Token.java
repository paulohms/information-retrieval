package br.com.ori;

public class Token {

	private String termo;
	private int docID;
	private double df;

	public Token(String termo, int docID) {
		this.termo = termo;
		this.docID = docID;
		
	}

	public String getTermo() {
		return termo;
	}

	public void setTermo(String termo) {
		this.termo = termo;
	}

	public int getDocID() {
		return docID;
	}

	public void setDocID(int docID) {
		this.docID = docID;
	}

	@Override
	public String toString() {
		return termo.toString() + "  ->  " + docID+"\n";
	}

	public double getDf() {
		return df;
	}

	public void setDf(double df) {
		this.df = df;
	}

}
