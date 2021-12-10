//B - Somar algarismos pares (v2)
//        Construa um programa que calcule a soma dos algarismos pares de um número inteiro positivo introduzido pelo utilizador.
//        Por exemplo, se a entrada for o número 36781 a saída será 14 (8+6)
//
//        O algoritmo deve ser aplicado a uma sequência de números inteiros terminada por um número não positivo.
//
//        Exemplo:
//        Entrada
//        Saída
//        36781
//        4567
//        10003
//        -1
//
//        14
//        10
//        0



import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, dig = 0, soma = 0;

        num = ler.nextInt();

        while (num >= 0) {
            while (num != 0) {
                dig = num % 10;
                if (dig % 2 == 0) {
                    soma = soma + dig;
                }
                num = num / 10;
            }
            System.out.println(soma);
            num = ler.nextInt();
            soma = 0;
        }

    }
}
