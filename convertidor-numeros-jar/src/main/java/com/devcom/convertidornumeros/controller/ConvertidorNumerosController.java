package com.devcom.convertidornumeros.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.devcom.convertidornumeros.exception.ServiceException;
import com.devcom.convertidornumeros.services.IConvertidorNumerosService;

/**
 * Controlador de la aplicación que implementa los servicios de conversión
 * @author Jorge Aguirre
 *
 */
@Controller
@RequestMapping("/convertir")
public class ConvertidorNumerosController {
	
	@Autowired
	IConvertidorNumerosService convertidorNumeroSevices;
	
	/** Método que recibe las peticiónes de conversión de números arábigos a romanos
	 * @param numeroArabigo
	 * @return String
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/arabigo/romano/{numero}", method = RequestMethod.GET)
    public @ResponseBody String convertirNumeroArabigoARomano(@PathVariable("numero") String numeroArabigo) throws ServiceException {		
        return convertidorNumeroSevices.arabigoARomano(numeroArabigo);
    }
	
	/** Método para manejar las excepciones de la aplicación
	 * @param ex
	 * @param request
	 * @return String
	 */
	@ExceptionHandler(value = { ServiceException.class , NumberFormatException.class})
	protected ResponseEntity<String> handleException(Exception ex, WebRequest request) {
		String bodyOfResponse = ex.getMessage();
		return new ResponseEntity<>(bodyOfResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
