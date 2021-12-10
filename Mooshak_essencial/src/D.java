/*
D - Produto dos algarismos impares (v2)
Construa um programa que calcule o produto dos algarismos ímpares de um número inteiro positivo introduzido pelo utilizador.
Por exemplo, se a entrada for o número 56983 a saída será 135 (3*9*5).

Se o número não contiver algarismos impares deve ser visualizada a mensagem "nao ha algarismos impares".

O algoritmo deve ser aplicado a uma sequência de números inteiros terminada por um número não positivo.

Exemplo:
Entrada
	Saída
56983
321
1234567
-1

	135
3
105
*/


import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num;

        num = ler.nextInt();

        while (num >= 0) {
            int dig = 0, prod = 1, cont = 0;
            while (num != 0) {
                dig = num % 10;
                if (dig % 2 == 1) {
                    prod = prod * dig;
                    cont = cont + 1;
                }
                num = num / 10;
            }
            if (cont > 0) {
                System.out.println(prod);
            } else {
                System.out.println("nao ha algarismos impares");
            }
            num = ler.nextInt();
        }
    }
}
