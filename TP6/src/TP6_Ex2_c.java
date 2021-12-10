import java.util.Scanner;

public class TP6_Ex2_c {
    static final int K = 3;

    public static int contador(int numero) {

        int contador = 1;
        while (numero >= 10) {
            numero = numero / 10;
            contador++;
        }
        return contador;
    }


    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int numero, digmax, cont, digitos, soma;
        float media;

        digmax = ler.nextInt();                     // número máximo de algarismos
        cont = 0;
        soma = 0;
        numero = ler.nextInt();
        digitos = contador(numero);
//        System.out.println(cont);

        while (digitos <= digmax && cont <= (K - 1)) {
            soma = soma + numero;
            cont++;
            if (cont <= (K - 1)) {
                numero = ler.nextInt();
                digitos = contador(numero);
            }
//            System.out.println(cont);
        }
        if (cont > 0) {
            media = (float) soma / (cont);
            System.out.println(media);
        } else {
            System.out.printf("Número introduzido tem mais de %d dígitos", digmax);
        }
    }
}

