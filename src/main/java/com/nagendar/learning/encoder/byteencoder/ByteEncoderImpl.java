/*
 * @author: pagidimarri.nagendar
 * @createdAt: 27/10/23 9:13 pm
 */

package com.nagendar.learning.encoder.byteencoder;

import java.io.ByteArrayOutputStream;

public class ByteEncoderImpl implements ByteEncoder {
	@Override
	public byte[] encode(String asciiString) {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		int byteValue = 0, bitsRemaining = 8;
		for (char c : asciiString.toCharArray()) {
			if (c == '0') {
				byteValue <<= 1;
			}
			else {
				byteValue = (byteValue << 1) | 1;
			}
			bitsRemaining--;

			if (bitsRemaining == 0) {
				byteArrayOutputStream.write(byteValue);
				byteValue = 0;
				bitsRemaining = 8;
			}
		}

		if (bitsRemaining < 8) {
			byteValue <<= bitsRemaining;
			byteArrayOutputStream.write(byteValue);
		}

		byte[] byteArray = byteArrayOutputStream.toByteArray();
		return byteArray;
	}
}
