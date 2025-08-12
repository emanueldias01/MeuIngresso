package br.com.emanueldias.MeuIngresso.service.evento;

import br.com.emanueldias.MeuIngresso.dto.evento.EventoRequestDTO;
import br.com.emanueldias.MeuIngresso.dto.evento.EventoUpdateDTO;
import br.com.emanueldias.MeuIngresso.model.evento.Evento;
import br.com.emanueldias.MeuIngresso.repository.evento.EventoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    private final EventoRepository eventoRepository;
    private final ModelMapper modelMapper;

    public EventoService(EventoRepository eventoRepository, ModelMapper modelMapper) {
        this.eventoRepository = eventoRepository;
        this.modelMapper = modelMapper;
    }

    public List<Evento> getAllEventos(){
        return this.eventoRepository.getAll().stream().toList();
    }

    public Evento getEventoById(Long id){
        return this.eventoRepository.findById(id);
    }

    public Evento createEvento(EventoRequestDTO dto){
        Evento evento = modelMapper.map(dto, Evento.class);
        return this.eventoRepository.save(evento);
    }

    public Evento updateEvento(Long id, EventoUpdateDTO dto){
        Evento uptated = modelMapper.map(dto, Evento.class);
        Evento evento = eventoRepository.update(id, uptated);
        return evento;
    }

    public void deleteEventoById(Long id){
        this.eventoRepository.deleteById(id);
    }
}
