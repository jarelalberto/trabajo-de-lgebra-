import java.util.Scanner;

public class Transformaciones {

    public static void ejecutar(Scanner sc) {
        System.out.println("\n--- TRANSFORMACIONES ELEMENTALES ---");

        System.out.print("Numero de filas: ");
        int f = sc.nextInt();
        System.out.print("Numero de columnas: ");
        int c = sc.nextInt();

        if (f <= 0 || c <= 0) {
            System.out.println("Dimensiones no validas.");
            return;
        }

        double[][] a = new double[f][c];

        System.out.println("Ingrese los datos de la matriz:");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextDouble();
            }
        }

        System.out.println("\n1. Intercambiar filas");
        System.out.println("2. Multiplicar una fila por un escalar");
        System.out.println("3. Sumar un multiplo de una fila a otra");
        System.out.print("Seleccione una operacion: ");
        int op = sc.nextInt();

        if (op < 1 || op > 3) {
            System.out.println("Opcion no valida.");
            return;
        }

        if (op == 1) {
            System.out.print("Primera fila: ");
            int f1 = sc.nextInt() - 1;
            System.out.print("Segunda fila: ");
            int f2 = sc.nextInt() - 1;

            if (f1 < 0 || f1 >= f || f2 < 0 || f2 >= f) {
                System.out.println("Fila no valida.");
                return;
            }

            double[] temporal = a[f1];
            a[f1] = a[f2];
            a[f2] = temporal;

        } else if (op == 2) {
            System.out.print("Fila que desea multiplicar: ");
            int fila = sc.nextInt() - 1;

            if (fila < 0 || fila >= f) {
                System.out.println("Fila no valida.");
                return;
            }

            System.out.print("Escalar distinto de cero: ");
            double k = sc.nextDouble();

            if (k == 0) {
                System.out.println("El escalar debe ser distinto de cero.");
                return;
            }

            for (int j = 0; j < c; j++) {
                a[fila][j] *= k;
            }

        } else {
            System.out.print("Fila que se modificara: ");
            int f1 = sc.nextInt() - 1;
            System.out.print("Fila que se utilizara: ");
            int f2 = sc.nextInt() - 1;

            if (f1 < 0 || f1 >= f || f2 < 0 || f2 >= f) {
                System.out.println("Fila no valida.");
                return;
            }

            if (f1 == f2) {
                System.out.println("Seleccione dos filas diferentes.");
                return;
            }

            System.out.print("Multiplo que se sumara: ");
            double k = sc.nextDouble();

            for (int j = 0; j < c; j++) {
                a[f1][j] += k * a[f2][j];
            }
        }

        System.out.println("\nMatriz resultante:");
        for (double[] fila : a) {
            for (double valor : fila) {
                System.out.printf("%10.2f", valor);
            }
            System.out.println();
        }
    }
}