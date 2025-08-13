package br.com.emanueldias.MeuIngresso.controller.evento;

import br.com.emanueldias.MeuIngresso.dto.evento.EventoRequestDTO;
import br.com.emanueldias.MeuIngresso.dto.evento.EventoUpdateDTO;
import br.com.emanueldias.MeuIngresso.model.evento.Evento;
import br.com.emanueldias.MeuIngresso.service.evento.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventos(){
        return ResponseEntity.ok(eventoService.getAllEventos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id){
        return ResponseEntity.ok(eventoService.getEventoById(id));
    }

    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody EventoRequestDTO dto, UriComponentsBuilder uriComponentsBuilder){
        Evento evento = eventoService.createEvento(dto);
        URI uri = uriComponentsBuilder
                .path("/{id}")
                .buildAndExpand(evento.getId())
                .toUri();

        return ResponseEntity.created(uri).body(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> uptadeEvento(@RequestBody EventoUpdateDTO dto, @PathVariable Long id){
        return ResponseEntity.ok(eventoService.updateEvento(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEventoById(@PathVariable Long id){
        eventoService.deleteEventoById(id);
        return ResponseEntity.noContent().build();
    }
}
