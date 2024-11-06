package atividade_pilha_fila.codigo2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        ListaLigada ll = new ListaLigada();

        while (true) {

            System.out.println("================================================");
            System.out.println("             LISTA LIGADA TIPO I");
            System.out.println("================================================");
            System.out.println("0 - encerrar");
            System.out.println("1 - inserir elemento");
            System.out.println("2 - extrair elemento");
            System.out.println("");
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
                if (ll.push(e)){
                    System.out.println("Elemento inserido com sucesso!!");
                }
                else{
                    System.out.println("*** Falha na insercao do elemento!! ***");
                }
            }
            else if (opc == 2){
                Elemento e = ll.pop();
                if (e==null){
                    System.out.println("A Lista esta' vazia!!");
                }
                else{
                    System.out.println("O elemento foi removido com sucesso.");
                    System.out.print("\nNome ---> " + e.getNome());
                    System.out.print("\nNumero -> " + e.getNumero());
                }
            }
        }

    }

}
