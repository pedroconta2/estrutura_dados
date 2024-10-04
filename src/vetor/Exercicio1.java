package vetor;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Solicitação da quantidade de pessoas para serem cadastradas
        System.out.print("Digite a quantidade de pessoas a serem cadastradas: ");
        int n = sc.nextInt();

        // Cria um vetor de armazenamento de idades
        int[] idades = new int[n];

        // Cadastrar as idades
        for (int i = 0; i < n; i++) {
            System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
            idades[i] = sc.nextInt();
        }

        // Contadores
        int menoresDe18 = 0;
        int entre18e59 = 0;
        int maioresOuIguais60 = 0;

        // Verificação das idades
        for (int idade : idades) {
            if (idade < 18) { // Pessoas menores de 18 anos
                menoresDe18++;
            } else if (idade >= 18 && idade < 60) { // Pessoas entre 18 e 59 anos
                entre18e59++;
            } else { // Pessoas com 60 anos ou mais
                maioresOuIguais60++;
            }
        }

        // Resultados
        System.out.println("Quantidade de pessoas menores de 18 anos: " + menoresDe18);
        System.out.println("Quantidade de pessoas entre 18 e 59 anos: " + entre18e59);
        System.out.println("Quantidade de pessoas com 60 anos ou mais: " + maioresOuIguais60);
    }
}
