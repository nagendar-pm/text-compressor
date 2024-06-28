package com.nagendar.learning;

/*
 * @author: pagidimarri.nagendar
 * @createdAt: 24/10/23 7:56 pm
 */

import com.nagendar.learning.decoder.HuffmanDecoder;
import com.nagendar.learning.decoder.HuffmanDecoderImpl;
import com.nagendar.learning.decoder.bytedecoder.ByteDecoder;
import com.nagendar.learning.decoder.bytedecoder.ByteDecoderImpl;
import com.nagendar.learning.decoder.uncompressor.FileUncompressor;
import com.nagendar.learning.decoder.uncompressor.FileUncompressorImpl;
import com.nagendar.learning.encoder.*;
import com.nagendar.learning.encoder.binarytree.*;
import com.nagendar.learning.encoder.byteencoder.ByteEncoder;
import com.nagendar.learning.encoder.byteencoder.ByteEncoderImpl;
import com.nagendar.learning.encoder.compressor.CompressedFileObject;
import com.nagendar.learning.encoder.compressor.FileCompressor;
import com.nagendar.learning.encoder.compressor.FileCompressorImpl;
import com.nagendar.learning.utils.Paths;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class Main {
	@Benchmark
	public void testParseAndFormat() throws IOException {
		encode();
		decode();
	}

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(Main.class.getSimpleName())
				.forks(1)
				.build();

		new Runner(opt).run();
	}

	private static void encode() {
		Path inputFile = Path.of(Paths.INPUT_FILE);
		String input;
		try {
			input = Files.readString(inputFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		CharacterFrequencyBaseBuilder characterBaseBuilder = new CharacterFrequencyBaseBuilderimpl();
		CharacterFrequencyBase characterBase = characterBaseBuilder.buildCharacterBase(input);

		HuffmanTreeBuilder treeBuilder = new HuffmanTreeBuilderImpl();
		HuffmanTreeNode root = treeBuilder.buildTree(characterBase);
		System.out.println("Encoding tree = " + root);

		CharacterCodeBaseBuilder characterCodeBaseBuilder = new CharacterCodeBaseBuilderImpl();
		CharacterCodeBase characterCodeBase = characterCodeBaseBuilder.buildCharacterCodeBase(root);
		System.out.println("characterCodeBase = " + characterCodeBase);

		HuffmanEncoder encoder = new HuffmanEncoderImpl();
		String encodedString = encoder.encode(characterCodeBase, input);
		if (encodedString.length() <= 1000) {
			System.out.println("encoded string = " + encodedString);
		}

		ByteEncoder byteEncoder = new ByteEncoderImpl();
		FileCompressor fileCompressor = new FileCompressorImpl(byteEncoder);
		fileCompressor.compressAndWrite(root, encodedString);
	}

	private static void decode() throws IOException {
		FileUncompressor uncompressor = new FileUncompressorImpl();
		CompressedFileObject uncompressedObject = uncompressor.uncompress();
		ByteDecoder byteDecoder = new ByteDecoderImpl();
		String uncompressedString = byteDecoder.decode(uncompressedObject.encodedString());

		HuffmanDecoder decoder = new HuffmanDecoderImpl();
		String originalString = decoder.decode(uncompressedString, uncompressedObject.root());

		Path original = Path.of(Paths.DECODED_UNCOMPRESSED_TEXT_FILE);
		Files.writeString(original, originalString);
	}
}