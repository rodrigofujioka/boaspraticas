package br.unipe.boaspraticas.exercicios.solid.sip.animais;

class Ave implements Animal {
    @Override
    public void comer() {
        System.out.println("A ave está comendo.");
    }

    @Override
    public void dormir() {
        System.out.println("A ave está dormindo.");
    }

    @Override
    public void voar() {
        System.out.println("A ave está voando.");
    }

    @Override
    public void nadar() {
        // Não faz sentido uma ave nadar, mas precisamos implementar o método.
        System.out.println("A ave está nadando.");
    }
}
