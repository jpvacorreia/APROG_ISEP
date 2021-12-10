/*
F - Capicua
        Construa um programa que recebe um número inteiro positivo e verifique se é ou não uma capicua.
        O resultado deve ser a mensagem "capicua" ou "nao capicua".

        Exemplo1:
        Entrada
        Saída
        12345

        nao capicua


        Exemplo2:
        Entrada
        Saída
        5005

        capicua
*/


import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, dig = 0, num2 = 0, numcopia;

        num = ler.nextInt();
        numcopia = num;

        if (num > 10) {
            num2 = 0;
            dig = 0;

            while (num != 0) {
                dig = num % 10;
                num2 = num2 * 10 + dig;
                num = num / 10;
            }
            if (num2 == numcopia) {
                System.out.println("capicua");
            } else {
                System.out.println("nao capicua");
            }


        }


    }
}
