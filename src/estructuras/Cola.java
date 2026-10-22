package src.estructuras;

public class Cola <T> {
    private Lista<T> listaInterna;

    public Cola (){
        listaInterna = new Lista<>();
    }

    public void Anula(){
        listaInterna.Anula();
    }

    public boolean Vacio(){
        if(listaInterna.Vacia()){
            return true;
        }
        return false;
    }

    public T Frente() throws RangoInvalidoException{
        if(Vacio()){
            throw new RangoInvalidoException("La cola esta vacia");
        }
        return listaInterna.Recupera(listaInterna.primero());
    }

    public void PoneEnCola(T elemento) throws RangoInvalidoException {
        listaInterna.inserta(elemento, listaInterna.fin());
    }

    public void QuitaDeCola() throws RangoInvalidoException{
        if(Vacio()){
            throw new RangoInvalidoException("Cola vacia, no existe elemento a quita");
        }
        listaInterna.suprime(listaInterna.primero());
    }
}
