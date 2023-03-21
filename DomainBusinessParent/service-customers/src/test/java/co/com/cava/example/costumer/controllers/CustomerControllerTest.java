package co.com.cava.example.costumer.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.cava.example.costumer.datos.Datos;
import co.com.cava.example.costumer.services.CustumerService;

@SpringBootTest
@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mvc;
	@MockBean
	private CustumerService service;
	
	ObjectMapper objectMapper;
	
	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
	}
	
	
	@Test
	@DisplayName("Test list all cutomer with datos")
	void testListAll() throws Exception {
		//Given
		when(service.listAllCostumer()).thenReturn(Datos.LIST_COSTUMERS);
		//
		mvc.perform(
				MockMvcRequestBuilders.get("/")
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().isOk())
		;
		verify(service).listAllCostumer();
	}
	@Test
	@DisplayName("Test list all cutomer with datos")
	void testListAllvacio() throws Exception {
		//Given
		when(service.listAllCostumer()).thenReturn(Datos.LIST_COSTUMERS_VACIA);
		//
		mvc.perform(
				MockMvcRequestBuilders.get("/")
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().isNoContent())
		;
		verify(service).listAllCostumer();
	}
	@Test
	void testSaveCostumer() {
		
	}

	@Test
	void testUdateCostomer() {
		
	}

	@Test
	void testDeleteCostumer() {
		
	}

}
