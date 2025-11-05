public class DequeSimples {

    private No inicio = null;
    private No fim = null;

    

    public void mostrarFrente() { //O(1). Não preciso percorrer a lista e já tá ali no começo
        if (inicio == null) {
            System.out.println("Deque vazio!");
        } else {
            System.out.println("\nO valor do inicio: " + inicio.getElemento());
        }
    }

    public void mostrarFim() { //O(1). O elemento já tem um ponteiro direto para o fim
        if (fim == null) {
            System.out.println("Deque vazio!");
        } else {
            System.out.println("\nO valor do fim: " + fim.getElemento());
        }
    }

    public void mostrarDeque() { //O(n) pq precisa percorrer a lista
        if (inicio == null) {
            System.out.println("Deque vazio!");
            return;
        }
        System.out.print("\nElementos no deque: ");
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.getElemento() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }

    //enfileirar na frente? o que considerar: 1. A fila tá vazia? 2. A fila já tem elementos?

    
    public void enfileirarFrente(int x) { //O(1)
        No novo = new No(x);
        if (inicio == null) {
            inicio = fim = novo; //significa que o inicio e o fim apontam para o mesmo nó
        } else {
            //
            novo.setProximo(inicio);
            inicio = novo;
        }
    }

    //enfileirar no fim? o que considerar: 1. A fila tá vazia? 
    // 2. O último elemento aponta para null, portanto novo elemento deve ser adicionado no fim e o ponteiro do fim(antigo) deve apontar para o novo elemento e novo elemento para null

    public void enfileirarFim(int x) { //O(1)
        No novo = new No(x);
        if (fim == null) {
            inicio = fim = novo;
        } else {
            //o fim antigo vai apontar para o novo nó
            fim.setProximo(novo);
            //é preciso atualizar o ponteiro do fim para o novo nó
            fim = novo;
        }
    }

    public void deletarFrente() { //O(1)
        if (inicio == null) {
            System.out.println("Deque vazio");
        } else {
            System.out.println("\nO elemento deletado: " + inicio.getElemento());
            inicio = inicio.getProximo(); //agr o prox do inicio antigo será o novo inicio
            if (inicio == null) { //se a lista ficar vazia, atualiza o fim também
                fim = null;
                System.out.println("Deque vazio após deletar o elemento da frente");
        }
        }
    }

    public void deletarFim() { //O(n) pq precisa percorrer a lista para encontrar o penúltimo nó e avisar que ele agora é o fim
            if (inicio == null) {
                System.out.println("Deque vaziooo");
            } else if (inicio == fim) { 
                System.out.println("\nO elemento deletado:" + fim.getElemento());
                inicio = fim = null;
                System.out.println("Deque vazio após deletar o elemento do fim");

                } else {
                    No atual = inicio;
                    while (atual.getProximo() != fim) {
                        atual = atual.getProximo();
                    }
                System.out.println("\nO elemento deletado:" + fim.getElemento());
                atual.setProximo(null);
                fim = atual;
            }
        }
    }


    
    
    
    