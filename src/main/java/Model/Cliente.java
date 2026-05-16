package Model;

public class Cliente extends Pessoa {
    private Endereco endereco;
    private String dataCadastro;

    public Cliente(String nome, String cpf, String telefone, Endereco endereco, String dataCadastro) {
        super(nome, cpf, telefone);
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }
}