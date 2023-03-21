package co.com.cava.example.costumer.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<?> saveCostumer(@RequestBody Custumer custumer){
		Custumer custumerdB = service.saveCostumer(custumer);
		return ResponseEntity.status(HttpStatus.CREATED).body(custumerdB);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> udateCostomer(@PathVariable Long id, @RequestBody Custumer custumer ){
		Optional<Custumer> optional = service.findById(id);
		if(!optional.isPresent()) {
			return  ResponseEntity.noContent().build();
		}
		Custumer customerDB = optional.get();
		customerDB.setName(custumer.getName());
		customerDB.setCode(custumer.getCode());
		customerDB.setIban(custumer.getIban());
		customerDB.setSurname(custumer.getSurname());
		customerDB.setPhone(custumer.getPhone());
		customerDB.setAddress(custumer.getAddress());
		customerDB.setProducts(custumer.getProducts());
		customerDB.setTransactions(custumer.getTransactions());
		return ResponseEntity.status(HttpStatus.OK).body(service.saveCostumer(customerDB));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCostumer(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
