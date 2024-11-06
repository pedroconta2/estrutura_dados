package atividade_pilha_fila.codigo2;

public class Elemento {

    public Elemento(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.proximo = null;
    }

    private String nome;
    private int numero;
    private Elemento proximo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Elemento getProximo() {
        return proximo;
    }

    public void setProximo(Elemento proximo) {
        this.proximo = proximo;
    }

}
