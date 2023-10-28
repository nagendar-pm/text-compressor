package com.nagendar.learning.decoder;/*
 * @author: pagidimarri.nagendar
 * @createdAt: 26/10/23 8:28 pm
 */

import com.nagendar.learning.encoder.binarytree.HuffmanTreeNode;

public interface HuffmanDecoder {
	String decode(String encodedString, HuffmanTreeNode root);
}
