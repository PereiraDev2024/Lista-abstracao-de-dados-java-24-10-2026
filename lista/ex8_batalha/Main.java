// Kaiky Brener De Souza Pereira

import java.util.Random;

abstract class Personagem {

    private String nome;
    private int vida = 100;

    public Personagem(String nome) {
        this.nome = nome;
    }

    public void receberDano(int d) {

        if (d < 0) {
            d = 0;
        }

        vida = Math.max(0, vida - d);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }

    protected abstract int calcularAtaque();

    public int atacar(Personagem alvo) {

        if (!estaVivo()) {
            return 0;
        }

        int dano = calcularAtaque();
        alvo.receberDano(dano);

        return dano;
    }
}

class Guerreiro extends Personagem {

    private Random random;

    public Guerreiro(String nome, Random random) {
        super(nome);
        this.random = random;
    }

    @Override
    public void receberDano(int d) {
        super.receberDano((int) Math.round(d * 0.8));
    }

    @Override
    protected int calcularAtaque() {
        return 8 + random.nextInt(8);
    }
}

class Mago extends Personagem {

    private int mana = 30;

    public Mago(String nome) {
        super(nome);
    }

    @Override
    protected int calcularAtaque() {

        if (mana >= 10) {
            mana -= 10;
            return 20;
        }

        return 5;
    }
}

public class Main {

    public static void main(String[] args) {

        Random random = new Random(42);

        Personagem guerreiro = new Guerreiro("Guerreiro", random);
        Personagem mago = new Mago("Mago");

        int turno = 1;

        while (guerreiro.estaVivo() && mago.estaVivo()) {

            Personagem atacante = (turno % 2 == 1) ? guerreiro : mago;
            Personagem alvo = (turno % 2 == 1) ? mago : guerreiro;

            int dano = atacante.atacar(alvo);

            System.out.println("Turno " + turno + ": " + atacante.getNome() + " causa " + dano
                    + " de dano. " + alvo.getNome() + " está com " + alvo.getVida() + " de vida.");

            turno++;
        }

        Personagem vencedor = guerreiro.estaVivo() ? guerreiro : mago;

        System.out.println("Vencedor: " + vencedor.getNome());
    }
}
