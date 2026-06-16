package org.example.dao;

import org.example.model.Personagem;
import org.example.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

    public void salvarPersonagens(String farmaceutico, String aprendiz, String cliente) {
        String sql = "INSERT INTO presonagens_farmacia (farmaceutico, aprendiz, cliente) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, farmaceutico);
            stmt.setString(2, aprendiz);
            stmt.setString(3, cliente);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPersonagem(int id, String novoFarmaceutico, String novoAprendiz, String novoCliente) {
        String sql = "UPDATE presonagens_farmacia SET farmaceutico = ?, aprendiz = ?, cliente = ? WHERE personagens_id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoFarmaceutico);
            stmt.setString(2, novoAprendiz);
            stmt.setString(3, novoCliente);
            stmt.setInt(4, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarPersonagem(int id) {
        String sql = "DELETE FROM presonagens_farmacia WHERE personagens_id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Personagem> listarTodos() {
        List<Personagem> lista = new ArrayList<>();
        String sql = "SELECT * FROM presonagens_farmacia";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Personagem p = new Personagem(
                        rs.getInt("personagens_id"),
                        rs.getString("farmaceutico"),
                        rs.getString("aprendiz"),
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