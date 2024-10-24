package stack;

import java.util.Scanner;
import java.util.Stack;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> pilha = new Stack<>();

        while (true){
            System.out.println("Digite um comando \nou 'desfazer' para desfazer o último comando\ne 'sair' para encerrar:");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("desfazer")) {
                if (!pilha.isEmpty()) {
                    String undoneCommand = pilha.pop();
                    System.out.println("Desfeito: " + undoneCommand);
                } else {
                    System.out.println("Nenhum comando para desfazer.");
                }
            } else if (input.equalsIgnoreCase("sair")) {
                break;
            } else {
                pilha.push(input);
                System.out.println("Comando inserido: " + input);
            }
        }
        }
    }

