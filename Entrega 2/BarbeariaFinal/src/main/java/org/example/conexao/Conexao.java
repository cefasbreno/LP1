package org.example.conexao; // Ajustado para estar no mesmo pacote que a sua pasta de arquivos

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/barbearia";
    private static final String USER = "postgres";
    private static final String PASSWORD = "139499";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao PostgreSQL", e);
        }
    }
}