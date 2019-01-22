package br.com.ori;

import java.util.Comparator;

public class ComparaTokens implements Comparator<Token> {

	@Override
	public int compare(Token o1, Token o2) {

		return o1.getTermo().compareTo(o2.getTermo());

	}

}
