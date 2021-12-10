import java.util.Scanner;

public class Z {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, dig, cont, contPares, maxImpar;
        float percentagemPares;
        num = ler.nextInt();
        dig = 0;
        cont = 0;
        contPares = 0;
        maxImpar = 0;

        while (num > 0) {
            dig = num % 10;
            cont++;
            if (dig % 2 == 0) {
                contPares = contPares + 1;
            } else if (dig > maxImpar) {
                maxImpar = dig;
            }
            num = num / 10;
        }
        if (contPares == cont) {
            percentagemPares = ((float) contPares / cont) * 100;
            System.out.printf("%.2f%%%n", percentagemPares);
            System.out.println("nao ha algarismos impares");
        } else {
            percentagemPares = ((float) contPares / cont) * 100;
            System.out.printf("%.2f%%%n", percentagemPares);
            System.out.println(maxImpar);
        }
    }
}
