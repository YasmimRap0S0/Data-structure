
package EXERCICIOS.TAREFA3.Vetorlista;

class Vetor{
    private No inicio, fim;
    private int qtd_elem = 0;
 
    public Vetor(){
        inicio = null;
        fim = null;
    }

    public int size(){
        return qtd_elem;
    }

    public boolean isEmpty(){
        if(qtd_elem == 0) return true;
        return false;
    }

      /* object elemAtRank(integer r): retorna o elemento na colocação
    r, sem removê-lo */

    public Object elemAtRank(Integer r){
        if(r == 0) return inicio.getElemento();
        else if( r < qtd_elem){
            No aux = inicio;
            for(int j = 0; j < r; j++){
                aux = aux.getProximo();
            }
            return aux.getElemento();
        }
        return -1;
    }

    /* insertAtRank(integer r, object o): insere um novo elemento o na
    colocação r */

    public void insertAtRank(Integer r, Object o){
        if(qtd_elem == 0 && r == 0){
            No novo = new No(o);
            inicio = novo;
            fim = novo;
        }
        else if(r == 0){
            No novo = new No(o);
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
        else if(r < qtd_elem){ 
            No novo = new No(o);
        
            No aux = inicio;
            for(int j = 0; j < r; j++){
                aux = aux.getProximo();
            }
            No auxA = aux.getAnterior(); 

            auxA.setProximo(novo);
            novo.setAnterior(auxA);

            aux.setAnterior(novo);
            novo.setProximo(aux);

            if(r == 0) inicio = novo;
        }
        else if(r == qtd_elem){
            No novo = new No(o);

            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
        else throw new ErrorVetor("Índice inválido.");
        qtd_elem++;
    }

        /* object removeAtRank(integer r): remove e retorna o elemento na
    colocação r */

    public Object removeAtRank(Integer r){
        if(r < qtd_elem && qtd_elem != 0){
            No removido = new No(null); 
            removido = inicio;
            for(int j = 0; j < r; j++){
                removido = removido.getProximo();
            }
            Object elem = removido.getElemento();
            No aux1 = new No(null);
            aux1 = removido.getAnterior();
            No aux2 = new No(null);
            aux2 = removido.getProximo();
            aux1.setProximo(aux2);
            aux2.setAnterior(aux1);
            qtd_elem--;
            return elem;
        }
        else throw new ErrorVetor("Índice inválido ou lista vazia.");
    }

    

    public Object replaceAtRank(Integer r, Object o){
        if(r >= qtd_elem) throw new ErrorVetor("NN tem esse indice ");
        No aux = inicio;
        for(int j = 0; j < r; j++)
            aux = aux.getProximo();
        Object elem = aux.getElemento();
        aux.setElemento(o);
        return elem;
    }
}

class ErrorVetor extends RuntimeException{
    public ErrorVetor(String err) {
		super(err);
	}
}