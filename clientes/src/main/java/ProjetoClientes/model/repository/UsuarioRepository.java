package ProjetoClientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoClientes.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
