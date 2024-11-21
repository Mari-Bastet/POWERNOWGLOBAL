package fiap.br.powernow;

public class PainelSolarUsuarioDTO {
	
	private String modelo;
	private String potencia;
	private Double energiaGeradaTotal;
	private Integer id;
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getEnergiaGeradaTotal() {
		return energiaGeradaTotal;
	}
	public void setEnergiaGeradaTotal(Double energiaGeradaTotal) {
		this.energiaGeradaTotal = energiaGeradaTotal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPotencia() {
		return potencia;
	}
	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	
	

}
