import java.util.Random;
public class MenuSismosMatriz {

    private static final int filas = 7;
    private static final int columnas = 24;
    private static final double magnitudMinimaSms = 7.0;

    public static void main(String[] args) {
        double[][] lecturas = generarLecturasAleatorias();

        int opcion;
        do {
            mostrarMenu();
            opcion = obtenerOpcion();
            switch (opcion) {
                case 1:
                    mostrarMatriz(lecturas);
                    break;
                case 2:
                    mostrarSismoMayorMagnitud(lecturas);
                    break;
                case 3:
                    mostrarSismosMayoresOIgualesA5(lecturas);
                    break;
                case 4:
                    enviarSMS(lecturas);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("Menu");
        System.out.println("1. Mostrar lecturas de la semana");
        System.out.println("2. Mostrar sismo de mayor magnitud");
        System.out.println("3. Mostrar sismos mayores o iguales a 5.0");
        System.out.println("4. Enviar SMS por lecturas mayores o iguales a 7.0");
        System.out.println("5. Salir del programa");
        System.out.print("Ingrese su opción: ");
    }
    private static int obtenerOpcion() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
    private static double[][] generarLecturasAleatorias() {
        Random random = new Random();
        double[][] lecturas = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                lecturas[i][j] = random.nextDouble() * 10;
            }
        }
        return lecturas;
    }

    private static void mostrarMatriz(double[][] lecturas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%.1f ", lecturas[i][j]);
            }
            System.out.println();
        }
    }

    private static void mostrarSismoMayorMagnitud(double[][] lecturas) {
        System.out.println("Mostrando sismo de mayor magnitud...");
    }

    private static void mostrarSismosMayoresOIgualesA5(double[][] lecturas) {
        System.out.println("Mostrando sismos mayores o iguales a 5.0...");
    }

    private static void enviarSMS(double[][] lecturas) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (lecturas[i][j] >= magnitudMinimaSms) {
                    System.out.println("SMS enviado por lectura de " + lecturas[i][j]);
                }
            }
        }
    }
}
