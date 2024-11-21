package fiap.br.powernow.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_MEDIDA")
@SequenceGenerator(name = "MEDIDA_SEQ", sequenceName = "TB_MEDIDA_SEQ", allocationSize = 1)
public class MedidaPainel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEDIDA_SEQ")
    @Column(name = "ID_MEDIDA", nullable = false)
    private Long idMedida;

    @Column(name = "ID_PAINEL_SOLAR")
    private Long idPainelSolar;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;

    @Column(name = "ENERGIA_GERADA")
    private String energiaGerada;

    @Column(name = "ENERGIA_CONSUMIDA")
    private String energiaConsumida;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    public Long getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Long idMedida) {
        this.idMedida = idMedida;
    }

    public Long getIdPainelSolar() {
        return idPainelSolar;
    }

    public void setIdPainelSolar(Long idPainelSolar) {
        this.idPainelSolar = idPainelSolar;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getEnergiaGerada() {
        return energiaGerada;
    }

    public void setEnergiaGerada(String energiaGerada) {
        this.energiaGerada = energiaGerada;
    }

    public String getEnergiaConsumida() {
        return energiaConsumida;
    }

    public void setEnergiaConsumida(String energiaConsumida) {
        this.energiaConsumida = energiaConsumida;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
