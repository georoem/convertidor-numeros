package com.devcom.convertidornumeros.util;

import com.devcom.convertidornumeros.exception.ServiceException;

/** 
 * Clase utilitaria para las conversiones auxiliares
 * @author Jorge Aguirre
 *
 */
public class ConversorUtil {

	/** Método estático para convertir números de String a Integer
	 * @param numeroString
	 * @return Integer
	 * @throws ServiceException
	 */
	public static Integer convertirNumeroStringAInteger(String numeroString) throws ServiceException {
		
		Integer numero = null;
		
		try {
			 numero = Integer.parseInt(numeroString);
		} catch (Exception e) {
			throw new ServiceException(String.format(ConstantesUtil.MSG_FORMATO_INVALIDO,numeroString));
		}
		
		return numero;
	}

}
