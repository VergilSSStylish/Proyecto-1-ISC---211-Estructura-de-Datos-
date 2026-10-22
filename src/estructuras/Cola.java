package estructuras;

public class Cola <T> {
    private Lista<T> listaInterna;

    public Cola (){
        listaInterna = new Lista<>();
    }


    // METODOS DE LA CLASE
    public void Anula(){
        listaInterna.ANULA();
    }

    public boolean VACIO(){
        if(listaInterna.VACIA()){
            return true;
        }
        return false;
    }

    public T FRENTE() throws RangoInvalidoException{
        if(VACIO()){
            throw new RangoInvalidoException("La cola esta vacia");
        }
        return listaInterna.RECUPERA(listaInterna.PRIMERO());
    }

    public void PONE_EN_COLA(T elemento) throws RangoInvalidoException {
        listaInterna.INSERTA(elemento, listaInterna.fin());
    }

    public void QUITA_DE_COLA() throws RangoInvalidoException{
        if(VACIO()){
            throw new RangoInvalidoException("Cola vacia, no existe elemento a quita");
        }
        listaInterna.SUPRIME(listaInterna.PRIMERO());
    }
}
