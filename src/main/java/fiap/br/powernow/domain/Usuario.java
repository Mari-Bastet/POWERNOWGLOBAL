package fiap.br.powernow.domain;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name="TB_USUARIOS")
@SequenceGenerator(name = "USU_SEQ", sequenceName = "TB_USUARIOS_SEQ", allocationSize = 1)
public class Usuario {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USU_SEQ")
	@Column(name="ID_USUARIO")
	private Long id;
	
	@NotNull
	@Size(min=2, max=255)
	private String nome;
	
	@Email
	private String email;
	
	@Size(min=2, max=255)
	private String endereco;
	
	@Size(min=2, max=300)
	private String senha;
	
	@Size(min=8, max=14)
	private String telefone;
	
    @ManyToMany
    @JoinTable(
        name = "TB_PAINEL_SOLAR_USUARIO",
        joinColumns = @JoinColumn(name = "ID_USUARIO"), 
        inverseJoinColumns = @JoinColumn(name = "ID_PAINEL_SOLAR"))
    private List<PainelSolar> paineis;
	
//    @OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//    private List<Compra> compras;
//   
//    public List<Compra> getCompras() {
//    return compras;
//     }
//    
//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//	private List<Feedback> feedbacks;
//    
//    public List<Feedback> getFeedbacks(){
//    	return feedbacks;
//    }
    
	public Usuario() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	};
	
}