package br.com.exercicio;

import br.com.exercicio.localidade.Localizacao;
import br.com.exercicio.movimento.FormasMovimentacao;
import br.com.exercicio.movimento.Movimentacao;
import br.com.exercicio.rotacionamento.FormasRotacionar;
import br.com.exercicio.rotacionamento.Orientacao;
import br.com.exercicio.rotacionamento.Rotacao;

public class Sonda implements Movimentacao, Rotacao {
    private Localizacao localizacaoSonda;

    public Sonda (Localizacao localizacaoSonda) {
        this.localizacaoSonda = localizacaoSonda;
    }

    public Localizacao getLocalizacaoSonda() {
        int posicaoX = localizacaoSonda.getX();
        int posicaoY = localizacaoSonda.getY();
        int index = localizacaoSonda.getOrientacao().ordinal();
        return new Localizacao(posicaoX, posicaoY, Orientacao.values()[index]);
    }

    @Override
    public void mover(FormasMovimentacao formasMovimentacao) {
        int posicaoX = localizacaoSonda.getX();
        int posicaoY = localizacaoSonda.getY();

        switch (localizacaoSonda.getOrientacao()) {
            case NORTE: posicaoY++;
                break;
            case SUL: posicaoY--;
                break;
            case LESTE: posicaoX++;
                break;
            case OESTE: posicaoX--;
                break;
        }

        localizacaoSonda.atualizar(posicaoX, posicaoY);
    }

    @Override
    public void rotacionar(FormasRotacionar formasRotacionar) {
        Orientacao[] todosSentidos = Orientacao.values();
        String nomeSentidoAtual = this.localizacaoSonda.getOrientacao().toString();
        int sentidoAtualIndex = Orientacao.valueOf(nomeSentidoAtual).ordinal();

        if (FormasRotacionar.ESQUERDA == formasRotacionar)
            sentidoAtualIndex--;
        else if (FormasRotacionar.DIREITA == formasRotacionar)
            sentidoAtualIndex++;
        else
            throw new IllegalStateException(String.format("Não foi encontrado um tratamento adequado para esta ação. (%s)", formasRotacionar.toString()));

        if (sentidoAtualIndex < 0)
            sentidoAtualIndex = todosSentidos.length;
        else if (sentidoAtualIndex > todosSentidos.length)
            sentidoAtualIndex = 0;

        this.localizacaoSonda.atualizar(Orientacao.values()[sentidoAtualIndex]);
    }
}
