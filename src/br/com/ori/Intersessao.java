package br.com.ori;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Intersessao {

	private ArrayList<String> operadores = new ArrayList<String>();
	private ArrayList<String> termos = new ArrayList<String>();
	SortedSet<Integer> result = new TreeSet<>();
	ArrayList<Dicionario> dicionario = new Dicionario().getDicionario();
	
	public SortedSet<Integer> interssessao(String[] aux) throws FileNotFoundException, IOException {
		
		// separa os termos dos operadores (and, not, or)
		for (int i = 0; i < aux.length; i++) {

			if (aux[i].equalsIgnoreCase("and") || aux[i].equalsIgnoreCase("not") || aux[i].equalsIgnoreCase("or"))
				operadores.add(aux[i]);
			else
				termos.add(aux[i]);
			
		}
		
		Dicionario d = new Dicionario();
		result = d.buscaTokens(termos.get(0), dicionario);

		for (int i = 0; i < operadores.size(); i++) {
			
			if (operadores.get(i).equalsIgnoreCase("and")) {
				result = interseccao(result, d.buscaTokens(termos.get(i+1), dicionario));
			}
			else if (operadores.get(i).equalsIgnoreCase("or")){
				result = uniao(result, d.buscaTokens(termos.get(i+1), dicionario));
			}
		}
		return result;
	}
    
	public SortedSet<Integer> interseccao(SortedSet<Integer> a, SortedSet<Integer> b) {
		if(a.isEmpty() && b.isEmpty())
			return null;
		else if(a.isEmpty())
			return b;
		else if(b.isEmpty())
			return a;
		
        a.retainAll(b);
        return a;
    }

    public SortedSet<Integer> uniao(SortedSet<Integer> a, SortedSet<Integer> b) {
        a.addAll(b);
        return a;
    }
	
	
}
