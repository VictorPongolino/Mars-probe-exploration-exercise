package br.com.exercicio.controle.verificacao;

import br.com.exercicio.localidade.Localizacao;
import br.com.exercicio.localidade.Planalto;

public class VerificarSondaLimitePlanalto extends MoverSondaChain{

    public VerificarSondaLimitePlanalto(Planalto planalto) {
        super(planalto);
    }


    @Override
    public boolean verificar(Localizacao localizacao) {
        int posicaoX = localizacao.getX();
        int posicaoY = localizacao.getY();

        if (this.planalto.isDentroLimites(posicaoX, posicaoY)) {
            return verificarProximo(localizacao);
        }

        return true;
    }
}
