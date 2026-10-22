package estructuras;

public class Nodo<T> {
    private T dato;
    private int siguiente;

    public Nodo(T elemento, int siguiente){
        dato = elemento;
        this.siguiente = siguiente;
    }

    public void setSiguiente(int indice){siguiente = indice;}
    public int getSiguiente(){return siguiente;}

    public T getDato(){return dato;}
    public void setDato(T data){ dato = data;}

    @Override 
    public String toString() {
        return dato.toString();
    }
}
