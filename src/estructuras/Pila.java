package src.estructuras;
import java.util.EmptyStackException;

public class Pila<T>{
    private Nodo<T>[] memoria;
    private int cima;
    private int tamano;
    private int cursor;

@SuppressWarnings("unchecked")

    public Pila(int max){
       memoria = (Nodo<T>[]) new Nodo[max];
       cima = -1;
       cursor = 0;
       tamano = 0;
       
       for(int i = 0; i < max-1; i++){memoria[i] = new Nodo<T>(null, i + 1);}
       memoria[max-1] = new Nodo<T>(null, -1);
    }

    

    public void anula(){
       cima = -1;
       tamano = 0;
       cursor = 0;
       int max = memoria.length;
       for(int i = 0; i < max-1; i++){memoria[i] = new Nodo<T>(null, i + 1);}
       memoria[max-1] = new Nodo<T>(null, -1);
    }

   public T Tope() throws EmptyStackException {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return memoria[cima].getDato();
    }

    public T Saca() throws EmptyStackException {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        
        int posAEliminar = cima;
        T datoRemovido = memoria[cima].getDato();
        
        cima = memoria[cima].getSiguiente();
        
        memoria[posAEliminar].setDato(null);
        memoria[posAEliminar].setSiguiente(cursor);
        cursor = posAEliminar;
        tamano--;
        
        return datoRemovido;
    }

    public void Mete(T dato) throws ListaLlenaException {
        if (cursor == -1) {
            throw new ListaLlenaException("Pila llena. No se pudo insertar el elemento.");
        }
        
        int posLibre = cursor;
        cursor = memoria[cursor].getSiguiente();
        
        var nuevoNodo = new Nodo<>(dato, cima);
        memoria[posLibre] = nuevoNodo;
        cima = posLibre; 
        tamano++;
    }

    public boolean estaVacia(){
        return cima == -1;
    }

    public int getTamano() {
        return tamano;
    }

}

