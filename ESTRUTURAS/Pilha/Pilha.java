import java.util.Stack;

public class Pilha {
    public static void main(String[] args) {
        Stack<Integer> elementos = new Stack<>();

        for (int f = 0; f < 5; f++) {
            elementos.push(f);
            System.out.println("\n🔹 Após push(" + f + "):");
            if (!elementos.isEmpty()) {
                for (int i = elementos.size() - 1; i >= 0; i--) { //lembrete: size retorna O N DE ELEMENTOS, mas a pilha começa no indíce 0
                    System.out.println("| " + elementos.get(i) + " |");
                }
            } else {
                System.out.println("TÁ VAZIA, MONA!");
            }
        }
    }
}
