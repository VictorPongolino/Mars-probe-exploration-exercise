package br.com.exercicio;

import br.com.exercicio.controle.SondaComposite;
import br.com.exercicio.movimento.FormasMovimentacao;
import br.com.exercicio.rotacionamento.FormasRotacionar;
import br.com.exercicio.rotacionamento.Orientacao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

interface Command {
    void executar(Sonda sonda);
}

public class DemoCommand {
    private Map<String, Command> operacoes = new HashMap<>();

    public DemoCommand() {
        operacoes = Map.of("mover", (sonda) -> {
            sonda.getLocalizacaoSonda().imprimirLocalizacao();
            sonda.mover(FormasMovimentacao.FRENTE);
            sonda.getLocalizacaoSonda().imprimirLocalizacao();
        }, "esquerda", (sonda) -> {
            sonda.getLocalizacaoSonda().imprimirLocalizacao();
            sonda.rotacionar(FormasRotacionar.ESQUERDA);
            sonda.getLocalizacaoSonda().imprimirLocalizacao();
        }, "direita", (sonda) -> {
            sonda.getLocalizacaoSonda().imprimirLocalizacao();
            sonda.rotacionar(FormasRotacionar.DIREITA);
            sonda.getLocalizacaoSonda().imprimirLocalizacao();
        }, "ajuda", (sonda) -> {
            imprimirOperacoes();
        });
    }

    public void imprimirOperacoes() {
        System.out.println("Informe uma destas operações para pilotar a sonda especificada: ");
        System.out.println(operacoes.keySet()
                .stream()
                .map(x -> "'" + x.trim().toLowerCase() + "'")
                .collect(Collectors.joining(", "))
        );
    }

    public boolean executarOperacao(String comando, Sonda sonda) {
        Command handler = this.operacoes.get(comando);
        if (handler != null) {
            handler.executar(sonda);
            return true;
        }

        return false;
    }

}
