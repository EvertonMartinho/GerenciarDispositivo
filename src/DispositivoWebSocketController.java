import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class DispositivoWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/monitorar/{id}")
    @SendTo("/topic/dispositivo/{id}")
    public Dispositivo monitorarDispositivo(@DestinationVariable Long id) {
        // Aqui você pode buscar informações do dispositivo pelo ID
        // Simulação de dados de um dispositivo para enviar em tempo real
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setId(id);
        dispositivo.setNome("Sensor de Temperatura");
        dispositivo.setStatus(true);  // Exemplo de status "ligado"
        dispositivo.setLocalizacao("Sala de Estar");
        
        // Retorna o objeto Dispositivo com os dados atuais
        return dispositivo;
    }

    // Método para enviar atualizações em tempo real de um dispositivo específico
    public void enviarAtualizacaoDispositivo(Long id, String dados) {
        messagingTemplate.convertAndSend("/topic/dispositivo/" + id, dados);
    }
}
