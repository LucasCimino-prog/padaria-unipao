package Controller;

import DAO.FornecedorDAO;
import Model.Fornecedor;

public class FornecedorController {
    private FornecedorDAO fornecedorDAO;

    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
    }

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        try {
            fornecedorDAO.salvar(fornecedor);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}