import java.util.Scanner;

public class ExC_Sequencia_Crescente {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {

        int qtdNumeros = ler.nextInt();
        if (qtdNumeros > 0) {
            int[] sequencia = criarArrayNumeros(qtdNumeros);
            boolean verifSequenciaCrescente = verificarSequenciaCrescente(sequencia);

            if (verifSequenciaCrescente == true) {
                System.out.printf("sempre crescente = %b%n", verifSequenciaCrescente);
            } else if (verifSequenciaCrescente == false && sequencia.length > 1) {
                System.out.printf("sempre crescente = %b%n", verifSequenciaCrescente);
            }
        }
    }

    public static int[] criarArrayNumeros(int qtdNumeros) {
        int[] result = new int[qtdNumeros];
        for (int i = 0; i < qtdNumeros; i++) {
            result[i] = ler.nextInt();
        }
        return result;
    }

    public static boolean verificarSequenciaCrescente(int[] sequencia) {
        boolean result = false;
        int cont = 0;
// VERIFICAR O QUE DEVE ACONTECER SE O NÚMERO INTRODUZIDO FOR 0 OU 1.
        for (int i = 1; i < sequencia.length; i++) {
            if (sequencia[i] <= sequencia[i - 1]) {
                cont++;
            }
            if (cont > 0) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }
}
