package desafioDev.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@Entity
@Table(name = "TABLE_DESAFIO_DEV")
@SequenceGenerator(name = "DESAFIO_DEV_SEQ", sequenceName = "DESAFIO_DEV_SEQ", allocationSize = 1)
public class DesafioDev {
	
	@Id
	@Column(name="ID")
	@JsonInclude(value=Include.NON_NULL)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DESAFIO_DEV_SEQ")
	private Long id;
	
	@Column(name="TIPO")
	private String tipo;
	
	@Column(name="DATA")
	private String data;
	
	@Column(name="VALOR")
	private Double valor;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="CARTAO")
	private String cartao;
	
	@Column(name="HORA")
	private String hora;
	
	@Column(name="DONO_LOJA")
	private String donoDaLoja;
	
	@Column(name="NOME_LOJA")
	private String nomeDaLoja;
	
	
}
