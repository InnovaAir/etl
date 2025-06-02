package innovaetl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

        private Connection connection;
        public Conexao() {
            try {
                // Carrega o driver JDBC do MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");

                // URL de conexão
                String url = "jdbc:mysql://localhost:3306/innovaair";

                // Nome de usuário e senha
                String user = "innova_admin";
                String password = "InnovaairAdmin@123";

                // Cria a conexão
                connection = DriverManager.getConnection(url, user, password);

                System.out.println("Conectado com sucesso ao banco de dados MySQL!");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC não encontrado: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            }
        }

        public Connection getConnection() {
            return connection;
        }

        public void closeConnection() {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexão com o banco de dados MySQL fechada.");
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
    }
