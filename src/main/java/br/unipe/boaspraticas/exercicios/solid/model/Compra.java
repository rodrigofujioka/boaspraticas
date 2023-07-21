package br.unipe.boaspraticas.exercicios.solid.model;

import lombok.Data;

import java.util.List;

@Data
public class Compra {
    private List<ItemCompra> i;   //Lista de itens
    private double desc; //desconto a ser aplicado

    // getters e setters omitidos
}
