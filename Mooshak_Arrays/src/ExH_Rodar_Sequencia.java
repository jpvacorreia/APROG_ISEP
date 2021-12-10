import java.util.Scanner;

public class ExH_Rodar_Sequencia {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int n = ler.nextInt();
        int[] sequencia = new int[n];

        for (int i = 0; i < sequencia.length; i++) {
            sequencia[i] = ler.nextInt();
        }

        String comando;
        ler.nextLine();

        do {
            comando = ler.nextLine();
            switch (comando) {
                case "direita":
                    rodarSequenciaDireita(sequencia, n);
                    printArray(sequencia, n);
                    break;
                case "esquerda":
                    rodarSequenciaEsquerda(sequencia, n);
                    printArray(sequencia, n);
                    break;
            }
        } while (!comando.equalsIgnoreCase("sair"));
    }

    public static void rodarSequenciaDireita(int[] sequencia, int n) {
        int valorRodarDireita = sequencia[sequencia.length - 1];
        for (int i = (sequencia.length - 1); i > 0; i--) {
            sequencia[i] = sequencia[i - 1];
        }
        sequencia[0] = valorRodarDireita;
    }

    public static void rodarSequenciaEsquerda(int[] sequencia, int n) {
        int valorRodarEsquerda = sequencia[0];
        for (int i = 0; i < (sequencia.length - 1); i++) {
            sequencia[i] = sequencia[i + 1];
        }
        sequencia[sequencia.length - 1] = valorRodarEsquerda;

    }

    public static void printArray(int[] sequencia, int n) {
        for (int i = 0; i < sequencia.length; i++) {
            System.out.printf("[%d]", sequencia[i]);
        }
        System.out.printf("%n");
    }


}
