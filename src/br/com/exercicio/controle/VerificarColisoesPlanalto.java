package br.com.exercicio.controle;


import br.com.exercicio.Sonda;
import br.com.exercicio.localidade.Localizacao;
import br.com.exercicio.localidade.Planalto;

import java.util.List;
import java.util.stream.Collectors;

public class VerificarColisoesPlanalto extends MoverSondaChain{
    public VerificarColisoesPlanalto(Planalto planalto) {
        super(planalto);
    }

    @Override
    public boolean verificar(Localizacao localizacao) {
        List<Localizacao> sondasLocalizacao = this.planalto.getSondas().stream()
                .map(Sonda::getLocalizacaoSonda)
                .collect(Collectors.toList());

        SondaComposite sondaComposite = new SondaComposite(sondasLocalizacao);

        int moverX = localizacao.getX();
        int moverY = localizacao.getY();

        boolean temSondaNoLocal = sondaComposite.isAnySondaLocalizacao(moverX, moverY);
        if (temSondaNoLocal) {
            return false;
        }

        return verificarProximo(localizacao);
    }
}
