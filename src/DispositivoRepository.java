import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    // Buscar dispositivos pelo nome
    List<Dispositivo> findByNome(String nome);

    // Buscar dispositivos pelo tipo (ex: Sensor, Lâmpada)
    List<Dispositivo> findByTipo(String tipo);

    // Buscar dispositivos ativos (ligados)
    List<Dispositivo> findByStatusTrue();

    // Buscar dispositivos pela localização
    List<Dispositivo> findByLocalizacao(String localizacao);
}
