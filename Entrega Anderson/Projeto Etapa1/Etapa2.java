import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoJDBC {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Configurações de conexão com o PostgreSQL
            String url = "jdbc:postgresql://localhost:5432/seu_banco_de_dados";
            String usuario = "Marcus";
            String senha = "12345678";

            // Conectar ao banco de dados
            connection = DriverManager.getConnection(url, usuario, senha);

            // Criar uma instrução SQL
            statement = connection.createStatement();

            // Exemplo de consulta SQL
            String consultaSQL = "SELECT * FROM educação";
            // Execute a consulta e obtenha resultados
            // Você pode personalizar a consulta para suas necessidades específicas

            // Processar os resultados da consulta
            // Aqui você pode fazer operações de leitura e manipulação dos dados

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Feche a conexão e o statement após a conclusão
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
