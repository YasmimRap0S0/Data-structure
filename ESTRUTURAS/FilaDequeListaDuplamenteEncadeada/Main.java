package FilaDequeListaDuplamenteEncadeada;

public class Main {
    public static void main(String[] args) {
        DequeDuplo deque = new DequeDuplo();

        deque.enfileirarFrente(2);
        deque.enfileirarFrente(1);
        deque.enfileirarFim(3);
        deque.enfileirarFim(5);
        deque.enfileirarFim(8);


        deque.mostrarDeque();
        //deque.mostrarFrente();
        //deque.mostrarFim();


        deque.deletarFrente();
        deque.deletarFim();


        deque.mostrarDeque();
    }
}

