/*
 * @author: pagidimarri.nagendar
 * @createdAt: 28/10/23 11:06 am
 */

package com.nagendar.learning.encoder.compressor;

import com.nagendar.learning.encoder.binarytree.HuffmanTreeNode;
import com.nagendar.learning.encoder.byteencoder.ByteEncoder;
import com.nagendar.learning.utils.Paths;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileCompressorImpl implements FileCompressor {
	private final ByteEncoder byteEncoder;

	public FileCompressorImpl(ByteEncoder byteEncoder) {
		this.byteEncoder = byteEncoder;
	}

	@Override
	public void compressAndWrite(HuffmanTreeNode root, String encodedString) {
		byte[] byteArray = byteEncoder.encode(encodedString);
		CompressedFileObject compressedFileObject = new CompressedFileObject(root, byteArray);

		try (FileOutputStream fileOutputStream = new FileOutputStream(Paths.OUTPUT_FILE);
		     ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(compressedFileObject);
			objectOutputStream.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
