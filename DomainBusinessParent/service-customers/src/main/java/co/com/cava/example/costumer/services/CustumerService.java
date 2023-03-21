package co.com.cava.example.costumer.services;

import java.util.Optional;

import co.com.cava.example.costumer.entities.Custumer;

public interface CustumerService {
	
	Iterable<Custumer> listAllCostumer();
	Optional<Custumer> findById(Long id);
	Custumer saveCostumer(Custumer costumer);
	void deleteById(Long id);

}
