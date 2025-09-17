package TAREFA1;
// Da esquerda p/ direita  é vermelho e t ==-1
// Da direita para esquerda é preto e t = size
// reduzir array quando 1/3 estiver em uso

class PilhaColorida {
    private Object[] array;
    private int topVermelha = -1;
    private int topPreta = topVermelha + 1;

    public PilhaColorida(int tam) {
        array = new Object[tam];
    }


    public int sizePreta(){
        return topPreta+1;
    }

   
   public boolean isEmptyVermelha(){
     if(topVermelha == -1) return true;
        return false;
     }
//*  
//*  public Object topPreto(){
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
//*  public void push_vermelha(int x){
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


class EPilhaVazia extends RuntimeException {
	public EPilhaVazia(String err) {
		super(err);
	}
};
}