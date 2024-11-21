package fiap.br.powernow.domain;

import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_COMPRA")
@SequenceGenerator(name = "COMPRA_SEQ", sequenceName = "TB_COMPRA_SEQ", allocationSize = 1)

public class Compra {

	public Compra() {}
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPRA_SEQ")
	@Column(name="ID_COMPRA")
	@NotNull
	private long idCompra;

	@Column(name="ID_CLIENTE", insertable=false, updatable=false)
	@NotNull
	private long idCliente;

	@Column(name="DATA_COMPRA")
	@NotNull
	private Calendar dataCompra;

	@Column(name="STATUS")
	@NotNull
	private String status;
	
	
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Usuario cliente;
    
    @ManyToMany
    @JoinTable(
        name = "TB_COMPRA_PRODUTO",
        joinColumns = @JoinColumn(name = "ID_COMPRA"), 
        inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO"))
    private List<Produto> produtos;
    
    
    @ManyToOne
    @JoinColumn(name = "ID_FILIAL")
    private Filial filial;
    

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
