package io.learning.coffeeshop.exception;

import org.springframework.dao.DataIntegrityViolationException;

import lombok.Synchronized;

public class DuplicateRecordException extends DataIntegrityViolationException {

	private static final long serialVersionUID = 3681617502734743084L;

	public DuplicateRecordException(String msg) {
		super(msg);
	}

	@Synchronized
	public DuplicateRecordException addSuppressedExeption(Throwable exception) {
		this.addSuppressed(exception);
		return this;
	}

}
