package ProjetoClientes;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ProjetoClientes.model.entity.Cliente;
import ProjetoClientes.model.entity.Servico;
import ProjetoClientes.model.repository.ClienteRepository;
import ProjetoClientes.model.repository.ServicoRepository;



@SpringBootApplication
public class ClienteApplication {
	
	@Autowired ClienteRepository repository;
	
	@Bean
	public CommandLineRunner run() {
		return args ->{
			Cliente cliente = Cliente.builder().cpf("3456789654").nome("jose").build();
			repository.save(cliente);
			
			
		};
		}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

}
