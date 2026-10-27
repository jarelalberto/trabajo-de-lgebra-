import java.util.Scanner;

public class VectoresBasicos {

    public static void ejecutar(Scanner sc) {
        System.out.println("\n--- VECTORES BASICOS ---");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion por escalar");
        System.out.print("Seleccione una operacion: ");
        int op = sc.nextInt();

        if (op < 1 || op > 3) {
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
        double[] b = new double[n];
        double[] r = new double[n];

        System.out.println("Ingrese los componentes del vector A:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }

        if (op == 1 || op == 2) {
            System.out.println("Ingrese los componentes del vector B:");
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextDouble();
            }

            for (int i = 0; i < n; i++) {
                if (op == 1) {
                    r[i] = a[i] + b[i];
                } else {
                    r[i] = a[i] - b[i];
                }
            }
        } else {
            System.out.print("Ingrese el escalar: ");
            double k = sc.nextDouble();

            for (int i = 0; i < n; i++) {
                r[i] = k * a[i];
            }
        }

        System.out.print("Resultado: (");
        for (int i = 0; i < n; i++) {
            System.out.print(r[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}