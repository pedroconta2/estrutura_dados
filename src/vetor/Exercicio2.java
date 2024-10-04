package vetor;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitação da quantidade de alunos a serem cadastrados
        System.out.print("Digite a quantidade de alunos a serem cadastrados: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Vetor para armazenar os nomes e as notas
        String[] nomes = new String[n];
        double[][] notas = new double[n][4];

        // For de cadastro dos alunos e suas notas
        for (int i = 0; i < n; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = sc.nextLine();

            // Cadastro das notas
            for (int j = 0; j < 4; j++) {
                double nota;
                do {
                    System.out.print("Digite a nota " + (j + 1) + " do aluno " + nomes[i] + ": ");
                    nota = sc.nextDouble();
                    if (nota < 0 || nota > 100) {
                        System.out.println("Nota inválida! A nota deve estar entre 0 e 100. Tente novamente.");
                    }
                } while (nota < 0 || nota > 100);
                notas[i][j] = nota; // Armazena a nota válida
            }
            sc.nextLine();
        }

        // Cálculo e exibição das informações de cada aluno
        for (int i = 0; i < n; i++) {
            double maiorNota = notas[i][0];
            double menorNota = notas[i][0];
            double somaNotas = 0;

            // Calcular a maior, menor nota e soma das notas
            for (int j = 0; j < 4; j++) {
                if (notas[i][j] > maiorNota) {
                    maiorNota = notas[i][j];
                }
                if (notas[i][j] < menorNota) {
                    menorNota = notas[i][j];
                }
                somaNotas += notas[i][j];
            }

            double mediaNotas = somaNotas / 4; // Cálculo da média

            // Resultados
            System.out.println("Aluno: " + nomes[i]);
            System.out.println("Maior nota: " + maiorNota);
            System.out.println("Menor nota: " + menorNota);
            System.out.printf("Média das notas: %.2f%n", mediaNotas);
            System.out.println("\n");
        }
    }
}
