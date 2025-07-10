package br.com.emanueldias.MeuIngresso.repository.usuario;

import br.com.emanueldias.MeuIngresso.model.usuario.Usuario;
import br.com.emanueldias.MeuIngresso.repository.IRepository;
import br.com.emanueldias.MeuIngresso.repository.RepositoryDefault;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UsuarioRepository extends RepositoryDefault implements IRepository<Usuario> {

    public UsuarioRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Set<Usuario> getAll() {
        String sql = "SELECT * from usuarios";
        Set<Usuario> usuarioSet = new HashSet<>();

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Long id = rs.getLong(1);
                String username = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);

                Usuario usuario = new Usuario(id, username, email, password);
                usuarioSet.add(usuario);
            }

            ps.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            try{
                if(this.conn != null && !this.conn.isClosed()){
                    this.conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }

        return usuarioSet;
    }

    @Override
    public Usuario findById(Long id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Long idUser = rs.getLong(1);
                String username = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);

                return new Usuario(
                        idUser,
                        username,
                        email,
                        password
                );
            }

            ps.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            try{
                if(this.conn != null && !this.conn.isClosed()){
                    this.conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }

        return null;
    }

    @Override
    public void save(Usuario entity) {
        String sql = "INSERT INTO usuarios(username, email, password) VALUES (?,?,?)";

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());

            ps.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            try{
                if(this.conn != null && !this.conn.isClosed()){
                    this.conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public Usuario update(Long id, Usuario entityUpdated) {
        String sql = "UPDATE usuarios SET username = ?, email = ?, password = ? WHERE id = ?";

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, entityUpdated.getUsername());
            ps.setString(2, entityUpdated.getEmail());
            ps.setString(3, entityUpdated.getPassword());
            ps.setLong(4, entityUpdated.getId());

            ps.execute();
            ps.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            try{
                if(this.conn != null && !this.conn.isClosed()){
                    this.conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }

        return this.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setLong(1, id);

            ps.execute();
            ps.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            try{
                if(this.conn != null && !this.conn.isClosed()){
                    this.conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
