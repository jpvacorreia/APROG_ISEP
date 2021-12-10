import java.util.Scanner;

public class ExB_Menores_Elementos {
    static final int K = 100;
    // Constante criada para definir tamanho máximo do array. dá problema no script
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int[] elementos = createAndFillArray(K);
        menorElemento(elementos);

        // FALTA COLOCAR IF PARA NÃO ACEITAR QUE O PRIMEIRO NÚMERO SEJA NEGATIVO

    }

    public static int[] createAndFillArray(int K) {
        int[] result = new int[K];
        int num, i = 0;

        do {
            num = ler.nextInt();
            if (num >= 0) {
                result[i] = num;
            }
            i++;
        } while (i < K && num >= 0);
        return result;
    }

    public static void menorElemento(int[] elementos) {
        int elemento, elementoMenor = elementos[0], cont = 1;

        for (int i = 1; i < elementos.length; i++) {
            if (elementos[i] <= elementoMenor && elementos[i] > 0) {
                cont++;
                if (elementos[i] < elementoMenor) {
                    cont = 1;
                }
                elementoMenor = elementos[i];
            }
        }
        if (elementoMenor > 0) {
            System.out.printf("menor=%d%n", elementoMenor);
            System.out.printf("ocorrencias=%d%n", cont);
        }

    }
}
