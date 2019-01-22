package br.com.ori;

import java.io.IOException;

public class TestaPalavraErrada {
	
	public static void main(String[] args) throws IOException {
		
		VerificaPalavraErrada vpe = new VerificaPalavraErrada();
		
		String correta = vpe.verifica(vpe.populaReferencias(), "abrsives");
		
		System.out.println(correta);
		
	}

}
