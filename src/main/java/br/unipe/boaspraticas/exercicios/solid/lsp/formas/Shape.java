package br.unipe.boaspraticas.exercicios.solid.lsp.formas;


//Neste exemplo, temos uma classe Shape como classe base, e duas subclasses Rectangle e Square que herdam de Shape.
// Ambas as subclasses possuem um método draw() para desenhar a forma geométrica e um método getArea() para calcular a área.
//
//O problema está no método getArea() da classe Square.
// Embora o método esteja correto para calcular a área de um quadrado, ele viola o Princípio da Substituição de Liskov,
// pois a área de um retângulo é diferente da área de um quadrado. Portanto, se tivermos uma lista de formas geométricas e esperarmos que o método getArea()
// funcione para todas elas, teremos um comportamento inesperado quando chamarmos esse método em um objeto da classe Square
class Shape {
    public void draw() {
        // Desenhar a forma geométrica
    }
}
