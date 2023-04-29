package ProjetoClientes.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public Cliente salvar(@RequestBody @Valid Cliente cliente) {
		return repository.save(cliente);
	}
	
	@GetMapping("{codigo}")
	public Cliente buscaPorId(@PathVariable("codigo") Long id) {
		return repository
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long id) {
		repository
		.findById(id)
		.map(cliente->{
			repository.delete(cliente);
			return Void.TYPE;
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizar(@PathVariable Long id,  @RequestBody Cliente clienteAtualizado) {
		repository
		.findById(id)
		.map(cliente->{
			cliente.setNome(clienteAtualizado.getNome());
			cliente.setCpf(clienteAtualizado.getCpf());
			
			return repository.save(cliente);
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

}
