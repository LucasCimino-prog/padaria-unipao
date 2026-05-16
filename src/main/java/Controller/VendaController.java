package Controller;

import DAO.VendaDAO;
import DAO.ProdutoDAO;
import Model.ItemVenda;
import Model.Venda;

public class VendaController {
    private VendaDAO vendaDAO;
    private ProdutoDAO produtoDAO; // Adicionamos o DAO do produto aqui

    public VendaController() {
        this.vendaDAO = new VendaDAO();
        this.produtoDAO = new ProdutoDAO(); // Inicializa o DAO
    }

    public void registrarVenda(Venda venda) {
        try {
            vendaDAO.salvar(venda);

            for (ItemVenda item : venda.getItens()) {
                produtoDAO.baixarEstoque(item.getProduto().getCodigo(), item.getQuantidade());
            }

            System.out.println("Venda registrada e estoque atualizado com sucesso no banco de dados!");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}