package br.com.exercicio.localidade;

public class LocalizacaoIndisponivelException extends RuntimeException{
    public LocalizacaoIndisponivelException(String message) {
        super(message);
    }
}
