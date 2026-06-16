package org.example.dao;

import org.example.model.Personagens;
import org.example.conexao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonagensDAO {

    public void salvarPersonagens(String barbeiro, String cliente) {
        String sql = "INSERT INTO personagens_barbearia (barbeiro, cliente) VALUES (?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, barbeiro);
            stmt.setString(2, cliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPersonagens(int id, String novoBarbeiro, String novoCliente) {
        String sql = "UPDATE personagens_barbearia SET barbeiro = ?, cliente = ? WHERE personagens_id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novoBarbeiro);
            stmt.setString(2, novoCliente);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPersonagens(int id) {
        String sql = "DELETE FROM personagens_barbearia WHERE personagens_id = ?";
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
        String sql = "SELECT * FROM personagens_barbearia";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Personagens p = new Personagens(
                        rs.getInt("personagens_id"),
                        rs.getString("barbeiro"),
                        rs.getString("cliente")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}