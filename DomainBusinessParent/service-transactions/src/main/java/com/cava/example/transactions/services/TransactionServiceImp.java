package com.cava.example.transactions.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cava.example.transactions.entities.Transaction;
import com.cava.example.transactions.repositorys.TransacctionRepository;

@Service
public class TransactionServiceImp implements TransactionService {
	
	@Autowired
	private TransacctionRepository repository;

	@Override
	public Iterable<Transaction> listadoTrasactions() {
		return repository.findAll();
	}

	@Override
	public Optional<Transaction> findById(Long id) {
		
		return repository.findById(id);
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return repository.save(transaction);
	}

	@Override
	public void deleteTransaction(Long id) {
		Optional<Transaction> optinal = findById(id);
		if(optinal.isPresent())
			repository.deleteById(id);
		
	}

}
