package EXERCICIOS.TAREFA3.VetorArray;

class Vetor {
    private Object[] array;
    private int qtd = 0;

    public Vetor(int capacidade) {
        array = new Object[capacidade];
    }

    public int size() {
        return qtd;
    }

    public boolean isEmpty() {
        if (qtd == 0) return true;
        return false;
    }

    /* object elemAtRank(integer r): retorna o elemento na colocação
    r, sem removê-lo */
    
    public Object elemAtRank(int r) {
        if (r < 0 || r >= qtd) {
            throw new ErrorVetor("Não existe esse indice.");
        }

        System.out.println("O elemento da posição " + r + " é " + array[r]);
        imprimir();

        return array[r];

    }

    /* insertAtRank(integer r, object o): insere um novo elemento o na
    colocação r */
    public void insertAtRank(int r, Object o) {
        if (r < 0 || r > qtd || qtd == array.length) throw new ErrorVetor("Não existe esse indice ou vetor tá cheio");
        for (int i = qtd - 1; i >= r; i--) {
            array[i + 1] = array[i];
        }
        array[r] = o;
        qtd++;
        System.out.println("Inserido " + array[r] + " " + "em posição " + r);
        imprimir();


    }

    /* object removeAtRank(integer r): remove e retorna o elemento na
    colocação r */

    public Object removeAtRank(int r) {
       if(r < 0 || r > qtd || array[r] == null ){
            throw new ErrorVetor("Não há elemento nesse índice para ser removido.");
        }
        Object elem = array[r];
        for(int j = r; j < qtd-1; j++){
            array[j] = array[j+1];
        }
        qtd--;
        System.out.println("Removido elemento" + elem + "' da posição " + r);
        imprimir();
        return elem;

    }

    /* replaceAtRank(integer r, object o): substitui o elemento na
    colocação r por o e retorna o
    antigo elemento */

    public Object replaceAtRank(int r, Object o) {
        if (r < 0 || r >= qtd) {
            throw new ErrorVetor("Não há elemento nesse índice para ser substituído.");
        }
        Object antigo = array[r];
        array[r] = o;
        System.out.println("Substituindo " + antigo + " " + "por " + array[r]);
        imprimir();
        return antigo;
    }


    public void imprimir() {
    System.out.print("Array atual: ");
    for (int i = 0; i < qtd; i++) {
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
