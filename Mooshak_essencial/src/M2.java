import java.util.Scanner;

public class M2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int n;
        n = ler.nextInt();

        for (int i = 0; i <= n; i++) {
            System.out.println(numFibonacci(i));
        }
    }

    public static int numFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return numFibonacci(n - 1) + numFibonacci(n - 2);
        }
    }
}