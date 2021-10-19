package br.com.exercicio;

import br.com.exercicio.localidade.Localizacao;
import br.com.exercicio.localidade.LocalizacaoIndisponivelException;
import br.com.exercicio.localidade.Planalto;
import br.com.exercicio.rotacionamento.Orientacao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SondaDemo {

    private static final int X = 12, Y = 12;

    public static void main(String[] args)  {
        Map<String, Sonda> sondas = definirSondas();
        Scanner scanner = new Scanner(System.in);
        DemoCommand demoCommand = new DemoCommand();
        while (true) {
            System.out.println("\nInforme o ID de uma sonda válida: ");
            Sonda sonda = null;
            while ((sonda = sondas.get(scanner.next())) == null );

            System.out.println("Informe uma operação: ");

            String operacaoSonda = scanner.next();
            demoCommand.executarOperacao(operacaoSonda, sonda);
        }
    }

    public static Map<String, Sonda> definirSondas() {
        Map<String, Sonda> sondas = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int quantidade = 0;
        System.out.println("\nQuantidade de sondas: ");
        try {
            do {
                quantidade = Integer.parseInt(scanner.next());
                if (quantidade <= 0) {
                    System.err.println("Valor inválido, deve especificar um número acima de zero!");
                }
            }
            while (quantidade <= 0);
        }
        catch (Exception e) {
            System.err.println("Informe uma quantidade válida !");
        }

        while (true) {
            try {
                for (int i = 0; i < quantidade; i++) {
                    System.out.println("\nPOS-X: ");
                    int x = Integer.parseInt(scanner.next());
                    System.out.println("POS-Y: ");
                    int y = Integer.parseInt(scanner.next());
                    System.out.println("Orientação: ");
                    Orientacao orientacao = Orientacao.valueOf(scanner.next().toUpperCase());
                    Sonda novaSonda = criarUnicaSonda(x, y, orientacao);
                    sondas.put("" + (i + 1), novaSonda);
                }

                return sondas;
            }
            catch (NumberFormatException nfe) {
                System.err.println("Apenas números são aceitos !");
            } catch (IllegalArgumentException iae) {
                String valoresOrientacaoEsperadosVirgula = Stream.of(Orientacao.values()).map(Orientacao::name).collect(Collectors.joining(", "));
                System.err.println("Falha ao encontrar a orientação, especifique uma orientação válida !");
                System.out.println(valoresOrientacaoEsperadosVirgula);
            } catch (LocalizacaoIndisponivelException lie) {
                System.out.println("Verifique a localização da sonda !");
            }
            catch (Exception e) {
                System.err.println("Não foi possível cadastrar esta sonda!");
            }
        }
    }

    public static Sonda criarUnicaSonda(final int x, final int y, final Orientacao orientacao) {
        Planalto planalto = new Planalto(X, Y);
        System.out.printf("\nPlanalto padrão em (%d, %d) !", X, Y);
        Localizacao localizacao = new Localizacao(x, y, orientacao);
        System.out.printf("\nCriando uma sonda em (%d, %d, %s) !", x, y, orientacao);
        return new Sonda(planalto, localizacao);
    }
}
