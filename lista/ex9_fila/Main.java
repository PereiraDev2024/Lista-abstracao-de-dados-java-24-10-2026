// Kaiky Brener De Souza Pereira

import java.util.Scanner;

class Fila {

    private String[] nomes;
    private int inicio;
    private int fim;
    private int quantidade;

    public Fila(int capacidade) {
        nomes = new String[capacidade];
    }

    public boolean entrar(String nome) {

        if (quantidade == nomes.length) {
            return false;
        }

        nomes[fim] = nome;
        fim = (fim + 1) % nomes.length;
        quantidade++;

        return true;
    }

    public String atender() {

        if (estaVazia()) {
            return null;
        }

        String nome = nomes[inicio];

        nomes[inicio] = null;
        inicio = (inicio + 1) % nomes.length;
        quantidade--;

        return nome;
    }

    public String proximo() {

        if (estaVazia()) {
            return null;
        }

        return nomes[inicio];
    }

    public int tamanho() {
        return quantidade;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }
}

public class Main {

    public static void main(String[] args) {

        Fila fila = new Fila(3);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            String linha = scanner.nextLine().trim();

            if (linha.isEmpty()) {
                continue;
            }

            if (linha.equals("FIM")) {
                break;
            }

            String[] partes = linha.split("\\s+", 2);
            String comando = partes[0];

            if (comando.equals("ENTRA") && partes.length == 2) {

                if (fila.entrar(partes[1])) {
                    System.out.println(partes[1] + " entrou na fila");
                } else {
                    System.out.println("Fila cheia");
                }

            } else if (comando.equals("ATENDE")) {

                String nome = fila.atender();

                System.out.println(nome == null ? "Fila vazia" : "Atendendo: " + nome);

            } else if (comando.equals("PROXIMO")) {

                String nome = fila.proximo();

                System.out.println(nome == null ? "Fila vazia" : "Próximo: " + nome);

            } else if (comando.equals("TAMANHO")) {

                System.out.println("Pessoas na fila: " + fila.tamanho());

            } else {
                System.out.println("Comando inválido");
            }
        }

        scanner.close();
    }
}
