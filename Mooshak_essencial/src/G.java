/*
G - Divisores de um número
        Construa um programa que dado um número inteiro positivo escreve todos os seus divisores e,
        no final, a quantidade de divisores entre parêntesis.
        Todos os valores devem ser escriros em linhas separadas.

        Exemplo:
        Entrada
        Saída
        30

        1
        2
        3
        5
        6
        10
        15
        30
        (8)

*/

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, i = 1, divisores, j = 0;
        num = ler.nextInt();

        while (i <= num) {
            if (num % i == 0){
                System.out.println(i);
                j++;
            }
            i++;
        }
        System.out.printf("(%d)%n", j);
    }
}
