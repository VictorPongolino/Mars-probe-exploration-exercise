package br.com.exercicio.localidade;

import br.com.exercicio.rotacionamento.Orientacao;

public class Localizacao {
    private int x;
    private int y;
    private Orientacao orientacao;

    public Localizacao(int x, int y) {
    	atualizar(x, y);
	}

	public Localizacao(int x, int y, Orientacao orientacao) {
        atualizar(x, y, orientacao);
    }

	
	public boolean hasOrientacao() {
		return this.orientacao != null;
	}
	
    @Override
    public String toString() {
    	String orientacaoObjeto = "";
    	if (hasOrientacao()) {
	        String nomeOrientacaoSentido = orientacao.toString();
	        int anguloSentido = orientacao.getAngulos();
	        
	        orientacaoObjeto = String.format("(%s - %d)", nomeOrientacaoSentido, anguloSentido);
    	}
    	
    	return String.format("X=%d, Y=%d %s", this.x, this.y, orientacaoObjeto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Localizacao that = (Localizacao) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        return y;
    }

    public void imprimirLocalizacao() {
        System.out.println(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientacao getOrientacao() {
        return orientacao;
    }

    public void atualizar (int x, int y) {

        this.x = x;
        this.y = y;
    }

    public void atualizar (Orientacao orientacao) {
        this.orientacao = orientacao;
    }

    public void atualizar (int x, int y, Orientacao orientacao) {
        this.atualizar(x, y);
        this.atualizar(orientacao);
    }


}
