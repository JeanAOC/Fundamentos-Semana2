package ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

    static Scanner sc = new Scanner(System.in);

    static double[][] ingresarPrecios(int n, int m) {
        double[][] precios = new double[n][m];
        System.out.println("\nIngrese los precios de cada articulo por sucursal:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("  Precio articulo " + (i + 1) + " en sucursal " + (j + 1) + ": ");
                precios[i][j] = sc.nextDouble();
            }
        }
        return precios;
    }

    static int[][] ingresarCantidades(int n, int m) {
        int[][] cantidades = new int[n][m];
        System.out.println("\nIngrese las cantidades vendidas por cada articulo en cada sucursal:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("  Cantidad articulo " + (i + 1) + " en sucursal " + (j + 1) + ": ");
                cantidades[i][j] = sc.nextInt();
            }
        }
        return cantidades;
    }

    static void calcularTotales(double[][] precios, int[][] cantidades, int n, int m) {
        System.out.println("\n===== TOTAL DE VENTAS POR ARTICULO =====");
        for (int i = 0; i < n; i++) {
            double total = 0;
            for (int j = 0; j < m; j++)
                total += precios[i][j] * cantidades[i][j];
            System.out.printf("  Articulo %d: $%.2f%n", (i + 1), total);
        }

        System.out.println("\n===== TOTAL DE VENTAS POR SUCURSAL =====");
        for (int j = 0; j < m; j++) {
            double total = 0;
            for (int i = 0; i < n; i++)
                total += precios[i][j] * cantidades[i][j];
            System.out.printf("  Sucursal %d: $%.2f%n", (j + 1), total);
        }
    }

    public static void main(String[] args) {
        System.out.print("Cuantos articulos produce la fabrica (N): ");
        int n = sc.nextInt();
        System.out.print("Cuantas sucursales tiene (M): ");
        int m = sc.nextInt();

        double[][] precios = ingresarPrecios(n, m);
        int[][] cantidades = ingresarCantidades(n, m);

        calcularTotales(precios, cantidades, n, m);
    }
}
