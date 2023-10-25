/*
 * @author: pagidimarri.nagendar
 * @createdAt: 25/10/23 8:39 pm
 */

package com.nagendar.learning.encoder;

import java.util.HashMap;
import java.util.Map;

public class CharacterCodeBase {
	private final Map<Character, String> codes;

	public CharacterCodeBase() {
		codes = new HashMap<>();
	}

	public void setCode(char c, String code) {
		codes.put(c, code);
	}

	public String getCode(char c) {
		return codes.get(c);
	}

	@Override
	public String toString() {
		return "CharacterCodeBase{" +
				"codes=" + codes +
				'}';
	}
}
