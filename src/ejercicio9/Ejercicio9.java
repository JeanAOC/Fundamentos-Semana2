package ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {

    static Scanner sc = new Scanner(System.in);

    static String[] nombres;
    static int[] stockActual;
    static int[] stockMinimo;
    static double[] precioUnitario;
    static int n;

    static void registrarMedicamentos() {
        System.out.print("Cuantos medicamentos desea registrar: ");
        n = sc.nextInt();
        sc.nextLine();

        nombres = new String[n];
        stockActual = new int[n];
        stockMinimo = new int[n];
        precioUnitario = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nMedicamento " + (i + 1) + ":");
            System.out.print("  Nombre: ");
            nombres[i] = sc.nextLine();
            System.out.print("  Stock actual: ");
            stockActual[i] = sc.nextInt();
            System.out.print("  Stock minimo: ");
            stockMinimo[i] = sc.nextInt();
            System.out.print("  Precio unitario: ");
            precioUnitario[i] = sc.nextDouble();
            sc.nextLine();
        }
    }

    static void stockBajoMinimo() {
        System.out.println("\n===== MEDICAMENTOS CON STOCK BAJO =====");
        boolean hayAlguno = false;
        for (int i = 0; i < n; i++) {
            if (stockActual[i] < stockMinimo[i]) {
                System.out.println("  " + nombres[i] + " -> Stock: " + stockActual[i] + " - Minimo: " + stockMinimo[i]);
                hayAlguno = true;
            }
        }
        if (!hayAlguno)
            System.out.println("  Todos los medicamentos tienen stock suficiente.");
    }

    static void valorTotalInventario() {
        double total = 0;
        for (int i = 0; i < n; i++)
            total += stockActual[i] * precioUnitario[i];
        System.out.printf("%n===== VALOR TOTAL DEL INVENTARIO: $%.2f =====%n", total);
    }

    static void actualizarStock() {
        System.out.print("\nIngrese el nombre del medicamento vendido: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < n; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                System.out.print("Cantidad vendida: ");
                int cantidad = sc.nextInt();
                if (cantidad > stockActual[i]) {
                    System.out.println("No hay suficiente stock.");
                } else {
                    stockActual[i] -= cantidad;
                    System.out.println("Stock actualizado. Stock actual de " + nombres[i] + ": " + stockActual[i]);
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
            System.out.println("Medicamento no encontrado.");
    }

    static void reporteInventario() {
        System.out.println("\n===== REPORTE GENERAL DEL INVENTARIO =====");
        System.out.printf("  %-20s %10s %10s %10s%n", "Nombre", "Stock", "Minimo", "Precio");
        System.out.println("  --------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("  %-20s %10d %10d %10.2f%n", nombres[i], stockActual[i], stockMinimo[i], precioUnitario[i]);
        }
    }

    public static void main(String[] args) {
        registrarMedicamentos();

        int opcion;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Medicamentos con stock bajo minimo");
            System.out.println("2. Valor total del inventario");
            System.out.println("3. Actualizar stock por venta");
            System.out.println("4. Reporte general");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1) stockBajoMinimo();
            else if (opcion == 2) valorTotalInventario();
            else if (opcion == 3) actualizarStock();
            else if (opcion == 4) reporteInventario();
            else if (opcion != 0) System.out.println("Opcion no valida.");
        } while (opcion != 0);
    }
}
