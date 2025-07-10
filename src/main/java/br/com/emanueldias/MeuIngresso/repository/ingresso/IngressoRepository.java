package br.com.emanueldias.MeuIngresso.repository.ingresso;

import br.com.emanueldias.MeuIngresso.model.ingresso.Ingresso;
import br.com.emanueldias.MeuIngresso.repository.IRepository;
import br.com.emanueldias.MeuIngresso.repository.RepositoryDefault;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class IngressoRepository extends RepositoryDefault implements IRepository<Ingresso> {


    public IngressoRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Set<Ingresso> getAll() {

        Set<Ingresso> ingressos = new HashSet<>();
        String sql = "SELECT * FROM ingressos";
        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
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
                if(this.conn != null && !this.conn.isClosed()){
                    this.conn.close();
                }
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
        }

        return ingressos;
    }

    @Override
    public Ingresso findById(Long id) {
        String sql = "SELECT * FROM ingressos WHERE id = ?";

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
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
    public void save(Ingresso entity) {
        String sql = "INSERT INTO ingressos(nome_ingresso, disponivel, valor, evento_id) VALUES(?, ?, ?, ?)";

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, entity.getNomeIngresso());
            ps.setBoolean(2, entity.getDisponivel());
            ps.setBigDecimal(3, entity.getValor());
            ps.setLong(4, entity.getEventoId());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
    public Ingresso update(Long id, Ingresso entityUpdated) {
        String sql = "UPDATE ingressos SET nome_ingresso = ?, disponivel = ?, valor = ? WHERE id = ? ";

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
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
        String sql = "DELETE FROM ingressos WHERE id = ?";

        try{
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setLong(1, id);

            ps.execute();
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
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
