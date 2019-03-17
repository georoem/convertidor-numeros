package com.devcom.convertidornumeros.services.impl;

import org.springframework.stereotype.Service;

import com.devcom.convertidornumeros.exception.ServiceException;
import com.devcom.convertidornumeros.services.IConvertidorNumerosService;
import com.devcom.convertidornumeros.util.ConversorUtil;
import com.devcom.convertidornumeros.util.ValidadorUtil;

/** 
 * Implementación de la interface para la conversión de números
 * @author Jorge Aguirre
 *
 */
@Service
public class ConvertidorNumerosServiceImpl implements IConvertidorNumerosService {

	/* (non-Javadoc)
	 * @see com.devcom.convertidornumeros.services.IConvertidorNumerosService#arabigoARomano(java.lang.String)
	 */
	@Override
	public String arabigoARomano(String numeroArabigoString) throws ServiceException {
		
		Integer numeroArabigo = ConversorUtil.convertirNumeroStringAInteger(numeroArabigoString);
		
		ValidadorUtil.validarRangoNumeroAConvertirRomano(numeroArabigo);
		
		return String.valueOf(new char[numeroArabigo]).replace('\0', 'I')
                .replace("IIIII", "V")
                .replace("IIII", "IV")
                .replace("VV", "X")
                .replace("VIV", "IX")
                .replace("XXXXX", "L")
                .replace("XXXX", "XL")
                .replace("LL", "C")
                .replace("LXL", "XC")
                .replace("CCCCC", "D")
                .replace("CCCC", "CD")
                .replace("DD", "M")
                .replace("DCD", "CM");
	}

}
