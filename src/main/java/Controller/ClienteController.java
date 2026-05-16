package Controller;

import DAO.ClienteDAO;
import Model.Cliente;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrarCliente(Cliente cliente) {
        try {
            clienteDAO.salvar(cliente);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}