package com.nagendar.learning.encoder;/*
 * @author: pagidimarri.nagendar
 * @createdAt: 25/10/23 8:44 pm
 */

import com.nagendar.learning.encoder.binarytree.HuffmanTreeNode;

public interface CharacterCodeBaseBuilder {
	CharacterCodeBase buildCharacterCodeBase(HuffmanTreeNode root);
}
