import java.util.Scanner;

public class TP6_Ex3 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int alunoMax = lerNumDentroDoIntervalo(1, 500);
        int pesoMax = 0;
        int idadeMax = 0;


        for (int i = 0; i < alunoMax; i++) {
            int alunoIdade = lerNumDentroDoIntervalo(8, 16);
            int alunoPeso = lerNumDentroDoIntervalo(30, 100);

            if (alunoPeso > pesoMax) {
                pesoMax = alunoPeso;
                idadeMax = alunoIdade;
            }
        }
        System.out.printf("O aluno com maior peso tem %d anos", idadeMax);

    }

    public static int lerNumDentroDoIntervalo( int limiteInf, int limiteSup) {
        Scanner ler = new Scanner(System.in);
        int limInf = limiteInf;
        int limSup = limiteSup;

        if (limInf > limSup) {
            limiteSup = limInf;
            limiteInf = limSup;
        }
        int num;
        num = ler.nextInt();
        while (num < limiteInf || num > limiteSup) {
            num = ler.nextInt();
        }
        return num;
    }


}
