package co.com.cava.example.costumer.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.cava.example.costumer.entities.Custumer;
import co.com.cava.example.costumer.repository.CustumerRepository;

@Service
public class CustumerServiceImp implements CustumerService{

	@Autowired
	private CustumerRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Custumer> listAllCostumer() {
		return repository.findAll();
	}
	@Transactional(readOnly = true)
	public Iterable<Custumer> listAllCostumer(Pageable pageable) {
		return repository.findAll(pageable);
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<Custumer> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional()
	public Custumer saveCostumer(Custumer costumer) {
		return repository.save(costumer);
	}

	@Override
	@Transactional()
	public void deleteById(Long id) {
		Optional<Custumer> costumer= findById(id);
		if(costumer.isPresent()) {
			repository.deleteById(id);
		}
	}

}
