package fiap.br.powernow.domain;

import jakarta.persistence.Entity;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;



@Entity
@Table(name="TB_PRODUTO")
@SequenceGenerator(name = "PROD_SEQ", sequenceName = "TB_PRODUTO_SEQ", allocationSize = 1)

public class Produto {
	
	public Produto() {}
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROD_SEQ")
	@Column(name="ID_PRODUTO") 
	private long idProduto;

	@Column(name="ID_TENDENCIA") 
	private long idTendencia;

	@Column(name="ID_CATEGORIA") 
	private long idCategoria;

	@Column(name="NOME", length=255) 
	private String nomeProduto;

	@Column(name="DESCRICAO",length=255) 
	private String descricaoProduto;

	@Column(name="CATEGORIA", length=100) 
	private String categoriaProduto;

	@Column(name="PRECO") 
	private Double precoProduto;

	@Column(name="DATA_LANCAMENTO") 
	private Calendar dataLancamento;
	
	
    @ManyToMany
    @JoinTable(
        name = "TB_COMPRA_PRODUTO",
        joinColumns = @JoinColumn(name = "ID_PRODUTO"), 
        inverseJoinColumns = @JoinColumn(name = "ID_COMPRA"))
    private List<Compra> compras;
    

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public long getIdTendencia() {
		return idTendencia;
	}

	public void setIdTendencia(long idTendencia) {
		this.idTendencia = idTendencia;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


}
