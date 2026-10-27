import java.util.Scanner;

public class OperacionesConMatrices {

public static double[][] sumar(double[][] a, double[][] b) {
    validar(a);
    validar(b);

    if (a.length != b.length || a[0].length != b[0].length)
        throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño.");

    double[][] r = new double[a.length][a[0].length];

    for (int i = 0; i < a.length; i++)
        for (int j = 0; j < a[0].length; j++)
            r[i][j] = a[i][j] + b[i][j];

    return r;
}

public static double[][] restar(double[][] a, double[][] b) {
    validar(a);
    validar(b);

    if (a.length != b.length || a[0].length != b[0].length)
        throw new IllegalArgumentException("Las matrices deben tener el mismo tamaño.");

    double[][] r = new double[a.length][a[0].length];

    for (int i = 0; i < a.length; i++)
        for (int j = 0; j < a[0].length; j++)
            r[i][j] = a[i][j] - b[i][j];

    return r;
}

public static double[][] multiplicar(double[][] a, double[][] b) {
    validar(a);
    validar(b);

    if (a[0].length != b.length)
        throw new IllegalArgumentException("Las columnas de A deben coincidir con las filas de B.");

    double[][] r = new double[a.length][b[0].length];

    for (int i = 0; i < a.length; i++)
        for (int j = 0; j < b[0].length; j++)
            for (int k = 0; k < b.length; k++)
                r[i][j] += a[i][k] * b[k][j];

    return r;
}

private static void validar(double[][] m) {
    if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
        throw new IllegalArgumentException("La matriz no puede estar vacía.");

    int columnas = m[0].length;

    for (double[] fila : m)
        if (fila == null || fila.length != columnas)
            throw new IllegalArgumentException("La matriz debe ser rectangular.");
}

public static void mostrar(double[][] matriz) {
    validar(matriz);

    for (double[] fila : matriz) {
        for (double valor : fila)
            System.out.printf("%10.2f", valor);
        System.out.println();
    }
}

private static double[][] leerMatriz(Scanner sc, String nombre, int filas, int columnas) {
    double[][] m = new double[filas][columnas];

    System.out.println("Introduce los valores de la matriz " + nombre + ":");

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            while (true) {
                System.out.print(nombre + "[" + (i + 1) + "][" + (j + 1) + "]: ");

                if (sc.hasNextDouble()) {
                    m[i][j] = sc.nextDouble();
                    break;
                }

                System.out.println("Entrada invalida. Introduce un numero.");
                sc.next();
            }
        }
    }

    return m;
}

private static int leerEntero(Scanner sc, String mensaje, int minimo, int maximo) {
    while (true) {
        System.out.print(mensaje);

        if (sc.hasNextInt()) {
            int valor = sc.nextInt();

            if (valor >= minimo && valor <= maximo)
                return valor;
        } else {
            sc.next();
        }

        System.out.println("Opcion invalida. Intenta de nuevo.");
    }
}

private static void ejecutarMenu(Scanner sc) {
    int opcion = leerEntero(sc,
            "\nOPERACIONES CON MATRICES\n1. Suma\n2. Resta\n3. Multiplicacion\nElige una operacion: ",
            1, 3);

    int filasA = leerEntero(sc, "Filas de A: ", 1, 100);
    int columnasA = leerEntero(sc, "Columnas de A: ", 1, 100);

    int filasB = opcion == 3 ? columnasA :
            filasA;
    int columnasB = opcion == 3 ?
            leerEntero(sc, "Columnas de B: ", 1, 100) : columnasA;

    double[][] a = leerMatriz(sc, "A", filasA, columnasA);
    double[][] b = leerMatriz(sc, "B", filasB, columnasB);

    double[][] resultado;

    if (opcion == 1)
        resultado = sumar(a, b);
    else if (opcion == 2)
        resultado = restar(a, b);
    else
        resultado = multiplicar(a, b);

    System.out.println("\nRESULTADO:");
    mostrar(resultado);
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;

    while (continuar) {
        try {
            ejecutarMenu(sc);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n1. Realizar otra operacion");
        System.out.println("2. Salir");

        continuar = leerEntero(sc, "Elige una opcion: ", 1, 2) == 1;
    }

    System.out.println("Programa finalizado.");
    sc.close();
}

}