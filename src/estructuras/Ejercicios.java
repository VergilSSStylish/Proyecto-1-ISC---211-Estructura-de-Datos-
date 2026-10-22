package estructuras;

public class Ejercicios {

    //ejercicio de invertir
    public static <T> Lista<T> invertirLista(Lista<T> listaOriginal) throws RangoInvalidoException, ListaLlenaException {
        int n = listaOriginal.fin() - 1; // Tamaño actual lógico
        Pila<T> pilaAuxiliar = new Pila<>();
        Lista<T> listaInvertida = new Lista<>();

        // Pasa todos los elementos de la lista a la pila         
        for (int i = 1; i <= n; i++) {
            pilaAuxiliar.Mete(listaOriginal.Recupera(i));
        }

        // 2. Sacamos de la pila y los insertamos en la nueva lista
        while (!pilaAuxiliar.estaVacia()) {
            listaInvertida.inserta(pilaAuxiliar.Saca(), listaInvertida.fin());
        }

        return listaInvertida;
    }

    
     // ejercicio de verificar si es un palíndromo
    public static boolean esPalindromo(String texto) {
        if (texto == null) return false;

        // quita espacios 
        String limpio = texto.replaceAll("\\s+", "");
        int longitud = limpio.length();

        if (longitud <= 1) return true;

        try {
            Lista<Character> listaCaracteres = new Lista<>();
            Pila<Character> pilaCaracteres = new Pila<>();

            // Llena la lista y la pila con los caracteres
            for (int i = 0; i < longitud; i++) {
                char c = limpio.charAt(i);
                listaCaracteres.inserta(c, listaCaracteres.fin());
                pilaCaracteres.Mete(c);
            }

            // Compara elemento por elemento
            // La lista mantiene el orden original, la pila devuelve el orden invertido.
            for (int i = 1; i <= longitud; i++) {
                char charLista = listaCaracteres.Recupera(i);
                char charPila = pilaCaracteres.Saca();

                if (charLista != charPila) {
                    return false;
                }
            }

            return true;

        } catch (Exception e) {
            System.out.println("Error durante la ejecución del palíndromo: " + e.getMessage());
            return false;
        }

    }
    // Control de Tráfico Aéreo 
    public static Lista<String> procesarControlAereo(Cola<String> colaAproximacion, int capacidad) throws Exception {
        Pila<String> pilaPlataforma = new Pila<>();
        Lista<String> bitacoraLista = new Lista<>();

        // quita de la cola y las ingresa en la pila
        while (!colaAproximacion.Vacio()) {
            String avion = colaAproximacion.Frente();
            colaAproximacion.QuitaDeCola();
            pilaPlataforma.Mete(avion);
        }

        // Se ingresan en la lista que funciona como bitacora
        while (!pilaPlataforma.estaVacia()) {
            String avionDespachado = pilaPlataforma.Saca();
            bitacoraLista.inserta(avionDespachado, bitacoraLista.fin());
        }

        return bitacoraLista;
    }
    
}