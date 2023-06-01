package ProjetoClientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import ProjetoClientes.model.entity.Cliente;
import ProjetoClientes.model.entity.ServicoPrestado;
import ProjetoClientes.model.repository.ClienteRepository;
import ProjetoClientes.model.repository.ServicoPrestadoRepository;
import ProjetoClientes.rest.dto.ServicoPrestadoDto;
import ProjetoClientes.util.BigDecimalConverter;

@RestController
@RequestMapping("api/servicos-prestados")

public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicoPrestadoRepository repository;
	private final BigDecimalConverter converter;
	
	

	public ServicoPrestadoController(ClienteRepository clienteRepository,
			ServicoPrestadoRepository servicoPrestadoRepository, BigDecimalConverter converter) {
		
		this.clienteRepository = clienteRepository;
		this.repository = servicoPrestadoRepository;
		this.converter = converter;
	}





	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServicoPrestado salvar(@RequestBody ServicoPrestadoDto dto) {
		//formatando a data usando a api LocalDate
		LocalDate data = LocalDate.parse(dto.getData(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		Long clienteId = dto.getIdcliente();
		
		/*metodo busca um cliente no banco de dados e caso não encontre e chamado um erro via http informando que o
		cliente não existe no banco esse tratamento é feito pois agente so busca o id do cliente pela tela e presisamos do
		objeto cliente para fazer a relação cliente e serviço da regra de negocio*/
		Cliente cliente = 
				clienteRepository
				.findById(clienteId)
				.orElseThrow(() ->new ResponseStatusException(HttpStatus.BAD_REQUEST,"cliente Inesistente"));
		//=============================================================================================================
		
		ServicoPrestado servicoPrestado = new ServicoPrestado();
		servicoPrestado.setDescicao(dto.getDescricao());
		servicoPrestado.setData(data);
		servicoPrestado.setCliente(cliente);
		servicoPrestado.setValor(converter.converter(dto.getPreco()));
		
		return repository.save(servicoPrestado);
	}
	
	@GetMapping
	public List<ServicoPrestado> pesquisar(
			//declarando paramentos para pesquisa nesse caso não é obrigatório 
			@RequestParam(value ="nome",required = false,defaultValue = "") String nome,
			@RequestParam(value = "mes",required = false) Integer mes
			
			){
		
		return repository.findByNomeClienteAndMes("%"+nome+"%",mes); 
		
	}

}
