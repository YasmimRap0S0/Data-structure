import java.util.Stack; //importar biblioteca de pilhas

public class Main {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();

        //CONCEITO LIFO → “Last in, first out”
        //push insere e pop remove
      
        pilha.push(5);
        System.out.println("Inserção do 5: " + pilha); //5
        pilha.push(3); 
        System.out.println("Inserção do 3: " + pilha); //5,3
        pilha.pop();
        System.out.println("Removendo: " + pilha); //5
        pilha.push(2);
        System.out.println("Inserção do 2: " + pilha); //5,2
        pilha.push(8);
        System.out.println("Inserção do 8: " + pilha); //5,2,8
        pilha.pop(); //tira 8
        System.out.println("Removendo: " + pilha); //5,2
        pilha.pop(); //tira 2
        System.out.println("Removendo: " + pilha); //5
        pilha.push(9); //5,9
        System.out.println("Inserção do 9: " + pilha); 
        pilha.push(1); 
        System.out.println("Inserção do 1: " + pilha); //5,9,1
        pilha.pop(); //tira 1
        System.out.println("Removendo: " + pilha); //5,9
        pilha.push(7); 
        System.out.println("Inserção do 7: " + pilha); //5,9,7
        pilha.push(6); //5,9,7,6
        System.out.println("Inserção do 6: " + pilha);
        pilha.pop(); //tira 6
        System.out.println("Removendo: " + pilha); //5,9,7
        pilha.pop(); //tira 7
        System.out.println("Removendo: " + pilha); //5,9
        pilha.push(4); //5,9,4
        System.out.println("Inserção do 4: " + pilha);
        pilha.pop(); //tira 4
        System.out.println("Removendo: " + pilha);  //5,9
        pilha.pop(); //tira 9
        System.out.println("Removendo: " + pilha); //5

        System.out.println("Pilha: " + pilha); 
    }
}
