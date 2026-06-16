package org.example.dao;

import org.example.model.Cena;
import org.example.conexao.Conexao;
import java.sql.*;

public class CenaDAO {

    public Cena buscarCena(int id, String cenario) {
        // A query continua sendo flexível, pois buscamos pelo ID e pelo Cenario
        String sql = "SELECT * FROM farmacia WHERE id = ? AND cenario = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, cenario); // O cenário mudará conforme a escolha (dia, recusa, moeda, noite)

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cena cena = new Cena();
                    cena.setId(rs.getInt("id"));
                    cena.setImagem(rs.getString("imagem"));
                    cena.setCenario(rs.getString("cenario"));
                    cena.setTexto(rs.getString("texto"));
                    return cena;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar cena no banco: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}