package br.com.emanueldias.MeuIngresso.repository.evento;

import br.com.emanueldias.MeuIngresso.model.evento.Evento;
import br.com.emanueldias.MeuIngresso.repository.IRepository;
import br.com.emanueldias.MeuIngresso.repository.RepositoryDefault;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.util.*;

@Repository
public class EventoRepository extends RepositoryDefault implements IRepository<Evento> {
    public EventoRepository(DataSource dataSource) throws SQLException {
        super(dataSource);
    }

    @Override
    public Set<Evento> getAll() {
        String sql = "SELECT * FROM eventos";
        Set<Evento> eventos = new HashSet<>();

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Array array = rs.getArray(7);
                String[] setores = (String[]) array.getArray(); // cast de acordo com seu tipo
                Set<String> setoresSet = new HashSet<>(Arrays.asList(setores));
                Evento evento = new Evento(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        setoresSet
                );

                eventos.add(evento);
            }

            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (this.conn != null && !this.conn.isClosed()) {
                    this.conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        return eventos;
    }

    @Override
    public Evento findById(Long id) {
        String sql = "SELECT * FROM eventos WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Array array = rs.getArray(7);
                String[] setores = (String[]) array.getArray(); // cast de acordo com seu tipo
                Set<String> setoresSet = new HashSet<>(Arrays.asList(setores));
                return new Evento(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3).toLocalDate(),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        setoresSet
                );

            }

            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (this.conn != null && !this.conn.isClosed()) {
                    this.conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        return null;
    }

    @Override
    public Evento save(Evento entity) {
        String sql = "INSERT INTO eventos(nome_evento, data, local, descricao, imagem, setores) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);

            Array sqlArray = conn.createArrayOf("VARCHAR", entity.getSetores().toArray());
            ps.setString(1, entity.getNome());
            ps.setDate(2, Date.valueOf(entity.getData()));
            ps.setString(3, entity.getLocal());
            ps.setString(4, entity.getDescricao());
            ps.setString(5, entity.getImagem());
            ps.setArray(6, sqlArray);

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
        } finally {
            try {
                if (this.conn != null && !this.conn.isClosed()) {
                    this.conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public Evento update(Long id, Evento entityUpdated) {
        String sql = "UPDATE eventos SET nome_evento = ?, data = ?, local = ?, descricao = ?, imagem = ?, setores = ? WHERE id = ?";

        try {

            PreparedStatement ps = this.conn.prepareStatement(sql);

            Array sqlArray = conn.createArrayOf("VARCHAR", entityUpdated.getSetores().toArray());
            ps.setString(1, entityUpdated.getNome());
            ps.setDate(2, Date.valueOf(entityUpdated.getData()));
            ps.setString(3, entityUpdated.getLocal());
            ps.setString(4, entityUpdated.getDescricao());
            ps.setString(5, entityUpdated.getImagem());
            ps.setArray(6, sqlArray);
            ps.setLong(7, id);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (this.conn != null && !this.conn.isClosed()) {
                    this.conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

        return this.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM eventos WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setLong(1, id);

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (this.conn != null && !this.conn.isClosed()) {
                    this.conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}