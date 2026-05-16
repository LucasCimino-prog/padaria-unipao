package Model;

import java.util.ArrayList;

public class Venda {
    private String dataVenda;
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<ItemVenda> itens;
    private double valorTotal;
    private Pagamento pagamento;

    public Venda(String dataVenda, Cliente cliente, Funcionario funcionario, Pagamento pagamento) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário é obrigatório na venda.");
        }

        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pagamento = pagamento;
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }

    public Venda(String dataVenda, Cliente cliente, Funcionario funcionario, Pagamento pagamento, Produto produto, int quantidade) {
        this(dataVenda, cliente, funcionario, pagamento);
        adicionarItem(produto, quantidade);
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        if (produto.getQuantidadeEstoque() < quantidade) {
            System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
            return;
        }

        ItemVenda item = new ItemVenda(produto, quantidade);
        itens.add(item);

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
        valorTotal += item.getSubtotal();
    }

    public void exibirVenda() {
        System.out.println("===== REGISTRO DA VENDA =====");
        System.out.println("Data: " + dataVenda);
        System.out.println("Cliente: " + (cliente != null ? cliente.getNome() : "Sem cliente identificado"));
        System.out.println("Funcionário: " + funcionario.getNome());
        System.out.println("Forma de pagamento: " + pagamento.getTipoPagamento());
        System.out.println("Itens da venda:");

        for (ItemVenda item : itens) {
            System.out.println("- Produto: " + item.getProduto().getNome());
            System.out.println("  Quantidade: " + item.getQuantidade());
            System.out.println("  Subtotal: R$ " + String.format("%.2f", item.getSubtotal()));
        }

        System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}