import java.util.ArrayList;

class Pilha{

    private ArrayList <Integer> pilha;

    public Pilha(){
        pilha = new ArrayList<Integer>();
    }

    public int size(){
        return pilha.size();
    }

    public boolean isEmpty(){
        return pilha.isEmpty();
    }

    public int objectTop(){
       return pilha.get(size()-1);
    }

    public int pop(){

        return pilha.remove(size()-1);
    }

    public void push(int x){
        if(isEmpty()){
            System.out.println("Tá vazio");
        } else {
        pilha.add(x);
        System.out.println("O elemento do topo é:" + x);
        }
        
    }
}

class EPilhaVazia extends RuntimeException {
	public EPilhaVazia(String err) {
		super(err);
	}
} 