package ProjetoClientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoClientes.model.entity.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
