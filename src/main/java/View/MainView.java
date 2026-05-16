package View;

import Controller.*;
import Model.*;

public class MainView {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        ClienteController clienteController = new ClienteController();
        FuncionarioController funcionarioController = new FuncionarioController();
        FornecedorController fornecedorController = new FornecedorController();
        VendaController vendaController = new VendaController();

        Endereco endereco = new Endereco("Rua A", "123", "Barbacena", "MG");
        Cliente cliente = new Cliente("João", "12345678900", "32999999999", endereco, "26/03/2026");
        clienteController.cadastrarCliente(cliente);

        Funcionario funcionario = new Funcionario("Maria", "98765432100", "32988888888", "Caixa", 1800.0, "01/03/2026");
        funcionarioController.cadastrarFuncionario(funcionario);

        Fornecedor fornecedor = new Fornecedor("Farinhas Finas", "12345678000199", "Farinha e derivados", "3233334444");
        fornecedorController.cadastrarFornecedor(fornecedor);

        Produto pao = new Produto("P01", "Pão Francês", 1.00, 50, "Padaria");
        Produto leite = new Produto("P02", "Leite", 6.50, 20, "Bebida");
        Produto cafe = new Produto("P03", "Café", 8.50, 15, "Bebida");

        produtoController.cadastrarProduto(pao);
        produtoController.cadastrarProduto(leite);
        produtoController.cadastrarProduto(cafe);

        Pagamento pagamentoDinheiro = new PagamentoDinheiro();
        Venda venda = new Venda("26/03/2026", cliente, funcionario, pagamentoDinheiro);
        venda.adicionarItem(pao, 2);
        venda.adicionarItem(cafe, 1);

        vendaController.registrarVenda(venda);
        venda.exibirVenda();
    }
}