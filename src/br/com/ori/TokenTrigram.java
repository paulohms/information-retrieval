package br.com.ori;

public class TokenTrigram {

	private String termoTrigram;
	private String palavras;

	public TokenTrigram(String termoTrigram, String palavras) {
		this.termoTrigram = termoTrigram;
		this.palavras = palavras;
	}

	public String getTermo() {
		return termoTrigram;
	}

	public void setTermo(String termo) {
		this.termoTrigram = termo;
	}

	public String getDocID() {
		return palavras;
	}

	public void setDocID(String palavras) {
		this.palavras = palavras;
	}

	@Override
	public String toString() {
		return termoTrigram.toString() + "  ->  " + palavras;
	}

}
