package ec.edu.utpl.computacion.proava;

// Implementamos Runnable para seguir las buenas prácticas de Java
public class Contador implements Runnable {

    private final String[] filaDatos; // Recibe la fila completa
    private final int numFila;
    private int cont;
    private final String buscPalabra;

    public Contador(String[] filaDatos, int numFila, String buscPalabra) {
        this.filaDatos = filaDatos;
        this.numFila = numFila;
        this.buscPalabra = buscPalabra;
        this.cont = 0; // Inicializa en 0
    }

    @Override
    public void run() {
        // Recorremos la fila dinámicamente con un bucle
        for (String palabra : filaDatos) {
            if (palabra != null && palabra.equals(buscPalabra)) {
                cont++;
            }
        }
        System.out.println("En la fila " + numFila + " existen " + cont + " de '" + buscPalabra + "'");
    }

    // Método Getter para que Main pueda consultar el total acumulado por este hilo
    public int getCont() {
        return cont;
    }
}
