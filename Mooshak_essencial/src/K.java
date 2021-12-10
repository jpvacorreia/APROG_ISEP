/*
K - Números primos até um limite
        Construa um programa que determine e visualize os números primos até um determinado valor N inserido pelo utilizador.
        Um número é primo se for inteiro, maior que 1 e se só for divisível, por ele próprio e por 1.

        Cada número deve aparecer numa linha separada..

        Exemplo:
        Entrada
        Saída
        16

        2
        3
        5
        7
        11
        13
*/

import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, i = 1, j = 0, l = 1, lCopia;
        num = ler.nextInt();

        while (i <= num) {
            while (l <= i) {
                if (i % l == 0) {
                    j++;
                }
                l++;
            }
            if (j == 2) {
                System.out.println(i);
            }
            l = 1;
            j = 0;
            i++;
        }
    }
}
