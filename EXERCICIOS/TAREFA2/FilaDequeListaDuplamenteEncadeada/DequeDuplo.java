package FilaDequeListaDuplamenteEncadeada;

public class DequeDuplo {
    private No inicio = null;
    private No fim = null;

    // Enfilerar na frente: O que considerar? 1. A exceção(fila vazia), 2. Novo nó deve ter como prox o antigo inicio, 3. inicio é novo e novo é inicio
    public void enfileirarFrente(Object x) {
        No novo = new No(x);
        if (inicio == null) {
            inicio = fim = novo;
            System.out.println("Primeiro elemento inserido na lista(método enfileirarFrente): " + inicio.getElemento());

        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
    }

    // Enfilerar no fim: O que considerar? 1. A exceção(fila vazia), 2. Novo nó vai ter como prox o null, 
    // 3. o Nó-fim antigo será o penultimo elemento e precisa apontar para o novo fim
    // 4. O Novo nó deve apontar tbm para o anterior dele(o antigo fim)

    public void enfileirarFim(Object x) {
        No novo = new No(x);
        if (fim == null) {
            inicio = fim = novo;
            System.out.println("Primeiro elemento inserido na lista(método enfileirarFim): " + inicio.getElemento());
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
    }

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

    // deletarFrente: 1. Exceção, 2. Se eu deletar inicio, eu preciso dizer que prox.elemento de inicio será meu novo inicio e que anterior == null
    
    
    public void deletarFrente() {
        if (inicio == null) {
            System.out.println("Deque vazio");
        } else if(inicio !=null) {
            System.out.println("Valor será deletado da frente: " + inicio.getElemento());
            inicio = inicio.getProximo();
            if (inicio != null) { //lista ficou vazia? não?
                inicio.setAnterior(null);
            } else {
                fim = null; //lista ficou vazia
                System.out.println("Lista ficou vazia por conta do deletarFrente. Era o unico elemento");

            }
        }
    }

    // deletarFim: 1. Considerar exceção, 2. Pra deletar fim, o penultimo elemento precisa se tornar fim e apontar para null
    
    public void deletarFim() {
        if (fim == null) {
            System.out.println("Deque vazio");
        } else {
            System.out.println("Valor será deletado do fim: " + fim.getElemento());
            fim = fim.getAnterior(); 
            if (fim != null) {
                fim.setProximo(null);
            } else {
                inicio = null;
                System.out.println("Lista ficou vazia por conta do deletarFim. ");


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
