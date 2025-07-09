package br.com.emanueldias.MeuIngresso.repository.ingresso;

import br.com.emanueldias.MeuIngresso.model.ingresso.Ingresso;
import br.com.emanueldias.MeuIngresso.repository.IRepository;
import br.com.emanueldias.MeuIngresso.repository.RepositoryDefault;

import java.sql.Connection;
import java.util.Set;

public class IngressoRepository extends RepositoryDefault implements IRepository<Ingresso> {


    public IngressoRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Set<Ingresso> getAll() {
        return Set.of();
    }

    @Override
    public Ingresso findById(Long id) {
        return null;
    }

    @Override
    public void save(Ingresso entity) {

    }

    @Override
    public Ingresso update(Long id, Ingresso entityUpdated) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
