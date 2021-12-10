import java.util.Scanner;

public class TP6_Ex1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int age;
        double height;
        String firstName;               //one word
        String address;                 //multiple words

        age = sc.nextInt();             //reads an INT until it finds a separator
        height = sc.nextDouble();       //reads a DOUBLE until it finds a separator
        firstName = sc.next();          //reads a STRING until it finds a separator

        sc.nextLine();                  //reads until the end of line (remove what's left)

        address = sc.nextLine();        //reads an entire line into a STRING

        System.out.print("various ways to output results using ");
        System.out.println("print(), println() and printf()");
        System.out.printf("age=%d height=%.2f firstname=%s address=%s", age, height, firstName, address);
    }
}

// Algoritmo em pseudocódigo,
// e em Java