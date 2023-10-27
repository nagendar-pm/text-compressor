package com.nagendar.learning;

/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 7:56 pm
 */

import com.nagendar.learning.encoder.*;
import com.nagendar.learning.encoder.binarytree.*;
import com.nagendar.learning.encoder.byteencoder.ByteEncoder;
import com.nagendar.learning.encoder.byteencoder.ByteEncoderImpl;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String input = "Given there is usually an unequal distribution of character occurrences in text " +
				"this can then be used to compress data by giving the most commonly occurring characters the shortest prefix.";
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
		byteEncoder.encode(encodedString);

		FileOutputStream fileOutputStream = new FileOutputStream("resources/test-serialization.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(treeNode);
		objectOutputStream.flush();
		objectOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("resources/test-serialization.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		HuffmanTreeNode deserializedTreeNode = (HuffmanTreeNode) objectInputStream.readObject();
		objectInputStream.close();

		System.out.println("deserializedTreeNode = " + deserializedTreeNode);
	}
}