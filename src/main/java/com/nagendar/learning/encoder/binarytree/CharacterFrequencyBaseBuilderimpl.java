/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 8:36 pm
 */

package com.nagendar.learning.encoder.binarytree;

public class CharacterFrequencyBaseBuilderimpl implements CharacterFrequencyBaseBuilder {
	@Override
	public CharacterFrequencyBase buildCharacterBase(String input) {
		CharacterFrequencyBase characterBase = new CharacterFrequencyBase();
		for (char c : input.toCharArray()) {
			characterBase.setFrequency(c);
		}
		return characterBase;
	}
}
