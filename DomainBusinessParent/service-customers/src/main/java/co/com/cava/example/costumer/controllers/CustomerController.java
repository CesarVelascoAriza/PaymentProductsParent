package co.com.cava.example.costumer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.cava.example.costumer.entities.Custumer;
import co.com.cava.example.costumer.services.CustumerService;

@RestController
@RequestMapping
public class CustomerController {

	@Autowired
	private CustumerService service;
	
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		List<Custumer> listado = (List<Custumer>) service.listAllCostumer();
		if(listado.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(listado);
	}
	
	@PostMapping
	public ResponseEntity<?> saveCostumer(){
		return ResponseEntity.ok().build();
	}
	@PutMapping
	public ResponseEntity<?> udateCostomer(){
		return ResponseEntity.ok().build();
	}
	@DeleteMapping
	public ResponseEntity<?> deleteCostumer(){
		return ResponseEntity.ok().build();
	}
}
