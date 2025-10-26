package TAREFA1;

// Da esquerda p/ direita  é vermelho e t == -1
// Da direita para esquerda é preto e t = size
// reduzir array quando 1/3 estiver em uso. Fzr isso em pop.

class PilhaColorida {
    private Object[] array;
    private int topVermelha = -1;
    private int topPreta;

    public PilhaColorida(int tam) {
        array = new Object[tam];
        topPreta = array.length; //quem é final da array? topPreta. Mas tá vazio por enquanto
    }

    public int sizePreta() {
        return array.length - topPreta; //Ex.:array de 10 elementos e topPreta = 8 -> size = 2 pq 0 e 7 estao ocupados por pilha vermelha
    }

    //primeiro elemento inserido estará no indice 0
    public int sizeVermelha() { 
        return topVermelha + 1;
    }

    public boolean isEmptyVermelha() {
        if (topVermelha == -1) {
            return true;
        }
        return false;
    }

    public boolean isEmptyPreta() {
        if (topPreta == array.length) {
            return true;
        }
        return false; //topPreta == size, significa que quando eu for inserir o primeiro elemento, ele estará na posicao size-1
    }

    public Object topVermelha() {
        if (isEmptyVermelha()) throw new EPilhaVazia("Pilha vermelha vazia.");
        return array[topVermelha];
    }

    public Object topPreta() {
        if (isEmptyPreta()) throw new EPilhaVazia("Pilha preta vazia.");
        return array[topPreta]; 
    }

    public void pushVermelha(Object x) {
        if (topVermelha + 1 == topPreta){
            duplicar();
        } 
        topVermelha++;
        array[topVermelha] = x;
    }

    public void pushPreta(Object x) {
        if (topPreta - 1 == topVermelha){
            duplicar();
        }
        topPreta--;
        array[topPreta] = x; 
    }

    public Object popVermelha() {
        if (isEmptyVermelha()) throw new EPilhaVazia("Pilha vermelha vazia.");
        reduzir();
        Object elemento = array[topVermelha];
        array[topVermelha] = null;
        topVermelha--;
        return elemento;
        
    }

    public Object popPreta() {
        if (isEmptyPreta()) throw new EPilhaVazia("Pilha preta vazia.");
        reduzir();
        Object elemento = array[topPreta];
        array[topPreta] = null;
        topPreta++;
        return elemento;
        
    }

    private void duplicar() {
        Object[] aux = new Object[array.length*2];
        for(int i = 0; i <= topVermelha; i++){
            aux[i] = array[i]; //ele.vermelho
        };
        int qtdPreta = sizePreta();
        
        int topPretanova = aux.length - qtdPreta;
        for (int i = topPretanova; i < aux.length; i++) {
            aux[i] = array[topPreta];
            topPreta++;
     }
    topPreta = topPretanova;
    array = aux;
};

    // se tenho qtd X de elem na array com capacidade pra 10 e ela tem 1/3 ou 1/4 apenas de utilizaçõa, reduz

    private void reduzir() {
        int qtdElem = sizePreta() + sizeVermelha();
        if  ((float) qtdElem / array.length <= (float) 1/3) {

         
            Object[] aux = new Object[array.length/2];
            for(int i = 0; i <= topVermelha; i++){
                aux[i] = array[i]; //ele.vermelho
            };
            int qtdPreta = sizePreta();
            
            int topPretanova = aux.length - qtdPreta;
            for (int i = topPretanova; i < aux.length; i++) {
                aux[i] = array[topPreta];
                topPreta++;
        }
        topPreta = topPretanova;
        array = aux;
    }
};

    public void ver() {
    System.out.print("Array atual:");
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }
    System.out.println();
}



class EPilhaVazia extends RuntimeException {
    public EPilhaVazia(String err) {
        super(err);
    }
}

}


/* O QUE ERA FEITO NORMALMENTE
class Pilha{

    private Object array[];
    private int top = -1;

    public Pilha(int tam){
        array = new Object[tam];
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        if(top == -1) return true;
        return false;
    }

    public Object objectTop(){
        if(isEmpty()) throw new EPilhaVazia("Pilha vazia.");
        return array[top];
    }

    public Object pop(){
        if(isEmpty()) throw new EPilhaVazia("Pilha vazia.");
        top--;
        return array[top + 1];
    }

    public void push(int x){
        if(array.length - 1 == top){
            Object[] aux;
            aux = (Object[]) new Object[array.length*2];
            for(int i = 0; i <= top; i++){
                aux[i] = array[i];
            }
            array = aux;
        }
        top++;
        array[top] = x;
    }
}

class EPilhaVazia extends RuntimeException {
	public EPilhaVazia(String err) {
		super(err);
	}
} 
    */