import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long dispositivoId;
    private String tipoEvento; // ex: leitura de temperatura, acionamento de lâmpada
    private String dados;
    private LocalDateTime dataHora;

    // Construtores
    public Evento() {
    }

    public Evento(Long dispositivoId, String tipoEvento, String dados, LocalDateTime dataHora) {
        this.dispositivoId = dispositivoId;
        this.tipoEvento = tipoEvento;
        this.dados = dados;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDispositivoId() {
        return dispositivoId;
    }

    public void setDispositivoId(Long dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // hashCode e equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evento evento = (Evento) o;
        return id.equals(evento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString
    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", dispositivoId=" + dispositivoId +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", dados='" + dados + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }
}
