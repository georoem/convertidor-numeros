package com.devcom.convertidornumeros.services.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.PostConstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.devcom.convertidornumeros.exception.ServiceException;
import com.devcom.convertidornumeros.services.IConvertidorNumerosService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertidorNumerosServiceImplTest {
	
	private static final String NUMERO_ARABIGO_UNO = "1";
	private static final String NUMERO_ARABIGO_MENOS_UNO = "-1";
	private static final String NUMERO_ARABIGO_CERO = "0";
	private static final String NUMERO_ARABIGO_CUATROMIL = "4000";
	private static final String NUMERO_ARABIGO_CUATROMIL_UNO = "4001";
	private static final String NUMERO_ROMANO_UNO = "I";
	private static final String NUMERO_ROMANO_CUATROMIL = "MMMM";
	
	IConvertidorNumerosService convertidorNumerosServiceImpl;
	
	@PostConstruct
	public void init() {
		convertidorNumerosServiceImpl = new ConvertidorNumerosServiceImpl();
	}

	@Test
	public void arabigoARomanoTest() throws ServiceException {
		String numeroRomano = convertidorNumerosServiceImpl.arabigoARomano(NUMERO_ARABIGO_UNO);
		assertEquals(NUMERO_ROMANO_UNO, numeroRomano);
	}
	
	@Test(expected = ServiceException.class)
	public void negativosArabigoARomanoTest() throws ServiceException {
		convertidorNumerosServiceImpl.arabigoARomano(NUMERO_ARABIGO_MENOS_UNO);
	}
	
	@Test(expected = ServiceException.class)
	public void numeroCeroArabigoARomanoTest() throws ServiceException {
		convertidorNumerosServiceImpl.arabigoARomano(NUMERO_ARABIGO_CERO);
	}
	
	@Test
	public void numeroCuatromilArabigoARomanoTest() throws ServiceException {
		String numeroRomano = convertidorNumerosServiceImpl.arabigoARomano(NUMERO_ARABIGO_CUATROMIL);
		assertEquals(NUMERO_ROMANO_CUATROMIL, numeroRomano);
	}
	
	@Test(expected = ServiceException.class)
	public void numeroCuatromilUnoArabigoARomanoTest() throws ServiceException {
		convertidorNumerosServiceImpl.arabigoARomano(NUMERO_ARABIGO_CUATROMIL_UNO);
	}

}
