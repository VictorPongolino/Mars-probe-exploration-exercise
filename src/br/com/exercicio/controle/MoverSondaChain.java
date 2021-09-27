package br.com.exercicio.controle;

import br.com.exercicio.localidade.Localizacao;
import br.com.exercicio.localidade.Planalto;

public abstract class MoverSondaChain {
    protected MoverSondaChain proximoHandler;
    protected Planalto planalto;

    public MoverSondaChain (Planalto planalto) {
        this.planalto = planalto;
    }

    public void setPlanalto(Planalto planalto) {
        this.planalto = planalto;
    }

    public boolean isProximoHandlerValido () {
        return this.proximoHandler != null;
    }

    public void setProximoHandler(MoverSondaChain moverSondaChain) {
        this.proximoHandler = moverSondaChain;
    }

    protected boolean verificarProximo(Localizacao localizacao) {
        if (isProximoHandlerValido()) {
            return this.proximoHandler.verificar(localizacao);
        }

        return true;
    }

    public abstract boolean verificar(Localizacao localizacao);

}
