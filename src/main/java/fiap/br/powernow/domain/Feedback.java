package fiap.br.powernow.domain;

import java.util.Calendar;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_FEEDBACKS")
@SequenceGenerator(name = "FEEDBACK_SEQ", sequenceName = "TB_FEEDBACKS_SEQ", allocationSize = 1)
public class Feedback {
	
	public Feedback() {}

	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FEEDBACK_SEQ")	
	@Column(name="ID_FEEDBACK")
	private Long idFeedback;

	@Column(name="ID_CLIENTE", insertable=false, updatable=false)
	private Long idCliente;

	@Column(name="ID_PRODUTO", insertable=false, updatable=false)
	private Long idProduto;

	@Column(name="AVALIACAO")
	@NotNull
	private int avaliacao;

	@Column(name="COMENTARIO", length=500)
	@NotNull
	@Max(500)
	private String comentario;

	@Column(name="DATA_AVALIACAO")
	@NotNull
	private Calendar dataAvaliacao;

	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
    private Usuario cliente;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUTO")
    private Produto produto;
	
	
	public Long getIdFeedback() {
		return idFeedback;
	}

	public void setIdFeedback(Long idFeedback) {
		this.idFeedback = idFeedback;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

}
