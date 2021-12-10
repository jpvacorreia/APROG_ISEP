//A - Somar algarismos pares
//        Construa um programa que calcule a soma dos algarismos pares de um número inteiro positivo introduzido pelo utilizador.
//
//        Por exemplo, se a entrada for o número 36781 a saída será 14 (8+6)
//
//        Exemplo:
//        Entrada
//        Saída
//        36781
//
//        14


import java.util.Scanner;

public class A {
    final double PI = Math.cos(12);
    final double E = Math.E;
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, dig = 0, soma = 0;

        num = ler.nextInt();

        while (num != 0) {
            dig = num % 10;
            if (dig % 2 == 0) {
                soma = soma + dig;
            }
            num = num / 10;

        }
        System.out.println(soma);

    }
}
