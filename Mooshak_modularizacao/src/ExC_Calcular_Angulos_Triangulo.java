import java.util.Scanner;

public class ExC_Calcular_Angulos_Triangulo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int a, b, c;
        double angAB, angAC, angBC;

        a = ler.nextInt();
        b = ler.nextInt();
        c = ler.nextInt();

        if (a+b>c && a+c>b && c+b>a && a>0 && b>0 && c>0) {
            angAB = calcAng(a,b,c);
            angAC = calcAng(a,c,b);
            angBC = calcAng(b,c,a);

            System.out.printf("a=%d%n", a);
            System.out.printf("b=%d%n", b);
            System.out.printf("c=%d%n", c);
            System.out.printf("ang(a,b)=%d%n", (int) angAB);
            System.out.printf("ang(a,c)=%d%n", (int) angAC);
            System.out.printf("ang(b,c)=%d%n", (int) angBC);
        } else {
            System.out.println("impossivel");
        }

    }

    public static double calcAng (int a, int b, int c) {
        double angulo = 0, ang = 0;

        ang = ((Math.pow(a,2) + Math.pow(b,2) - Math.pow(c,2)) / (2*a*b));
        angulo = Math.toDegrees(Math.acos(ang));

        return angulo;
    }
}
