package Model;

public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;
    private String dataContratacao;

    public Funcionario(String nome, String cpf, String telefone, String cargo, double salario, String dataContratacao) {
        super(nome, cpf, telefone);

        if (salario < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo.");
        }

        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }
}