import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==================================");
            System.out.println("       PROYECTO DE ALGEBRA LINEAL");
            System.out.println("==================================");
            System.out.println("1. Operaciones con vectores");
            System.out.println("2. Operaciones con matrices");
            System.out.println("3. Transformaciones elementales");
            System.out.println("4. Salir");
            System.out.print("Seleccione un tema: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    int tipo;
                    System.out.println("\n--- OPERACIONES CON VECTORES ---");
                    System.out.println("1. Operaciones basicas");
                    System.out.println("2. Operaciones avanzadas");
                    System.out.print("Seleccione: ");
                    tipo = sc.nextInt();

                    if (tipo == 1) {
                        VectoresBasicos.ejecutar(sc);
                    } else if (tipo == 2) {
                        VectoresAvanzados.ejecutar(sc);
                    } else {
                        System.out.println("Opcion no valida.");
                    }
                    break;

                case 2:
                    OperacionesMatrices.ejecutar(sc);
                    break;

                case 3:
                    Transformaciones.ejecutar(sc);
                    break;

                case 4:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}