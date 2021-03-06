package com.nttdata.bootcamp.project1.accounts.infraestructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.project1.accounts.application.AccountOperations;
import com.nttdata.bootcamp.project1.accounts.domain.Account;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	AccountOperations accountOperations;
	
	@GetMapping
	public Flux<Account> get() {
		log.info("Trazabilidad");
		return accountOperations.queryAll();
	}
	
	@GetMapping("/{number}")
	public Mono<Account> getNumber(@PathVariable String number) {
		return accountOperations.findNumber(number);
	}
	
	@PostMapping()
	public Mono<Account> post(@RequestBody Account entity) {
		return accountOperations.create(entity);
	}
	
	@PutMapping("/update/{number}")
	public Mono<Account> put(@PathVariable String number, @RequestBody Mono<Account> entity) {
		return accountOperations.update(number, entity);
	}
	
	@DeleteMapping("/delete/{number}")
	public Mono<Void> delete(@PathVariable String number) {
		return accountOperations.delete(number);
	}

}
