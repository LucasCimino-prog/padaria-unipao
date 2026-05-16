package Model;

import java.util.HashSet;
import java.util.Set;

public class Fornecedor {
    private static final Set<String> cnpjsCadastrados = new HashSet<>();

    private String nomeEmpresa;
    private String cnpj;
    private String tipoProduto;
    private String telefone;

    public Fornecedor(String nomeEmpresa, String cnpj, String tipoProduto, String telefone) {
        if (cnpj == null || cnpj.isBlank()) {
            throw new IllegalArgumentException("CNPJ não pode ser vazio.");
        }

        if (cnpjsCadastrados.contains(cnpj)) {
            throw new IllegalArgumentException("CNPJ já cadastrado.");
        }

        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.tipoProduto = tipoProduto;
        this.telefone = telefone;

        cnpjsCadastrados.add(cnpj);
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public String getTelefone() {
        return telefone;
    }
}