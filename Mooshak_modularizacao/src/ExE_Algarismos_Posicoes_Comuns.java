import java.util.Scanner;

public class ExE_Algarismos_Posicoes_Comuns {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int N, num1, num2, i, contador, contadormax = 0, num1copia = 0, num2copia = 0;
        N = ler.nextInt();

        for (i = 0; i < N; i++) {
            num1 = ler.nextInt();
            num2 = ler.nextInt();
            contador = digitosMesmasPosicoes(num1, num2);
            if (contador >= contadormax) {
                contadormax = contador;
                num1copia = num1;
                num2copia = num2;
            }
        }
        if (contadormax > 0) {
            System.out.println(num1copia + "/" + num2copia);
        } else {
            System.out.println("sem resultados");
        }
    }

    public static int digitosMesmasPosicoes(int num1, int num2) {
        int cont = 0, copia, dig1, dig2;

        if (num1 < num2) {
            copia = num1;
            num1 = num2;
            num2 = copia;
        }

        while (num1 > 0) {
            dig1 = num1 % 10;
            dig2 = num2 % 10;
            if (dig1 == dig2) {
                cont++;
            }
            num1 = num1 / 10;
            num2 = num2 / 10;
        }
        return cont;
    }
}