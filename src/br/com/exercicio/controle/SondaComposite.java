package br.com.exercicio.controle;

import br.com.exercicio.localidade.Localizacao;

import java.util.List;

public class SondaComposite implements SondasPlanalto {
    private List<Localizacao> sondas;
    public SondaComposite (List<Localizacao> sondas) {
        this.sondas = sondas;
    }

    @Override
    public void imprimirLocalizacaoSonda() {
        for (Localizacao localizacao : sondas) {
            localizacao.imprimirLocalizacao();
        }
    }

    @Override
    public boolean isAnySondaLocalizacao(int x, int y) {
        for (Localizacao localizacao : sondas) {
            int posicaoX = localizacao.getX();
            int posicaoY = localizacao.getY();

            if (posicaoX == x && posicaoY == y) {
                return true;
            }
        }

        return false;
    }
}
