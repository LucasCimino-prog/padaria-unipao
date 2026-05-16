import Model.*;

public class Main {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Rua A", "123", "Barbacena", "MG");
        Endereco endereco2 = new Endereco("Rua B", "456", "Barbacena", "MG");

        Cliente cliente1 = new Cliente("João", "12345678900", "32999999999", endereco1, "26/03/2026");
        Cliente cliente2 = new Cliente("Ana", "11122233344", "32977777777", endereco2, "26/03/2026");

        Funcionario funcionario = new Funcionario("Maria", "98765432100", "32988888888", "Caixa", 1800.0, "01/03/2026");

        Fornecedor fornecedor = new Fornecedor("Farinhas Finas", "12345678000199", "Farinha e derivados", "3233334444");

        Produto pao = new Produto("P01", "Pão Francês", 1.00, 50, "Padaria");
        Produto leite = new Produto("P02", "Leite", 6.50, 20, "Bebida");
        Produto cafe = new Produto("P03", "Café", 8.50, 15, "Bebida");

        Pagamento pagamentoDinheiro = new PagamentoDinheiro();
        Pagamento pagamentoCartao = new PagamentoCartaoCredito();

        System.out.println("=== CADASTROS REALIZADOS ===");
        System.out.println("Cliente 1: " + cliente1.getNome());
        System.out.println("Cliente 2: " + cliente2.getNome());
        System.out.println("Funcionário: " + funcionario.getNome());
        System.out.println("Fornecedor: " + fornecedor.getNomeEmpresa());
        System.out.println("Produto 1: " + pao.getNome());
        System.out.println("Produto 2: " + leite.getNome());
        System.out.println("Produto 3: " + cafe.getNome());

        System.out.println("\n=== ESTOQUE ANTES ===");
        System.out.println("Pão: " + pao.getQuantidadeEstoque());
        System.out.println("Leite: " + leite.getQuantidadeEstoque());
        System.out.println("Café: " + cafe.getQuantidadeEstoque());

        Venda venda = new Venda("26/03/2026", cliente1, funcionario, pagamentoDinheiro);
        venda.adicionarItem(pao, 2);
        venda.adicionarItem(cafe, 1);

        System.out.println("\n=== ESTOQUE DEPOIS ===");
        System.out.println("Pão: " + pao.getQuantidadeEstoque());
        System.out.println("Leite: " + leite.getQuantidadeEstoque());
        System.out.println("Café: " + cafe.getQuantidadeEstoque());

        System.out.println();
        venda.exibirVenda();

        System.out.println("\n=== TESTE DE OUTRA FORMA DE PAGAMENTO DISPONÍVEL ===");
        System.out.println("Forma cadastrada no sistema: " + pagamentoCartao.getTipoPagamento());
    }
}