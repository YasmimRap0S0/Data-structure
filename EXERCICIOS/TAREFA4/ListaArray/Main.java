package EXERCICIOS.TAREFA4.ListaArray;

public class Main {
    public static void main(String[] args) {
        ListaArray lista = new ListaArray(6);

        lista.insertLast("A");
        lista.insertLast("B");
        lista.insertLast("C");

        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Está vazia? " + lista.isEmpty());

        lista.first();
        lista.last();

        lista.insertFirst("X");

        lista.insertBefore(2, "Y"); 
        lista.insertAfter(3, "Z"); 

        lista.swapElements(0, 4);

        lista.replaceElement(2, "OI");

        lista.remove(3);

        lista.mostrar();
    }
}
