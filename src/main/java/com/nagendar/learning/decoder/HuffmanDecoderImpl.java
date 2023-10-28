/*
 * @author: pagidimarri.nagendar
 * @createdAt: 26/10/23 8:28 pm
 */

package com.nagendar.learning.decoder;

import com.nagendar.learning.decoder.parsetree.HuffmanTreeParser;
import com.nagendar.learning.encoder.binarytree.HuffmanTreeNode;

public class HuffmanDecoderImpl implements HuffmanDecoder {
	@Override
	public String decode(String encodedString,
	                     HuffmanTreeNode root) {
		HuffmanTreeParser parser = new HuffmanTreeParser(encodedString, root);
		StringBuilder stringBuilder = new StringBuilder();
		while (parser.hasCode()) {
			Character code = parser.getNextCode();
//			System.out.println("code = " + code);
			stringBuilder.append(code);
			// TODO: throw exception here
		}
		return stringBuilder.toString();
	}

}
