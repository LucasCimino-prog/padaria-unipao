package DAO;

import Connection.Conexao;
import Model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FornecedorDAO {
    public void salvar(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (nome_empresa, cnpj, tipo_produto, telefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fornecedor.getNomeEmpresa());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getTipoProduto());
            stmt.setString(4, fornecedor.getTelefone());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}