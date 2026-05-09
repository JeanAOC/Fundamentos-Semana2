package ejercicio10;

import java.util.Scanner;

public class Ejercicio10 {

    static Scanner sc = new Scanner(System.in);

    static String[] clientes;
    static String[] platos;
    static int[] cantidades;
    static double[] precios;
    static double[] totales;
    static int n;

    static void registrarPedidos() {
        System.out.print("Cuantos pedidos desea registrar: ");
        n = sc.nextInt();
        sc.nextLine();

        clientes = new String[n];
        platos = new String[n];
        cantidades = new int[n];
        precios = new double[n];
        totales = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nPedido " + (i + 1) + ":");
            System.out.print("  Nombre del cliente: ");
            clientes[i] = sc.nextLine();
            System.out.print("  Plato solicitado: ");
            platos[i] = sc.nextLine();
            System.out.print("  Cantidad: ");
            cantidades[i] = sc.nextInt();
            System.out.print("  Precio unitario: ");
            precios[i] = sc.nextDouble();
            sc.nextLine();

            totales[i] = cantidades[i] * precios[i];
            if (totales[i] > 50)
                totales[i] *= 0.90;
        }
    }

    static void mostrarTotalesPorPedido() {
        System.out.println("\n===== TOTAL POR PEDIDO =====");
        for (int i = 0; i < n; i++) {
            double subtotal = cantidades[i] * precios[i];
            System.out.println("  Cliente: " + clientes[i] + " - " + platos[i]);
            System.out.printf("  Subtotal: $%.2f", subtotal);
            if (subtotal > 50)
                System.out.printf(" -> Con descuento 10%%: $%.2f%n", totales[i]);
            else
                System.out.printf(" -> Total: $%.2f%n", totales[i]);
        }
    }

    static void ingresoTotal() {
        double total = 0;
        for (int i = 0; i < n; i++)
            total += totales[i];
        System.out.printf("%n===== INGRESO TOTAL DEL RESTAURANTE: $%.2f =====%n", total);
    }

    static void pedidoMayorValor() {
        int mayor = 0;
        for (int i = 1; i < n; i++)
            if (totales[i] > totales[mayor])
                mayor = i;
        System.out.println("\n===== PEDIDO DE MAYOR VALOR =====");
        System.out.println("  Cliente: " + clientes[mayor]);
        System.out.println("  Plato: " + platos[mayor]);
        System.out.printf("  Total: $%.2f%n", totales[mayor]);
    }

    public static void main(String[] args) {
        registrarPedidos();
        mostrarTotalesPorPedido();
        ingresoTotal();
        pedidoMayorValor();
    }
}
