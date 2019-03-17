package com.devcom.convertidornumeros.util;

import com.devcom.convertidornumeros.exception.ServiceException;

/** 
 * Clase utilitaria para las válidaciones en las conversiones
 * @author Jorge Aguirre
 *
 */
public class ValidadorUtil {

	/** Método estático para validar el rango de conversión de números arábigos
	 * @param numeroArabigo
	 * @return Boolean
	 * @throws ServiceException
	 */
	public static Boolean validarRangoNumeroAConvertirRomano(int numeroArabigo) throws ServiceException {
		
		if(numeroArabigo < ConstantesUtil.LIMITE_INFERIOR_RANGO_ROMANOS || 
				numeroArabigo > ConstantesUtil.LIMITE_SUPERIOR_RANGO_ROMANOS) {
			throw new ServiceException(ConstantesUtil.MSG_RANGO_DE_NUMERO_INVALIDO);
		}
		
		return Boolean.TRUE;
	}

}
