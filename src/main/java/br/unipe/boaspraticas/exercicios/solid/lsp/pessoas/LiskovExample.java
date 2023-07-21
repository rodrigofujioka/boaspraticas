package br.unipe.boaspraticas.exercicios.solid.lsp.pessoas;

public class LiskovExample {
    public static void main(String[] args) {
        // Usando polimorfismo com a referência da classe base (Pessoa)
        Pessoa pessoa = new Funcionario("João", 3000);
        pessoa.fazerSom(); // Oi!

        // Violando o princípio da substituição de Liskov
        // Usando a referência da classe derivada (Funcionario)
        Funcionario funcionario = new Funcionario("Maria", 4000);
        funcionario.fazerSom(); // Bom dia!

        // O comportamento não é consistente entre as duas referências, o que pode causar problemas.
    }
}
