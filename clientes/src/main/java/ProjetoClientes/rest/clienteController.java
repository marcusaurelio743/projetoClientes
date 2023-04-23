package ProjetoClientes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ProjetoClientes.model.entity.Cliente;
import ProjetoClientes.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class clienteController {
	
	private ClienteRepository repository;
	
	//injeção de dependencia do cliente repository para classe controller
	
	@Autowired
	public clienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}

}
