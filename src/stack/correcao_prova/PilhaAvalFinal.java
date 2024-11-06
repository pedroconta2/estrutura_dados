package stack.correcao_prova;

import java.util.Arrays;
import java.util.Objects;

// Classe que representa uma pilha genérica com controle de tamanho
class PilhaAvalFinal<T> {
    private Object[] elements; // Array para armazenar os elementos da pilha
    private int last;          // Índice do último elemento adicionado
    private int size;          // Capacidade máxima da pilha

    // Construtor da classe que inicializa a pilha com um tamanho específico
    public PilhaAvalFinal(int size) {
        this.size = size; // Define a capacidade da pilha
        this.elements = new Object[size]; // Cria o array para armazenar os elementos
        this.last = -1; // Inicializa o índice como -1, indicando que a pilha está vazia
    }

    // Método para adicionar um novo elemento na pilha
    public void push(T element) {
        // Verifica se há espaço na pilha
        if (last + 1 >= size) {
            System.out.println("Não é possível adicionar mais URLs. O histórico está cheio.");
            return; // Sai do método se a pilha estiver cheia
        }
        elements[++last] = element; // Adiciona o elemento e incrementa o índice
    }

    // Método que retorna o último elemento e o remove da pilha
    public T pop() {
        // Verifica se a pilha está vazia
        if (last < 0) {
            System.out.println("Histórico está vazio. Não há páginas para voltar.");
            return null; // Retorna null se não houver elementos para remover
        }
        T element = (T) elements[last]; // Obtém o último elemento
        elements[last--] = null; // Limpa a referência do elemento removido e decrementa o índice
        return element; // Retorna o elemento removido
    }

    // Método que retorna o último elemento da pilha sem removê-lo
    public T pick() {
        // Verifica se a pilha está vazia
        if (last < 0) {
            System.out.println("Histórico está vazio. Não há páginas acessadas.");
            return null; // Retorna null se não houver elementos
        }
        return (T) elements[last]; // Retorna o último elemento
    }

    // Método que verifica se a pilha está vazia
    public boolean isEmpty() {
        return last < 0; // Retorna true se não houver elementos na pilha
    }

    // Método que retorna a quantidade de elementos na pilha
    public int size() {
        return last + 1; // Retorna o número de elementos armazenados
    }

    // Método que transforma a pilha em uma representação de string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Usado para construir a string de saída
        for (int i = 0; i <= last; i++) {
            sb.append(i).append(" - ").append(elements[i]).append("\n"); // Adiciona cada elemento com seu índice
        }
        return sb.toString(); // Retorna a string formatada
    }

    // Método que verifica se duas pilhas são iguais
    @Override
    public boolean equals(Object object) {
        if (this == object) return true; // Verifica se são o mesmo objeto
        if (!(object instanceof PilhaAvalFinal<?> pilhaAval)) return false; // Verifica se o objeto é uma instância de PilhaAvalFinal
        // Compara o estado das pilhas
        return last == pilhaAval.last && size == pilhaAval.size && Arrays.equals(elements, pilhaAval.elements);
    }

    // Método que gera um código hash para a pilha
    @Override
    public int hashCode() {
        int result = Objects.hash(last, size); // Gera um hash baseado em last e size
        result = 31 * result + Arrays.hashCode(elements); // Inclui o hash dos elementos
        return result; // Retorna o código hash gerado
    }
}