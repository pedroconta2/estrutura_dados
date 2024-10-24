package stack;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Avaliacao1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repetidos = true;
        int opc = 9;
        String menu = "====Menu====\n" +
                "1. Navegar por novas páginas\n" +
                "2. Voltar na página anterior\n"+
                "3. Visualizar histórioco\n" +
                "4. Quantidade de páginas armazenadas no histórico\n" +
                "5. Ultima página acessada\n" +
                "6. Página específica do histórico";

        System.out.println("Quantos URLs você deseja armazenar?");
        int tamanho = sc.nextInt();

        PilhaAval<String> historico = new PilhaAval<>(tamanho);

        System.out.println("Você permite URLs repetidos no seu histórico (S/N)");
        String permitirRepetidos  = sc.next();

        if(permitirRepetidos.toLowerCase().equals("n"))
            repetidos = false;

        do{
            System.out.println(menu);
            int opcMenu = sc.nextInt();

            switch (opcMenu){
                case 1:
                    System.out.println("Digite a URL que deseja acessar:");
                    String url = sc.next();
                    if (repetidos || !historico.toString().contains(url)) {
                        historico.push(url);
                    } else {
                        System.out.println("URL já existe no histórico.");
                    }
                    break;
                case 2:
                    System.out.println("Voltando para a página anterior: " + historico.pop());
                    break;
                case 3:
                    System.out.println("Histórico de páginas:\n"
                            + historico);
                    break;
                case 4:
                    System.out.println("Quantidade de páginas no histórico: " + historico.size());
                    break;
                case 5:
                    System.out.println("Última página acessada: " + historico.pick());
                    break;
                case 6:
                    System.out.println("Digite o número da página que deseja visualizar (A primeira começa no 0):");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index >= 0 && index < historico.size()) {
                        System.out.println("Página " + index + ": " + historico.toString().split("\n")[index]);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(opc != 0);
        System.out.println("Encerrando!");

    }
}
