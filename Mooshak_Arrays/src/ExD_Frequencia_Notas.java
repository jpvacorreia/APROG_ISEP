import java.util.Scanner;

public class ExD_Frequencia_Notas {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int nAlunos = ler.nextInt();
        int[] tabelaNotas = criarTabelaNotas(nAlunos);
        int[] tabelaFrequencia = determinarFrequenciaNotas(tabelaNotas);
        imprimirValoresFrequencias(tabelaFrequencia);
    }

    public static int[] criarTabelaNotas(int nAlunos) {
        int[] result = new int[nAlunos];
        int nota = 0;

        for (int i = 0; i < nAlunos; i++) {
            do {
                nota = ler.nextInt();
            } while (nota < 0 || nota > 20);
            result[i] = nota;
        }
        return result;
    }

    public static int[] determinarFrequenciaNotas(int[] tabelaNotas) {
        int[] result = new int[21];

        for (int i = 0; i < tabelaNotas.length; i++) {
            int nota = tabelaNotas[i];
            result[nota] = (result[nota] + 1);
        }
        return result;
    }

    public static void imprimirValoresFrequencias(int[] tabelaFrequencia) {

        for (int i = 0; i < tabelaFrequencia.length; i++) {
            System.out.printf("%d %d%n",i ,tabelaFrequencia[i]);
        }
    }
}