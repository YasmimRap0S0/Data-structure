package TAREFA1;

// Da esquerda p/ direita  é vermelho e t == -1
// Da direita para esquerda é preto e t = size
// reduzir array quando 1/3 estiver em uso

class PilhaColorida {
    private Object[] array;
    private int topVermelha = -1;
    private int topPreta;

    public PilhaColorida(int tam) {
        array = new Object[tam];
        topPreta = array.length;
    }

    public int sizePreta() {
        return array.length - topPreta;
    }

    public boolean isEmptyVermelha() {
        if (topVermelha == -1) return true;
        return false;
    }

    public boolean isEmptyPreta() {
        return topPreta == array.length;
    }
 

    public Object topVermelha() {
        if (isEmptyVermelha()) throw new EPilhaVazia("Pilha vermelha vazia.");
        return array[topVermelha];
    }

    public Object topPreta() {
        if (isEmptyPreta()) throw new EPilhaVazia("Pilha preta vazia.");
        return array[topPreta];
    }

    public Object popVermelha() {
        if (isEmptyVermelha()) throw new EPilhaVazia("Pilha vermelha vazia.");
        Object elemento = array[topVermelha];
        array[topVermelha--] = null;
        verificarReducao();
        return elemento;
    }

    public Object popPreta() {
        if (isEmptyPreta()) throw new EPilhaVazia("Pilha preta vazia.");
        Object elemento = array[topPreta];
        array[topPreta++] = null;
        verificarReducao();
        return elemento;
    }

    public void pushVermelha(Object x) {
        if (topVermelha + 1 == topPreta) duplicar(array.length * 2);
        array[++topVermelha] = x;
    }

    public void pushPreta(Object x) {
        if (topVermelha + 1 == topPreta) duplicar(array.length * 2);
        array[--topPreta] = x;
    }

    private void verificarReducao() {
        int total = (topVermelha + 1) + (array.length - topPreta);
        if (total <= array.length / 3 && array.length > 1) duplicar(array.length / 2);
    }

    private void duplicar(int novoTam) {
        Object[] aux = new Object[novoTam];
        for (int i = 0; i <= topVermelha; i++) {
            aux[i] = array[i];
        }
        int novaTopPreta = novoTam - (array.length - topPreta);
        for (int i = topPreta; i < array.length; i++) {
            aux[novaTopPreta + i - topPreta] = array[i];
        }
        topPreta = novaTopPreta;
        array = aux;
    }
}

class EPilhaVazia extends RuntimeException {
    public EPilhaVazia(String err) {
        super(err);
    }
}

//*  O QUE ERA FEITO NORMALMENTE
    //*  public Object top(){
    //*      if(isEmpty()) throw new EPilhaVazia("Pilha vazia.");
    //*      return array[top];
    //*  }
    //*  
    //*  public Object pop(){
    //*      if(isEmpty()) throw new EPilhaVazia("Pilha vazia.");
    //*      top--;
    //*      return array[top + 1];
    //*  }
    //*  
    //*  public void push(int x){
    //*      if(array.length - 1 == top){ // 
    //*          Object[] aux;
    //*          aux = (Object[]) new Object[array.length*2]; //duplicação da array
    //*          for(int i = 0; i <= top; i++){
    //*              aux[i] = array[i]; //copia
    //*          }
    //*          array = aux;
    //*      }
    //*      top++;
    //*      array[top] = x;
    //*  }
    //*      } //*
