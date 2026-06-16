package org.example.dao;

import org.example.model.Personagens;
import org.example.conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagensDAO {

    public void salvarPersonagens(String dona, String ajudante1, String ajudante2) {
        String sql = "INSERT INTO personagens_barraca (dona, ajudante1, ajudante2) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, dona);
            stmt.setString(2, ajudante1);
            stmt.setString(3, ajudante2);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPersonagens(int id, String novaDona, String novoAjudante1, String novoAjudante2) {
        String sql = "UPDATE personagens_barraca SET dona = ?, ajudante1 = ?, ajudante2 = ? WHERE personagens_id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novaDona);
            stmt.setString(2, novoAjudante1);
            stmt.setString(3, novoAjudante2);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPersonagens(int id) {
        String sql = "DELETE FROM personagens_barraca WHERE personagens_id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Personagens> listarTodos() {
        List<Personagens> lista = new ArrayList<>();
        String sql = "SELECT * FROM personagens_barraca";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Personagens p = new Personagens(
                        rs.getInt("personagens_id"),
                        rs.getString("dona"),
                        rs.getString("ajudante1"),
                        rs.getString("ajudante2")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}