/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 8:18 pm
 */

package com.nagendar.learning.encoder.binarytree;

import java.util.HashMap;
import java.util.Map;

public class CharacterBase {
	private final Map<Character, Integer> frequencyData;

	public CharacterBase() {
		frequencyData = new HashMap<>();
	}

	public void setFrequency(char c) {
		frequencyData.put(c, frequencyData.getOrDefault(c, 0)+1);
	}

	public Integer getFrequency(char c) {
		if (!frequencyData.containsKey(c)) {
			return 0;
		}
		return frequencyData.get(c);
	}
}
