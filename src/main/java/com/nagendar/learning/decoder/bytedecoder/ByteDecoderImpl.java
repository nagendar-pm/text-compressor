/*
 * @author: pagidimarri.nagendar
 * @createdAt: 28/10/23 12:09 pm
 */

package com.nagendar.learning.decoder.bytedecoder;

public class ByteDecoderImpl implements ByteDecoder {
	@Override
	public String decode(byte[] byteString) {
		StringBuilder stringBuilder = new StringBuilder();
		int validBitsInLastByte = byteString[byteString.length - 1];
		for (int i=0; i<byteString.length - 1; i++) {
			byte byteInput = byteString[i];
			int bitsToConsider = 7;
			if (i == byteString.length - 2) {
				if (validBitsInLastByte == 0) validBitsInLastByte = 8;
				bitsToConsider = validBitsInLastByte - 1;
			}
			for (int bitsRemaining = 7;
			     bitsRemaining >= Math.max(7-bitsToConsider, 0);
				 bitsRemaining--) {
				if (((int) byteInput & (1<<bitsRemaining)) != 0) {
					stringBuilder.append('1');
				}
				else {
					stringBuilder.append('0');
				}
			}
		}
		return stringBuilder.toString();
	}
}
