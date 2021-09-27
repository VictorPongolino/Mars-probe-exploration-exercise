package br.com.exercicio.rotacionamento;

public enum Orientacao {
    NORTE(0), OESTE (270), SUL (180), LESTE (90);

    private final int angulos;
    Orientacao (int sentido) {
        this.angulos = sentido;
    }

    public int getAngulos () {
        return this.angulos;
    }

    public boolean isHorizontal() {
        return this.angulos == 270 || this.angulos == 90;
    }

    public boolean isVertical () {
        return this.angulos == 0 || this.angulos == 180;
    }
}
