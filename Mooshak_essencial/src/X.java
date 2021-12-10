/*
X - Relógio
        Construa um programa em que dado um valor inteiro, representativo de um código de um relógio, indique a marca do mesmo.

        A tabela seguinte indica a correspondência entre o dígito e a marca.

        Código
        Marca
        1
        Tag Heuer
        2
        Rolex
        3
        Omega
        4
        Cartier
        5
        Bvlgari
        6
        Raymond Weil
        Outro
        Marca invalida


        Exemplo1:
        Entrada
        Saída
        5

        Bvlgari


        Exemplo2:
        Entrada
        Saída
        3

        Omega


        Exemplo3:
        Entrada
        Saída
        8

        Marca invalida

*/


import java.util.Scanner;

public class X {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num;

        num = ler.nextInt();

        switch (num) {
            case 1:
                System.out.println("Tag Heuer");
                break;
            case 2:
                System.out.println("Rolex");
                break;
            case 3:
                System.out.println("Omega");
                break;
            case 4:
                System.out.println("Cartier");
                break;
            case 5:
                System.out.println("Bvlgari");
                break;
            case 6:
                System.out.println("Raymond Weil");
                break;
            default:
                System.out.println("Marca invalida");
                break;
        }
    }
}
