import java.util.Scanner;

public class ExD_Combinacoes_Permutacoes {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int m, n, C, P;

        m = ler.nextInt();
        n = ler.nextInt();

        if (m > 0 && m >= n) {
            C = combinacoes(m, n);
            P = permutacoes(m, n);
            System.out.printf("C(%d,%d)=%d%n", m, n, C);
            System.out.printf("P(%d,%d)=%d%n", m, n, P);
        }

    }

    public static int fatorial(int alg) {
        int fatorial = 1, i;
        for (i = 1; i <= alg; i++) {
            fatorial = fatorial * i;
        }
        return fatorial;
    }

    public static int combinacoes(int m, int n) {
        return (fatorial(m) / (fatorial(n) * fatorial(m - n)));
    }

    public static int permutacoes(int m, int n) {
        return (fatorial(m) / (fatorial(m - n)));
    }

}
