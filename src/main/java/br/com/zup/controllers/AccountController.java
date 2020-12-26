package br.com.zup.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.exceptions.AccountNotFoundException;
import br.com.zup.exceptions.ClientNotFoundException;
import br.com.zup.model.Account;
import br.com.zup.model.Client;
import br.com.zup.repositories.AccountRepository;
import br.com.zup.repositories.ClientRepository;
import br.com.zup.util.AccountUtils;
import br.com.zup.util.AgencyUtils;



@RestController //@Controller + @ResponseBody
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private ClientRepository clientRepository;

	
	
	@GetMapping
	public List<Account> listAccounts(){
		return accountRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Account newAccount(@RequestBody Map<String, String> jsonParameters) throws Exception { 
		
		String clientCpf = jsonParameters.get("clientCpf");
		String zipcode = jsonParameters.get("zipcode");
		
		Client clientFromDatabase = clientRepository.findByCpf(clientCpf);
		
		if(clientFromDatabase == null) {
			throw new ClientNotFoundException();
		}else {
			int agencyNumber = AgencyUtils.getAgencyNumberByLocation(zipcode);
			int accountNumber = AccountUtils.generateAccountNumber(clientFromDatabase);
				
			Account newAccount = new Account(agencyNumber, accountNumber, clientFromDatabase);
			
			return accountRepository.save(newAccount);	
		}
	}
	
	@DeleteMapping
	public void deleteAccount(@RequestParam String accountIdStr) throws AccountNotFoundException{
		
		Account accountFromDatabase = null;
				
		if (accountIdStr != null) {
			long accountId = Long.parseLong(accountIdStr);			
			accountFromDatabase = accountRepository.getOne(accountId);
		}
		
		if(accountFromDatabase != null) {
			accountRepository.delete(accountFromDatabase);	
		}else {
			throw new AccountNotFoundException();
		}
		
	}
	
}
