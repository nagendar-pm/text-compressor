package com.nagendar.learning;

/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 7:56 pm
 */

import com.nagendar.learning.decoder.HuffmanDecoder;
import com.nagendar.learning.decoder.HuffmanDecoderImpl;
import com.nagendar.learning.encoder.*;
import com.nagendar.learning.encoder.binarytree.*;

public class Main {
	public static void main(String[] args) {
		String input = "Given there is usually an unequal distribution of character occurrences in text " +
				"this can then be used to compress data by giving the most commonly occurring characters the shortest prefix.";
		CharacterFrequencyBaseBuilder characterBaseBuilder = new CharacterFrequencyBaseBuilderimpl();
		HuffmanTreeBuilder treeBuilder = new HuffmanTreeBuilderImpl();
		CharacterFrequencyBase characterBase = characterBaseBuilder.buildCharacterBase(input);
		HuffmanTreeNode treeNode = treeBuilder.buildTree(characterBase);
		System.out.println("treeNode = " + treeNode);
		CharacterCodeBaseBuilder characterCodeBaseBuilder = new CharacterCodeBaseBuilderImpl();
		CharacterCodeBase characterCodeBase = characterCodeBaseBuilder.buildCharacterCodeBase(treeNode);
		System.out.println("characterCodeBase = " + characterCodeBase);
		HuffmanEncoder encoder = new HuffmanEncoderImpl();
		String encodedString = encoder.encode(characterCodeBase, input);
		System.out.println("encoded string = " + encodedString);
		HuffmanDecoder decoder = new HuffmanDecoderImpl();
		String decodedString = decoder.decode(encodedString, treeNode);
		System.out.println("decodedString = " + decodedString);
	}
}