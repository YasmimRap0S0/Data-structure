package EXERCICIOS.TAREFA3.VetorArray;

public class Main {
    public static void main(String[] args) {
        Vetor vetor = new Vetor(5);

        System.out.println("Vetor está vazio? " + vetor.isEmpty());
        System.out.println("Qtd de elementos é " + vetor.size());

        vetor.insertAtRank(0, "1");
        System.out.println("Qtd elementos " + vetor.size());

        vetor.insertAtRank(1, "2");
        vetor.insertAtRank(2, "5");
        vetor.insertAtRank(1, "4"); // insere x na posição 1

        vetor.size();

        vetor.elemAtRank(0);
        vetor.elemAtRank(1);
        vetor.elemAtRank(2);
        vetor.elemAtRank(3);

        vetor.replaceAtRank(2, "Z");
        vetor.elemAtRank(1);

        vetor.removeAtRank(1);
        

        vetor.size();
        vetor.isEmpty();

        
    }
}
