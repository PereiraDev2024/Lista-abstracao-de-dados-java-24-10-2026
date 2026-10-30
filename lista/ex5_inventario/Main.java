// Kaiky Brener De Souza Pereira

import java.util.ArrayList;

class Item {

    private String nome;
    private double peso;

    public Item(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }
}

class Inventario {

    private static final int MAX_ITENS = 5;
    private static final double MAX_PESO = 20.0;

    private ArrayList<Item> itens = new ArrayList<>();

    public boolean adicionar(Item i) {

        if (i == null || itens.size() >= MAX_ITENS) {
            return false;
        }

        if (pesoTotal() + i.getPeso() > MAX_PESO) {
            return false;
        }

        itens.add(i);
        return true;
    }

    public boolean remover(String nome) {

        for (int k = 0; k < itens.size(); k++) {

            if (itens.get(k).getNome().equals(nome)) {
                itens.remove(k);
                return true;
            }
        }

        return false;
    }

    public double pesoTotal() {

        double total = 0;

        for (Item i : itens) {
            total += i.getPeso();
        }

        return total;
    }

    public void listar() {

        for (Item i : itens) {
            System.out.println(i.getNome() + " (" + i.getPeso() + " kg)");
        }
    }

    // Sem getItens(): devolver a lista interna deixaria quem está fora dar add() direto nela e burlar os limites de itens e peso.
}

public class Main {

    public static void main(String[] args) {

        Inventario inv = new Inventario();

        inv.adicionar(new Item("Espada", 8));
        inv.adicionar(new Item("Escudo", 7));
        inv.adicionar(new Item("Poção", 1));

        System.out.println(inv.adicionar(new Item("Armadura", 10)));
        System.out.println(inv.pesoTotal());
        inv.listar();
    }
}
