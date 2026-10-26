package estructuras;

public class Main
{
    public static void main(String[] args) {
        System.out.println("PRUeBA: LISTA, PILA Y COLA");

        try {
            //LISTA 
            System.out.println("\n Prueba Lista");
            Lista<String> miLista = new Lista<>();
            miLista.INSERTA("Manzana", miLista.PRIMERO());
            miLista.INSERTA("Banana", 2);
            miLista.INSERTA("Cereza", miLista.fin());
            miLista.listar(); // Debería mostrar [ Manzana, Banana, Cereza, ]

            // INVERTIR LISTA 
            System.out.println("\n Prueba Invertir Lista");
            Lista<String> listaInvertida = Ejercicios.invertirLista(miLista);
            System.out.print("Lista original: ");
            miLista.listar();
            System.out.print("Lista invertida: ");
            listaInvertida.listar();

            //VERIFICAR PALÍNDROMO
            System.out.println("\n Prueba Palíndromos");
            String palabra1 = "reconocer";
            String palabra2 = "programacion";
            String palabra3 = "ana";

            System.out.println("¿Es '" + palabra1 + "' palíndromo? -> " + Ejercicios.esPalindromo(palabra1));
            System.out.println("¿Es '" + palabra2 + "' palíndromo? -> " + Ejercicios.esPalindromo(palabra2));
            System.out.println("¿Es '" + palabra3 + "' palíndromo? -> " + Ejercicios.esPalindromo(palabra3));

            //COLA
            System.out.println("\n Prueba Cola ");
            Cola<Integer> miCola = new Cola<>();
            miCola.PONE_EN_COLA(10);
            miCola.PONE_EN_COLA(20);
            miCola.PONE_EN_COLA(30);

            System.out.println("Frente de la cola: " + miCola.FRENTE()); // 10
            miCola.QUITA_DE_COLA();
            System.out.println("Nuevo frente tras quitar: " + miCola.FRENTE()); // 20



            //ejercicio de control
            System.out.println("\nEjercicio examen \n");
            Cola<String> colaVuelos = new Cola<>();
            Pila<String> plataformaAviones = new Pila<>();

            colaVuelos.PONE_EN_COLA("Vuelo IB-6301");
            colaVuelos.PONE_EN_COLA("Vuelo AA-940");
            colaVuelos.PONE_EN_COLA("Vuelo CM-212");

            Ejercicios.registrarAvionPlataforma(colaVuelos, plataformaAviones);


            Ejercicios.registrarAvionPlataforma(colaVuelos, plataformaAviones);

            Ejercicios.registrarAvionPlataforma(colaVuelos, plataformaAviones);

            Lista<String> bitacoraAterrizajes = Ejercicios.generarBitacora(plataformaAviones);

            System.out.print("\nBitácora actual: \n");
            bitacoraAterrizajes.listar();

        } catch (Throwable e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}