package br.com.exercicio.controle;

import br.com.exercicio.localidade.Localizacao;
import br.com.exercicio.rotacionamento.Orientacao;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SondaComposite implements SondasPlanalto {
    private Set<Localizacao> sondas;
    public SondaComposite (Set<Localizacao> sondas) {
        this.sondas = sondas;
    }

    @Override
    public void imprimirLocalizacaoSonda() {
        sondas.forEach(Localizacao::imprimirLocalizacao);
    }

    @Override
    public boolean isAnySondaLocalizacao(int x, int y) {
        return sondas.contains(new Localizacao(x, y, null));
    }
}
