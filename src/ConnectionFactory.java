import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/rh";
    private static final String USUARIO = "root";
    private static final String SENHA = "password";

public static Connection conectar() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");  // Força carregar o driver
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return DriverManager.getConnection(URL, USUARIO, SENHA);
}

}
