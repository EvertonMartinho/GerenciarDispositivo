import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    // Listar todos os dispositivos
    @GetMapping
    public ResponseEntity<List<Dispositivo>> listarDispositivos() {
        List<Dispositivo> dispositivos = dispositivoService.listarDispositivos();
        return ResponseEntity.ok(dispositivos);
    }

    // Criar um novo dispositivo
    @PostMapping
    public ResponseEntity<Dispositivo> criarDispositivo(@RequestBody Dispositivo dispositivo) {
        Dispositivo novoDispositivo = dispositivoService.criarDispositivo(dispositivo);
        return new ResponseEntity <> (novoDispositivo, HttpStatus.CREATED);
    }

    // Obter dispositivo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> obterDispositivo(@PathVariable Long id) {
        Dispositivo dispositivo = dispositivoService.obterDispositivo(id);
        return ResponseEntity.ok(dispositivo);
    }

    // Atualizar dispositivo existente
    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> atualizarDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        Dispositivo dispositivoAtualizado = dispositivoService.atualizarDispositivo(id, dispositivo);
        return ResponseEntity.ok(dispositivoAtualizado);
    }

    // Excluir dispositivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDispositivo(@PathVariable Long id) {
        dispositivoService.excluirDispositivo(id);
        return ResponseEntity.noContent().build();
    }

    // Alterar status (ligar/desligar) do dispositivo
    @PatchMapping("/{id}/status")
    public ResponseEntity<Dispositivo> alterarStatus(@PathVariable Long id, @RequestParam boolean status) {
        Dispositivo dispositivoAtualizado = dispositivoService.alterarStatus(id, status);
        return ResponseEntity.ok(dispositivoAtualizado);
    }

    // Listar dispositivos ativos (ligados)
    @GetMapping("/ativos")
    public ResponseEntity<List<Dispositivo>> listarDispositivosAtivos() {
        List<Dispositivo> dispositivosAtivos = dispositivoService.listarDispositivosAtivos();
        return ResponseEntity.ok(dispositivosAtivos);
    }
}
