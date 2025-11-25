package EXERCICIOS.TAREFA4.ListaArray;


public class ListaArray {
    private Object[] array;
    private int qtd_elem = 0;


    public ListaArray(int capacidade) {
        array = new Object[capacidade];
    }


    public int size() {
        return qtd_elem;
    }


    public boolean isEmpty() {
        if (qtd_elem == 0) return true;
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
        System.out.println("Elemento last é " + array[qtd_elem-1]);
        mostrar();
        return array[qtd_elem - 1];
    }




    //before = antes


    public Object before(int r) {
        if (r <= 0 || r >= qtd_elem) throw new ErrorLista("Não tem elemento anterior");
        System.out.println("Elemento anterior ao indice " + r + " é " + array[r-1]);
        mostrar();
        return array[r - 1];
    }


    //after = depois


    public Object after(int r) {
        if (r < 0 || r >= qtd_elem - 1) throw new ErrorLista("Sem elemento seguinte");
        System.out.println("Elemento posterior ao indice " + r + " é " + array[r+1]);
        mostrar();
        return array[r + 1];
    }




     /* replaceAtRank(integer r, object o): substitui o elemento na
    colocação r por o e retorna o
    antigo elemento */

  public void replaceElement(Object p, Object o){ //o valor do elemento do objeto O se torna o valor do elemento do objeto P
        int posicao = -1;
        for(int i = 0; i < tam; i++){
            if(array[i] == o){
                posicao = i;
            } 
        }
        if(posicao != -1) array[posicao] = p;
    }


  /*  public void swapElements(int a, int b) {
        if (a < 0 || a >= qtd_elem || b < 0 || b >= qtd_elem) throw new ErrorLista("Índice inválido");
        Object elem = array[a];
        array[a] = array[b];
        array[b] = elem;
        System.out.println("Trocando posição dos elementos " + array[a] + " e " + array[b]);
        mostrar();
    }


    public void insertBefore(int r, Object o) {
        System.out.println("Antes do insertBefore: ");
        mostrar();
        if (r < 0 || r >= qtd_elem || qtd_elem == array.length) throw new ErrorLista("Índice inválido ou Lista Cheia");


        for (int i = qtd_elem - 1; i >= r; i--) {
            array[i + 1] = array[i];
        }
        array[r] = o;
        qtd_elem++;
        System.out.println("insertBefore: " + array[r]);
        mostrar();


    }


    public void insertAfter(int r, Object o) {
        System.out.println("Antes do insertAfter: ");
        mostrar();
        if (r < 0 || r >= qtd_elem || qtd_elem == array.length) throw new ErrorLista("Índice inválido ou Lista Cheia");
        for (int i = qtd_elem - 1; i >= r + 1; i--) {
            array[i + 1] = array[i];
        }
        array[r + 1] = o;
        qtd_elem++;
        System.out.println("insertAfter: " + array[r+1]);
        mostrar();


    }
    */


    public void insertFirst(Object o) {
        System.out.println("Antes do insertFirst: ");
        mostrar();
        if (qtd_elem == array.length) throw new ErrorLista("Lista cheia");


        for (int i = qtd_elem - 1; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = o;
        qtd_elem++;
        System.out.println("insertFirst: " + array[0]);
        mostrar();
    }


    public void insertLast(Object o) {
        System.out.println("Antes do insertLast: ");
        mostrar();
        if (qtd_elem == array.length) throw new ErrorLista("Lista cheia");


        array[qtd_elem] = o;
        qtd_elem++;
        System.out.println("insertLast: " + array[qtd_elem]);
        mostrar();
    }


     /* object removeAtRank(integer r): remove e retorna o elemento na
    colocação r */


   public Object remove(Object o) {
        int posicao = -1;
        for (int i = 0; i < qtd_elem; i++) {
            if (array[i].equals(o)) {
                posicao = i;
                break;
            }
        }
        if (posicao == -1) throw new ErrorLista("Elemento não encontrado");

        Object removido = array[posicao];
        for (int i = posicao; i < qtd_elem - 1; i++) {
            array[i] = array[i + 1];
        }
        array[qtd_elem - 1] = null;
        qtd_elem--;
        System.out.println("Removendo " + removido);
        mostrar();
        return removido;
}


   
    public void mostrar() {
        System.out.print("Lista atual: ");
        for (int i = 0; i < qtd_elem; i++) {
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


