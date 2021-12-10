/*
H - Número primo
        Construa um programa que dado um número inteiro positivo verifica se é ou não um número primo.
        Um número é primo se for inteiro e se só for divisível, por ele próprio e por 1.

        O resultado deve ser a mensagem "primo" ou "nao e primo".

        Exemplo1:
        Entrada
        Saída
        27

        nao e primo


        Exemplo2:
        Entrada
        Saída
        31

        primo
*/


import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, i = 1, j = 0;
        num = ler.nextInt();

        while (num <= 0){
            num = ler.nextInt();
        }
        while (i <= num){
            if (num % i == 0){
                j++;
            }
            i++;
        }
        if (j == 2){
            System.out.println("primo");
        } else {
            System.out.println("nao e primo");
        }



    }
}
