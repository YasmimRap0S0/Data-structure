package TAREFA1;

public class Main {
    public static void main(String[] args) {
        PilhaColorida pilha = new PilhaColorida(10);

        for (int i = 0; i < 10; i++) {
            pilha.pushVermelha(i);
            pilha.pushPreta(i + 10);
        }

        System.out.println("Topo Vermelha: " + pilha.topVermelha());
        System.out.println("Topo Preta: " + pilha.topPreta());

        while (!pilha.isEmptyVermelha()) {
            System.out.println("Pop Vermelha: " + pilha.popVermelha());
        }

        while (!pilha.isEmptyPreta()) {
            System.out.println("Pop Preta: " + pilha.popPreta());
        }
    }
}
