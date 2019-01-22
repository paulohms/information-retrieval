package br.com.ori;

import java.util.Comparator;

public class ComparaTokenTrigram implements Comparator<TokenTrigram> {

	@Override
	public int compare(TokenTrigram o1, TokenTrigram o2) {

		return o1.getTermo().compareTo(o2.getTermo());

	}

}
