package ProjetoClientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ProjetoClientes.model.entity.Usuario;
import ProjetoClientes.model.repository.UsuarioRepository;
import ProjetoClientes.util.UsuarioCadastradoExeption;


@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario salvar(Usuario usuario) {
		boolean exists = repository.existsByUsername(usuario.getLogin());
		
		if(exists) {
			throw new UsuarioCadastradoExeption(usuario.getLogin());
		}
		return repository.save(usuario);
	}
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		Usuario usuario = repository
							.findBylogin(login)
							.orElseThrow(()-> new UsernameNotFoundException("Login não encontrado"));
		
		return User
				.builder()
				.username(usuario.getLogin())
				.password(usuario.getSenha())
				.roles("USER")
				.build()
				;
	}

}
