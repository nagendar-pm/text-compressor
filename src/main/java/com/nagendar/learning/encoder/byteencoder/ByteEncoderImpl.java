/*
 * @author: pagidimarri.nagendar
 * @createdAt: 27/10/23 9:13 pm
 */

package com.nagendar.learning.encoder.byteencoder;

import com.nagendar.learning.utils.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class ByteEncoderImpl implements ByteEncoder {
	@Override
	public void encode(String asciiString) {
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
		System.out.println("byteArray = " + Arrays.toString(byteArray));
		String outputFile = "resources/firstOutput.txt";
		String path = FileUtils.toAbsolutePath(outputFile);
		System.out.println("path = " + path);
		try {
			Files.write(Path.of(path), byteArray);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
