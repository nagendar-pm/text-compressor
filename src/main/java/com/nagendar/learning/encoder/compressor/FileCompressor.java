package com.nagendar.learning.encoder.compressor;/*
 * @author: pagidimarri.nagendar
 * @createdAt: 28/10/23 11:05 am
 */

import com.nagendar.learning.encoder.binarytree.HuffmanTreeNode;

public interface FileCompressor {
	void compressAndWrite(HuffmanTreeNode root, String encodedString);
}
