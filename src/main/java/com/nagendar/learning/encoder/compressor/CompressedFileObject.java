/*
 * @author: pagidimarri.nagendar
 * @createdAt: 28/10/23 11:00 am
 */

package com.nagendar.learning.encoder.compressor;

import com.nagendar.learning.encoder.binarytree.HuffmanTreeNode;

import java.io.Serial;
import java.io.Serializable;

public record CompressedFileObject(HuffmanTreeNode root, byte[] encodedString) implements Serializable {
	@Serial
	private static final long serialVersionUID = 882788657295502291L;

}
