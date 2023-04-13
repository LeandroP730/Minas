import java.util.Random;
import java.util.Scanner;

public class JuegoDeMinas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tamañoTablero = 5;
        int[][] tablero = new int[tamañoTablero][tamañoTablero];
        int numeroDeMinas = 10;
        int dificultad = 0;
        System.out.println("Elige la dificultad: 1 - Fácil, 2 - Medio, 3 - Difícil");
        dificultad = scanner.nextInt();
        switch (dificultad) {
            case 1:
                numeroDeMinas = 10;
                break;
            case 2:
                numeroDeMinas = 15;
                break;
            case 3:
                numeroDeMinas = 20;
                break;
            default:
                System.out.println("Opción inválida");
                break;
        }
        colocarMinasAleatoriamente(tablero, numeroDeMinas);
        boolean juegoTerminado = false;
        int casillasReveladas = 0;
        int casillasSinMinas = tamañoTablero * tamañoTablero - numeroDeMinas;
        while (!juegoTerminado) {
            System.out.println("Ingresa la fila y columna separadas por un espacio: ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();
            if (fila >= 0 && fila < tamañoTablero && columna >= 0 && columna < tamañoTablero) {
                if (tablero[fila][columna] == -1) {
                    System.out.println("Perdiste!");
                    mostrarMinas(tablero);
                    juegoTerminado = true;
                } else {
                    casillasReveladas++;
                    if (casillasReveladas == casillasSinMinas) {
                        System.out.println("Ganaste!");
                        juegoTerminado = true;
                    } else {
                        System.out.println("Continúa jugando");
                    }
                }
            } else {
                System.out.println("Coordenadas inválidas. Inténtalo de nuevo.");
            }
        }
    }

    public static void colocarMinasAleatoriamente(int[][] tablero, int numeroDeMinas) {
        Random rand = new Random();
        int minasColocadas = 0;
        while (minasColocadas < numeroDeMinas) {
            int fila = rand.nextInt(tablero.length);
            int columna = rand.nextInt(tablero[0].length);
            if (tablero[fila][columna] != -1) {
                tablero[fila][columna] = -1;
                minasColocadas++;
            }
        }
    }

    public static void mostrarMinas(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == -1) {
                    System.out.print("M ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}