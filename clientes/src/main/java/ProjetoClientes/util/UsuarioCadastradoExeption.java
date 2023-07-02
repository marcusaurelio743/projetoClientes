package ProjetoClientes.util;

public class UsuarioCadastradoExeption extends RuntimeException {
	
	public UsuarioCadastradoExeption(String login) {
		super("Usuário Já está cadastrado para o Login ! "+login);
	}
}
