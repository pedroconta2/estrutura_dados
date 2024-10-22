package stack;

import java.util.Scanner;
import java.util.Stack;

public class Exercicio4 {
    private static int verificaOperador(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Divisão por zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operator);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma expressão matemática");
        String input = sc.nextLine();

        String[] vetor = input.split(" ");

        Stack<Integer> pilha = new Stack<>();

        for (String s : vetor) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int i = pilha.pop();
                int j = pilha.pop();

                int resultado = verificaOperador(i,j,s);
                pilha.push(resultado);
            } else {
                pilha.push(Integer.parseInt(s));
            }
        }

        int resultadoFinal = pilha.pop();

        System.out.println("Resultado final: "+ resultadoFinal);
    }
}
