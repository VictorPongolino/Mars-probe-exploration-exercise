package br.com.exercicio.localidade;

import br.com.exercicio.rotacionamento.Orientacao;

public class Localizacao {
    private int x;
    private int y;
    private Orientacao orientacao;

    public Localizacao(int x, int y, Orientacao orientacao) {
        atualizar(x, y, orientacao);
    }

    @Override
    public String toString() {
        String nomeOrientacaoSentido = orientacao.toString();
        int anguloSentido = orientacao.getAngulos();
        return String.format("X=%d, Y=%d (%s - %d°)", this.x, this.y, nomeOrientacaoSentido, anguloSentido);
    }

    public void imprimirLocalizacao() {
        System.out.println(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientacao getOrientacao() {
        return orientacao;
    }

    public void atualizar (int x, int y) {

        this.x = x;
        this.y = y;
    }

    public void atualizar (Orientacao orientacao) {
        this.orientacao = orientacao;
    }

    public void atualizar (int x, int y, Orientacao orientacao) {
        this.atualizar(x, y);
        this.atualizar(orientacao);
    }


}
