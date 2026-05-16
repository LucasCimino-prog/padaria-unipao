package Model;

public class PagamentoCartaoCredito implements Pagamento {
    @Override
    public String getTipoPagamento() {
        return "Cartão de Crédito";
    }
}