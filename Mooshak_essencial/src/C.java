//C - Produto dos algarismos impares
//        Construa um programa que calcule o produto dos algarismos ímpares de um número inteiro positivo introduzido pelo utilizador.
//        Por exemplo, se a entrada for o número 56983 a saída será 135 (3*9*5).
//
//        Se o número não contiver algarismos impares deve ser visualizada a mensagem "nao ha algarismos impares".
//
//        Exemplo:
//        Entrada
//        Saída
//        56983
//
//        135


import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, dig = 0, prod = 1, cont = 0;

        num = ler.nextInt();

        if (num >= 0) {
            while (num != 0) {
                dig = num % 10;
                if (dig % 2 == 1) {
                    prod = prod * dig;
                    cont++;
                }
                num = num / 10;
            }
            if (cont < 1) {
                System.out.println("nao ha algarismos impares");
            } else {
                System.out.println(prod);
            }
        }
    }
}

