/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 8:22 pm
 */

package com.nagendar.learning.encoder.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HuffmanTreeBuilderImpl implements HuffmanTreeBuilder {
	@Override
	public HuffmanTreeNode buildTree(CharacterFrequencyBase characterBase) {
		List<HuffmanTreeNode> treeNodes = initializeTreeNodes(characterBase);
		PriorityQueue<HuffmanTreeNode> minHeap = new PriorityQueue<>(treeNodes);
		while (!minHeap.isEmpty() && minHeap.size() >= 2) {
			HuffmanTreeNode characterA = minHeap.poll();
			HuffmanTreeNode characterB = minHeap.poll();
			HuffmanTreeNode parent = mergeNodes(characterA, characterB);
			minHeap.offer(parent);
		}
		if (minHeap.isEmpty()) return null;
		return minHeap.poll();
	}

	private List<HuffmanTreeNode> initializeTreeNodes(CharacterFrequencyBase characterBase) {
		List<HuffmanTreeNode> treeNodes = new ArrayList<>();
		// Here we may have extended ascii characters
		// i.e. characters not belonging to UTF-8
		// so we have to iterate on the key set for the better inclusion
		for (char c : characterBase.keySet()) {
			int frequency = characterBase.getFrequency(c);
			if (frequency == 0) continue;
			treeNodes.add(new HuffmanTreeNode(c, frequency, true));
		}
		return treeNodes;
	}

	private HuffmanTreeNode mergeNodes(HuffmanTreeNode a, HuffmanTreeNode b) {
		int value = a.getValue() + b.getValue();
		HuffmanTreeNode parent = new HuffmanTreeNode(null, value, false);
		parent.setLeft(a);
		parent.setRight(b);
		return parent;
	}
}
