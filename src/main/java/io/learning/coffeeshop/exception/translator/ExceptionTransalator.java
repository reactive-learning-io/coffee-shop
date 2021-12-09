package io.learning.coffeeshop.exception.translator;

public interface ExceptionTransalator<E extends Throwable, T> {

	T translate(E exception);

}
