package estructuras;

public class Lista<T> {

    private Nodo<T>[] memoria;
    private int cabeza;
    private int tamaño;
    private int cursor;


    public Lista(){
        int INICIAL = 10;
        memoria = (Nodo<T>[]) new Nodo[INICIAL];
        cabeza = -1;
        cursor = 0;
        tamaño = 0;

        for (int i = 0; i < INICIAL - 1; i++) {
            memoria[i] = new Nodo<T>(null, i + 1);
        }

        memoria[INICIAL - 1] = new Nodo<T>(null, -1);

    }


    public int PRIMERO(){return 1;}
    public int fin(){return tamaño+1;}

    //esta funcion sirve si el arreglo esta lleno, entonces que automaticamente lo haga
    //mas grande XD. Esto para evitar que la lista tenga un limite 
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

    /* ni idea de que servia este metodo de suhelen, asi que su servidor omar la explicara
        simplemente busca el ultimo indice de espacio libre que hay en dicha lista, devuleve dicho indice
        ////gracias Omar, eres muy inteligente att: alexa
     */
    private int buscarEspacioLibre(){
        if(cursor == -1){
            //throw new ListaLlenaException("Lista llena. No se pudo encontrar un espacio libre en la memoria.");
            ajustarMemoria();
        }

        int posLibre = cursor;
        cursor = memoria[cursor].getSiguiente();
        return posLibre;

    }

    //DEVUELVE EL NODO EN POSICION -1, ANTERIOR AL QUE SE LE SOLICITA PERDON PERO 
    //NO ME FUNCIONO DE OTRA FORMA OK
    private int buscarPosicionNodo(int posicion){
        int actual = cabeza;

        for(int i=1; i<posicion-1; i++){
            actual = memoria[actual].getSiguiente();
        }

        return actual;
    }

    //METODO DE CLASE
    public void INSERTA(T elemento, int posicion) throws RangoInvalidoException{
        if (posicion > fin() || posicion < PRIMERO()) {
            throw new RangoInvalidoException("Posicion "+ posicion +" invalida. No se pudo insertar.");
        }

        int posLibre = buscarEspacioLibre();
        var nuevoNodo = new Nodo<>(elemento, -1);


        if (posicion==1) {
            nuevoNodo.setSiguiente(cabeza);
            memoria[posLibre] = nuevoNodo;
            cabeza = posLibre;
            
        }else{
            int posAInsertar = buscarPosicionNodo(posicion);
            var nodo = memoria[posAInsertar];

            nuevoNodo.setSiguiente(nodo.getSiguiente());
            memoria[posLibre] = nuevoNodo;
            nodo.setSiguiente(posLibre);

        }
        
        tamaño++;

    }

    //METODO DE CLASE
    public void SUPRIME(int posicion) throws RangoInvalidoException{

        if (posicion <= 0 || posicion > tamaño) {
            throw new RangoInvalidoException("Posicion " + posicion + " fuera del tamaño " + tamaño
            + ". No se pudo suprimir.");
        }

        if (tamaño <= 0) {
            throw new RangoInvalidoException("No se puede suprimir en lista vacia.");
        }

        int posAeliminar;

        if (posicion == 1) {
            posAeliminar = cabeza;
            cabeza = memoria[cabeza].getSiguiente(); 
            

        }else{
            int posAnterior = buscarPosicionNodo(posicion);
            var nodoAnterior = memoria[posAnterior];

            posAeliminar = nodoAnterior.getSiguiente();
            var nodoAeliminar = memoria[posAeliminar];

            nodoAnterior.setSiguiente(nodoAeliminar.getSiguiente());

        }
        
        memoria[posAeliminar].setDato(null);
        memoria[posAeliminar].setSiguiente(cursor);
        cursor = posAeliminar;

        tamaño--;
    }

    //METODO DE CLASE
    public int LOCALIZA(T elemento){
        int actual = cabeza;

        for(int i=1; i<=tamaño; i++){
            var valor = memoria[actual].getDato();
            if (valor != null && valor.equals(elemento)) {
                return i;
            }

            actual = memoria[actual].getSiguiente();
        }

        return fin();
    }

    //METODO OPCIONAL DE CLASE
    public void listar(){
        int actual = cabeza;

        System.out.print("[ ");
        while (actual != -1) {
            System.out.print(memoria[actual] + ", ");
            actual = memoria[actual].getSiguiente();
        }
        System.out.println("]");

    }

    //METODO DE CLASE
    boolean VACIA(){
        if(cabeza == -1){
            return true;
        }else {
            return false;
        }
    }

    //METODO DE CLASE
    void ANULA(){
        if(VACIA()){
            System.out.println("Lista se encontraba previamente vacia");
        }

        cabeza = -1;
        tamaño = 0;
        cursor = 0;
        int max = memoria.length;
        for(int i = 0; i < max - 1; i++){
            memoria[i] = new Nodo<>(null, i + 1);
        }
        memoria[max - 1]  = new Nodo<>(null, -1);

    }

    //METODO DE CLASE
    public T RECUPERA(int posicion) throws RangoInvalidoException{
    if(posicion < 1 || posicion > tamaño){
        throw new RangoInvalidoException("Posicion " + posicion + " invalida" );
    }
    int actual = cabeza;
    for(int i = 1; i < posicion; i++){
        actual = memoria[actual].getSiguiente();
    }
    return memoria[actual].getDato();
    }

    //METODO DE CLASE

    public int ANTERIOR(int posicion) throws RangoInvalidoException{
        if(posicion <= 1 || posicion > tamaño){
            throw new RangoInvalidoException("Posicion " + posicion + " invalida" );
        }
        return (posicion -1);
    }

    //METODO DE CLASE
    public int SIGUIENTE(int posicion) throws RangoInvalidoException {
        if (posicion < 1 || posicion > tamaño) {
            throw new RangoInvalidoException("Posicion " + posicion + " invalida");
        }
        return (posicion + 1);
    }
}