package vetor;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;


public class Exercico3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // Criando vetor e adicionando valores aleatórios
        int[] vetor = new int[random.nextInt(100)];

        for(int i = 0; i < vetor.length; i++){
            vetor[i]= random.nextInt(-100,100);
        }

        boolean mn = true;

        while(mn){
            System.out.println("\nMenu:");
            System.out.println("1. Apresentar o tamanho do vetor");
            System.out.println("2. Ordenar o vetor em ordem crescente");
            System.out.println("3. Verificar se existe um número específico no vetor");
            System.out.println("4. Apresentar quantos números pares e ímpares estão no vetor");
            System.out.println("5. Apresentar todos os valores do vetor");
            System.out.println("6. Apresentar a soma e a média dos valores do vetor");
            System.out.println("7. Criar um novo vetor com os valores ao contrário");
            System.out.println("8. Criar um novo vetor de tamanho e valor informados pelo usuário");
            System.out.println("9. Encerrar o programa");
            System.out.print("Escolha uma opção: \n");
            int opc = sc.nextInt();

            switch(opc){
                case 1:
                    System.out.println("O tamanho do vetor é: " + vetor.length);
                    break;
                case 2:
                    Arrays.sort(vetor);
                    System.out.println("Vetor ordenado:" + Arrays.toString(vetor));
                    break;
                case 3:
                    System.out.println("Digite um numero para verificar se está presente no vetor:");
                    int n = sc.nextInt();
                    boolean estaPresente = false;

                    for(int numero: vetor){
                        estaPresente = numero == n;
                    }

                    System.out.println(estaPresente ? "O numero foi encontrado" : "O numero não foi encontrado");
                case 4:
                    int par = 0;
                    int impar = 0;

                    for (int numero: vetor){
                        if (numero % 2 == 0){
                            par++;
                        } else {
                            impar++;
                        }
                    }
                    System.out.println("Quantidade de numeros pares: " + par +
                    "\nQuantidade de numeros impares: " + impar);
                    break;
                case 5:
                    System.out.println(Arrays.toString(vetor));
                    break;
                case 6:
                    System.out.println("Soma dos valores: " + Arrays.stream(vetor).sum() +
                            "\nMédia dos valores: " + Arrays.stream(vetor).average());
                    break;
                case 7:
                    int[] vetorClone = new int[vetor.length];
                    int j = 0;
                    for(int i = vetor.length; i != 0; i--){
                        vetorClone[j] = vetor[i-1];
                        j++;
                    }
                    System.out.println("Vetor invertido: " + Arrays.toString(vetorClone));
                    break;
                case 8:
                    System.out.print("Informe o tamanho do novo vetor: ");
                    int tamanho = sc.nextInt();
                    int[] novoVetor = new int[tamanho];
                    for (int i = 0; i < tamanho; i++) {
                        System.out.print("Informe o valor para o índice " + i + ": ");
                        novoVetor[i] = sc.nextInt();
                    }
                    System.out.println("Novo vetor criado: " + Arrays.toString(novoVetor));
                    break;

                case 9:
                    mn = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        System.out.println("Encerrando o programa!");
    }
}
