package com.nagendar.learning;

/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 7:56 pm
 */

import com.nagendar.learning.encoder.CharacterCodeBase;
import com.nagendar.learning.encoder.CharacterCodeBaseBuilder;
import com.nagendar.learning.encoder.CharacterCodeBaseBuilderImpl;
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
	}
}