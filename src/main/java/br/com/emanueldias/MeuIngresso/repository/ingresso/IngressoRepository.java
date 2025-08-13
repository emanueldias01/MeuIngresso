package br.com.emanueldias.MeuIngresso.repository.ingresso;

import br.com.emanueldias.MeuIngresso.model.ingresso.Ingresso;
import br.com.emanueldias.MeuIngresso.repository.IRepository;
import br.com.emanueldias.MeuIngresso.repository.RepositoryDefault;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class IngressoRepository extends RepositoryDefault implements IRepository<Ingresso> {

    public IngressoRepository(DataSource dataSource) throws SQLException {
        super(dataSource);
    }

    @Override
    public Set<Ingresso> getAll() {

        Connection conn = null;
        Set<Ingresso> ingressos = new HashSet<>();
        String sql = "SELECT * FROM ingressos";
        try{
            conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Long id = rs.getLong(1);
                String nome = rs.getString(2);
                Boolean disponivel = rs.getBoolean(3);
                BigDecimal valor = rs.getBigDecimal(4);
                Long eventoId = rs.getLong(5);

                Ingresso ingresso = new Ingresso(id, nome, disponivel, valor, eventoId);
                ingressos.add(ingresso);
            }

            ps.close();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }

        return ingressos;
    }

    @Override
    public Ingresso findById(Long id) {
        Connection conn = null;
        String sql = "SELECT * FROM ingressos WHERE id = ?";

        try{
            conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return new Ingresso(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getBoolean(3),
                        rs.getBigDecimal(4),
                        rs.getLong(5)
                );
            }

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }

        return null;
    }

    @Override
    public Ingresso save(Ingresso entity) {
        Connection conn = null;
        String sql = "INSERT INTO ingressos(nome_ingresso, disponivel, valor, evento_id) VALUES(?, ?, ?, ?)";

        try{
            conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getNomeIngresso());
            ps.setBoolean(2, entity.getDisponivel());
            ps.setBigDecimal(3, entity.getValor());
            ps.setLong(4, entity.getEventoId());

            ps.execute();
            ps.close();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    long id = rs.getLong(1);
                    return this.findById(id);
                } else {
                    throw new SQLException();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public Ingresso update(Long id, Ingresso entityUpdated) {
        Connection conn = null;
        String sql = "UPDATE ingressos SET nome_ingresso = ?, disponivel = ?, valor = ? WHERE id = ? ";

        try{
            conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entityUpdated.getNomeIngresso());
            ps.setBoolean(2, entityUpdated.getDisponivel());
            ps.setBigDecimal(3, entityUpdated.getValor());
            ps.setLong(4, entityUpdated.getId());

            ps.execute();
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }

        return this.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        Connection conn = null;
        String sql = "DELETE FROM ingressos WHERE id = ?";

        try{
            conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);

            ps.execute();
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }

    public List<Ingresso> getAllIngressosFromEventoId(Long id){
        Connection conn = null;
        String sql = "SELECT * FROM ingressos WHERE evento_id = ?";

        try{
            conn = this.dataSource.getConnection();
            Set<Ingresso> ingressos = new HashSet<>();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Long ingressoId = rs.getLong(1);
                String nome = rs.getString(2);
                Boolean disponivel = rs.getBoolean(3);
                BigDecimal valor = rs.getBigDecimal(4);
                Long eventoId = rs.getLong(5);

                Ingresso ingresso = new Ingresso(ingressoId, nome, disponivel, valor, eventoId);
                ingressos.add(ingresso);
            }

            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            try{
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}
