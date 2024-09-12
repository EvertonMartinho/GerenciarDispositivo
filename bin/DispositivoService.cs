// DispositivoService.java
@Service
public class DispositivoService {
    
    @Autowired
    private DispositivoRepository dispositivoRepository;

    public List<Dispositivo> listarDispositivos() {
        return dispositivoRepository.findAll();
    }

    public Dispositivo criarDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    public Dispositivo obterDispositivo(Long id) {
        return dispositivoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dispositivo não encontrado"));
    }

    public Dispositivo atualizarDispositivo(Long id, Dispositivo dispositivo) {
        Dispositivo existente = obterDispositivo(id);
        existente.setNome(dispositivo.getNome());
        existente.setStatus(dispositivo.isStatus());
        return dispositivoRepository.save(existente);
    }

    public void excluirDispositivo(Long id) {
        dispositivoRepository.deleteById(id);
    }
}
