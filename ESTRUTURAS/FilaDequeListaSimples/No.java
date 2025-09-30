
public class No {
    private Object elemento;
    private No prox;


    public No(Object elemento) {
        this.elemento = elemento;
        this.prox = null;
    }


    public Object getElemento() {
        return elemento;
    }


    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }


    public No getProximo() {
        return prox;
    }


    public void setProximo(No prox) {
        this.prox = prox;
    }
}




