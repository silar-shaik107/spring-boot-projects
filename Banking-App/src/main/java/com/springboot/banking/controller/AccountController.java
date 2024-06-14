package com.springboot.banking.controller;

import java.util.List;
import java.util.Map;

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

import com.springboot.banking.dto.AccountDto;
import com.springboot.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	AccountService accountService;

	// Add Account REST API
	@PostMapping("/create")
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
		AccountDto accountDto1=accountService.createAccount(accountDto);
		return new ResponseEntity<>(accountDto1, HttpStatus.CREATED);
	}

	// Get Account by Id
	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable long id) {
		AccountDto accountDto = accountService.getAccountById(id);
		return new ResponseEntity<>(accountDto, HttpStatus.OK);
	}

	// Deposit REST API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		AccountDto accountDto = accountService.deposit(id, amount);
		return new ResponseEntity<>(accountDto,HttpStatus.OK);
	}

	// withdraw REST API
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {

		Double amount = request.get("amount");
		AccountDto accountDto = accountService.withdraw(id, amount);
		return new ResponseEntity<>(accountDto,HttpStatus.OK);
	}
	
	//Get All Accounts REST API
	@GetMapping
	public ResponseEntity<List<AccountDto>> getAllAccounts(){
		List<AccountDto> accounts=accountService.getAllAccounts();
		return new ResponseEntity<>(accounts,HttpStatus.OK);
	}
	
	//Delete Account REST API
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		return new ResponseEntity<>("Account is deleted Successfully",HttpStatus.OK);
	}

}
