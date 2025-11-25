package EXERCICIOS.TAREFA3.VetorArray;

public class Main {
    public static void main(String[] args) {
        VetorArray vetor = new VetorArray(5);

        System.out.println("Vetor está vazio? " + vetor.isEmpty());
        System.out.println("Qtd de elementos é " + vetor.size());

        vetor.insertAtRank(0, "Y");
        System.out.println("Qtd elementos " + vetor.size());

        vetor.insertAtRank(1, "A");
        vetor.insertAtRank(2, "S");
        vetor.insertAtRank(1, "M"); 

        vetor.size();

        vetor.elemAtRank(0);
        vetor.elemAtRank(1);
        vetor.elemAtRank(2);
        vetor.elemAtRank(3);

        vetor.replaceAtRank(2, "R");
        vetor.elemAtRank(1);

        vetor.removeAtRank(0);
        

        vetor.size();
        vetor.isEmpty();

        
    }
}
