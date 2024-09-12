import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configura um broker para enviar mensagens de broadcast para destinos que começam com "/topic"
        config.enableSimpleBroker("/topic");
        // Prefixo para mensagens enviadas do cliente para o servidor, será mapeado para métodos @MessageMapping
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Registra o endpoint WebSocket no caminho "/ws" e permite origens cruzadas (CORS) para qualquer origem
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    }
}
