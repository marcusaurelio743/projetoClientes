package ProjetoClientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoClientes.model.entity.Servico;



public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
