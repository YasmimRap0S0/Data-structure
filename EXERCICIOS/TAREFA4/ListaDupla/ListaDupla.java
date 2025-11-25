package EXERCICIOS.TAREFA4.Lista2Encadeada;


public class ListaDupla {
    private No inicio;
    private No fim;
    private int tam = 0;


    public int size() {
        return tam;
    }


    public boolean isEmpty() {
        return tam == 0;
    }


    public Object first() {
        if (isEmpty()) throw new ErrorLista("Lista tá vazia");
        System.out.println("Elemento first é " + inicio.getElemento());
        mostrar();
        return inicio.getElemento();
    }


    public Object last() {
        if (isEmpty()) throw new ErrorLista("Lista tá vazia");
        System.out.println("Elemento last é " + fim.getElemento());
        mostrar();
        return fim.getElemento();
    }


    public Object before(int r) {
        No atual = inicio;
        for (int i = 0; i < r; i++) {
            atual = atual.getProximo();
        }
        if (atual.getAnterior() == null) throw new ErrorLista("Não tem elemento anterior");
        System.out.println("Elemento anterior ao índice " + r + " é " + atual.getAnterior().getElemento());
        mostrar();
        return atual.getAnterior().getElemento();
    }


    public Object after(int r) {
        No atual = inicio;
        for (int i = 0; i < r; i++) {
            atual = atual.getProximo();
        }
        if (atual.getProximo() == null) throw new ErrorLista("Sem elemento seguinte");
        System.out.println("Elemento posterior ao índice " + r + " é " + atual.getProximo().getElemento());
        mostrar();
        return atual.getProximo().getElemento();
    }


    public Object replaceElement(int r, Object o) {
        No atual = inicio;
        for (int i = 0; i < r; i++) {
            atual = atual.getProximo();
        }
        Object antigo = atual.getElemento();
        atual.setElemento(o);
        System.out.println("Troca elemento " + antigo + " por " + o);
        mostrar();
        return antigo;
    }


    public void swapElements(int a, int b) {
        No noA = inicio;
        No noB = inicio;
        for (int i = 0; i < a; i++) noA = noA.getProximo();
        for (int i = 0; i < b; i++) noB = noB.getProximo();
        Object temp = noA.getElemento();
        noA.setElemento(noB.getElemento());
        noB.setElemento(temp);
        System.out.println("Trocando posição dos elementos " + noA.getElemento() + " e " + noB.getElemento());
        mostrar();
    }


    public void insertBefore(int r, Object o) {
        System.out.println("Antes do insertBefore:");
        mostrar();
        No atual = inicio;
        for (int i = 0; i < r; i++) {
            atual = atual.getProximo();
        }
        No novo = new No(o);
        novo.setProximo(atual);
        novo.setAnterior(atual.getAnterior());


        if (atual.getAnterior() != null) {
            atual.getAnterior().setProximo(novo);
        } else {
            inicio = novo;
        }


        atual.setAnterior(novo);
        tam++;
        System.out.println("insertBefore: " + o);
        mostrar();
    }


    public void insertAfter(int r, Object o) {
        System.out.println("Antes do insertAfter:");
        mostrar();
        No atual = inicio;
        for (int i = 0; i < r; i++) {
            atual = atual.getProximo();
        }
        No novo = new No(o);
        novo.setAnterior(atual);
        novo.setProximo(atual.getProximo());


        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(novo);
        } else {
            fim = novo;
        }


        atual.setProximo(novo);
        tam++;
        System.out.println("insertAfter: " + o);
        mostrar();
    }


    public void insertFirst(Object o) {
        System.out.println("Antes do insertFirst:");
        mostrar();
        No novo = new No(o);
        novo.setProximo(inicio);


        if (inicio != null) {
            inicio.setAnterior(novo);
        } else {
            fim = novo;
        }


        inicio = novo;
        tam++;
        System.out.println("insertFirst: " + o);
        mostrar();
    }


    public void insertLast(Object o) {
        System.out.println("Antes do insertLast:");
        mostrar();
        No novo = new No(o);
        novo.setAnterior(fim);


        if (fim != null) {
            fim.setProximo(novo);
        } else {
            inicio = novo;
        }


        fim = novo;
        tam++;
        System.out.println("insertLast: " + o);
        mostrar();
    }


    public Object remove(int r) {
        No atual = inicio;
        for (int i = 0; i < r; i++) {
            atual = atual.getProximo();
        }
        Object removido = atual.getElemento();


        if (atual.getAnterior() != null) {
            atual.getAnterior().setProximo(atual.getProximo());
        } else {
            inicio = atual.getProximo();
        }


        if (atual.getProximo() != null) {
            atual.getProximo().setAnterior(atual.getAnterior());
        } else {
            fim = atual.getAnterior();
        }


        tam--;
atual.setAnterior(null);
atual.setProximo(null);




        System.out.println("Removendo " + removido);
        mostrar();
		
        return removido;
    }


    public void mostrar() {
        No atual = inicio;
        System.out.print("Lista atual: ");
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }


    class ErrorLista extends RuntimeException {
        public ErrorLista(String err) {
            super(err);
        }
    }
}
