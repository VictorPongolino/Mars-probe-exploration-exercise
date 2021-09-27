package br.com.exercicio.controle;

import br.com.exercicio.controle.verificacao.VerificarColisoesPlanalto;
import br.com.exercicio.controle.verificacao.VerificarSondaLimitePlanalto;
import br.com.exercicio.localidade.Planalto;
import br.com.exercicio.Sonda;
import br.com.exercicio.movimento.FormasMovimentacao;
import br.com.exercicio.movimento.Movimentacao;

public class Piloto implements Movimentacao {
    private Sonda sonda;
    private Planalto planalto;

    public Piloto (Sonda sonda, Planalto planalto) {
        this.sonda = sonda;
        this.planalto = planalto;
    }

    @Override
    public void mover(FormasMovimentacao formasMovimentacao) {
        VerificarColisoesPlanalto verificarColisoesPlanalto = new VerificarColisoesPlanalto(this.planalto);

        VerificarSondaLimitePlanalto verificarSondaLimitePlanalto = new VerificarSondaLimitePlanalto(this.planalto);
        verificarSondaLimitePlanalto.setProximoHandler(verificarColisoesPlanalto);

        if (verificarSondaLimitePlanalto.verificar(sonda.getLocalizacaoSonda(FormasMovimentacao.FRENTE))) {
            sonda.mover(FormasMovimentacao.FRENTE);
        }
    }
}
