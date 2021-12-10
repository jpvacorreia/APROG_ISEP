import java.util.Scanner;

public class N {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, numAnterior, numAtual, dig, digNext, cont1, cont2, cont3;
        num = ler.nextInt();
        cont1 = 0;
        cont2 = 0;

        if (num >= 0) {
            numAnterior = num;
            digNext = 10;
            while (num >= 0) {
                numAtual = num;
                while (num != 0) {
                    dig = num % 10;
                    if (dig < digNext) {
                        cont2++;
                    }
                    digNext = dig;
                    num = num / 10;
                    cont1++;
                }
                if (numAnterior < numAtual && cont2 == cont1) {
                        System.out.println(numAtual);
                }
                numAnterior = numAtual;
                num = ler.nextInt();
                cont1 = 0;
                cont2 = 0;
                digNext = 10;
            }
        }
    }
}