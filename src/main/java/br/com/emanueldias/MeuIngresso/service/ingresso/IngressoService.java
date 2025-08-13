package br.com.emanueldias.MeuIngresso.service.ingresso;

import br.com.emanueldias.MeuIngresso.dto.evento.EventoUpdateDTO;
import br.com.emanueldias.MeuIngresso.dto.ingresso.IngressoRequestDTO;
import br.com.emanueldias.MeuIngresso.dto.ingresso.IngressoUpdateDTO;
import br.com.emanueldias.MeuIngresso.model.ingresso.Ingresso;
import br.com.emanueldias.MeuIngresso.repository.ingresso.IngressoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngressoService {

    private final IngressoRepository ingressoRepository;
    private final ModelMapper modelMapper;

    public IngressoService(IngressoRepository ingressoRepository, ModelMapper modelMapper) {
        this.ingressoRepository = ingressoRepository;
        this.modelMapper = modelMapper;
    }

    public List<Ingresso> getAllIngressosFromEventoId(Long eventoId){
        return this.ingressoRepository.getAllIngressosFromEventoId(eventoId).stream().toList();
    }

    public Ingresso getIngressoById(Long id){
        return ingressoRepository.findById(id);
    }

    public Ingresso createIngresso(IngressoRequestDTO dto){
        Ingresso ingresso = modelMapper.map(dto, Ingresso.class);
        return this.ingressoRepository.save(ingresso);
    }

    public Ingresso updateIngresso(Long id, IngressoUpdateDTO dto){
        Ingresso updated = modelMapper.map(dto, Ingresso.class);
        return this.ingressoRepository.update(id, updated);
    }

    public void deleteIngressoById(Long id){
        this.ingressoRepository.deleteById(id);
    }
}
