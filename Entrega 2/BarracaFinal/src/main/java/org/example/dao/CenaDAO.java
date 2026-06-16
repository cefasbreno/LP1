package org.example.dao;

import org.example.model.Cena;
import org.example.conexao.Conexao;
import java.sql.*;

public class CenaDAO {

    public Cena buscarCena(int id, String cenario) {
        // Query ajustada para a tabela 'barraca'
        String sql = "SELECT * FROM barraca WHERE id = ? AND cenario = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, cenario);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cena cena = new Cena();
                    cena.setId(rs.getInt("id"));
                    cena.setImagem(rs.getString("imagem"));
                    cena.setCenario(rs.getString("cenario"));
                    cena.setTexto(rs.getString("texto"));
                    cena.setPersonagens(rs.getInt("personagens"));
                    return cena;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}