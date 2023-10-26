/*
 * @author: pagidimarri.nagendar
 * @createdAt: 26/10/23 8:37 pm
 */

package com.nagendar.learning.decoder.parsetree;

import com.nagendar.learning.encoder.binarytree.HuffmanTreeNode;

import java.util.Objects;

public class HuffmanTreeParser {
	private final String encodedString;
	private int index;
	private final HuffmanTreeNode root;

	public HuffmanTreeParser(String encodedString, HuffmanTreeNode root) {
		this.encodedString = encodedString;
		this.root = root;
		this.index = 0;
	}

	public boolean hasCode() {
		return index < encodedString.length();
	}

	public Character getNextCode() {
		HuffmanTreeNode iterator = root;
		while (Objects.nonNull(iterator) && !iterator.isLeaf()) {
			if (encodedString.charAt(index) == '0') {
				iterator = iterator.getLeft();
			}
			else {
				iterator = iterator.getRight();
			}
			index++;
		}
		// TODO: check for potential edge cases and cover exceptions
		return iterator.getCharacter();
	}
}
