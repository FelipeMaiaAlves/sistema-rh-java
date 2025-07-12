import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FuncionarioDAO {

    public void salvar(Funcionario f) {
        String sql = "INSERT INTO funcionarios (nome, departamento_id, salario) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setInt(2, f.getDepartamento().getId());
            stmt.setDouble(3, f.getSalario());
            stmt.executeUpdate();

            System.out.println("Funcionário salvo com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        Connection conn = Conexao.conectar();

        String sql = "SELECT f.id, f.nome, f.salario, d.id as departamento_id, d.nome as departamento_nome " +
                     "FROM funcionarios f INNER JOIN departamentos d ON f.departamento_id = d.id";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setSalario(rs.getDouble("salario"));

            Departamento d = new Departamento();
            d.setId(rs.getInt("departamento_id"));
            d.setNome(rs.getString("departamento_nome"));

            f.setDepartamento(d);
            lista.add(f);
        }

        rs.close();
        stmt.close();
        conn.close();

        return lista;
    }

    public void exportarFuncionariosCSV(String caminho) throws SQLException, IOException {
        List<Funcionario> funcionarios = listar();
        PrintWriter writer = new PrintWriter(new FileWriter(caminho));

        writer.println("ID,Nome,Salário,Departamento");
        for (Funcionario f : funcionarios) {
            writer.printf("%d,%s,%.2f,%s%n",
                    f.getId(),
                    f.getNome(),
                    f.getSalario(),
                    f.getDepartamento().getNome());
        }

        writer.close();
        System.out.println("Funcionários exportados com sucesso para " + caminho);
    }
}
