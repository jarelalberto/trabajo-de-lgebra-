import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n====================================");
            System.out.println("       PROYECTO DE ALGEBRA LINEAL");
            System.out.println("====================================");
            System.out.println("Lider: Jarel Alberto Gadea Manzanares");
            System.out.println("------------------------------------");
            System.out.println("1. Operaciones con vectores");
            System.out.println("2. Operaciones con matrices");
            System.out.println("3. Transformaciones elementales");
            System.out.println("4. Integrantes del equipo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Modulo de vectores");
                    break;

                case 2:
                    System.out.println("Modulo de matrices");
                    break;

                case 3:
                    System.out.println("Modulo de transformaciones");
                    break;

                case 4:
                    System.out.println("\nINTEGRANTES DEL EQUIPO");
                    System.out.println("1. Jarel - Lider");
                    System.out.println("2. Yasir");
                    System.out.println("3. Wilbert");
                    System.out.println("4. Jeydel");
                    System.out.println("5. Maycol");
                    System.out.println("6. Cristobal");
                    break;

                case 5:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}