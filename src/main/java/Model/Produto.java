package Model;

import java.util.HashSet;
import java.util.Set;

public class Produto {
    private static final Set<String> codigosCadastrados = new HashSet<>();

    private String codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    private String categoria;

    public Produto(String codigo, String nome, double preco, int quantidadeEstoque, String categoria) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código do produto não pode ser vazio.");
        }

        if (codigosCadastrados.contains(codigo)) {
            throw new IllegalArgumentException("Código do produto já cadastrado.");
        }

        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }

        if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo.");
        }

        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;

        codigosCadastrados.add(codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        if (quantidadeEstoque < 0) {
            throw new IllegalArgumentException("Estoque não pode ser negativo.");
        }
        this.quantidadeEstoque = quantidadeEstoque;
    }
}