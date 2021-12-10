import java.util.Scanner;

public class ExF_Volumes_Solidos_Revolucao {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        String solido;
        double raio, altura, volume;

        solido = ler.nextLine();

        while (solido.equals("fim") == false) {
            switch (solido) {
                case ("cone"):
                    raio = ler.nextDouble();
                    altura = ler.nextDouble();
                    volume = vCone(raio, altura);
                    System.out.printf("%.2f%n", volume);
                    break;
                case ("esfera"):
                    raio = ler.nextDouble();
                    volume = vEsfera(raio);
                    System.out.printf("%.2f%n", volume);
                    break;
                case ("cilindro"):
                    raio = ler.nextDouble();
                    altura = ler.nextDouble();
                    volume = vCilindro(raio, altura);
                    System.out.printf("%.2f%n", volume);
                    break;
            }
            ler.nextLine();
            solido = ler.nextLine();
        }

    }

    public static double vCone(double raio, double altura) {
        double volume = ((double) 1 / 3) * Math.PI * Math.pow(raio, 2) * altura;
        return volume;
    }

    public static double vCilindro(double raio, double altura) {
        double volume = Math.PI * Math.pow(raio, 2) * altura;
        return volume;

    }

    public static double vEsfera(double raio) {
        double volume = ((double) 4 / 3) * Math.PI * Math.pow(raio, 3);
        return volume;
    }
}
