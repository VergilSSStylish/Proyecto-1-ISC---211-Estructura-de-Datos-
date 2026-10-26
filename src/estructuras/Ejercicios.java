package estructuras;

public class Ejercicios {

    //ejercicio de invertir
    public static <T> Lista<T> invertirLista(Lista<T> listaOriginal) throws RangoInvalidoException, ListaLlenaException {
        int n = listaOriginal.fin() - 1; // Tamaño actual lógico
        Pila<T> pilaAuxiliar = new Pila<>();
        Lista<T> listaInvertida = new Lista<>();

        // Pasa todos los elementos de la lista a la pila         
        for (int i = 1; i <= n; i++) {
            pilaAuxiliar.METE(listaOriginal.RECUPERA(i));
        }

        // 2. Sacamos de la pila y los insertamos en la nueva lista
        while (!pilaAuxiliar.VACIA()) {
            listaInvertida.INSERTA(pilaAuxiliar.SACA(), listaInvertida.fin());
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
                listaCaracteres.INSERTA(c, listaCaracteres.fin());
                pilaCaracteres.METE(c);
            }

            // Compara elemento por elemento
            // La lista mantiene el orden original, la pila devuelve el orden invertido.
            for (int i = 1; i <= longitud; i++) {
                char charLista = listaCaracteres.RECUPERA(i);
                char charPila = pilaCaracteres.SACA();

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
    // Control de Trafico aereo
    public static void registrarAvionPlataforma(Cola<String> colaAproximacion, Pila<String> pilaPlataforma) throws Exception {
        if (!colaAproximacion.VACIO()) {
            String avion = colaAproximacion.FRENTE();
            colaAproximacion.QUITA_DE_COLA();
            pilaPlataforma.METE(avion);
            System.out.print("> " + avion + " ha sido registrado exitosamente.\n");
            pilaPlataforma.listar();
            Thread.sleep(1000);
        } else {
            System.out.print("No hay más aviones en la cola de aproximación.");
        }
    }

    // Generar la bitácora final en Lista a partir de lo que está en la Pila, cuando tú lo pidas
    public static Lista<String> generarBitacora(Pila<String> pilaPlataforma) throws Exception {
        Lista<String> bitacoraLista = new Lista<>();

        // Usamos una pila temporal para no alterar el orden original si se requiere,
        // o vaciamos la plataforma directamente hacia la lista como bitácora de aterrizajes.
        while (!pilaPlataforma.VACIA()) {
            String avionDespachado = pilaPlataforma.SACA();
                bitacoraLista.INSERTA(avionDespachado, bitacoraLista.fin());
        }

        return bitacoraLista;
    }


}