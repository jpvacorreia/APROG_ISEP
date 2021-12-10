import java.util.Scanner;

public class ExI_Condominio {
    static Scanner ler = new Scanner(System.in);
    static int Length = 3;
    static int Height = 4;

    public static void main(String[] args) {
        String[][] condominio = new String[3][4];
        boolean residente = false;

        preencherApartamentos(condominio);

        String nome = ler.nextLine();
        residente = procurarNomeNosApartamentos(condominio, nome);

        if (!residente) {
            System.out.println("Nao mora no predio");
        }


    }

    public static void preencherApartamentos(String[][] condominio) {
        for (int j = 0; j < condominio.length; j++) {
            for (int i = 0; i < condominio[j].length; i++) {
                condominio[j][i] = ler.nextLine();
            }
        }
    }

    public static boolean procurarNomeNosApartamentos(String[][] condominio, String nome) {
        boolean residente = false;
        for (int j = 0; j < condominio.length; j++) {
            for (int i = 0; i < condominio[j].length; i++) {
                if (condominio[j][i].equalsIgnoreCase(nome)) {
                    residente = true;
                    System.out.printf("nome=%s%n", nome);
                    System.out.printf("entrada=%d%n", j);
                    System.out.printf("piso=%d%n", i);
                }
            }
        }
        return residente;
    }

}
