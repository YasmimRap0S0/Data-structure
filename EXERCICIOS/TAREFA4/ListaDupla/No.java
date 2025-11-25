ackage EXERCICIOS.TAREFA4.Lista2Encadeada;


public class No {
    private Object elemento;
    private No anterior;
    private No proximo;


    public No(Object elemento) {
        this.elemento = elemento;
        this.anterior = null;
        this.proximo = null;
    }


    public Object getElemento() {
        return elemento;
    }




    public No getAnterior() {
        return anterior;
    }


    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }


    public No getProximo() {
        return proximo;
    }


    public void setProximo(No proximo) {
        this.proximo = proximo;
    }


    public void setElemento(Object elemento) {
        this.elemento = elemento;
}
}



