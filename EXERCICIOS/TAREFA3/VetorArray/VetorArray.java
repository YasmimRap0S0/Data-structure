package EXERCICIOS.TAREFA3.VetorArray;


class VetorArray {
    private Object[] array;
    private int qtd_elem = 0;


    public VetorArray(int capacidade) {
        array = new Object[capacidade];
    }

    public int size() {
        return qtd_elem;
    }


    public boolean isEmpty() {
        if (qtd_elem == 0) return true;
        return false;
    }


    /* object elemAtRank(integer r): retorna o elemento na colocação
    r, sem removê-lo */
   
      public Object elemAtRank(int r) {
        if (r < 0 || r >= qtd_elem) {
            throw new ErrorVetor("Não existe esse indice.");
        }

        System.out.println("O elemento da posição " + r + " é " + array[r]);
        mostrar();

        return array[r];

    }



    /* insertAtRank(integer r, object o): insere um novo elemento o na
    colocação r */
    public void insertAtRank(int r, Object o) {
        if (r < 0 || r > qtd_elem || qtd_elem == array.length) throw new ErrorVetor("Não existe esse indice ou vetor tá cheio");
        for (int i = qtd_elem - 1; i >= r; i--) {
            array[i + 1] = array[i];
        }
        array[r] = o;
        qtd_elem++;
        System.out.println("Inserido " + array[r] + " " + "em posição " + r);
        mostrar();




    }

    /* object removeAtRank(integer r): remove e retorna o elemento na
    colocação r */


    public Object removeAtRank(int r) {
       if(r < 0 || r > qtd_elem || array[r] == null ){
            throw new ErrorVetor("Não há elemento nesse índice para ser removido.");
        }
        Object removido = array[r];
        for(int j = r; j < qtd_elem-1; j++){
            array[j] = array[j+1];
        }
        qtd_elem--;
        System.out.println("Removido elemento" + removido + "' da posição " + r);
        mostrar();
        return removido;


    }


    /* replaceAtRank(integer r, object o): substitui o elemento na
    colocação r por o e retorna o
    antigo elemento */


    public Object replaceAtRank(int r, Object o) {
        if (r < 0 || r >= qtd_elem) {
            throw new ErrorVetor("Não há elemento nesse índice para ser substituído.");
        }
        Object antigo = array[r];
        array[r] = o;
        System.out.println("Substituindo " + antigo + " " + "por " + array[r]);
        mostrar();
        return antigo;
    }




    public void mostrar() {
    System.out.print("Array atual: ");
    for (int i = 0; i < qtd_elem; i++) {
        System.out.print(array[i] + " ");
    }
    System.out.println();
}
}




class ErrorVetor extends RuntimeException {
    public ErrorVetor(String err) {
        super(err);
    }
}
