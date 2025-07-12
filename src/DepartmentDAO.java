import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    public void inserir(Departamento d) throws SQLException {
        Connection conn = Conexao.conectar();
        String sql = "INSERT INTO departamentos (nome) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, d.getNome());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public List<Departamento> listar() throws SQLException {
        List<Departamento> lista = new ArrayList<>();
        Connection conn = Conexao.conectar();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM departamentos");
        while (rs.next()) {
            Departamento d = new Departamento();
            d.setId(rs.getInt("id"));
            d.setNome(rs.getString("nome"));
            lista.add(d);
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}
