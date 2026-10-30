// Kaiky Brener De Souza Pereira

class Cofre {

    private String senha;
    private int tentativasErradas;
    private boolean bloqueado;

    public Cofre(String senha) {
        this.senha = senha;
    }

    public boolean abrir(String tentativa) {

        if (bloqueado) {
            return false;
        }

        if (senha.equals(tentativa)) {
            tentativasErradas = 0;
            return true;
        }

        tentativasErradas++;

        if (tentativasErradas >= 3) {
            bloqueado = true;
        }

        return false;
    }

    public boolean trocarSenha(String antiga, String nova) {

        if (bloqueado || !senha.equals(antiga)) {
            return false;
        }

        if (nova == null || nova.length() < 6) {
            return false;
        }

        senha = nova;
        return true;
    }

    public boolean estaBloqueado() {
        return bloqueado;
    }
}

public class Main {

    public static void main(String[] args) {

        Cofre c = new Cofre("dragao42");

        System.out.println(c.abrir("abc"));
        System.out.println(c.abrir("dragao42"));
        System.out.println(c.trocarSenha("dragao42", "123"));

        c.abrir("x");
        c.abrir("y");
        c.abrir("z");

        System.out.println(c.estaBloqueado());
        System.out.println(c.abrir("dragao42"));
    }
}
