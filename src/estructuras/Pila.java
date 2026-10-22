package estructuras;
import java.util.EmptyStackException;

public class Pila<T>{
    private Nodo<T>[] memoria;
    private int cima;
    private int tamano;
    private int cursor;

@SuppressWarnings("unchecked")

    public Pila(){
    int max = 10;
       memoria = (Nodo<T>[]) new Nodo[max];
       cima = -1;
       cursor = 0;
       tamano = 0;
       
       for(int i = 0; i < max-1; i++){memoria[i] = new Nodo<T>(null, i + 1);}
       memoria[max-1] = new Nodo<T>(null, -1);
    }

    private void ajustarMemoria(){
        int tamañoViejo = memoria.length;
        int nuevoTamaño = tamañoViejo *2;
        Nodo<T>[] nuevaMemoria = (Nodo<T>[]) new Nodo[nuevoTamaño];

        for(int i=0; i<tamañoViejo; i++){
            nuevaMemoria[i] = memoria[i];
        }

        for (int i = tamañoViejo; i < nuevoTamaño - 1; i++) {
            nuevaMemoria[i] = new Nodo<>(null, i + 1);
        }
        nuevaMemoria[nuevoTamaño - 1] = new Nodo<>(null, -1);

        if (cursor ==-1) {
            cursor = tamañoViejo;
        }else{
            int ultimoNodo = nuevoTamaño-1;
            nuevaMemoria[ultimoNodo].setSiguiente(cursor);
            cursor = tamañoViejo;
        }

        memoria = nuevaMemoria;

    }
    

    public void ANULA(){
       cima = -1;
       tamano = 0;
       cursor = 0;
       int max = memoria.length;
       for(int i = 0; i < max-1; i++){memoria[i] = new Nodo<T>(null, i + 1);}
       memoria[max-1] = new Nodo<T>(null, -1);
    }

   public T TOPE() throws EmptyStackException {
        if (VACIA()) {
            throw new EmptyStackException();
        }
        return memoria[cima].getDato();
    }

    public T SACA() throws EmptyStackException {
        if (VACIA()) {
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

    public void METE(T dato)  {
        if (cursor == -1) {
           ajustarMemoria();
        }
        
        int posLibre = cursor;
        cursor = memoria[cursor].getSiguiente();
        
        var nuevoNodo = new Nodo<>(dato, cima);
        memoria[posLibre] = nuevoNodo;
        cima = posLibre; 
        tamano++;
    }

    public boolean VACIA(){
        return cima == -1;
    }

    public int getTamano() {
        return tamano;
    }

}

