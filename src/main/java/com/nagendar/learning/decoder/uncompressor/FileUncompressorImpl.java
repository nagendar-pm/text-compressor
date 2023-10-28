/*
 * @author: pagidimarri.nagendar
 * @createdAt: 28/10/23 12:01 pm
 */

package com.nagendar.learning.decoder.uncompressor;

import com.nagendar.learning.encoder.compressor.CompressedFileObject;
import com.nagendar.learning.utils.Paths;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileUncompressorImpl implements FileUncompressor {
	@Override
	public CompressedFileObject uncompress() {
		CompressedFileObject compressedFileObject;
		try (FileInputStream fileInputStream = new FileInputStream(Paths.OUTPUT_FILE);
		     ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			compressedFileObject = (CompressedFileObject) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return compressedFileObject;
	}
}
