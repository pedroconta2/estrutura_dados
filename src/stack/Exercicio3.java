package stack;

import java.util.Scanner;
import java.util.Stack;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma palavra:");
        String input = sc.nextLine();

        Stack<Character> pilha = new Stack<Character>();

        for (char letra : input.toCharArray()){
            pilha.push(letra);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while(!pilha.isEmpty()){
            stringBuilder.append(pilha.pop());
        }

        System.out.println("Palavra invertida: " + stringBuilder);

    }
}
