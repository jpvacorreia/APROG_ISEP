/*
Y - Divisores múltiplos de 3
        Construa um programa que leia um número inteiro positivo e apresente todos os seus divisores que sejam múltiplos de 3.
        Deverá visualizar um  divisor por linha.
        Caso não existam divisores deverá ser visualizada a mensagem "sem divisores multiplos de 3".

        Exemplo1:
        Entrada
        Saída
        30

        3
        6
        15


        Exemplo2:
        Entrada
        Saída
        29

        sem divisores multiplos de 3

*/


import java.util.Scanner;

public class Y {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int div = 3, numcopia, i = 1, cont1 = 0, cont2 = 0;
        int num = ler.nextInt();
        numcopia = num;

        while (div < numcopia) {
            if (num % div == 0) {
                System.out.println(div);
                i++;
                div = 3 * i;
                cont1++;
            } else {
                i++;
                div = 3 * i;
            }
        }
        if (cont1 == 0) {
            System.out.println("sem divisores multiplos de 3");
        }
    }
}
