package Model;

public class PagamentoDinheiro implements Pagamento {
    @Override
    public String getTipoPagamento() {
        return "Dinheiro";
    }
}