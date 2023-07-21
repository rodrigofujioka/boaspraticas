package br.unipe.boaspraticas.exercicios.solid.lsp.formas;

class Square extends Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void draw() {
        // Desenhar um quadrado
    }

    public int getArea() {
        return side * side;
    }
}