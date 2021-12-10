import java.util.Scanner;

public class ExA_Classificacao_APROG {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int size = ler.nextInt();
        int[] notas = createAndFillArray(size);
        double media = (sumArray(notas) / (double)size);
        System.out.printf("media=%.1f%n", media);
        int reprovacoes = 0;

        for (int i = 0; i < notas.length; i++) {
            if ((notas[i]) < 10) {
                reprovacoes++;
            }
        }
        System.out.printf("reprovacoes=%d%n", reprovacoes);

    }

    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = ler.nextInt();
        }
        return result;
    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}