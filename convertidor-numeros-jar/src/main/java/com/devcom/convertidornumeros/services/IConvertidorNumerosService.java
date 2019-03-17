package com.devcom.convertidornumeros.services;

import com.devcom.convertidornumeros.exception.ServiceException;

/** 
 * Interface con los métodos de conversión
 * @author Jorge Aguirre
 *
 */
public interface IConvertidorNumerosService {

	/** Método de conversión de números arábigos a romanos
	 * @param numeroArabigoString
	 * @return String
	 * @throws ServiceException
	 */
	public String arabigoARomano(String numeroArabigoString) throws ServiceException;

}
