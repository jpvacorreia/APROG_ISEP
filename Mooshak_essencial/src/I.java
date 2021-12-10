/*
I - Mínimo múltiplo comum
        Construa um programa que dados dois números inteiros positivos calcula o mínimo múltiplo comum.

        Exemplo1:
        Entrada
        Saída
        12
        6

        12


        Exemplo2:
        Entrada
        Saída
        5
        4

        20
*/


import java.util.Scanner;

public class I {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num1, num2, num1copia, num2copia, i = 0, mmc = 0;

        num1 = ler.nextInt();
        num2 = ler.nextInt();
        num1copia = num1;
        num2copia = num2;
        if (num1 < num2) {
            mmc = num2;
            while (num2 % num1 != 0) {
                i++;
                num2 = num2copia * i;
                mmc = num2;
            }
        } else {
            mmc = num1;
            while (num1 % num2 != 0) {
                i++;
                num1 = num1copia * i;
                mmc = num1;
            }
        }
        System.out.println(mmc);
    }
}
