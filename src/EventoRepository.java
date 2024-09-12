import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    // Buscar eventos por dispositivo
    List<Evento> findByDispositivoId(Long dispositivoId);

    // Buscar eventos por tipo de evento (ex: leitura de temperatura)
    List<Evento> findByTipoEvento(String tipoEvento);

    // Buscar eventos ocorridos após uma determinada data/hora
    List<Evento> findByDataHoraAfter(LocalDateTime dataHora);

    // Buscar eventos de um dispositivo específico após uma determinada data/hora
    List<Evento> findByDispositivoIdAndDataHoraAfter(Long dispositivoId, LocalDateTime dataHora);
}
