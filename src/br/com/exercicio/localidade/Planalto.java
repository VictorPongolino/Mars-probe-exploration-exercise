package br.com.exercicio.localidade;

import br.com.exercicio.Sonda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Planalto {
    private int[][] limites;
    private List<Sonda> sondas = new ArrayList<>();

    public Planalto(int tamanhoX, int tamanhoY) {
        this.limites = new int[tamanhoX][tamanhoY];
    }

    public List<Sonda> getSondas() {
        return Collections.unmodifiableList(sondas);
    }

    public boolean isDentroLimites(int posicaoX, int posicaoY) {
        int limitePlanaltoEixoX = this.limites.length;
        int limitePlanoEixoY = this.limites[0].length;

        boolean isDentroEixoX = (posicaoX >= 0 && posicaoX < limitePlanaltoEixoX);
        boolean isDentroEixoY = (posicaoY >= 0 && posicaoY < limitePlanoEixoY);

        return isDentroEixoX && isDentroEixoY;
    }
}

