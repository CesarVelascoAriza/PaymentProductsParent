package co.com.cava.example.costumer.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;

import co.com.cava.example.costumer.datos.Datos;
import co.com.cava.example.costumer.entities.Custumer;
import co.com.cava.example.costumer.services.CustumerService;


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
		.andExpect(jsonPath("$",Matchers.hasSize(1)))
		;
		verify(service).listAllCostumer();
	}
	@Test
	@DisplayName("Test list all cutomer with emty datos")
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
	void testSaveCostumer() throws JsonProcessingException, Exception {
		
		Custumer custumer= new Custumer();
		custumer.setName("prueba");
		custumer.setCode("011");
		custumer.setIban("100");
		custumer.setSurname("pruebas");
		custumer.setPhone("123123");
		custumer.setAddress("1231");
		custumer.setProducts(Datos.LIST_PRODUCTS);
		
		when(service.saveCostumer(any())).then(invocatio ->{
			Custumer c= invocatio.getArgument(0);
			c.setId(1L);
			return c;
		});
		mvc.perform(
				MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(custumer))
				)
		.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.name").value("prueba"))
		.andExpect(jsonPath("$.id").value(1))
		;		
	}

	@Test
	void testUdateCostomer() throws JsonProcessingException, Exception {
		Custumer custumer= new Custumer();
		custumer.setName("prueba");
		custumer.setCode("011");
		custumer.setIban("100");
		custumer.setSurname("pruebas");
		custumer.setPhone("123123");
		custumer.setAddress("1231");
		custumer.setProducts(Datos.LIST_PRODUCTS);
		when(service.findById(1L)).thenReturn(Datos.CUSTOMER);
		when(service.saveCostumer(any())).then(invocatio ->{
			Custumer c= invocatio.getArgument(0);
			c.setId(1L);
			return c;
		});
		mvc.perform(
				MockMvcRequestBuilders.put("/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(custumer))
				)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.name").value("prueba"))
		.andExpect(jsonPath("$.id").value(1))
		;
	}

	@Test
	void testDeleteCostumer() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.delete("/1")
				
				)
		.andExpect(status().isOk());
	}

}
