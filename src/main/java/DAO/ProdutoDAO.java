package DAO;

import Connection.Conexao;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (codigo, nome, preco, quantidade_estoque, categoria) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setString(5, produto.getCategoria());

            stmt.executeUpdate();
            System.out.println("Produto '" + produto.getNome() + "' salvo no banco de dados com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar produto no banco: " + e.getMessage());
        }
    }

    public void baixarEstoque(String codigoProduto, int quantidadeVendida) {
        String sql = "UPDATE produto SET quantidade_estoque = quantidade_estoque - ? WHERE codigo = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantidadeVendida);
            stmt.setString(2, codigoProduto);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o estoque no banco: " + e.getMessage());
        }
    }

    public List<Produto> listarTodos() {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                        rs.getString("codigo"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade_estoque"),
                        rs.getString("categoria")
                );
                produtos.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos: " + e.getMessage());
        } catch (IllegalArgumentException e) {
        }
        return produtos;
    }
}