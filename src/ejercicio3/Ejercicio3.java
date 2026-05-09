package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    static Scanner sc = new Scanner(System.in);

    static void ingresarEmpleados(int[] codigos, String[] nombres, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Empleado " + (i + 1) + ":");
            System.out.print("  Codigo: ");
            codigos[i] = sc.nextInt();
            sc.nextLine();
            System.out.print("  Nombre: ");
            nombres[i] = sc.nextLine();
        }
    }

    static void buscarEmpleado(int[] codigos, String[] nombres) {
        System.out.print("\nIngrese el codigo a buscar: ");
        int codigo = sc.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < codigos.length; i++) {
            if (codigos[i] == codigo) {
                System.out.println("Empleado: " + nombres[i]);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun empleado con ese codigo.");
        }
    }

    public static void main(String[] args) {
        System.out.print("Cuantos empleados hay (N): ");
        int n = sc.nextInt();
        sc.nextLine();

        int[] codigos = new int[n];
        String[] nombres = new String[n];

        ingresarEmpleados(codigos, nombres, n);
        buscarEmpleado(codigos, nombres);
    }
}
