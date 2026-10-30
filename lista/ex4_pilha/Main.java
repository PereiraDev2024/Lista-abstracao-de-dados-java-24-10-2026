// Kaiky Brener De Souza Pereira

class Pilha {

    private int[] dados;
    private int topo;

    public Pilha(int capacidade) {
        dados = new int[capacidade];
        topo = 0;
    }

    public boolean empilhar(int x) {

        if (estaCheia()) {
            return false;
        }

        dados[topo++] = x;
        return true;
    }

    public int desempilhar() {

        if (estaVazia()) {
            System.out.println("Aviso: pilha vazia!");
            return -1;
        }

        return dados[--topo];
    }

    public int espiar() {

        if (estaVazia()) {
            System.out.println("Aviso: pilha vazia!");
            return -1;
        }

        return dados[topo - 1];
    }

    public boolean estaVazia() {
        return topo == 0;
    }

    public boolean estaCheia() {
        return topo == dados.length;
    }

    public int tamanho() {
        return topo;
    }
}

class PilhaChar {

    private char[] dados;
    private int topo;

    public PilhaChar(int capacidade) {
        dados = new char[capacidade];
    }

    public boolean empilhar(char c) {

        if (topo == dados.length) {
            return false;
        }

        dados[topo++] = c;
        return true;
    }

    public char desempilhar() {

        if (topo == 0) {
            return '\0';
        }

        return dados[--topo];
    }

    public boolean estaVazia() {
        return topo == 0;
    }
}

public class Main {

    public static boolean balanceada(String expressao) {

        PilhaChar pilha = new PilhaChar(expressao.length() + 1);

        for (int i = 0; i < expressao.length(); i++) {

            char c = expressao.charAt(i);

            if (c == '(') {
                pilha.empilhar(c);
            } else if (c == ')') {

                if (pilha.estaVazia()) {
                    return false;
                }

                pilha.desempilhar();
            }
        }

        return pilha.estaVazia();
    }

    public static void main(String[] args) {

        Pilha p = new Pilha(3);

        p.empilhar(10);
        p.empilhar(20);
        p.empilhar(30);

        System.out.println(p.empilhar(40));
        System.out.println(p.desempilhar());
        System.out.println(p.espiar());
        System.out.println(p.tamanho());

        System.out.println(balanceada("(a+b)*(c-d))"));
        System.out.println(balanceada("(a+b)*(c-d)"));
    }
}
