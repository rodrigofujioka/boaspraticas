package br.unipe.boaspraticas.exercicios.solid.sip.animais;



//Neste exemplo, a interface Animal contém todos os métodos relacionados a comportamentos comuns de todos os animais,
// incluindo os métodos voar() e nadar(). No entanto, ao implementar essa interface nas classes Ave e Peixe,
// somos obrigados a implementar métodos que não fazem sentido para cada uma dessas classes. Por exemplo, a classe
// Ave precisa implementar o método nadar(), mesmo que as aves não nadem. O mesmo acontece com a classe Peixe,
// que precisa implementar o método voar(), mesmo que os peixes não voem.
//
//Essa violação do ISP torna o código menos coeso e mais difícil de manter, pois as classes estão
// forçadas a implementar métodos que não são relevantes para elas
interface Animal {
    void comer();
    void dormir();
    void voar();
    void nadar();
}