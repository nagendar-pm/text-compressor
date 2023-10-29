/*
 * @author: pagidimarri.nagendar
 * @createdAt: 28/10/23 8:16 pm
 */

package com.nagendar.learning.exceptions;

public class BaseException extends RuntimeException {
	public BaseException() {
	}

	public BaseException(String message) {
		super(message);
	}
}
