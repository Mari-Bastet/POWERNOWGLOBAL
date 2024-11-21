package fiap.br.powernow.domain;
 
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 
@Entity
@SequenceGenerator(name = "FILIAL_SEQ", sequenceName = "TB_FILIAL_SEQ", allocationSize = 1)

@Table(name = "TB_FILIAL")
public class Filial {
 
	@Id()
	@Column(name = "ID_FILIAL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILIAL_SEQ")
	private Long idFilial;
 
	@Column
	@NotNull
	@Max(255)
	private String nome;
 
	@Column
	@NotNull
	@Max(2)
	private String estado;
 
	@Column
	@NotNull
	@Max(100)
	private String cidade;
 
	@Column
	@NotNull
	@Max(8)
	private String cep;
 
	@Column
	@NotNull
	@Max(255)
	private String endereco;
	
	@Column(name = "COD_FILIAL")
	@NotNull
	@Max(255)
	private String codFilial;
	
	@OneToMany(mappedBy = "filial",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Compra> compras;
	
	public Filial(Long idFilial, @NotNull @Max(255) String nome, @NotNull @Max(2) String estado,
			@NotNull @Max(100) String cidade, @NotNull @Max(8) String cep, @NotNull @Max(255) String endereco,
			@NotNull @Max(255) String codFilial) {
		super();
		this.idFilial = idFilial;
		this.nome = nome;
		this.estado = estado;
		this.cidade = cidade;
		this.cep = cep;
		this.endereco = endereco;
		this.codFilial = codFilial;
	}
	
	public Filial(){}

	public Long getIdFilial() {
		return idFilial;
	}

	public void setIdFilial(Long idFilial) {
		this.idFilial = idFilial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCodFilial() {
		return codFilial;
	}

	public void setCodFilial(String codFilial) {
		this.codFilial = codFilial;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
 
}