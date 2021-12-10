/*
modularização
B - Gráfico de classificações
Faça um programa que represente sob a forma de gráficos de barras, o número de positivas
e negativas dos alunos de uma turma a um conjunto de disciplinas.
O programa deverá começar por pedir o nº de alunos da turma e o nº de disciplinas e
para cada disciplina pedirá o nome da disciplina e o nº de alunos aprovados.
Deve implementar um módulo para imprimir a informação de uma disciplina.
O output produzido deverá ter o seguinte aspeto:

Disciplina: Portugues
- Positivas: ****************
- Negativas: ****
Disciplina: Matematica
- Positivas: ***********
- Negativas: *********


Exemplo:
Entrada
Saída
10
2
Portugues
6
Matematica
7

Disciplina: Portugues
- Positivas: ******
- Negativas: ****
Disciplina: Matematica
- Positivas: *******
- Negativas: ***
*/


import java.util.Scanner;

public class ExB_Grafico_Classificacoes {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int nAlunos, nDisciplinas, nPositivas, nNegativas, i, j;
        String disciplina, positivasS, negativasS;

        nAlunos = ler.nextInt();
        nDisciplinas = ler.nextInt();
        ler.nextLine();

        for (i = 0; i < nDisciplinas; i++) {
            disciplina = ler.nextLine();
            nPositivas = ler.nextInt();
            ler.nextLine();
            nNegativas = nAlunos - nPositivas;
            imprimirInformacao(disciplina, nPositivas, nNegativas);
        }
    }


    public static void imprimirInformacao(String disciplina, int nPositivas, int nNegativas) {
        String string1 = "", string2 = "";
        int i;

        for (i = 0; i < nPositivas; i++){
            string1 += '*';
        }
        for (i = 0; i < nNegativas; i++){
            string2 += '*';
        }
        System.out.println("Disciplina: " + disciplina);
        System.out.println("- Positivas: " + string1);
        System.out.println("- Negativas: " + string2);

    }
}

