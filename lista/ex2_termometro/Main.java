// Kaiky Brener De Souza Pereira

class Termometro {

    private static final double ZERO_ABSOLUTO = -273.15;

    private double celsius;

    public Termometro(double celsius) {

        if (celsius < ZERO_ABSOLUTO) {
            throw new IllegalArgumentException("Abaixo do zero absoluto");
        }

        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return celsius * 9 / 5 + 32;
    }

    public double getKelvin() {
        return celsius + 273.15;
    }

    public boolean setCelsius(double novo) {

        if (novo < ZERO_ABSOLUTO) {
            return false;
        }

        celsius = novo;
        return true;
    }
}

public class Main {

    public static void main(String[] args) {

        Termometro t = new Termometro(25);

        System.out.println(t.getFahrenheit());
        System.out.println(t.getKelvin());
        System.out.println(t.setCelsius(-300));
        System.out.println(t.getCelsius());
    }
}
