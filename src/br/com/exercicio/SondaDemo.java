package br.com.exercicio;

import br.com.exercicio.controle.Piloto;
import br.com.exercicio.localidade.Localizacao;
import br.com.exercicio.localidade.Planalto;
import br.com.exercicio.movimento.FormasMovimentacao;
import br.com.exercicio.rotacionamento.Orientacao;

public class SondaDemo {
    public static void main(String[] args)  {
        final int tamanhoPlanaltoX = 5, tamanhoPlanaltoY = 5;
        Planalto planalto = new Planalto(tamanhoPlanaltoX, tamanhoPlanaltoY);
        Localizacao localizacao = new Localizacao(2, 2, Orientacao.LESTE);
        Sonda umaSonda = new Sonda(planalto, localizacao);

        Piloto piloto = new Piloto(umaSonda, umaSonda.getPlanalto());
        for (int i = 1; i < 5; i++) {
            umaSonda.getLocalizacaoSonda().imprimirLocalizacao();
            piloto.mover(FormasMovimentacao.FRENTE);
            umaSonda.getLocalizacaoSonda().imprimirLocalizacao();
        }
    }
}
