// Kaiky Brener De Souza Pereira

interface Forma {

    double area();

    double perimetro();

    String nome();
}

class Retangulo implements Forma {

    private double base;
    private double altura;

    public Retangulo(double base, double altura) {

        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Medidas devem ser positivas");
        }

        this.base = base;
        this.altura = altura;
    }

    public double area() {
        return base * altura;
    }

    public double perimetro() {
        return 2 * (base + altura);
    }

    public String nome() {
        return "Retângulo";
    }
}

class Circulo implements Forma {

    private double raio;

    public Circulo(double raio) {

        if (raio <= 0) {
            throw new IllegalArgumentException("Medidas devem ser positivas");
        }

        this.raio = raio;
    }

    public double area() {
        return Math.PI * raio * raio;
    }

    public double perimetro() {
        return 2 * Math.PI * raio;
    }

    public String nome() {
        return "Círculo";
    }
}

class Triangulo implements Forma {

    private double a;
    private double b;
    private double c;

    public Triangulo(double a, double b, double c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException("Medidas devem ser positivas");
        }

        if (a >= b + c || b >= a + c || c >= a + b) {
            throw new IllegalArgumentException("Triângulo inválido");
        }

        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double area() {

        double p = perimetro() / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double perimetro() {
        return a + b + c;
    }

    public String nome() {
        return "Triângulo";
    }
}

public class Main {

    public static void main(String[] args) {

        Forma[] formas = {
            new Retangulo(3, 4),
            new Circulo(1),
            new Triangulo(3, 4, 5)
        };

        double soma = 0;
        Forma maior = formas[0];

        for (Forma f : formas) {

            System.out.printf("%s: área %.2f, perímetro %.2f%n", f.nome(), f.area(), f.perimetro());

            soma += f.area();

            if (f.area() > maior.area()) {
                maior = f;
            }
        }

        System.out.printf("Soma das áreas: %.2f%n", soma);
        System.out.println("Maior área: " + maior.nome());
    }
}
