import java.util.Scanner;

public class ExG_Inverter_Sequencia {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int numN = ler.nextInt();
        int[] sequenciaNumeros = new int[numN];

        criarSequenciaNumeros(sequenciaNumeros);

        int[] sequenciaNumerosInversa = inverterSequencia(sequenciaNumeros);

        for (int i = 0; i < sequenciaNumerosInversa.length; i++) {
            System.out.println(sequenciaNumerosInversa[i]);
        }
    }

    public static void criarSequenciaNumeros(int[] sequenciaNumeros) {

        for (int i = 0; i < sequenciaNumeros.length; i++) {
            sequenciaNumeros[i] = ler.nextInt();
        }

    }

    public static int[] inverterSequencia(int[] sequenciaNumeros) {
        int[] sequenciaInversa = new int[sequenciaNumeros.length];
        for (int i = 0; i < sequenciaNumeros.length; i++) {
            sequenciaInversa[i] = sequenciaNumeros[sequenciaNumeros.length - i - 1];
        }
        return sequenciaInversa;
    }
}

