import java.util.Scanner;

public class VectoresAvanzados {

    public static void ejecutar(Scanner sc) {
        System.out.println("\n--- VECTORES AVANZADOS ---");
        System.out.println("1. Producto punto");
        System.out.println("2. Magnitud de un vector");
        System.out.print("Seleccione una operacion: ");
        int op = sc.nextInt();

        if (op < 1 || op > 2) {
            System.out.println("Opcion no valida.");
            return;
        }

        System.out.print("Dimension del vector: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("La dimension debe ser positiva.");
            return;
        }

        double[] a = new double[n];

        System.out.println("Ingrese los componentes del vector A:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        if (op == 1) {
            double[] b = new double[n];
            double producto = 0;

            System.out.println("Ingrese los componentes del vector B:");
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextDouble();
                producto += a[i] * b[i];
            }

            System.out.println("Producto punto: " + producto);
        } else {
            double suma = 0;

            for (int i = 0; i < n; i++) {
                suma += a[i] * a[i];
            }

            System.out.println("Magnitud: " + Math.sqrt(suma));
        }
    }
}