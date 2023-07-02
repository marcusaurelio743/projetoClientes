package ProjetoClientes.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true,length = 100)
	@NotEmpty(message = "{campo.login.obrigatorio}")
	private String login;
	
	@Column(length = 100)
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String senha;

}
