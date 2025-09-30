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
        if (topVermelha == -1) return true;
        return false;
    }

    public boolean isEmptyPreta() {
        if (topPreta == array.length) return true;
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


    //pop retira o elemento do topo e topo tá onde? mais a direta da pilha vermelha
    public Object popVermelha() {
        if (isEmptyVermelha()) throw new EPilhaVazia("Pilha vermelha vazia.");
        Object elemento = array[topVermelha];
        array[topVermelha--] = null; 
        verificarReducao();
        return elemento;
    }

    //faz o contrario, topPreta tá mais a esquerda da pilha preta
    public Object popPreta() {
        if (isEmptyPreta()) throw new EPilhaVazia("Pilha preta vazia.");
        Object elemento = array[topPreta];
        array[topPreta++] = null;
        verificarReducao();
        return elemento;
    }

    //e se o prox indice da pilha vermelha for o mesmo da preta?

    public void pushVermelha(Object x) {
        if (topVermelha + 1 == topPreta) duplicar(array.length * 2);
        array[++topVermelha] = x;
    }

    public void pushPreta(Object x) {
        if (topVermelha + 1 == topPreta) duplicar(array.length * 2);
        array[--topPreta] = x; //apenas decrementamos já que insere da direita p/ esquerda
    }

    private void duplicar(int novoTam) {
        Object[] aux = new Object[novoTam]; //cria array auxiliar
        for (int i = 0; i <= topVermelha; i++) {
            aux[i] = array[i]; //copia elem.vermelhos
        }

        //como realocar o indice do preto?Ex.: topPreta tá na posicao 8, array.length é 10, novoTam é 20
        //topPreta deve ir para a posicao 18... ent, eu descubro quantos elementos tem na pilha preta velha e realoco pra definir topPreta nova
        
        int topPretanova = novoTam - (array.length - topPreta); 
        for (int i = topPreta; i < array.length; i++) {
            aux[topPretanova + i - topPreta] = array[i];
        }
        topPreta = topPretanova;
        array = aux; //copiar toda a array auxiliar para a original
    }

    //pra reduzir... 1/3 do array em uso
    //e se minha array for de tamanho 1? ai n da pra reduzir a array mais, ent... apenas reduzo se for maior que 1

    private void verificarReducao() {
        int totalArray = (topVermelha + 1) + (array.length - topPreta);
        if (totalArray <= array.length / 3 && array.length > 1) duplicar(array.length / 2); //Dá pra reutilizar o método duplicar pq ele faz a realocação dos elementos
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