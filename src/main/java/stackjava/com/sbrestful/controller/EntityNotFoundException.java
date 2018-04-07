package stackjava.com.sbrestful.controller;

public class EntityNotFoundException extends RuntimeException {
	public EntityNotFoundException(String msg) {
		super(msg);
	}
}