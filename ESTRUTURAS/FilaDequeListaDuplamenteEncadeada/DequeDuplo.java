package FilaDequeListaDuplamenteEncadeada;

public class DequeDuplo {
    private No inicio = null;
    private No fim = null;

    // Inserir na frente
    public void enfileirarFrente(Object x) {
        No novo = new No(x);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
    }

    // Inserir no fim
    public void enfileirarFim(Object x) {
        No novo = new No(x);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
    }

    // Remover da frente
    public void deletarFrente() {
        if (inicio == null) {
            System.out.println("Deque vazio!");
        } else {
            System.out.println("Valor deletado da frente: " + inicio.getElemento());
            inicio = inicio.getProximo();
            if (inicio != null) {
                inicio.setAnterior(null);
            } else {
                fim = null;
            }
        }
    }

    // Remover do fim
    public void deletarFim() {
        if (fim == null) {
            System.out.println("Deque vazio!");
        } else {
            System.out.println("Valor deletado do fim: " + fim.getElemento());
            fim = fim.getAnterior();
            if (fim != null) {
                fim.setProximo(null);
            } else {
                inicio = null;
            }
        }
    }

    // Mostrar todos os elementos
    public void mostrarDeque() {
        if (inicio == null) {
            System.out.println("Deque vazio!");
            return;
        }
        System.out.print("Deque: ");
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
