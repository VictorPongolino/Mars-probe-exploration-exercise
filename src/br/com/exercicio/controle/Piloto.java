package br.com.exercicio.controle;

import br.com.exercicio.controle.verificacao.MoverSondaChain;
import br.com.exercicio.controle.verificacao.VerificarColisoesPlanalto;
import br.com.exercicio.controle.verificacao.VerificarSondaLimitePlanalto;
import br.com.exercicio.localidade.Planalto;
import br.com.exercicio.Sonda;
import br.com.exercicio.movimento.FormasMovimentacao;
import br.com.exercicio.movimento.Movimentacao;

public class Piloto implements Movimentacao {
    private Sonda sonda;
    private Planalto planalto;
    private MoverSondaChain moverSondaChain;

    public Piloto (Sonda sonda, Planalto planalto) {
        this.sonda = sonda;
        this.planalto = planalto;
    }

    private void criarOperacoesVerificacao () {
        if (this.moverSondaChain == null) {
            VerificarColisoesPlanalto verificarColisoesPlanalto = new VerificarColisoesPlanalto(this.planalto);

            VerificarSondaLimitePlanalto verificarSondaLimitePlanalto = new VerificarSondaLimitePlanalto(this.planalto);
            verificarSondaLimitePlanalto.setProximoHandler(verificarColisoesPlanalto);

            this.moverSondaChain = verificarSondaLimitePlanalto;
        }
    }

    @Override
    public void mover(FormasMovimentacao formasMovimentacao) {
        criarOperacoesVerificacao();

        if (moverSondaChain.verificar(sonda.movimentarSonda(FormasMovimentacao.FRENTE))) {
            sonda.mover(FormasMovimentacao.FRENTE);
        }
    }
}
