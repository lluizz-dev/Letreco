package main.java; // Pacote principal do projeto.

// Importa a classe Scanner, usada para ler dados digitados pelo usuário no terminal.
import java.util.Scanner;

/**
 * Classe principal do jogo Letreco (versão console).
 * Responsável por exibir a interface textual e coordenar as interações com o jogador.
 *
 * @author Luiz Eduardo
 * @version 1.0
 */
public class LetrecoConsole {

    // Códigos ANSI para colorir o terminal
    public static final String RESET = "\u001B[0m";        // Reseta as cores do terminal.
    public static final String BG_VERMELHO = "\u001B[41m"; // Fundo vermelho — usado ao perder o jogo.

    /**
     * Método principal (main) — ponto de entrada do programa.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Scanner para ler as respostas do jogador.
        int opcao; // Variável de controle para repetir o jogo.

        // Laço principal que controla se o jogador quer jogar novamente.
        do {
            Controle controle = new Controle(); // Cria uma nova instância do controle para gerenciar o jogo.
            boolean verificacaoPalavra;         // Variável para verificar se a palavra digitada é válida.

            // Mensagens iniciais do jogo.
            System.out.println("Bem-vindo ao Letreco!");
            System.out.println("Tente acertar a palavra com 5 letras em 6 tentativas!");

            // Loop principal do jogo (6 tentativas)
            do {
                // Loop interno para garantir que o jogador digite uma palavra válida.
                do {
                    System.out.printf("\nDigite a sua %d° tentativa: ", controle.getNumTentativas() + 1);

                    // O método receberPalavra() faz a leitura e validação da palavra.
                    // Retorna true se for válida, ou false se for inválida.
                    if (controle.receberPalavra()) {
                        verificacaoPalavra = true;  // Palavra válida — pode seguir para comparação.
                    } else {
                        verificacaoPalavra = false; // Palavra inválida — repete a tentativa.
                        System.out.println("Tente novamente!");
                    }
                } while (!verificacaoPalavra); // Continua até o jogador digitar uma palavra válida.

                // Faz a comparação entre a tentativa e a palavra secreta.
                controle.comparacao();

                // Se o jogador acertar, o loop é interrompido.
                if (controle.getAcertou()) {
                    break;
                }
                // Caso tenha usado todas as 6 tentativas sem acertar:
                else if (controle.getNumTentativas() == 6) {
                    System.out.println("\n" + BG_VERMELHO + "Perdeu! Tente novamente!" + RESET);
                    System.out.printf("A palavra era %s", controle.getPalavraSecreta());
                }

            } while (controle.getNumTentativas() < 6); // Sai do loop após 6 tentativas ou acerto.

            // Menu para jogar novamente
            System.out.println();
            System.out.println("Quer jogar novamente?");
            System.out.println("0 - Não \n1 - Sim");
            opcao = input.nextInt(); // Lê a opção do usuário.

        } while (opcao == 1); // Repete o jogo se o jogador digitar 1 (Sim).
    }
}
