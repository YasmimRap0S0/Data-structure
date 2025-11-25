package EXERCICIOS.TAREFA4.ListaArray;


public class ListaArray {
    private Object[] array;
    private int tam = 0;


    public ListaArray(int capacidade) {
        array = new Object[capacidade];
    }


    public int size() {
        return tam;
    }


    public boolean isEmpty() {
        if (tam == 0) return true;
        return false;
    }


    public Object first() {
        if (isEmpty()) throw new ErrorLista("Lista tá vazia");
        System.out.println("Elemento first é " + array[0]);
        mostrar();
        return array[0];
    }


    public Object last() {
        if (isEmpty()) throw new ErrorLista("Lista tá vazia");
        System.out.println("Elemento last é " + array[tam-1]);
        mostrar();
        return array[tam - 1];
    }




    //before = antes


    public Object before(int r) {
        if (r <= 0 || r >= tam) throw new ErrorLista("Não tem elemento anterior");
        System.out.println("Elemento anterior ao indice " + r + " é " + array[r-1]);
        mostrar();
        return array[r - 1];
    }


    //after = depois


    public Object after(int r) {
        if (r < 0 || r >= tam - 1) throw new ErrorLista("Sem elemento seguinte");
        System.out.println("Elemento posterior ao indice " + r + " é " + array[r+1]);
        mostrar();
        return array[r + 1];
    }




     /* replaceAtRank(integer r, object o): substitui o elemento na
    colocação r por o e retorna o
    antigo elemento */


    public Object replaceElement(int r, Object o) {
        if (r < 0 || r >= tam) throw new ErrorLista("Índice inválido");
        Object antigo = array[r];


        array[r] = o;
        System.out.println("Troca elemento " + antigo + " por " + array[r]);
        mostrar();
        return antigo;
    }


    public void swapElements(int a, int b) {
        if (a < 0 || a >= tam || b < 0 || b >= tam) throw new ErrorLista("Índice inválido");
        Object elem = array[a];
        array[a] = array[b];
        array[b] = elem;
        System.out.println("Trocando posição dos elementos " + array[a] + " e " + array[b]);
        mostrar();
    }


    public void insertBefore(int r, Object o) {
        System.out.println("Antes do insertBefore: ");
        mostrar();
        if (r < 0 || r >= tam || tam == array.length) throw new ErrorLista("Índice inválido ou Lista Cheia");


        for (int i = tam - 1; i >= r; i--) {
            array[i + 1] = array[i];
        }
        array[r] = o;
        tam++;
        System.out.println("insertBefore: " + array[r]);
        mostrar();


    }


    public void insertAfter(int r, Object o) {
        System.out.println("Antes do insertAfter: ");
        mostrar();
        if (r < 0 || r >= tam || tam == array.length) throw new ErrorLista("Índice inválido ou Lista Cheia");
        for (int i = tam - 1; i >= r + 1; i--) {
            array[i + 1] = array[i];
        }
        array[r + 1] = o;
        tam++;
        System.out.println("insertAfter: " + array[r+1]);
        mostrar();


    }


    public void insertFirst(Object o) {
        System.out.println("Antes do insertFirst: ");
        mostrar();
        if (tam == array.length) throw new ErrorLista("Lista cheia");


        for (int i = tam - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = o;
        tam++;
        System.out.println("insertFirst: " + array[0]);
        mostrar();
    }


    public void insertLast(Object o) {
        System.out.println("Antes do insertLast: ");
        mostrar();
        if (tam == array.length) throw new ErrorLista("Lista cheia");


        array[tam] = o;
        tam++;
        System.out.println("insertLast: " + array[tam]);
        mostrar();
    }


     /* object removeAtRank(integer r): remove e retorna o elemento na
    colocação r */


    public Object remove(int r) {
        if (r < 0 || r >= tam) throw new ErrorLista("Índice inválido");
        Object removido = array[r];
        for (int i = r; i < tam - 1; i++) {
            array[i] = array[i + 1];
        }
        array[tam - 1] = null;
        tam--;
        System.out.println("Removendo " + removido);
        mostrar();
        return removido;
    }


   
    public void mostrar() {
        System.out.print("Lista atual: ");
        for (int i = 0; i < tam; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    class ErrorLista extends RuntimeException {
    public ErrorLista(String err) {
        super(err);
    }
}
}


