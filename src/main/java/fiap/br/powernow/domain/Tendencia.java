package fiap.br.powernow.domain;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "TB_TENDENCIA")
public class Tendencia {
	
	@Id
	private Long idTendencia;
	
	@Column
	private String nome;
	
	@Column(name = "DATA_INICIO")
	private Calendar dataInicio;
	
	@Column(name = "DATA_FIM")
	private Calendar dataFim;
	
	@OneToMany( mappedBy = "")

	public Long getIdTendencia() {
		return idTendencia;
	}

	public void setIdTendencia(Long idTendencia) {
		this.idTendencia = idTendencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}
	

}
