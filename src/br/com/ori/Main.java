package br.com.ori;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.SortedSet;

public class Main {

	private static Scanner s;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		menu();
	}

	public static void menu() throws FileNotFoundException, IOException {

		s = new Scanner(System.in);

		System.out.println("\n::::::Bem Vindo::::::\n\n");
		System.out.println("1 - Pesquisar \n2 - Escrever Hash Table em disco\n0 - Sair\n\n");
		int op = s.nextInt();
		boolean loop = true;

		while (loop) {

			switch (op) {
				case 1:
					pesquisar();
					break;
				case 2:
					escreveHashTable();
					loop = false;
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("Opção inválida!\n\n");
					System.out.println("1 - Pesquisar \n2 - Escrever Hash Table em disco\n0 - Sair\n\n");
					op = s.nextInt();
					break;
			}

		}

	}

	public static void pesquisar() throws FileNotFoundException, IOException {
		System.out.println("\n\nDigite -1 para voltar\n\nDigite uma busca:\tEx.(Cesar and Brutus) ");
		String resultado = s.nextLine();

		if (resultado.equals("-1"))
			menu();

		String aux[] = resultado.split(" ");
		ArrayList<String> termos = new ArrayList<>();
		DicionarioTrigram dt = new DicionarioTrigram();

		VerificaPalavraErrada vpe = new VerificaPalavraErrada();

		String ref = "";
		boolean errado = false;
		int i = 0;

		String[] verificaCoringa;
		ArrayList<String> referenciaPalavraErrada = vpe.populaReferencias();

		// separa coringas para a buscar com and's

		for (String coringa : aux) {

			verificaCoringa = coringa.split("\\*");
			if (verificaCoringa.length != 0)
				for (int j = 0; j < verificaCoringa.length; j++) {
					if (dt.buscaTokens(verificaCoringa[j], dt.getDicionarioTrigram()) != null) {
						SortedSet<String> ax = dt.buscaTokens(verificaCoringa[j], dt.getDicionarioTrigram());

						for (String str : ax) {
							termos.add(str);
							termos.add("OR");
						}

						termos.remove(termos.size() - 1);
					} else
						termos.add(verificaCoringa[j]);
				}
			else
				termos.add(coringa);

		}

		String busca[] = new String[termos.size()];

		// verifica as palavras erradas no array de busca
		for (String a : termos) {

			if (!a.equalsIgnoreCase(vpe.verifica(referenciaPalavraErrada, a))) {
				ref = ref + " " + vpe.verifica(referenciaPalavraErrada, a);
				errado = true;
				busca[i] = vpe.verifica(referenciaPalavraErrada, a);
			}

			else {
				ref = ref + " " + a;
				busca[i] = a.toString();
			}

			i++;
		}

		System.out.println("\nInforme a quantidade de registros para exibição :");
		int qtdRegistros = s.nextInt();

		SortedSet<Integer> docs = new MinHeap().getMoreImportantResults(busca, qtdRegistros);

		if (errado == true)
			System.out.println("\nVocê quiz dizer : " + ref + " ?\n ");

		// até aqui todo o resultado é do modelo vetorial, daqui para frete está a lógica do AutorRanking

		// fim da lógica do AutorRanking

		new Leitura().imprimeIntersessao(docs, Path.getPath());

	}

	public static void escreveHashTable() throws FileNotFoundException, IOException {

		Leitura l = new Leitura();
		ComparaTokens ct = new ComparaTokens();

		l.processarDoc(Path.getPath());

		Collections.sort(l.documento, ct);

		AdicionaTokenDicionario ad = new AdicionaTokenDicionario();

		ad.add(l.documento);

		EscreveHashTable hs = new EscreveHashTable();
		hs.escreverHashTable(ad.getDicionario());

		System.out.println("Processo terminado !");
		System.out.println("Escrito em: /media/ph/DADOS/corpus-/hashtable.ris");
		System.exit(0);

	}

}
