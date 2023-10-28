/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 8:12 pm
 */

package com.nagendar.learning.encoder.binarytree;

import java.io.Serial;
import java.io.Serializable;

public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>, Serializable {
	@Serial
	private static final long serialVersionUID = 1718804620817441052L;
	private final Character character;
	private final Integer value;
	private HuffmanTreeNode left, right;
	private final Boolean isLeaf;

	public HuffmanTreeNode(Character character, Integer value, Boolean isLeaf) {
		this.character = character;
		this.value = value;
		this.isLeaf = isLeaf;
	}

	public Character getCharacter() {
		return character;
	}

	public Integer getValue() {
		return value;
	}

	public HuffmanTreeNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanTreeNode left) {
		this.left = left;
	}

	public HuffmanTreeNode getRight() {
		return right;
	}

	public void setRight(HuffmanTreeNode right) {
		this.right = right;
	}

	public Boolean isLeaf() {
		return isLeaf;
	}

	@Override
	public int compareTo(HuffmanTreeNode that) {
		return Integer.compare(this.value, that.value);
	}

	@Override
	public String toString() {
		return "{" + (character != null ? character : "") +
				" " + value +
				" " + (left != null ? left : "_") +
				" " + (right != null ? right : "_") +
				'}';
	}
}
