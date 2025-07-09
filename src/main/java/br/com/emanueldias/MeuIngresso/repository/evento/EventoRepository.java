package br.com.emanueldias.MeuIngresso.repository.evento;

import br.com.emanueldias.MeuIngresso.model.evento.Evento;
import br.com.emanueldias.MeuIngresso.repository.IRepository;
import br.com.emanueldias.MeuIngresso.repository.RepositoryDefault;

import java.sql.Connection;
import java.util.Set;

public class EventoRepository extends RepositoryDefault implements IRepository<Evento> {
    public EventoRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Set<Evento> getAll() {
        return Set.of();
    }

    @Override
    public Evento findById(Long id) {
        return null;
    }

    @Override
    public void save(Evento entity) {

    }

    @Override
    public Evento update(Long id, Evento entityUpdated) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
