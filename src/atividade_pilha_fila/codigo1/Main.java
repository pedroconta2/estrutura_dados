package atividade_pilha_fila.codigo1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        ListaLigada ll = new ListaLigada();

        while (true) {
            try {
                System.out.println("\n\n================================================");
                System.out.println("             LISTA LIGADA TIPO II");
                System.out.println("================================================");
                System.out.println("0 - encerrar");
                System.out.println("1 - inserir elemento (no final)");
                System.out.println("2 - extrair elemento (do inicio)");
                System.out.println("3 - imprimir elementos da lista (sentido inicio -> fim)");
                System.out.println("4 - localizar um elemento dado seu numero (primeira ocorrencia)");
                System.out.println("5 - inserir um elemento em determinada posicao");
                System.out.println("6 - remover um elemento de determinada posicao");
                System.out.print("Opcao -> ");
                int opc = scn.nextInt();

                if (opc == 0) {
                    break;
                } else if (opc == 1) {
                    System.out.print("Nome do elemento -> ");
                    String nm = scn.next();
                    System.out.print("Numero do elemento -> ");
                    int nr = scn.nextInt();
                    Elemento e = new Elemento(nm, nr);
                    if (ll.enqueue(e)) {
                        System.out.println("Elemento inserido com sucesso!!");
                    } else {
                        System.out.println("*** Falha na insercao do elemento!! ***");
                    }
                } else if (opc == 2) {
                    Elemento e = ll.dequeue();
                    if (e == null) {
                        System.out.println("A Lista esta' vazia!!");
                    } else {
                        System.out.println("O elemento foi removido da fila com sucesso.");
                        System.out.print("\nNome ---> " + e.getNome());
                        System.out.print("\nNumero -> " + e.getNumero());
                    }
                } else if (opc == 3) {
                    System.out.println("Elementos da fila:");
                    System.out.println("--------------------------------------------");
                    if (ll.isEmpty()) {
                        System.out.println("A fila esta' vazia.");
                    } else {
                        Elemento e = ll.getInicio();
                        while (e != null) {
                            System.out.println(e.getNumero() + " | " + e.getNome());
                            e = e.getProximo();
                        }
                    }
                } else if (opc == 4) {
                    System.out.print("Digite o numero do elemento -> ");
                    int nr = scn.nextInt();
                    Elemento e = ll.getInicio();
                    boolean encontrado = false;
                    while (e != null) {
                        if (e.getNumero() == nr) {
                            System.out.println("Elemento encontrado: " + e.getNome() + " | " + e.getNumero());
                            encontrado = true;
                            break;
                        }
                        e = e.getProximo();
                    }
                    if (!encontrado) {
                        System.out.println("Elemento nao encontrado!");
                    }
                } else if (opc == 5) {
                    System.out.print("Nome do elemento -> ");
                    String nm = scn.next();
                    System.out.print("Numero do elemento -> ");
                    int nr = scn.nextInt();
                    System.out.print("Posicao -> ");
                    int posicao = scn.nextInt();
                    Elemento novoElemento = new Elemento(nm, nr);

                    if (posicao == 0) {
                        novoElemento.setProximo(ll.getInicio());
                        ll.enqueue(novoElemento); // Insere no início
                    } else {
                        Elemento atual = ll.getInicio();
                        for (int i = 0; i < posicao - 1 && atual != null; i++) {
                            atual = atual.getProximo();
                        }
                        if (atual == null) {
                            System.out.println("*** Falha: posicao invalida! ***");
                        } else {
                            novoElemento.setProximo(atual.getProximo());
                            atual.setProximo(novoElemento);
                            System.out.println("Elemento inserido com sucesso na posicao " + posicao + "!");
                        }
                    }
                } else if (opc == 6) {
                    System.out.print("Posicao do elemento a ser removido -> ");
                    int posicao = scn.nextInt();

                    if (posicao == 0 && !ll.isEmpty()) {
                        ll.dequeue();
                        System.out.println("Elemento removido com sucesso da posicao " + posicao + "!");
                    } else {
                        Elemento atual = ll.getInicio();
                        for (int i = 0; i < posicao - 1 && atual != null; i++) {
                            atual = atual.getProximo();
                        }
                        if (atual == null || atual.getProximo() == null) {
                            System.out.println("*** Falha: posicao invalida! ***");
                        } else {
                            atual.setProximo(atual.getProximo().getProximo());
                            System.out.println("Elemento removido com sucesso da posicao " + posicao + "!");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                scn.nextLine(); // Limpa o buffer do scanner caso haja erro de entrada
            }
        }
        scn.close();
    }
}

