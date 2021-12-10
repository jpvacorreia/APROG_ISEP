import java.util.Scanner;

public class ExH_Capicua {
    static Scanner ler = new Scanner(System.in);
    static final int K = 5;

    public static void main(String[] args) {
        int num, i = 0;


        do {
            num = ler.nextInt();

            if (verifCapicua(num) == true) {
                System.out.println("capicua");
            }
            i++;
            if (i == K && verifCapicua(num) == false) {
                System.out.println("tentativas excedidas");
            }
        } while (i < K && (verifCapicua(num) == false));

    }


    public static boolean verifCapicua(int num) {
        boolean verif = false;
        int dig = 0, num2 = 0, numcopia;

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
                verif = true;
            }
        }
        return verif;
    }
}
