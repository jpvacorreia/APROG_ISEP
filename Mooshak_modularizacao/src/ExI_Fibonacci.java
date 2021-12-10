import java.util.Scanner;

public class ExI_Fibonacci {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int num;

        num = ler.nextInt();

        if (verifFibonacci(num) == true) {
            System.out.println("e de Fibonacci");
        } else {
            System.out.println("nao e de Fibonacci");
        }

    }

    public static boolean verifFibonacci(int num) {
        boolean verif = false;
        int n, num1, num2, i;

        n = num;
        num1 = 0;
        num2 = 1;

        if (n > 0) {
            switch (n) {
                case (1): {
                    verif = true;
//                    System.out.println(num1);
                    break;
                }
                case (2): {
                    verif = true;
//                    System.out.println(num1);
//                    System.out.println(num2);
                    break;
                }
                default: {
                    for (i = 1; i <= (n); i++) {
                        num2 = num2 + num1;
                        num1 = num2 - num1;
                        if (num2 == n) {
                            verif = true;
                        }
                    }
                }
            }
        }
        return verif;
    }
}