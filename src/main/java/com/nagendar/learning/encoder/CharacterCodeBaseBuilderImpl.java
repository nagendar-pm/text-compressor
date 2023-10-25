/*
 * @author: pagidimarri.nagendar
 * @createdAt: 25/10/23 8:45 pm
 */

package com.nagendar.learning.encoder;

import com.nagendar.learning.encoder.binarytree.HuffmanTreeNode;

public class CharacterCodeBaseBuilderImpl implements CharacterCodeBaseBuilder {
	@Override
	public CharacterCodeBase buildCharacterCodeBase(HuffmanTreeNode root) {
		CharacterCodeBase characterCodeBase = new CharacterCodeBase();
		constructCode(root, new StringBuilder(), characterCodeBase);
		return characterCodeBase;
	}

	private void constructCode(HuffmanTreeNode node,
	                     StringBuilder code,
	                     CharacterCodeBase characterCodeBase) {
		if (node.isLeaf()) {
			characterCodeBase.setCode(node.getCharacter(), code.toString());
			return;
		}
		int lengthOfCode = code.length();
		constructCode(node.getLeft(), code.append("0"), characterCodeBase);
		code.setLength(lengthOfCode);
		constructCode(node.getRight(), code.append("1"), characterCodeBase);
	}
}
