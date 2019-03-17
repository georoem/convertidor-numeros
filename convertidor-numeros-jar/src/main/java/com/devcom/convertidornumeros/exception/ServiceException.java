package com.devcom.convertidornumeros.exception;

/** 
 * Excepción customizada para los servicios
 * @author Jorge Aguirre
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 604797247348272836L;

	/** Constructor de la excepción con el mensaje de la excepción
	 * @param errorMessage
	 */
	public ServiceException(String errorMessage) {
	    super(errorMessage);
	 }

}
