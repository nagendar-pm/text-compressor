/*
 * @author: pagidimarri.nagendar
 * @createdAt: 25/10/23 10:33 pm
 */

package com.nagendar.learning.encoder;

public class HuffmanEncoderImpl implements HuffmanEncoder {
	@Override
	public String encode(CharacterCodeBase characterCodeBase, String input) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : input.toCharArray()) {
			stringBuilder.append(characterCodeBase.getCode(c));
		}
		return stringBuilder.toString();
	}
}
