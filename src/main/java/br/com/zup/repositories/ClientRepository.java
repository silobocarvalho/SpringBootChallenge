package br.com.zup.repositories;

import org.springframework.stereotype.Repository;

import br.com.zup.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
//responsavel por oferecer a interação com o banco de dados de forma encapsulada.
// a implementação do string data jpa ja oferece uma implementação em tempo de execução com diversos metodos, 
//	como: listagem, inserção, deleção da entidade.
	
	public Client findByEmail(String email);
	public Client findByCpf(String cpf);
	
}
