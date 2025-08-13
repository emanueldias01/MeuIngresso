package br.com.emanueldias.MeuIngresso.controller.ingresso;

import br.com.emanueldias.MeuIngresso.dto.ingresso.IngressoUpdateDTO;
import br.com.emanueldias.MeuIngresso.model.ingresso.Ingresso;
import br.com.emanueldias.MeuIngresso.service.ingresso.IngressoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.emanueldias.MeuIngresso.dto.ingresso.IngressoRequestDTO;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {

    private final IngressoService ingressoService;

    public IngressoController(IngressoService ingressoService) {
        this.ingressoService = ingressoService;
    }

    @GetMapping("/evento/{id}")
    public ResponseEntity<List<Ingresso>> getAllIngressosFromEventoId(@PathVariable Long id){
        return ResponseEntity.ok(ingressoService.getAllIngressosFromEventoId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingresso> getIngressoById(@PathVariable Long id){
        return ResponseEntity.ok(ingressoService.getIngressoById(id));
    }

    @PostMapping
    public ResponseEntity<Ingresso> createIngressoFromEventoId(@RequestBody IngressoRequestDTO dto, UriComponentsBuilder uriComponentsBuilder){
        Ingresso ingresso = ingressoService.createIngresso(dto);
        URI uri = uriComponentsBuilder.path("{id}")
                .buildAndExpand(ingresso.getId())
                .toUri();

        return ResponseEntity.created(uri).body(ingresso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingresso> updateIngresso(@RequestBody IngressoUpdateDTO dto, @PathVariable Long id){
        return ResponseEntity.ok(ingressoService.updateIngresso(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteIngressoById(@PathVariable Long id){
        ingressoService.deleteIngressoById(id);
        return ResponseEntity.noContent().build();
    }
}
