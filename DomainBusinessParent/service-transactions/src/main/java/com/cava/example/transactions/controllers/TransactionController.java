package com.cava.example.transactions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cava.example.transactions.services.TransactionService;

@RestController
@RequestMapping
public class TransactionController {

	@Autowired
	private TransactionService service;
	
	@GetMapping
	public ResponseEntity<?> listarTodos(){
		return ResponseEntity.ok().body(service.listadoTrasactions());
	}
}
