package Controller;

import DAO.FuncionarioDAO;
import Model.Funcionario;

public class FuncionarioController {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        try {
            funcionarioDAO.salvar(funcionario);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}