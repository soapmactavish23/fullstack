package br.hkprogrammer.fullstack.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Resource Not Fund with id: " + id);
	}
	
}
