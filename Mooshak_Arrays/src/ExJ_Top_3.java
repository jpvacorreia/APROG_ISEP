import java.util.Scanner;

public class ExJ_Top_3 {
    static Scanner ler = new Scanner(System.in);
    static final int NumeroFuncionarios = 100;

    public static void main(String[] args) {
        String[] nomes = new String[NumeroFuncionarios];
        double[] vencimentos = new double[NumeroFuncionarios];

        int nElementos = inserirInformacaoFuncionarios(vencimentos, nomes);

        ordenarArrays(vencimentos, nomes, nElementos);

        imprimirTop3(vencimentos, nomes, nElementos);

//        System.out.printf("#%d:%s:%d", nomes[i], vencimentos[i]);

    }

    public static int inserirInformacaoFuncionarios(double[] vencimentos, String[] nomes) {
        String nome = "";
        int i = 0;

        do {
            nome = ler.nextLine();
            if (!nome.equals("FIM")) { // if nome é diferente de "FIM"
                nomes[i] = nome;
                vencimentos[i] = ler.nextDouble();
                ler.nextLine();
                i++;
            }
        } while (!nome.equals("FIM") && i <= nomes.length);

        return i;
    }

    public static void ordenarArrays(double[] vencimentos, String[] nomes, int nElementos) {

        // ordenar primeiro por vencimento e depois alfabeticamente
        for (int i = 0; i < nElementos - 1; i++) {
            for (int j = i + 1; j < nElementos; j++) {
                if (vencimentos[i] < vencimentos[j] && vencimentos[i] != 0
                        || vencimentos[i] == vencimentos[j] && nomes[i].compareTo(nomes[j]) > 0) {
                    double auxVenc = vencimentos[i];
                    vencimentos[i] = vencimentos[j];
                    vencimentos[j] = auxVenc;

                    String auxN = nomes[i];
                    nomes[i] = nomes[j];
                    nomes[j] = auxN;
                }
            }
        }
    }

    public static void imprimirTop3(double[] vencimentos, String[] nomes, int nElementos) {

        for (int i = 0; i < 3; i++) {
            if (vencimentos[i] != 0) {
                System.out.printf("#%d:%s:%.0f%n", (i + 1), nomes[i], vencimentos[i]);
            }
        }
    }
}

