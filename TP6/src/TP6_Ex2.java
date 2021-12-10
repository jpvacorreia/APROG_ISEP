import java.util.Scanner;

public class TP6_Ex2 {
    public static int contador(int numero) {

        int contador = 1;
        while (numero > 10) {
            numero = numero / 10;
            contador++;
        }
        return contador;
    }


    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int numero;
        numero = ler.nextInt();

        System.out.println(contador(numero));

    }
}
