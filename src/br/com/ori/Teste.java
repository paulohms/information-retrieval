package br.com.ori;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Teste {

	public static void main(String[] args) {
		Map<String, Set<String>> index = new TreeMap<String, Set<String>>();
		
		String [] files = new String[] { "1.txt", "2.txt", "3.txt" };
		String [] [] words = new String[][] { { "xpto", "xxxx", "yyyyy" }, { "xpto", "xxxx2", "yyyyy" }, { "xpto", "xxxx", "yyyyy3" } };
		
		for (int i = 0; i < files.length; i++) {
			for (int j = 0; j < words[i].length; j++) {

				found(words[i][j], files[i], index);
			}
		}
		
		System.out.println(index);
		
		for (String word : index.keySet()) {
			System.out.print(word);
			System.out.print("=");
			System.out.println(index.get(word));
			
		}
		
	}

	private static void found(String word, String file, Map<String, Set<String>> index) {
		Set<String> files = index.get(word);
		if (files == null) {
			files = new LinkedHashSet<String>();
			index.put(word, files);
		}
		files.add(file);
	}
	
}
