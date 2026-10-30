// Kaiky Brener De Souza Pereira

class Lampada {

    private boolean ligada;
    private int vezesLigada;

    public void ligar() {

        if (!ligada) {
            ligada = true;
            vezesLigada++;
        }
    }

    public void desligar() {
        ligada = false;
    }

    public void alternar() {

        if (ligada) {
            desligar();
        } else {
            ligar();
        }
    }

    public boolean estaLigada() {
        return ligada;
    }

    public int getVezesLigada() {
        return vezesLigada;
    }
}

public class Main {

    public static void main(String[] args) {

        Lampada l = new Lampada();

        l.ligar();
        l.ligar();
        l.alternar();
        l.alternar();

        System.out.println(l.estaLigada());
        System.out.println(l.getVezesLigada());
    }
}
