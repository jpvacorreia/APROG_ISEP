import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CampeonatoMundialDeFutebol {

    static Scanner input = new Scanner(System.in);
    static final int MAX_TEAMS = 32;    //máximo de 32 equipas num mundial de futebol
    static final int MAX_GAMES = 3;     //máximo de jogos realizados por equipa nesta fase de grupos do mundial
    static final int Grp = 0;           //indicação da coluna onde a identificação do grupo será armazenada
    static final int Team = 1;          //coluna equipa
    static final int J = 0;             //coluna jogos
    static final int V = 1;             //coluna vitórias
    static final int E = 2;             //coluna empates
    static final int D = 3;             //coluna derrotas
    static final int GM = 4;            //coluna golos marcados
    static final int GS = 5;            //coluna golos sofridos
    static final int Pts = 6;           //coluna pontos
    static final int Pos = 7;           //coluna posição
    static final int GD = 8;            //coluna golos de diferença

    public static void main(String[] args) throws IOException {

        String[] infoFile = new String[MAX_TEAMS];          //Array que vai ser utilizado para recolher a informação presente no ficheiro a ser carregado
        String[][] infoStrings = new String[MAX_TEAMS][2];  //Array principal de strings (Grp e Team)
        int[][] infoNumbers = new int[MAX_TEAMS][9];        //Array principal de integers (J, V, E, D, GM, GS, Pts, Pos, GD)
        int nElements = 0;                                  //Número de equipas introduzidas nos arrays principais
        int op;                                             //variável utilizada para seleccionar a opção do menu
        String leaveScript;
        boolean fileRead = false, case1Pressed;
        boolean teamsRemoved = false, case12Pressed;
        boolean case3Pressed = false;
        boolean case4Pressed = false;

        do {
            op = showMenu();
            switch (op) {
                case 1:
                    System.out.println("Pff introduza o nome do ficheiro");
                    String pathName = input.next();         //pedido de indicação do path para o ficheiro a ser carregado

                    nElements = readInputFile(infoFile, infoStrings, infoNumbers, pathName);
                    fileRead = confirmInputFile(nElements);
                    if (fileRead) {
                        System.out.println("Informação do ficheiro carregada para a memória com sucesso.");
                        waitEnter();
                    } else {
                        System.out.println("Erro ao carregar informação do ficheiro de texto.");
                        waitEnter();
                    }

                    break;
                case 2:

                    case1Pressed = confirmFile(fileRead);

                    if (case1Pressed) {

                        String[] newTeamString = new String[2];     //string que, numa primeira instancia, irá receber a informação de formato string de cada equipa
                        int[] newTeamNumbers = new int[6];          //string que, numa primeira instancia, irá receber a informação em formato integer da cada equipa


                        if (nElements < MAX_TEAMS) {
                            inviteTeam(newTeamString, newTeamNumbers);


                            if (teamExist(infoStrings, nElements, newTeamString)) {
                                System.out.println("A equipa ja existe e não sera adicionada.");
                                waitEnter();
                            } else if (groupFullNewTeam(infoStrings, nElements, newTeamString)) {
                                System.out.println("O grupo já se encontra totalmente preenchido. A equipa não será adicionada.");
                                waitEnter();
                            } else if (groupNameExceeded(newTeamString)) {
                                System.out.println("O grupo tem de estar incluido até \"H\". A equipa não será adicionada.");
                                waitEnter();
                            } else {        //coloca a informação introduzida pelo utilizador nos arrays principais
                                for (int i = 0; i < 6; i++) {
                                    infoNumbers[nElements][i] = newTeamNumbers[i];  //copia elemento a elemento para a nova linha
                                }
                                infoStrings[nElements] = newTeamString;              //copia linha completa
                                nElements++;

                                System.out.println();
                                System.out.println("Equipa adicionada com sucesso!");
                                waitEnter();
                            }
                        } else {
                            System.out.println("Erro: Não é possível adicionar mais equipas ao mundial de Futebol.");
                            waitEnter();
                        }
                    } else {
                        errorMessageCase1();
                    }

                    break;

                case 3:

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed) {
                        case3Pressed = calculateTeamPoints(infoNumbers, nElements);
                        System.out.println("Pontuação das equipas calculada com sucesso.");
                        waitEnter();
                    } else {
                        errorMessageCase1();
                    }

                    break;

                case 4:

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed && case3Pressed) {
                        case4Pressed = classifyAndSortTeams(infoStrings, infoNumbers, nElements);
                        System.out.println("Classificacao de todas as equipas nos respetivos grupos calculada e armazenada com sucesso.");
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    }

                    break;

                case 5:

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed && case3Pressed && case4Pressed) {
                        printClassifications(infoStrings, infoNumbers, nElements);
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    } else if (!case4Pressed) {
                        errorMessageCase4();
                    }
                    break;

                case 6:

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed && case3Pressed && case4Pressed) {
                        classifyAndSortTeams(infoStrings, infoNumbers, nElements);
                        listOnlyScoredMax(infoStrings, infoNumbers, nElements);
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    } else if (!case4Pressed) {
                        errorMessageCase4();
                    }
                    break;

                case 7:

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed && case3Pressed && case4Pressed) {
                        classifyAndSortTeams(infoStrings, infoNumbers, nElements);
                        listOnlySufferedUserInput(infoStrings, infoNumbers, nElements);
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    } else if (!case4Pressed) {
                        errorMessageCase4();
                    }
                    break;

                case 8:

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed && case3Pressed && case4Pressed) {
                        classifyAndSortTeams(infoStrings, infoNumbers, nElements);
                        listTeamsMoreSufferedThanScored(infoStrings, infoNumbers, nElements);
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    } else if (!case4Pressed) {
                        errorMessageCase4();
                    }
                    break;

                case 9:

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed && case3Pressed && case4Pressed) {
                        classifyAndSortTeams(infoStrings, infoNumbers, nElements);
                        listFirstTeamEachGroup(infoStrings, infoNumbers, nElements);
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    } else if (!case4Pressed) {
                        errorMessageCase4();
                    }
                    break;

                case 10:
                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed && case3Pressed && case4Pressed) {
                        classifyAndSortTeams(infoStrings, infoNumbers, nElements);
                        listFullTeamInfo(infoStrings, infoNumbers, nElements);
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    } else if (!case4Pressed) {
                        errorMessageCase4();
                    }
                    break;

                case 11:

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed) {
                        String[] statistics = new String[8];
                        printStatistics(infoNumbers, nElements, statistics);
                        exportFileStatistics(statistics);
                        System.out.println("Documento \"Statistics.txt\" criado com sucesso.");
                        waitEnter();
                    } else {
                        errorMessageCase1();
                    }

                    break;

                case 12:
                    int[][] infoNumbersFinalStage = new int[MAX_TEAMS / 2][9];      //novo array que receberá a informação de integers das equipas que passam à fase seguinte do mundial
                    String[][] infoStringsFinalStage = new String[MAX_TEAMS / 2][2];//novo array que receberá a informação de strings das equipas que passam à fase seguinte do mundial

                    case1Pressed = confirmFile(fileRead);
                    if (case1Pressed && case3Pressed && case4Pressed) {
                        nElements = removeFromNextPhase(infoStrings, infoNumbers, nElements, infoStringsFinalStage, infoNumbersFinalStage);

                        infoNumbers = infoNumbersFinalStage;
                        infoStrings = infoStringsFinalStage;

                        System.out.println("Equipas que não vão disputar a fase seguinte removidas da memória.");
                        teamsRemoved = true;
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    } else if (!case4Pressed) {
                        errorMessageCase4();
                    }
                    break;

                case 13:

                    case1Pressed = confirmFile(fileRead);
                    case12Pressed = confirmFile(teamsRemoved);
                    if (case1Pressed && case12Pressed) {
                        exportToCSVFile(infoStrings, infoNumbers, nElements);
                        System.out.println("Documento \"FinalStage.csv\" criado com sucesso.");
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case3Pressed) {
                        errorMessageCase3();
                    } else if (!case4Pressed) {
                        errorMessageCase4();
                    } else if (!case12Pressed) {
                        System.out.println("Equipas não removidas da memória, por favor correr alinea 12.");
                        waitEnter();
                    }

                    break;

                case 14:

                    case1Pressed = confirmFile(fileRead);
                    case12Pressed = confirmFile(teamsRemoved);
                    if (case1Pressed && case12Pressed) {

                        createNewFileFinalPhase(infoStrings, infoNumbers, nElements);
                        System.out.println("Documento \"FinalStageGames.txt\" criado com sucesso.");
                        waitEnter();
                    } else if (!case1Pressed) {
                        errorMessageCase1();
                    } else if (!case12Pressed) {
                        System.out.println("Equipas não removidas da memória, por favor correr alinea 12.");
                        waitEnter();
                    }
                    break;

                case 15:

                    System.out.println("Tem certeza que deseja sair ? S/N");
                    leaveScript = input.next();

                    while (!leaveScript.equalsIgnoreCase("s") || !leaveScript.equalsIgnoreCase("n")) {
                        if (leaveScript.equalsIgnoreCase("s")) {
                            break;
                        } else if (leaveScript.equalsIgnoreCase("n")) {
                            op = 0;
                            break;
                        } else {
                            System.out.println("Tem certeza que deseja sair ? S/N");
                            leaveScript = input.next();
                        }
                    }
                    break;

                default:
                    System.out.printf("%nOpção invalida. Pressione ENTER para continuar.%n");
                    waitEnter();
            }
        } while (op != 15);     // COM O CASE 15 ISTO ESTÁ INCOERENTE....... MAS TAMBÉM NÃO ESTOU A VER O QUE VAMOS COLOCAR AQUI

    }

    //MENU

    public static int showMenu() {

        System.out.printf("###############%n");
        System.out.println("MENU");
        System.out.printf("###############%n");

        System.out.printf("%n1 - Ler e armazenar informação disponivel em ficheiro de texto.%n"
                + "2 - Inserir informações de uma Seleção.%n"
                + "3 - Calcular e armazenar em memoria a pontuação de todas as equipas.%n"
                + "4 - Calcular e armazenar em memória a classificação de todas as equipas nos respetivos grupos.%n"
                + "5 - Listar a classificação das equipas por grupo.%n"
                + "6 - Listar equipas cujo golos marcados é igual ao máximo de golos marcados.%n"
                + "7 - Listar equipas com um determinado numero de golos sofridos.%n"
                + "8 - Listar equipas com mais golos sofridos do que golos marcados, ordenada alfabeticamente.%n"
                + "9 - Listar o primeiro classificado de cada grupo.%n"
                + "10 - Listar informação completa de uma equipa.%n"
                + "11 - Criar um ficheiro de texto com as estatiscas dos jogos.%n"
                + "12 - Remover da memória as equipas que não vão disputar a fase seguinte.%n"
                + "13 - Criar um ficheiro de texto com as equipas que vão disputar a fase seguinte do campeonato.%n"
                + "14 - Criar um ficheiro de texto com os jogos da fase final.%n"
                + "15 - Sair.%n%n");

        System.out.print("Escolha uma opção: ");

        int op = input.nextInt();
        return op;
    }


    //UTILITARIOS

    public static void tableHeader() {
        System.out.printf("| Grp | Pos | Equipa          | Pts| J  | V  | E  | D  | GM | GS | GD |%n");
        System.out.printf("|=====|=====|=================|====|====|====|====|====|====|====|====|%n");
    }

    public static void printFormatedInfo(String[][] infoStrings, int[][] infoNumbers, int i) {
        System.out.printf("|%-5s|%5s|%-17s|%4d|%4d|%4d|%4d|%4d|%4d|%4d|%4s|%n", infoStrings[i][Grp], infoNumbers[i][Pos], infoStrings[i][Team], infoNumbers[i][Pts], infoNumbers[i][J], infoNumbers[i][V], infoNumbers[i][E], infoNumbers[i][D], infoNumbers[i][GM], infoNumbers[i][GS], infoNumbers[i][GD]);
    }   //esta função imprime a informação de cada linha formatada conforme pedido

    public static boolean confirmFile(boolean fileRead) {

        boolean read = false;
        if (fileRead) {
            read = true;
        }
        return read;
    }

    public static boolean confirmInputFile(int nElements) {

        boolean archived = false;
        if (nElements > 0 && nElements <= MAX_TEAMS) {
            archived = true;
        }
        return archived;
    }

    public static void waitEnter(){
        System.out.println("Pressione ENTER para continuar.");
        try {
            System.in.read();
        } catch (Exception e) {
            System.out.println();
        }
        System.out.println();
    }

    public static void errorMessageCase1() throws IOException {
        System.out.println("Documento não carregado para memoria, por favor correr alinea 1.");
        waitEnter();
    }

    public static void errorMessageCase3() throws IOException {
        System.out.println("Pontos ainda não foram calculados para memoria , por favor correr alinea 3.");
        waitEnter();
    }

    public static void errorMessageCase4() throws IOException {
        System.out.println("Ainda nao foram armazenados na memoria a classificao de todos as equipas no respectivo grupo, por favor correr alinea 4.");
        waitEnter();
    }

    //CASE - 1
    public static boolean inputFileExists(String pathName) {

        File file = new File(pathName);
        boolean exists = file.exists();
        return exists;
    }


    public static int readInputFile(String[] infoFile, String[][] infoStrings, int[][] infoNumbers, String pathName) throws
            FileNotFoundException {

        boolean fileExists = inputFileExists(pathName);
        int i = 0, j = 0;

        if (fileExists) {
            File file = new File(pathName);
            Scanner fileInput = new Scanner(file);

            fileInput.nextLine(); // descarta a primeira linha (cabeçalho)
            while (fileInput.hasNextLine()) {
                String linha = fileInput.nextLine();    //string linha com toda a informação de cada equipa
                if (linha.trim().length() > 0) {        //retira espaços em branco e verifica o comprimento da linha
                    infoFile[i] = linha;                //copia a informação da linha, em bruto, para uma linha do array infoFile
                    String temp[] = infoFile[i].split(","); //separa a informação da linha segundo o seu delimitador e copia para o array de strings
                    infoStrings[i][Grp] = temp[0];
                    infoStrings[i][Team] = temp[1];
                    infoNumbers[i][J] = Integer.parseInt(temp[2]);
                    infoNumbers[i][V] = Integer.parseInt(temp[3]);
                    infoNumbers[i][E] = Integer.parseInt(temp[4]);
                    infoNumbers[i][D] = Integer.parseInt(temp[5]);
                    infoNumbers[i][GM] = Integer.parseInt(temp[6]);
                    infoNumbers[i][GS] = Integer.parseInt(temp[7]);
                    i++;
                }
            }
            fileInput.close();
        } else {
            System.out.println("Ficheiro não existe com o path especificado");
        }

        return i;

    }

    // CASE 2
    public static void inviteTeam(String[] newTeamString, int[] newTeamNumbers) {

        boolean flag = false;
        int cont = 0;

        do {
            if (cont >= 1) {
                System.out.println("Grupo inválido, pff introduza um Grupo entre A e H: ");
            } else { //Assume-se que outros ficheiros podem conter informação de equipas em grupos diferentes
                System.out.println("Grupo: ");
            }
            newTeamString[Grp] = input.next();
            cont++;
        } while (isNumeric(newTeamString[Grp]));

        cont = 0;
        do {
            if (cont >= 1) {
                System.out.println("Equipa inválida, pff introduza o nome de uma equipa que contenha caracteres alfabéticos");
            } else {
                System.out.println("Equipa: ");
            }
            input.nextLine();   //limpeza de buffer necessária caso a equipa a introduzir tenha mais do que uma palavra
            newTeamString[Team] = input.nextLine();
            cont++;
        } while (isNumeric(newTeamString[Team]));

        cont = 0;
        do {
            if (cont >= 1) {
                System.out.println("Número de Jogos inválido. Nesta fase dos grupos o número de jogos realizados terá de ser igual a 3.");
                System.out.println("Pff introduza um número de jogos válido: ");
            } else {
                System.out.println("Jogos: ");
            }
            newTeamNumbers[J] = input.nextInt();
            cont++;
        } while (newTeamNumbers[J] != MAX_GAMES);

        cont = 0;
        do {
            if (cont >= 1) {
                System.out.println("Soma entre Vitórias, Empates e Derrotas não pode ser diferente do número de jogos realizados.");
            }
            System.out.println("Vitorias: ");
            newTeamNumbers[V] = input.nextInt();
            System.out.println("Empates: ");
            newTeamNumbers[E] = input.nextInt();
            System.out.println("Derrotas: ");
            newTeamNumbers[D] = input.nextInt();

            if (newTeamNumbers[V] + newTeamNumbers[E] + newTeamNumbers[D] == MAX_GAMES) {
                flag = true;
            }
            cont++;
        }
        while (!flag);

        do {
            System.out.println("Golos Marcados (valor positivo ou 0): ");
            newTeamNumbers[GM] = input.nextInt();
        } while (newTeamNumbers[GM] < 0);

        do {
            System.out.println("Golos Sofridos (valor positivo ou 0):");
            newTeamNumbers[GS] = input.nextInt();
        } while (newTeamNumbers[GS] < 0);

    }

    public static boolean teamExist(String[][] infoStrings, int nElements, String[] newTeamString) {

        boolean exist = false;

        String newTeamName = newTeamString[Team];
        for (int i = 0; i < nElements; i++) {
            if (newTeamName.equalsIgnoreCase(infoStrings[i][Team])) {
                exist = true;
            }
        }
        return exist;
    }

    public static boolean isNumeric(String newTeamString) {
        boolean test = false;
        try {
            Double.parseDouble(newTeamString);
            test = true;
        } catch (NumberFormatException e) {
            test = false;
        }
        return test;
    }

    public static boolean groupFullNewTeam(String[][] infoStrings, int nElements, String[] newTeamString) {
        boolean full = false;

        String newTeamGroup = newTeamString[Grp];
        int cont = 0;

        for (int i = 0; i < nElements; i++) {
            for (int j = 0; j < nElements; j++) {
                if (infoStrings[i][Grp].equalsIgnoreCase(infoStrings[j][Grp])) {
                    cont++;
                }
            }
            if (newTeamGroup.equalsIgnoreCase(infoStrings[i][Grp]) && cont == 4) {
                full = true;
            }
            cont = 0;
        }
        return full;
    }

    public static boolean groupNameExceeded(String[] newTeamString) {

        boolean group = false;
        if (newTeamString[Grp].compareToIgnoreCase("H") > 0) {
            group = true;
        }
        return group;
    }

    // CASE 3
    public static boolean calculateTeamPoints(int[][] infoNumbers, int nElements) {

        int points, victories, draws;

        for (int i = 0; i < nElements; i++) {
            victories = infoNumbers[i][V];
            draws = infoNumbers[i][E];
            points = victories * 3 + draws;
            infoNumbers[i][Pts] = points;
            infoNumbers[i][GD] = infoNumbers[i][GM] - infoNumbers[i][GS];
        }

        return true;

    }

    // CASE 4
    public static boolean classifyAndSortTeams(String[][] infoStrings, int[][] infoNumbers, int nElements) throws
            IOException {

        // ordenar primeiro por grupo, depois por maior pontuação, depois por mais golos marcados, depois por menos golos sofridos
        // e por último por ordem alfabética crescente
        for (int i = 0; i < nElements - 1; i++) {
            for (int j = i + 1; j < nElements; j++) {
                if (infoStrings[i][Grp].compareToIgnoreCase(infoStrings[j][Grp]) > 0
                        || infoStrings[i][Grp].compareToIgnoreCase(infoStrings[j][Grp]) == 0 && infoNumbers[i][Pts] < infoNumbers[j][Pts]
                        || infoStrings[i][Grp].compareToIgnoreCase(infoStrings[j][Grp]) == 0 && infoNumbers[i][Pts] == infoNumbers[j][Pts] && infoNumbers[i][GM] < infoNumbers[j][GM]
                        || infoStrings[i][Grp].compareToIgnoreCase(infoStrings[j][Grp]) == 0 && infoNumbers[i][Pts] == infoNumbers[j][Pts] && infoNumbers[i][GM] == infoNumbers[j][GM] && infoNumbers[i][GS] > infoNumbers[j][GS]
                        || infoStrings[i][Grp].compareToIgnoreCase(infoStrings[j][Grp]) == 0 && infoNumbers[i][Pts] == infoNumbers[j][Pts] && infoNumbers[i][GM] == infoNumbers[j][GM] && infoNumbers[i][GS] == infoNumbers[j][GS] && infoStrings[i][Team].compareToIgnoreCase(infoStrings[j][Team]) > 0) {
                    int[] auxNumbers = infoNumbers[i];
                    infoNumbers[i] = infoNumbers[j];
                    infoNumbers[j] = auxNumbers;

                    String[] auxStrings = infoStrings[i];
                    infoStrings[i] = infoStrings[j];
                    infoStrings[j] = auxStrings;
                }
            }
        }

        int k = 0;

        for (int i = 0; i < nElements - 1; i++) {
            if (infoStrings[i][Grp].equalsIgnoreCase(infoStrings[i + 1][Grp])) {
                infoNumbers[i][Pos] = k + 1;
                k++;
            } else {
                infoNumbers[i][Pos] = k + 1;
                k = 0;
            }
            if (i >= nElements - 2) {
                infoNumbers[i + 1][Pos] = k + 1;
            }
        }
        return true;
    }

    // CASE 5
    public static void printClassifications(String[][] infoStrings, int[][] infoNumbers, int nElements) throws
            IOException {

        tableHeader();
        for (int i = 0; i < nElements; i++) {
            printFormatedInfo(infoStrings, infoNumbers, i);
        }
    }


    // CASE 6
    public static void listOnlyScoredMax(String[][] infoStrings, int[][] infoNumbers, int nElements) throws
            IOException {
        int maxScored = infoNumbers[0][GM];

        for (int i = 0; i < nElements; i++) { // varre todas as linhas e guarda o maior valor de golos marcados
            if (infoNumbers[i][GM] > maxScored) {
                maxScored = infoNumbers[i][GM];
            }
        }

        tableHeader();
        for (int i = 0; i < nElements; i++) {
            if (infoNumbers[i][GM] == maxScored) {
                printFormatedInfo(infoStrings, infoNumbers, i);
            }
        }

    }

    // CASE 7
    public static void listOnlySufferedUserInput(String[][] infoStrings, int[][] infoNumbers, int nElements) throws
            IOException {
        System.out.println("Listar as equipas com um determinado número de golos sofridos (definido pelo utilizador)");
        System.out.printf("Introduza número de golos sofridos pretendido: ");
        int userInputSufferedGoals = input.nextInt();
        boolean exists = false;

        for (int i = 0; i < nElements; i++) {
            if (infoNumbers[i][GS] == userInputSufferedGoals) {
                exists = true;
            }
        }

        if (exists) {

            tableHeader();
            for (int i = 0; i < nElements; i++) {
                if (infoNumbers[i][GS] == userInputSufferedGoals) {
                    printFormatedInfo(infoStrings, infoNumbers, i);
                }
            }
        } else {
            System.out.println("Nenhuma equipa com número de golos sofridos igual ao definido.");
        }

    }

    // CASE 8
    public static void listTeamsMoreSufferedThanScored(String[][] infoStrings, int[][] infoNumbers, int nElements) throws
            IOException {

        for (int i = 0; i < nElements - 1; i++) {
            for (int j = i + 1; j < nElements; j++) {       //ordenação alfabética das esquipas
                if (infoStrings[i][Team].compareToIgnoreCase(infoStrings[j][Team]) > 0) {
                    int[] auxNumbers = infoNumbers[i];
                    infoNumbers[i] = infoNumbers[j];
                    infoNumbers[j] = auxNumbers;

                    String[] auxStrings = infoStrings[i];
                    infoStrings[i] = infoStrings[j];
                    infoStrings[j] = auxStrings;
                }
            }
        }

        tableHeader();
        for (int i = 0; i < nElements; i++) {
            if (infoNumbers[i][GD] < 0) {
                printFormatedInfo(infoStrings, infoNumbers, i);
            }
        }
    }

    // CASE 9
    public static void listFirstTeamEachGroup(String[][] infoStrings, int[][] infoNumbers, int nElements) throws
            IOException {

        tableHeader();
        for (int i = 0; i < nElements; i++) {
            if (infoNumbers[i][Pos] == 1) {
                printFormatedInfo(infoStrings, infoNumbers, i);
            }
        }
    }

    // CASE 10
    public static void listFullTeamInfo(String[][] infoStrings, int[][] infoNumbers, int nElements) throws
            IOException {

        System.out.println("Listar informação completa de uma equipa (definida pelo utilizador)");
        System.out.println("Introduza o nome da equipa pretendida: ");
        String userInputTeam = input.next();
        boolean exists = false;

        for (int i = 0; i < nElements; i++) {
            if (infoStrings[i][Team].equalsIgnoreCase(userInputTeam)) {
                exists = true;
            }
        }

        if (!exists) {
            System.out.println("Equipa inválida.");
        } else {
            tableHeader();
            for (int i = 0; i < nElements; i++) {
                if (infoStrings[i][Team].equalsIgnoreCase(userInputTeam)) {
                    printFormatedInfo(infoStrings, infoNumbers, i);
                }
            }
        }
    }

    // CASE 11
    public static void printStatistics(int[][] infoNumbers, int nElements, String[] statistics) {
        int totalGames = 0, totalVictories = 0, totalDraws = 0, totalLoses = 0, totalScored = 0, totalSuffered = 0;
        double meanScoredPerGame = 0, meanSufferedPerGame = 0;

        for (int i = 0; i < nElements; i++) {
            totalVictories += infoNumbers[i][V];
            totalDraws += infoNumbers[i][E];
            totalLoses += infoNumbers[i][D];
            totalScored += infoNumbers[i][GM];
            totalSuffered += infoNumbers[i][GS];
        }

        totalDraws = totalDraws / 2;                //total de empates é repetido para as 2 equipas que empataram entre si
        totalGames = totalVictories + totalDraws;   //total de jogos pode também ser calculado somando o total de derrotas e empates
        meanScoredPerGame = (double) totalScored / totalGames;
        meanSufferedPerGame = (double) totalSuffered / totalGames;

        statistics[J] = Integer.toString(totalGames);
        statistics[V] = Integer.toString(totalVictories);
        statistics[E] = Integer.toString(totalDraws);
        statistics[D] = Integer.toString(totalLoses);
        statistics[GM] = Integer.toString(totalScored);
        statistics[GS] = Integer.toString(totalSuffered);
        statistics[Pts] = Double.toString(meanScoredPerGame);
        statistics[Pos] = Double.toString(meanSufferedPerGame);
    }

    public static void exportFileStatistics(String[] statistics) throws FileNotFoundException {

        File exportFile = new File("Statistics.txt");
        PrintWriter printWriter = new PrintWriter(exportFile);

        printWriter.printf("Total de jogos=%s%n" +
                "Total de vitórias=%s%n" +
                "Total de empates=%s%n" +
                "Total de derrotas=%s%n" +
                "Total de golos marcados=%s%n" +
                "Total de golos sofridos=%s%n" +
                "Média de golos marcados por jogo=%.1f%n" +
                "Média de golos sofridos por jogo=%.1f%n",
                statistics[J], statistics[V], statistics[E], statistics[D], statistics[GM], statistics[GS],
                Double.parseDouble(statistics[Pts]), Double.parseDouble(statistics[Pos]));
        printWriter.close();

    }

    // CASE 12
    public static int removeFromNextPhase(String[][] infoStrings, int[][] infoNumbers, int nElements, String[][]
            infoStringsFinalStage, int[][] infoNumbersFinalStage) throws
            IOException {

        classifyAndSortTeams(infoStrings, infoNumbers, nElements); //ordenação das equipas

        int cont = 0;
        int j = 0;
        while (j < nElements) {
            if (infoNumbers[j][Pos] > 0 && infoNumbers[j][Pos] <= 2) {
                infoNumbersFinalStage[cont] = infoNumbers[j];   //copia a informação da equipa do array de integers principal para o novo array
                infoStringsFinalStage[cont] = infoStrings[j];   //copia a informação da equipa do array de strings principal para o novo array
                cont++;
            }
            j++;
        }

        infoNumbers = infoNumbersFinalStage;    //confere à variável o índice para o novo array de integers
        infoStrings = infoStringsFinalStage;    //confere à variável o índice para o novo array de strings

        return cont;
    }


    //CASE 13
    public static void exportToCSVFile(String[][] infoStrings, int[][] infoNumbers, int nElements) throws
            IOException {

        File pathName = new File("FinalStage.csv");
        PrintWriter printWriter = new PrintWriter(pathName);

        for (int i = 0; i < nElements; i++) {
            if (infoNumbers[i] != null && infoStrings[i] != null) {
                printWriter.printf("%s,%d,%s,%d\n", infoStrings[i][Grp], infoNumbers[i][Pos], infoStrings[i][Team], infoNumbers[i][Pts]);
            }
        }
        printWriter.close();

    }

    // CASE 14
    public static void createNewFileFinalPhase(String[][] infoStrings, int[][] infoNumbers, int nElementos) throws
            IOException {

        File pathName = new File("FinalStageGames.txt");
        PrintWriter printWriter = new PrintWriter(pathName);

        for (int i = 0; i < nElementos; i += 4) {
            printWriter.printf("%s,%d,%s - %s,%d,%s\n", infoStrings[i][Grp], infoNumbers[i][Pos], infoStrings[i][Team], infoStrings[i + 3][Grp], infoNumbers[i + 3][Pos], infoStrings[i + 3][Team]);
            printWriter.printf("%s,%d,%s - %s,%d,%s\n", infoStrings[i + 1][Grp], infoNumbers[i + 1][Pos], infoStrings[i + 1][Team], infoStrings[i + 2][Grp], infoNumbers[i + 2][Pos], infoStrings[i + 2][Team]);
        }
        printWriter.close();
    }
}