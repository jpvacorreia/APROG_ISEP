/*
A - Palíndromo
Faça um programa que leia uma sequência de palavras até encontrar um palíndromo (palavra cuja leitura
da esquerda para a direita é igual à da direita para a esquerda).
Deve implementar um módulo para verificar se uma palavra é um palíndromo, isto é, o módulo
recebe uma palavra e retorna a indicação se essa palavra é ou não um palíndromo.
O programa deve mostrar o número de palavras lidas que antecedem o palíndromo.

Exemplo:
Entrada
Saída
joao
nada
banana
ana

3
*/

import java.util.Scanner;

public class ExA_Palindromo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String palavra, palavraInvertida;
        int cont = 0;

        do {
            palavra = ler.nextLine();
            palavraInvertida = invertString(palavra);
            if (palavra.equalsIgnoreCase(palavraInvertida)) {
                System.out.println(cont);
            }
            cont++;

        } while (palavra.equalsIgnoreCase(palavraInvertida)==false);

    }


    public static String invertString(String palavra) {
        String result = "";
        while (palavra.length() != 0) {
            result = palavra.charAt(0) + result;
            palavra = palavra.substring(1);
        }
        return result;
    }
}