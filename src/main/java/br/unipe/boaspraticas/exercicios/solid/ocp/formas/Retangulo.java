package br.unipe.boaspraticas.exercicios.solid.ocp.formas;

import br.unipe.boaspraticas.exercicios.solid.model.FormaGeometrica;

public class Retangulo extends FormaGeometrica {
    private double altura;
    private double largura;

    // Construtor, getters e setters omitidos

    public double calcularArea() {
        return altura * largura;
    }
}
