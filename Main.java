package ec.edu.utpl.computacion.proava;

public class Main {
    public static void main(String[] args) {
        String palabraObjetivo = "java";
        String[][] matriz = new String[3][3];

        System.out.println("=== Matriz Generada ===");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = generarPalabra();
                System.out.print("[" + matriz[i][j] + "] ");
            }
            System.out.println();
        }
        System.out.println("=======================\n");

        // REQUISITO 1: Mostrar al inicio la palabra que se está buscando
        System.out.println(">>> Iniciando búsqueda de la palabra: '" + palabraObjetivo + "' <<<\n");

        // Instanciamos los contadores pasándole la fila completa de la matriz
        Contador cFila1 = new Contador(matriz[0], 1, palabraObjetivo);
        Contador cFila2 = new Contador(matriz[1], 2, palabraObjetivo);
        Contador cFila3 = new Contador(matriz[2], 3, palabraObjetivo);

        // Pasamos el Runnable directamente al Thread
        Thread hiloA = new Thread(cFila1);
        Thread hiloB = new Thread(cFila2);
        Thread hiloC = new Thread(cFila3);

        hiloA.start();
        hiloB.start();
        hiloC.start();

        try {
            // Esperamos de forma segura que todos terminen
            hiloA.join();
            hiloB.join();
            hiloC.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El hilo principal fue interrumpido.");
            return;
        }

        // REQUISITO 2: Sumar los resultados parciales y mostrar el gran total al final
        int totalRepeticiones = cFila1.getCont() + cFila2.getCont() + cFila3.getCont();

        System.out.println("\n=======================================================");
        System.out.println("TOTAL: La palabra '" + palabraObjetivo + "' se repite " + totalRepeticiones + " veces en total.");
        System.out.println("=======================================================");
    }

    public static String generarPalabra() {
        int b = (int) (Math.random() * 3);
        return switch (b) {
            case 0 -> "java";
            case 1 -> "python";
            default -> "c++";
        };
    }
}
