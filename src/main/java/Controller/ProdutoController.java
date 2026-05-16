package Controller;

import DAO.ProdutoDAO;
import Model.Produto;
import java.util.List;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void cadastrarProduto(Produto produto) {
        try {
            produtoDAO.salvar(produto);
        } catch (Exception e) {
            System.err.println("Erro ao salvar produto no banco: " + e.getMessage());
        }
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoDAO.listarTodos();
    }
}