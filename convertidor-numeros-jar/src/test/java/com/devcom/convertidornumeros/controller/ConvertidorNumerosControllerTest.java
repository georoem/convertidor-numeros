package com.devcom.convertidornumeros.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConvertidorNumerosControllerTest {
	
	private static final int NUMERO_ARABIGO_UNO = 1;
	private static final int NUMERO_ARABIGO_MENOS_UNO = -1;
	private static final int NUMERO_ARABIGO_CERO = 0;
	private static final int NUMERO_ARABIGO_CUATROMIL = 4000;
	private static final int NUMERO_ARABIGO_CUATROMIL_UNO = 4001;
	private static final String NUMERO_ROMANO_UNO = "I";
	private static final String NUMERO_ROMANO_CUATROMIL = "MMMM";
	private static final String ERROR_RANGO_DE_NUMERO_INVALIDO = "Rango de número inválido";
	private static final String ERROR_NUMERO_INVALIDO = "Formato Inválido";

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void convertirUnoARomanoControllerTest() throws Exception {
        this.mockMvc.perform(get("/convertir/arabigo/romano/"+NUMERO_ARABIGO_UNO)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(NUMERO_ROMANO_UNO)));
    }
    
    @Test
    public void convertirMenosUnoARomanoControllerTest() throws Exception {
        this.mockMvc.perform(get("/convertir/arabigo/romano/"+NUMERO_ARABIGO_MENOS_UNO)).andDo(print()).andExpect(status().is5xxServerError())
                .andExpect(content().string(containsString(ERROR_RANGO_DE_NUMERO_INVALIDO)));
    }
    
    @Test
    public void convertirCeroARomanoControllerTest() throws Exception {
        this.mockMvc.perform(get("/convertir/arabigo/romano/"+NUMERO_ARABIGO_CERO)).andDo(print()).andExpect(status().is5xxServerError())
                .andExpect(content().string(containsString(ERROR_RANGO_DE_NUMERO_INVALIDO)));
    }
    
    @Test
    public void convertirCuatromilARomanoControllerTest() throws Exception {
        this.mockMvc.perform(get("/convertir/arabigo/romano/"+NUMERO_ARABIGO_CUATROMIL)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(NUMERO_ROMANO_CUATROMIL)));
    }
    
    @Test
    public void convertirCuatromilUnoARomanoControllerTest() throws Exception {
        this.mockMvc.perform(get("/convertir/arabigo/romano/"+NUMERO_ARABIGO_CUATROMIL_UNO)).andDo(print()).andExpect(status().is5xxServerError())
                .andExpect(content().string(containsString(ERROR_RANGO_DE_NUMERO_INVALIDO)));
    }
    
    @Test
    public void convertirNoNumeroARomano1ControllerTest() throws Exception {
        this.mockMvc.perform(get("/convertir/arabigo/romano/ABC")).andDo(print()).andExpect(status().is5xxServerError())
                .andExpect(content().string(containsString(ERROR_NUMERO_INVALIDO)));
    }
 
}
