package com.nagendar.learning;

/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 7:56 pm
 */

import com.nagendar.learning.encoder.*;
import com.nagendar.learning.encoder.binarytree.*;
import com.nagendar.learning.encoder.byteencoder.ByteEncoder;
import com.nagendar.learning.encoder.byteencoder.ByteEncoderImpl;
import com.nagendar.learning.encoder.compressor.FileCompressor;
import com.nagendar.learning.encoder.compressor.FileCompressorImpl;
import com.nagendar.learning.utils.Paths;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Path inputFile = Path.of(Paths.INPUT_FILE);
		String input = Files.readString(inputFile);

		CharacterFrequencyBaseBuilder characterBaseBuilder = new CharacterFrequencyBaseBuilderimpl();
		HuffmanTreeBuilder treeBuilder = new HuffmanTreeBuilderImpl();
		CharacterFrequencyBase characterBase = characterBaseBuilder.buildCharacterBase(input);
		HuffmanTreeNode treeNode = treeBuilder.buildTree(characterBase);
		System.out.println("treeNode = " + treeNode);
		CharacterCodeBaseBuilder characterCodeBaseBuilder = new CharacterCodeBaseBuilderImpl();
		CharacterCodeBase characterCodeBase = characterCodeBaseBuilder.buildCharacterCodeBase(treeNode);
		System.out.println("characterCodeBase = " + characterCodeBase);
		HuffmanEncoder encoder = new HuffmanEncoderImpl();
		String encodedString = encoder.encode(characterCodeBase, input);
		System.out.println("encoded string = " + encodedString);

		ByteEncoder byteEncoder = new ByteEncoderImpl();
		FileCompressor fileCompressor = new FileCompressorImpl(byteEncoder);
		fileCompressor.compressAndWrite(treeNode, encodedString);


//		FileInputStream fileInputStream = new FileInputStream("resources/test-serialization.txt");
//		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//		HuffmanTreeNode deserializedTreeNode = (HuffmanTreeNode) objectInputStream.readObject();
//		objectInputStream.close();
//
//		System.out.println("deserializedTreeNode = " + deserializedTreeNode);
	}
}