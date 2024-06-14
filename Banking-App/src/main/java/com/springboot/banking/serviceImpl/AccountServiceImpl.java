package com.springboot.banking.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.banking.dto.AccountDto;
import com.springboot.banking.entity.Account;
import com.springboot.banking.repository.AccountRepository;
import com.springboot.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = new Account();
		account.setId(accountDto.getId());
		account.setAccountHolderName(accountDto.getAccountHolderName());
		account.setBalance(accountDto.getBalance());
		Account savedAccount = accountRepository.save(account);
		return mapToAccountDto(savedAccount);
	}

	private Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
		return account;
	}

	private AccountDto mapToAccountDto(Account account) {

		AccountDto accountDto = new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
		return accountDto;
	}

	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		return mapToAccountDto(account);
	}

	@Override

	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));

		double total = account.getBalance() + amount;
		account.setBalance(total);

		Account savedAccount = accountRepository.save(account);

		return mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));

		if(account.getBalance()< amount){
			throw new RuntimeException("Insufficient amount");
		}
		double total=account.getBalance()-amount;
		account.setBalance(total);
		Account savedAccount=accountRepository.save(account);
		
		return mapToAccountDto(savedAccount);
	}

	
	public List<AccountDto> getAllAccounts() {
	    List<Account> accounts = accountRepository.findAll();
	    
	    // Map Account entities to AccountDto objects
	    List<AccountDto> accountDtos = accounts.stream()
	            .map(this::mapToAccountDto)
	            .collect(Collectors.toList());

	    return accountDtos; // Return the list of AccountDto objects
	}

	@Override
	public void deleteAccount(Long id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
	
		accountRepository.deleteById(id);
	}


}
