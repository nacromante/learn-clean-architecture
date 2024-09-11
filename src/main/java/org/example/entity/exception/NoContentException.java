package org.example.entity.exception;

public class NoContentException extends RuntimeException {
	public NoContentException() {
		super("Not content");
	}
}
