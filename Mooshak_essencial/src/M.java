import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int n, num1, num2, i;
        n = ler.nextInt();
        num1 = 0;
        num2 = 1;

        if (n > 0) {
            switch (n) {
                case (1): {
                    System.out.println(num1);
                    break;
                }
                case (2): {
                    System.out.println(num1);
                    System.out.println(num2);
                    break;
                }
                default: {
                    System.out.println(num1);
                    System.out.println(num2);
                    for (i = 1; i <= (n - 2); i++) {
                        num2 = num2 + num1;
                        num1 = num2 - num1;
                        System.out.println(num2);
                    }
                }
            }
        }
    }
}
