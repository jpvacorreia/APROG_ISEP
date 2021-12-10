import java.util.Scanner;

public class ExE_Estatisticas_Vencimentos {
    static Scanner ler = new Scanner(System.in);
    static final int NUMMAX = 20; // enunciado indica que este valor não pode ser maior que 20........

    public static void main(String[] args) {
        String[] nomes = new String[NUMMAX];
        double[] vencimentos = new double[NUMMAX];

        int numeroElementos = inserirInformacaoFuncionarios(vencimentos, nomes);

        double media = calcularMediaVencimentos(vencimentos, numeroElementos);
        mostrarNomesComVencimentosMenoresQueMedia(numeroElementos, vencimentos, nomes, media);

    }

    public static int inserirInformacaoFuncionarios(double[] vencimentos, String[] nomes) {
        String nome;
        int i = 0;

        do {
            nome = ler.nextLine();
            if (!nome.equalsIgnoreCase("fim")) {
                nomes[i] = nome;
                vencimentos[i] = ler.nextDouble();
                ler.nextLine();
                i++;
            }
        } while (!nome.equalsIgnoreCase("fim") && i < nomes.length);

        return i;
    }

    public static double calcularMediaVencimentos(double[] vencimentos, int numeroElementos) {
        double soma = 0;
        for (int i = 0; i < numeroElementos; i++) {
            soma = soma + vencimentos[i];
        }
        double media = soma / numeroElementos;
        return media;
    }

    public static void mostrarNomesComVencimentosMenoresQueMedia(int numeroElementos, double[] vencimentos, String[] nomes, double media) {

//        double media = calcularMediaVencimentos(vencimentos, numeroElementos);
        System.out.printf("%.1f%n", media);

        for (int i = 0; i < numeroElementos; i++) {
            if (vencimentos[i] < media) {
                System.out.println(nomes[i]);
            }
        }
    }

}


