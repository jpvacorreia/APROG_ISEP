/*
J - Percentagem de dígitos divisores do próprio número
        Construa um programa que leia uma sequência de N números inteiros positivos, sendo N definido pelo
        utilizador.
        Se o valor de N for negativo o algoritmo termina de imediato.

        O algoritmo deve apresentar numa linha separada, para cada um dos números lidos, a percentagem dos dígitos que são divisores do próprio número (usando 2 casas decimais). O dígito zero (0) não deve ser considerado como potencial divisor mas deve ser contabilizado como digito.
        No final deve mostrar a maior dessas percentagens entre prêntesis.

        Exemplo1:
        Entrada
        Saída
        3
        123
        6
        200

        66.67%
        100.00%
        33.33%
        (100.00%)


        Exemplo2:
        Entrada
        Saída
        -6

*/


        import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, i = 1, dig, numNum, numCopia;
        float percent = 0, percentMaior = -1, j = 0, l = 0;

        numNum = ler.nextInt();

        if (numNum > 0) {
            do {
                num = ler.nextInt();
                numCopia = num;
                i++;
                if (num > 0) {
                    while (num != 0) {
                        dig = num % 10;
                        j++;
                        if (dig != 0 && numCopia % dig == 0) {
                            l++;
                        }
                        num = num / 10;
                    }
                    percent = (l / j) * 100;
                    System.out.printf("%.2f%%%n", percent);
                    if (percent > percentMaior) {
                        percentMaior = percent;
                    }
                    j = 0;
                    l = 0;
                }
            } while (i <= numNum && num >= 0);
            if (numCopia > 0) {
                System.out.printf("(%.2f%%)%n", percentMaior);
            }
        }
    }
}