package br.com.exercicio.localidade;

import br.com.exercicio.Sonda;
import br.com.exercicio.controle.verificacao.MoverSondaChain;
import br.com.exercicio.controle.verificacao.VerificarColisoesPlanalto;
import br.com.exercicio.controle.verificacao.VerificarSondaLimitePlanalto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Planalto {
    private int[][] limites;
    private List<Sonda> sondas = new ArrayList<>();
    private MoverSondaChain moverSondaChain;

    public Planalto(int tamanhoX, int tamanhoY) {
        this.limites = new int[tamanhoX][tamanhoY];
    }

    public List<Sonda> getSondas() {
        return Collections.unmodifiableList(sondas);
    }

    public boolean isPermitidoDestinatario(Localizacao localizacao) {
        if (moverSondaChain == null) {
            VerificarColisoesPlanalto verificarColisoesPlanalto = new VerificarColisoesPlanalto(this);

            VerificarSondaLimitePlanalto verificarSondaLimitePlanalto = new VerificarSondaLimitePlanalto(this);
            verificarSondaLimitePlanalto.setProximoHandler(verificarColisoesPlanalto);

            this.moverSondaChain = verificarSondaLimitePlanalto;
        }

        return moverSondaChain.verificar(localizacao);
    }

    public void adicionarSonda(Sonda umaSonda) {
        if (isPermitidoDestinatario(umaSonda.getLocalizacaoSonda()) == false) {
            int localizacaoX = umaSonda.getLocalizacaoSonda().getX();
            int localizacaoY = umaSonda.getLocalizacaoSonda().getY();

            throw new LocalizacaoIndisponivelException(String.format("Não é possível adicionar nesta localização (%d, %d)", localizacaoX, localizacaoY));
        }

        sondas.add(umaSonda);
    }

    public boolean isDentroLimites(int posicaoX, int posicaoY) {
        int limitePlanaltoEixoX = this.limites.length;
        int limitePlanoEixoY = this.limites[0].length;

        boolean isDentroEixoX = (posicaoX >= 0 && posicaoX < limitePlanaltoEixoX);
        boolean isDentroEixoY = (posicaoY >= 0 && posicaoY < limitePlanoEixoY);

        return isDentroEixoX && isDentroEixoY;
    }
}

