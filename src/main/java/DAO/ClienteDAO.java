package DAO;

import Connection.Conexao;
import Model.Cliente;
import Model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAO {
    public void salvar(Cliente cliente) {
        String sqlEndereco = "INSERT INTO endereco (rua, numero, cidade, estado) VALUES (?, ?, ?, ?)";
        String sqlCliente = "INSERT INTO cliente (nome, cpf, telefone, data_cadastro, id_endereco) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtEnd = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS)) {
                Endereco end = cliente.getEndereco();
                stmtEnd.setString(1, end.getRua());
                stmtEnd.setString(2, end.getNumero());
                stmtEnd.setString(3, end.getCidade());
                stmtEnd.setString(4, end.getEstado());
                stmtEnd.executeUpdate();

                ResultSet rs = stmtEnd.getGeneratedKeys();
                int idEndereco = -1;
                if (rs.next()) {
                    idEndereco = rs.getInt(1);
                }

                try (PreparedStatement stmtCli = conn.prepareStatement(sqlCliente)) {
                    stmtCli.setString(1, cliente.getNome());
                    stmtCli.setString(2, cliente.getCpf());
                    stmtCli.setString(3, cliente.getTelefone());
                    stmtCli.setString(4, cliente.getDataCadastro());
                    stmtCli.setInt(5, idEndereco);
                    stmtCli.executeUpdate();
                }
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}