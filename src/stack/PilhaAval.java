package stack;


import java.util.Arrays;
import java.util.Objects;

public class PilhaAval<T> {
    private Object[] elements;
    private int last;
    private int size;

    public PilhaAval(int size){
        this.size = size;
        this.elements = new Object[size];
        this.last = -1;
    }

    public void push(T element){
        if (last + 1 >= size){
            System.out.println("Não entrar em mais nenhum site");
            return;
        }
        elements[++last] = element;
    }

    public T pop(){
        if (last < 0){
            System.out.println("Histórico está vazio");
            return null;
        }
        T element = (T) elements[last];
        elements[last--] = null;
        return element;
    }

    public T pick(){
        if (last < 0){
            System.out.println("Histórico está vazio");
            return null;
        }
        return (T) elements[last];
    }

    public boolean isEmpty(){
        return last < 0;
    }

    public int size(){
        return last + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= last; i++) {
            sb.append("").append(i).append(" - ").append(elements[i]).append("\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof PilhaAval<?> pilhaAval)) return false;
        return last == pilhaAval.last && size == pilhaAval.size && Arrays.equals(elements, pilhaAval.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(last, size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}
