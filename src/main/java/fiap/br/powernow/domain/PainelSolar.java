package fiap.br.powernow.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PAINEL_SOLAR")
@SequenceGenerator(name = "PAINEL_SEQ", sequenceName = "TB_PAINEL_SOLAR_SEQ", allocationSize = 1)
public class PainelSolar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAINEL_SEQ")
    @Column(name = "id_painel_solar")
    private Integer id;

    @Column(name = "modelo", length = 500, nullable = false)
    private String modelo;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Column(name = "fabricante", length = 500)
    private String fabricante;

    @Column(name = "potencia", length = 255)
    private String potencia;

    @Column(name = "tamanho")
    private Double tamanho;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "vida_util")
    private Integer vidaUtil;

    @ManyToMany(mappedBy = "paineis")
    private List<Usuario> usuarios;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public Double getTamanho() {
        return tamanho;
    }

    public void setTamanho(Double tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(Integer vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

}
