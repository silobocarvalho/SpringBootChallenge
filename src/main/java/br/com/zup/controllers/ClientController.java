package br.com.zup.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.exceptions.CpfAlreadyExistsException;
import br.com.zup.exceptions.EmailAlreadyExistsException;
import br.com.zup.model.Account;
import br.com.zup.model.Client;
import br.com.zup.repositories.ClientRepository;

@RestController //@Controller + @ResponseBody
@RequestMapping("/clients")
public class ClientController {

	@Autowired //Spring framework.factory
	//Adiciona uma instancia automaticamente, permitindo o uso sem precisar instanciar.
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> listClients(){
		
		return clientRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//Request body transform input data into model object.
	public Client newClient(@RequestBody Client client) throws Exception { 
		
		if (clientRepository.findByEmail(client.getEmail()) != null) {
			throw new EmailAlreadyExistsException(); 
		}
		
		if (clientRepository.findByCpf(client.getCpf()) != null) {
			throw new CpfAlreadyExistsException(); 
		}
		
		return clientRepository.save(client);
	}
}
