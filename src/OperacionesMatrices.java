import java.util.Scanner;

public class OperacionesMatrices {

    public static void ejecutar(Scanner sc) {
        System.out.println("\n--- OPERACIONES CON MATRICES ---");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Transpuesta");
        System.out.print("Seleccione una operacion: ");
        int op = sc.nextInt();

        if (op < 1 || op > 4) {
            System.out.println("Opcion no valida.");
            return;
        }

        System.out.print("Filas de la matriz A: ");
        int f = sc.nextInt();
        System.out.print("Columnas de la matriz A: ");
        int c = sc.nextInt();

        if (f <= 0 || c <= 0) {
            System.out.println("Dimensiones no validas.");
            return;
        }

        double[][] a = new double[f][c];

        System.out.println("Ingrese los datos de la matriz A:");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] = sc.nextDouble();
            }
        }

        double[][] b = null;
        double[][] r;

        if (op == 1 || op == 2) {
            System.out.print("Filas de la matriz B: ");
            int fb = sc.nextInt();
            System.out.print("Columnas de la matriz B: ");
            int cb = sc.nextInt();

            if (fb != f || cb != c) {
                System.out.println(
                    "Las matrices deben tener las mismas dimensiones."
                );
                return;
            }

            b = new double[fb][cb];

            System.out.println("Ingrese los datos de la matriz B:");
            for (int i = 0; i < fb; i++) {
                for (int j = 0; j < cb; j++) {
                    b[i][j] = sc.nextDouble();
                }
            }

            r = new double[f][c];

            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    if (op == 1) {
                        r[i][j] = a[i][j] + b[i][j];
                    } else {
                        r[i][j] = a[i][j] - b[i][j];
                    }
                }
            }

        } else if (op == 3) {
            System.out.print("Filas de la matriz B: ");
            int fb = sc.nextInt();
            System.out.print("Columnas de la matriz B: ");
            int cb = sc.nextInt();

            if (c != fb || fb <= 0 || cb <= 0) {
                System.out.println(
                    "Las columnas de A deben coincidir con las filas de B."
                );
                return;
            }

            b = new double[fb][cb];

            System.out.println("Ingrese los datos de la matriz B:");
            for (int i = 0; i < fb; i++) {
                for (int j = 0; j < cb; j++) {
                    b[i][j] = sc.nextDouble();
                }
            }

            r = new double[f][cb];

            for (int i = 0; i < f; i++) {
                for (int j = 0; j < cb; j++) {
                    for (int k = 0; k < c; k++) {
                        r[i][j] += a[i][k] * b[k][j];
                    }
                }
            }

        } else {
            r = new double[c][f];

            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    r[j][i] = a[i][j];
                }
            }
        }

        System.out.println("Matriz resultante:");
        for (double[] fila : r) {
            for (double valor : fila) {
                System.out.printf("%10.2f", valor);
            }
            System.out.println();
        }
    }
}