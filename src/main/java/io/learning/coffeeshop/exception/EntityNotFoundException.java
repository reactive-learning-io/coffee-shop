package io.learning.coffeeshop.exception;

import org.springframework.dao.DataAccessException;

import lombok.Synchronized;

public class EntityNotFoundException extends DataAccessException {

	private static final long serialVersionUID = 3681617502734743084L;

	public EntityNotFoundException(String msg) {
		super(msg);
	}

	@Synchronized
	public EntityNotFoundException addSuppressedExeption(Throwable exception) {
		this.addSuppressed(exception);
		return this;
	}

}
