package br.com.zup.repositories;

import org.springframework.stereotype.Repository;

import br.com.zup.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public Account findByAccountNumber(int accountNumber);
	public Account findByClientId(long clientId);
	
}
