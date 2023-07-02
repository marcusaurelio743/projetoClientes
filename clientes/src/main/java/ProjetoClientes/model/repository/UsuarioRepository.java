package ProjetoClientes.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoClientes.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findBylogin(String login);
	
	//select count(*)>0 from usuario where login = :login
	boolean existsByUsername(String login);

}
