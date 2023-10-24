/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 8:36 pm
 */

package com.nagendar.learning.encoder.binarytree;

public class CharacterBaseBuilderimpl implements CharacterBaseBuilder {
	@Override
	public CharacterBase buildCharacterBase(String input) {
		CharacterBase characterBase = new CharacterBase();
		for (char c : input.toCharArray()) {
			characterBase.setFrequency(c);
		}
		return characterBase;
	}
}
