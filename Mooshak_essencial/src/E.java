/*
E - Converter de base 8 para decimal
Construa um programa que recebe um número inteiro na base 8 e converte-o para o sistema decimal.
O algoritmo deve ser aplicado a uma sequência de números inteiros terminada por um número não positivo.

Exemplo:
Entrada
	Saída
12345
5000
111
-1

	5349
2560
73

*/



import java.util.Scanner;

public class E {    // Converter um número inteiro em base 8 para decimal (não verifica se o número indicado está
                    // correctamente em base 8)
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, decimal = 0, soma = 0;
        double dig = 0, cont = 0;

        num = ler.nextInt();
        while (num >= 0) {
            while (num != 0) {
                dig = num % 10;
                decimal = (int) (dig * Math.pow(8, cont));
                soma = soma + decimal;
                cont++;
                num = num / 10;
            }
            System.out.println(soma);
            num = ler.nextInt();
            cont = 0;
            soma = 0;
            dig = 0;
            decimal= 0;
        }
    }
}
