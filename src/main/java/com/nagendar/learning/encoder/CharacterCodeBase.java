/*
 * @author: pagidimarri.nagendar
 * @createdAt: 25/10/23 8:39 pm
 */

package com.nagendar.learning.encoder;

import java.util.HashMap;
import java.util.Map;

public class CharacterCodeBase {
	private final Map<Character, String> codes;
	private final Map<String, Character> reverseCodes;

	public CharacterCodeBase() {
		codes = new HashMap<>();
		reverseCodes = new HashMap<>();
	}

	public void setCode(char c, String code) {
		codes.put(c, code);
		reverseCodes.put(code, c);
	}

	public String getCode(char c) {
		return codes.get(c);
	}

	public Character getCharacter(String code) {
		return reverseCodes.get(code);
	}

	@Override
	public String toString() {
		return "CharacterCodeBase{" +
				"codes=" + codes +
				'}';
	}
}
