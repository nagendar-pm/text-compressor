package com.nagendar.learning.decoder.uncompressor;/*
 * @author: pagidimarri.nagendar
 * @createdAt: 28/10/23 12:00 pm
 */

import com.nagendar.learning.encoder.compressor.CompressedFileObject;

public interface FileUncompressor {
	CompressedFileObject uncompress();
}
