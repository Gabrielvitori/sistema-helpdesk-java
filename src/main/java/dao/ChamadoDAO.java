package dao;

import connection.ConnectionFactory;
import model.Chamado;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ChamadoDAO {

    public void salvar(Chamado chamado) {
        String sql = "INSERT INTO chamados (nome_pc, problema, descricao) VALUES (?, ?, ?)";

        try {
            Connection conn = new ConnectionFactory().getConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, chamado.getNomePc());
            stmt.setString(2, chamado.getProblema());
            stmt.setString(3, chamado.getDescricao());

            stmt.execute();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar chamado: " + e.getMessage());
        }
    }
}