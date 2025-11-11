package main.java; // Pacote principal do projeto.

// Importações necessárias para manipulação de arquivos e listas.
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

/**
 * Classe Palavra
 * Representa uma palavra dentro do jogo Letreco.
 * Contém métodos de validação e leitura de listas de palavras.
 *
 * @author Luiz Eduardo
 * @version 1.0
 */
public class Palavra {

    private String letras;  // Palavra digitada pelo jogador.
    private int tamanho;    // Número de letras da palavra.

    /**
     * Construtor da classe Palavra.
     * @param letras - palavra digitada.
     * @param tamanho - quantidade de caracteres.
     */
    public Palavra(String letras, int tamanho) {
        this.letras = letras;
        this.tamanho = tamanho;
    }

    /**
     * Exibe todas as palavras do arquivo "lexico.txt".
     * (Método útil para debug ou verificação de dicionário.)
     */
    public void todasPalavras() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get("src/Jogo/resources/lexico.txt"));
            for (String linha : linhas) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    /**
     * Verifica se o tamanho da palavra é igual a 5.
     * @return true se tiver 5 letras, senão false.
     */
    public boolean verificarTamanho() {
        return tamanho == 5;
    }

    /**
     * Verifica se a palavra existe dentro do arquivo "lexico.txt".
     * @return true se a palavra for encontrada, senão false.
     */
    public boolean existePalavra() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get("src/main/resources/lexico.txt"));

            for (String linha : linhas) {
                if (linha.equalsIgnoreCase(letras)) {
                    return true;
                }
            }
            return false;

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Verifica se a palavra está na lista de palavras proibidas (negativas.txt).
     * @return true se for uma palavra obscena, senão false.
     */
    public boolean palavraObscena() {
        try {
            List<String> obscenas = Files.readAllLines(Paths.get("src/main/resources/negativas.txt"));

            for (String linha : obscenas) {
                if (linha.equalsIgnoreCase(letras)) {
                    return true;
                }
            }
            return false;

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return false;
        }
    }

    // Getters
    public String getLetras() {
        return letras;
    }

    public int getTamanho() {
        return tamanho;
    }
}
