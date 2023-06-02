package lab02;

import java.sql.*;

public class Main {
    public static void inserirRegistro(Statement statement, String sql) throws SQLException {
        int rows = statement.executeUpdate(sql);

        if (rows > 0) {
            System.out.println("Registro inserido!");
        }
    }
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:h2:mem:test";
        Connection connection = DriverManager.getConnection(jdbcURL);
        System.out.println("Conectado ao Banco de Dados!");

        String sql = "CREATE TABLE carrinho (" +
                " id INTEGER PRIMARY KEY," +
                " nome_produto VARCHAR(255) NOT NULL," +
                " quantidade INTEGER NOT NULL," +
                " preco numeric(7, 2) NOT NULL)";

        Statement statement = connection.createStatement();
        statement.execute(sql);
        System.out.println("Tabela criada!");

        sql = "INSERT INTO carrinho VALUES (1, 'PS 5', 2, 4999.00)";
        Main.inserirRegistro(statement, sql);

        sql = "INSERT INTO carrinho VALUES (2, 'Camisa do PSG', 5, 399.90)";
        Main.inserirRegistro(statement, sql);

        sql = "INSERT INTO carrinho VALUES (3, 'Apple MacBook Pro', 1, 17000.00)";
        Main.inserirRegistro(statement, sql);

        sql = "INSERT INTO carrinho VALUES (4, 'Macallan 12', 10, 25000.00)";
        Main.inserirRegistro(statement, sql);

        sql = "INSERT INTO carrinho VALUES (5, 'RTX 4190', 2, 18000.00)";
        Main.inserirRegistro(statement, sql);

        sql = "SELECT * FROM carrinho";
        ResultSet resultSet = statement.executeQuery(sql);

        int count = 0;

        while (resultSet.next()) {
            count++;

            int id = resultSet.getInt("id");
            String nome_produto = resultSet.getString("nome_produto");
            int quantidade = resultSet.getInt("quantidade");
            double preco = resultSet.getDouble("preco");
            System.out.println("Produto #" + id + ": " + nome_produto +
                    ", " + quantidade + " unidade(s) ao preço de R$ " + preco);
        }
    }
}