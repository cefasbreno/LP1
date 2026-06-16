package org.example.dao;

import org.example.model.Cena;
import org.example.conexao.Conexao;
import java.sql.*;

public class CenaDAO {

    public Cena buscarCena(int codigo, String cenario) {
        // Query específica para a tabela 'barbearia' usando a coluna 'codigo'
        String sql = "SELECT * FROM barbearia WHERE id = ? AND cenario = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.setString(2, cenario);

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
            e.printStackTrace();
        }
        return null;
    }
}