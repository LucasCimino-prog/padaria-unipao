package DAO;

import Connection.Conexao;
import Model.Venda;
import Model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VendaDAO {
    public void salvar(Venda venda) {
        String sqlVenda = "INSERT INTO venda (data_venda, id_cliente, id_funcionario, tipo_pagamento, valor_total) VALUES (?, (SELECT id_cliente FROM cliente WHERE cpf = ?), (SELECT id_funcionario FROM funcionario WHERE cpf = ?), ?, ?)";
        String sqlItem = "INSERT INTO item_venda (id_venda, id_produto, quantidade, subtotal) VALUES (?, (SELECT id_produto FROM produto WHERE codigo = ?), ?, ?)";

        try (Connection conn = Conexao.conectar()) {
            conn.setAutoCommit(false);

            try (PreparedStatement stmtVenda = conn.prepareStatement(sqlVenda, Statement.RETURN_GENERATED_KEYS)) {
                stmtVenda.setString(1, venda.getDataVenda());
                stmtVenda.setString(2, venda.getCliente().getCpf());
                stmtVenda.setString(3, venda.getFuncionario().getCpf());
                stmtVenda.setString(4, venda.getPagamento().getTipoPagamento());
                stmtVenda.setDouble(5, venda.getValorTotal());
                stmtVenda.executeUpdate();

                ResultSet rs = stmtVenda.getGeneratedKeys();
                int idVenda = -1;
                if (rs.next()) {
                    idVenda = rs.getInt(1);
                }

                try (PreparedStatement stmtItem = conn.prepareStatement(sqlItem)) {
                    for (ItemVenda item : venda.getItens()) {
                        stmtItem.setInt(1, idVenda);
                        stmtItem.setString(2, item.getProduto().getCodigo());
                        stmtItem.setInt(3, item.getQuantidade());
                        stmtItem.setDouble(4, item.getSubtotal());
                        stmtItem.executeUpdate();
                    }
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