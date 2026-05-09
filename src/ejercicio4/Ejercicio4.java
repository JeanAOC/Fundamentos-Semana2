package ejercicio4;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

    static Scanner sc = new Scanner(System.in);

    static int[][] generarMatriz(int m, int n) {
        Random rand = new Random();
        int[][] matriz = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matriz[i][j] = rand.nextInt(20) + 1;
        return matriz;
    }

    static void mostrarMatriz(int[][] matriz, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.printf("%4d", matriz[i][j]);
            System.out.println();
        }
    }

    static int[][] sumar(int[][] a, int[][] b, int m, int n) {
        int[][] resultado = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                resultado[i][j] = a[i][j] + b[i][j];
        return resultado;
    }

    static int[][] restar(int[][] a, int[][] b, int m, int n) {
        int[][] resultado = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                resultado[i][j] = a[i][j] - b[i][j];
        return resultado;
    }

    static int[][] multiplicar(int[][] a, int[][] b, int n) {
        int[][] resultado = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    resultado[i][j] += a[i][k] * b[k][j];
        return resultado;
    }

    static int[][] transponer(int[][] a, int m, int n) {
        int[][] resultado = new int[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                resultado[j][i] = a[i][j];
        return resultado;
    }

    public static void main(String[] args) {
        System.out.print("Ingrese el numero de filas (M): ");
        int m = sc.nextInt();
        System.out.print("Ingrese el numero de columnas (N): ");
        int n = sc.nextInt();

        int[][] matrizA = generarMatriz(m, n);
        int[][] matrizB = generarMatriz(m, n);

        System.out.println("\nMatriz A:");
        mostrarMatriz(matrizA, m, n);
        System.out.println("\nMatriz B:");
        mostrarMatriz(matrizB, m, n);

        int opcion;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar (requiere matriz cuadrada)");
            System.out.println("4. Transponer matriz A");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("\nResultado A + B:");
                mostrarMatriz(sumar(matrizA, matrizB, m, n), m, n);
            } else if (opcion == 2) {
                System.out.println("\nResultado A - B:");
                mostrarMatriz(restar(matrizA, matrizB, m, n), m, n);
            } else if (opcion == 3) {
                if (m != n) {
                    System.out.println("La multiplicacion requiere una matriz cuadrada (M == N).");
                } else {
                    System.out.println("\nResultado A x B:");
                    mostrarMatriz(multiplicar(matrizA, matrizB, n), n, n);
                }
            } else if (opcion == 4) {
                System.out.println("\nTranspuesta de A:");
                mostrarMatriz(transponer(matrizA, m, n), n, m);
            } else if (opcion != 0) {
                System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);

        System.out.println("Fin del programa.");
    }
}
