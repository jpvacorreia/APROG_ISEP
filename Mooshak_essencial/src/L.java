import java.util.Scanner;

public class L {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int n, num, cont, sum, div;
        n = ler.nextInt();
        cont = 0;
        num = 6;


        while (cont < n) {
            sum = 0;
            for (div = 1; div <= (num / 2); div++) {
                if (num % div == 0) {
                    sum += div;
                }
            }
            if (sum == num) {
                cont++;
                System.out.println(num);
            }
            num++;
        }
    }
}

