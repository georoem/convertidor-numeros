package com.devcom.convertidornumeros.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devcom.convertidornumeros.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConversorUtilTest {
	
	private static final String NUMERO_ARABIGO_UNO_STRING = "1";
	private static final Integer NUMERO_ARABIGO_UNO = 1;
	private static final String NUMERO_ARABIGO_INVALIDO = "ABC";
	
	@Test(expected = ServiceException.class)
	public void convertirNumeroCeroTest() throws ServiceException {
		ConversorUtil.convertirNumeroStringAInteger(NUMERO_ARABIGO_INVALIDO);
	}
	
	@Test
	public void validarNumeroUnoAConvertirRomanoTest() throws ServiceException {
		Integer resultado = ConversorUtil.convertirNumeroStringAInteger(NUMERO_ARABIGO_UNO_STRING);;
		assertEquals(NUMERO_ARABIGO_UNO, resultado);
	}

}
