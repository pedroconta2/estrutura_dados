package atividade_pilha_fila.codigo1;

public class ListaLigada {

    private Elemento inicio;

    //Adiciona um elemento no final da fila
    public boolean enqueue(Elemento e) {

        try {
            if (isEmpty()) {
                inicio = e;
            } else {
                Elemento fim = getFim();
                fim.setProximo(e);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    //Remove e retorna o elemento no inicio da fila
    public Elemento dequeue() {

        if (inicio == null) {
            return null;
        }

        Elemento e = inicio;
        inicio = e.getProximo();
        e.setProximo(null);
        return e;

    }

    //Retorna o elemento inicial
    public Elemento getInicio() {
        return inicio;
    }

    /**
     * Percorre a lista ate' encontrar o ultimo elemento. Este metodo e'
     * necessario neste caso pois nao ha' ponteiro para o final.
     *
     * @return
     */
    public Elemento getFim() {
        if (isEmpty()) {
            return inicio;
        }
        Elemento e = inicio;
        while (e.getProximo() != null) {
            e = e.getProximo();
        }
        return e;
    }

    //Verifica se a lista está vazia
    public boolean isEmpty() {
        return inicio == null;
    }
}
