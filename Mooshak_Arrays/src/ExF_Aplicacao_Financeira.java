import java.util.Scanner;

public class ExF_Aplicacao_Financeira {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int numeroMeses = 6;
        double[] juros = new double[numeroMeses];
        taxasJuroMensais(juros);

        double depositoInicial = ler.nextInt();

        calcularEImprimirMontanteFinal(numeroMeses, depositoInicial, juros);

    }

    public static void taxasJuroMensais(double[] juros) {
        for (int i = 0; i < juros.length; i++) {
            juros[i] = ler.nextDouble();
        }

    }

    public static void calcularEImprimirMontanteFinal(int numeroMeses, double depositoInicial, double[] juros) {
        double valorFinal = depositoInicial;
        for (int i = 0; i < numeroMeses; i++) {
            valorFinal = valorFinal * (juros[i] + 1);
        }
        System.out.printf("valor final=%.2f%n", valorFinal);
    }
}
