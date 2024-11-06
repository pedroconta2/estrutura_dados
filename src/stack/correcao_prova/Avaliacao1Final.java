package stack.correcao_prova;

import java.util.Scanner;

public class Avaliacao1Final {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Inicializa o Scanner para leitura de entrada
        boolean permitirRepetidos = true; // Flag para permitir ou não URLs duplicadas
        int opcMenu; // Variável para armazenar a opção do menu escolhida
        // Menu de opções disponíveis
        String menu = "==== Menu ====\n" +
                "1. Navegar por novas páginas\n" +
                "2. Voltar na página anterior\n" +
                "3. Visualizar histórico\n" +
                "4. Quantidade de páginas armazenadas no histórico\n" +
                "5. Última página acessada\n" +
                "6. Página específica do histórico\n" +
                "0. Sair";

        try {
            System.out.println("Quantos URLs você deseja armazenar?");
            int tamanho = sc.nextInt(); // Lê o número máximo de URLs a serem armazenadas
            PilhaAvalFinal<String> historico = new PilhaAvalFinal<>(tamanho); // Cria uma nova pilha para o histórico

            System.out.println("Você permite URLs repetidos no seu histórico? (S/N)");
            String resposta = sc.next(); // Lê a resposta do usuário
            // Verifica se o usuário não permite URLs duplicadas
            if (resposta.equalsIgnoreCase("N")) {
                permitirRepetidos = false;
            }

            do {
                System.out.println(menu); // Exibe o menu de opções
                opcMenu = sc.nextInt(); // Lê a opção escolhida pelo usuário

                switch (opcMenu) {
                    case 1:
                        System.out.println("Digite a URL que deseja acessar:");
                        String url = sc.next(); // Lê a URL a ser acessada
                        // Adiciona a URL ao histórico se permitir ou se não for duplicada
                        if (permitirRepetidos || !historico.toString().contains(url)) {
                            historico.push(url);
                            System.out.println("URL " + url + " adicionada ao histórico.");
                        } else {
                            System.out.println("URL já existe no histórico. Tente acessar outra URL.");
                        }
                        break;
                    case 2:
                        String urlAnterior = historico.pop(); // Remove a última URL acessada
                        if (urlAnterior != null) {
                            System.out.println("Voltando para a página anterior: " + urlAnterior);
                        }
                        break;
                    case 3:
                        System.out.println("Histórico de páginas:\n" + historico); // Exibe todo o histórico
                        break;
                    case 4:
                        System.out.println("Quantidade de páginas no histórico: " + historico.size()); // Mostra o número de URLs armazenadas
                        break;
                    case 5:
                        String ultimaPagina = historico.pick(); // Obtém a última URL acessada
                        if (ultimaPagina != null) {
                            System.out.println("Última página acessada: " + ultimaPagina);
                        }
                        break;
                    case 6:
                        System.out.println("Digite o número da página que deseja visualizar (A primeira começa no 0):");
                        int index = sc.nextInt(); // Lê o índice da página desejada
                        // Verifica se o índice está dentro do intervalo válido
                        if (index >= 0 && index < historico.size()) {
                            System.out.println("Página " + index + ": " + historico.toString().split("\n")[index]);
                        } else {
                            System.out.println("Índice inválido. Tente um número entre 0 e " + (historico.size() - 1) + ".");
                        }
                        break;
                    case 0:
                        System.out.println("Encerrando o programa. Obrigado por usar!"); // Mensagem de encerramento
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção válida do menu."); // Mensagem de erro para opções inválidas
                }
            } while (opcMenu != 0); // Continua até que o usuário escolha sair

        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage()); // Captura e exibe erros
        } finally {
            sc.close(); // Fechando o Scanner para evitar vazamentos de recursos
        }
    }
}
