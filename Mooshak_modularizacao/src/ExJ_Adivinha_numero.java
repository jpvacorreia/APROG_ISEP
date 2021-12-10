import java.util.Scanner;

public class ExJ_Adivinha_numero {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int num, i, cont = 1;
        boolean verif;

        num = ler.nextInt();
        for (i = 0; i < 30; i++) {
            System.out.printf("%n");
        }

        do {
            verif = verifNum(num,cont);
            cont++;
        } while (verif != true);


    }

    public static boolean verifNum(int num, int cont) {
        int num2;
        boolean verif = false;

        num2 = ler.nextInt();
        if (num2 < num) {
            System.out.println("Tente maior");
        } else if (num2 > num) {
            System.out.println("Tente menor");
        } else {
            verif = true;
            System.out.printf("Acertou%n%d%n",cont);
        }

        return verif;
    }
}