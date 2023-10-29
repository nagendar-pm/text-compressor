/*
 * @author: pagidimarri.nagendar
 * @createdAt: 25/10/23 10:33 pm
 */

package com.nagendar.learning.encoder;

import com.nagendar.learning.exceptions.EncodingException;

import java.util.Objects;

public class HuffmanEncoderImpl implements HuffmanEncoder {
	@Override
	public String encode(CharacterCodeBase characterCodeBase, String input) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char c : input.toCharArray()) {
			String code = characterCodeBase.getCode(c);
			if (Objects.isNull(code)) {
				throw new EncodingException("Couldn't find code for character " + c);
			}
			stringBuilder.append(code);
		}
		return stringBuilder.toString();
	}
}
