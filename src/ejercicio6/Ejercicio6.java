package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

    static Scanner sc = new Scanner(System.in);

    static double[][] ingresarVentas(int n, int m) {
        double[][] ventas = new double[n][m];
        System.out.println("\nIngrese las ventas de cada vendedor por año:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("  Vendedor " + (i + 1) + " - Año " + (j + 1) + ": ");
                ventas[i][j] = sc.nextDouble();
            }
        }
        return ventas;
    }

    static void totalPorVendedor(double[][] ventas, int n, int m) {
        System.out.println("\n===== TOTAL DE VENTAS POR VENDEDOR =====");
        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j < m; j++)
                total += ventas[i][j];
            System.out.printf("  Vendedor %d: $%.2f%n", (i + 1), total);
        }
    }

    static void totalPorAnio(double[][] ventas, int n, int m) {
        System.out.println("\n===== TOTAL DE VENTAS POR AÑO =====");
        for (int j = 0; j < m; j++) {
            double total = 0;
            for (int i = 0; i < n; i++)
                total += ventas[i][j];
            System.out.printf("  Año %d: $%.2f%n", (j + 1), total);
        }
    }

    static void totalEmpresa(double[][] ventas, int n, int m) {
        double total = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                total += ventas[i][j];
        System.out.printf("%n===== TOTAL DE VENTAS DE LA EMPRESA: $%.2f =====%n", total);
    }

    public static void main(String[] args) {
        System.out.print("Cuantos vendedores tiene la empresa (N): ");
        int n = sc.nextInt();
        System.out.print("Cuantos años de operaciones (M): ");
        int m = sc.nextInt();

        double[][] ventas = ingresarVentas(n, m);

        totalPorVendedor(ventas, n, m);
        totalPorAnio(ventas, n, m);
        totalEmpresa(ventas, n, m);
    }
}
