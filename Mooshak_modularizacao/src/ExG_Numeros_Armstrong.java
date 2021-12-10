import java.util.Scanner;

public class ExG_Numeros_Armstrong {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int num;

        num = ler.nextInt();
        imprimirNumerosArmstrongAteIntroduzido(num);
        verificarArmstrong(num);

/*
        if (verificarArmstrong(num) == true) {
            System.out.println("O número introduzido é número de Armstrong");
        } else {
            System.out.println("O número introduzido não é número de Armstrong");
        }
*/

    }
// ALTERAR O MODULO IMPRIMIR PARA CHAMAR O MODULO VERIFICAR

    public static void imprimirNumerosArmstrongAteIntroduzido(int num) {
        int i, n, m, mCopia, algarismo, cont = 0;
        double soma;

        for (i = 0; i <= num; i++) {
            n = i;
            m = i;
            mCopia = m;
            soma = 0;
            cont = 0;
            if (n == 0) {
                cont = 1;
            }
            while (n != 0) {
                cont++;
                n = n / 10;
            }
            while (m != 0) {
                algarismo = m % 10;
                soma = soma + Math.pow(algarismo, cont);
                m = m / 10;
            }
            if (soma == mCopia) {
                System.out.printf("%.0f%n", soma);
            }
        }
    }

    public static boolean verificarArmstrong(int num) {
        boolean verif = false;
        int n, m, algarismo, cont = 0;
        double soma = 0;

        n = num;
        m = num;
        while (n != 0) {
            cont++;
            n = n / 10;
        }
        while (m != 0) {
            algarismo = m % 10;
            soma = soma + Math.pow(algarismo, cont);
            m = m / 10;
        }
        if (soma == num && soma != 0) {
            verif = true;
        }
        return verif;
    }
}