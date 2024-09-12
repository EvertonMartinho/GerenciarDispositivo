import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    // Listar todos os dispositivos
    public List<Dispositivo> listarDispositivos() {
        return dispositivoRepository.findAll();
    }

    // Criar um novo dispositivo
    public Dispositivo criarDispositivo(Dispositivo dispositivo) {
        // Validações personalizadas podem ser feitas aqui, como verificar se já existe um dispositivo com o mesmo nome
        return dispositivoRepository.save(dispositivo);
    }

    // Obter um dispositivo pelo ID
    public Dispositivo obterDispositivo(Long id) {
        return dispositivoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo não encontrado com id: " + id));
    }

    // Atualizar um dispositivo existente
    @Transactional
    public Dispositivo atualizarDispositivo(Long id, Dispositivo dispositivo) {
        Dispositivo existente = obterDispositivo(id);
        existente.setNome(dispositivo.getNome());
        existente.setStatus(dispositivo.isStatus());
        existente.setTipo(dispositivo.getTipo());
        existente.setLocalizacao(dispositivo.getLocalizacao());
        return dispositivoRepository.save(existente); // Pode não ser necessário devido ao @Transactional
    }

    // Excluir um dispositivo
    public void excluirDispositivo(Long id) {
        if (!dispositivoRepository.existsById(id)) {
