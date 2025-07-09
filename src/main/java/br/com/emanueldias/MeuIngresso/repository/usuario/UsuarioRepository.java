package br.com.emanueldias.MeuIngresso.repository.usuario;

import br.com.emanueldias.MeuIngresso.model.usuario.Usuario;
import br.com.emanueldias.MeuIngresso.repository.IRepository;
import br.com.emanueldias.MeuIngresso.repository.RepositoryDefault;

import java.sql.Connection;
import java.util.Set;

public class UsuarioRepository extends RepositoryDefault implements IRepository<Usuario> {

    public UsuarioRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Set<Usuario> getAll() {
        return Set.of();
    }

    @Override
    public Usuario findById(Long id) {
        return null;
    }

    @Override
    public void save(Usuario entity) {

    }

    @Override
    public Usuario update(Long id, Usuario entityUpdated) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
