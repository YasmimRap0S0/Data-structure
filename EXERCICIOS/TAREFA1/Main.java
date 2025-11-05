package EXERCICIOS.TAREFA1;

public class Main {
    public static void main(String[] args) {
        PilhaColorida pilha = new PilhaColorida(6);

         /* pilha.pushVermelha(1);
        pilha.pushVermelha(2);
        pilha.pushVermelha(3);
        pilha.pushVermelha(4);
        pilha.pushPreta(5);
        pilha.pushPreta(6);
        pilha.pushPreta(7);
        pilha.pushPreta(8);
        pilha.pushPreta(9);
        pilha.pushPreta(10);

       */
        pilha.pushVermelha(1);
                pilha.pushVermelha(5);

        pilha.pushPreta(2);

        pilha.ver();

        System.out.println("Topo Vermelha: " + pilha.topVermelha());
        System.out.println("TopPreta: " + pilha.topPreta());

        pilha.ver();


        System.out.println("Pop Vermelha: " + pilha.popVermelha());
        

        pilha.ver();

        System.out.println("Pop preta: " + pilha.popPreta());

        pilha.ver();
        pilha.pushPreta(1);
        pilha.ver();

        pilha.pushPreta(2);
        pilha.ver();

        pilha.pushPreta(3);

        pilha.ver();
        System.out.println("Pop preta: " + pilha.popPreta());
        System.out.println("Pop preta: " + pilha.popPreta());
        pilha.ver();
        System.out.println("Pop preta: " + pilha.popPreta());
        pilha.ver();
        pilha.pushPreta(1);
        pilha.ver();
        System.out.println("Pop preta: " + pilha.popPreta());
        pilha.ver();

        pilha.pushVermelha(1);
        pilha.ver();
        pilha.pushVermelha(2);
        pilha.ver();
        pilha.pushVermelha(1);
        pilha.ver();
        pilha.pushVermelha(2);
        pilha.ver();





        
    /* 
        System.out.println("testando método duplicação:");
        
        pilha.pushVermelha(1);
        pilha.pushVermelha(2);
        pilha.pushVermelha(3);
        pilha.pushVermelha(4);
        pilha.pushPreta(5);
        pilha.pushPreta(6);
        pilha.pushPreta(7);
        pilha.pushPreta(8);
        pilha.pushPreta(9);
        pilha.pushPreta(10);
         System.out.println("Topo Vermelha: " + pilha.topVermelha());
        System.out.println("Topo Preta: " + pilha.topPreta());
        pilha.ver();

        
        System.out.println("testando dnv:");
       
        pilha.pushPreta(15);
        pilha.ver();
        System.out.println("Topo Preta: " + pilha.topPreta());


*/
/*

pilha.pushVermelha(8);
pilha.ver();
pilha.pushVermelha(8);
pilha.ver();
pilha.pushVermelha(8);
pilha.ver();
    */
    }
}

