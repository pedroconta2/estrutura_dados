package atividade_pilha_fila.codigo2;

//Pilha
public class ListaLigada {

    private Elemento inicio;

    //Adiciona um elemento na pilha
    public boolean push(Elemento e) {

        try {
            e.setProximo(inicio);
            inicio = e;
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    // Remove e retorna o ultimo elemento da pilha
    public Elemento pop() {

        if (inicio == null) {
            return null;
        }

        Elemento e = inicio;
        inicio = e.getProximo();
        e.setProximo(null);
        return e;

    }

}
