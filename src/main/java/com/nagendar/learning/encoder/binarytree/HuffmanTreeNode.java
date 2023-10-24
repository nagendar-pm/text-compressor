/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 8:12 pm
 */

package com.nagendar.learning.encoder.binarytree;

public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
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
		return "HuffmanTreeNode{" +
				"character=" + character +
				", value=" + value +
				", left=" + left +
				", right=" + right +
				", isLeaf=" + isLeaf +
				'}';
	}
}
