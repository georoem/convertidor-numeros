package com.devcom.convertidornumeros.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devcom.convertidornumeros.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidadorUtilTest {
	
	private static final int NUMERO_ARABIGO_UNO = 1;
	private static final int NUMERO_ARABIGO_MENOS_UNO = -1;
	private static final int NUMERO_ARABIGO_CERO = 0;
	private static final int NUMERO_ARABIGO_CUATROMIL = 4000;
	private static final int NUMERO_ARABIGO_CUATROMIL_UNO = 4001;
	
	@Test(expected = ServiceException.class)
	public void validarNumeroCeroAConvertirRomanoTest() throws ServiceException {
		ValidadorUtil.validarRangoNumeroAConvertirRomano(NUMERO_ARABIGO_CERO);
	}
	
	@Test(expected = ServiceException.class)
	public void validarNumeroNegativoAConvertirRomanoTest() throws ServiceException {
		ValidadorUtil.validarRangoNumeroAConvertirRomano(NUMERO_ARABIGO_MENOS_UNO);
	}
	
	@Test
	public void validarNumeroUnoAConvertirRomanoTest() throws ServiceException {
		Boolean resultado = ValidadorUtil.validarRangoNumeroAConvertirRomano(NUMERO_ARABIGO_UNO);
		assertEquals(Boolean.TRUE, resultado);
	}
	
	@Test
	public void validarNumeroCuatromilAConvertirRomanoTest() throws ServiceException {
		Boolean resultado = ValidadorUtil.validarRangoNumeroAConvertirRomano(NUMERO_ARABIGO_CUATROMIL);
		assertEquals(Boolean.TRUE, resultado);
	}
	
	@Test(expected = ServiceException.class)
	public void validarNumeroCuatromilUnoAConvertirRomanoTest() throws ServiceException {
		ValidadorUtil.validarRangoNumeroAConvertirRomano(NUMERO_ARABIGO_CUATROMIL_UNO);
	}

}
