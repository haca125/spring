package stackjava.com.sbrestful.controller;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1290717976223273702L;

	public EntityNotFoundException(String msg) {
		super(msg);
	}
}