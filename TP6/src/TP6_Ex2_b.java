import java.util.Scanner;

public class TP6_Ex2_b {
    public static int contador(long numero) {

        int cont = 1;
        while (numero >= 10) {
            numero = numero / 10;
            cont++;
        }
        return cont;
    }


    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int digmax, cont, digitos;
        long numero, soma;
        float media;

        digmax = ler.nextInt();                     // número máximo de algarismos
        cont = 0;
        soma = 0;
        numero = ler.nextLong();
        digitos = contador(numero);

        while (digitos <= digmax) {
            soma = soma + numero;
            cont++;
            numero = ler.nextLong();
            digitos = contador(numero);
        }
        if (cont > 0) {
            media = (float) soma / (cont);
            System.out.println(media);
        } else {
            System.out.printf("Número introduzido tem mais de %d dígitos", digmax);
        }
    }
}

