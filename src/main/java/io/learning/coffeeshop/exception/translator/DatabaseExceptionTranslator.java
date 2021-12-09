package io.learning.coffeeshop.exception.translator;

import org.springframework.dao.DataAccessException;

public class DatabaseExceptionTranslator implements ExceptionTransalator<DataAccessException, RuntimeException> {

	@Override
	public RuntimeException translate(DataAccessException exception) {
		return null;
	}

}
