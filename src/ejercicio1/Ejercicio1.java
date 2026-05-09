package ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {

    static Scanner sc = new Scanner(System.in);

    static long[] llenarArreglo(int n, String materia) {
        long[] arr = new long[n];
        System.out.println("Ingrese las cedulas de los que reprobaron " + materia + ":");
        for (int i = 0; i < n; i++) {
            System.out.print("Cedula " + (i + 1) + ": ");
            arr[i] = sc.nextLong();
        }
        return arr;
    }

    static long[] buscarReprobadosEnAmbas(long[] mat, long[] ing, int n) {
        long[] ambas = new long[n];
        int cont = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i] == ing[j]) {
                    ambas[cont] = mat[i];
                    cont++;
                    break;
                }
            }
        }
        long[] resultado = new long[cont];
        for (int i = 0; i < cont; i++) {
            resultado[i] = ambas[i];
        }
        return resultado;
    }

    static void mostrarArreglo(long[] arr, String nombre) {
        System.out.println("\n" + nombre + ":");
        if (arr.length == 0) {
            System.out.println("Ninguno");
        } else {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("  [" + i + "] " + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Cuantos estudiantes hay (N): ");
        int n = sc.nextInt();

        long[] matematica = llenarArreglo(n, "MATEMATICA");
        long[] ingles = llenarArreglo(n, "INGLES");
        long[] ambas = buscarReprobadosEnAmbas(matematica, ingles, n);

        System.out.println("\n===== RESULTADOS =====");
        System.out.println("\nReprobados en MATEMATICA:");
        for (int i = 0; i < matematica.length; i++)
            System.out.println("  " + matematica[i]);

        System.out.println("\nReprobados en INGLES:");
        for (int i = 0; i < ingles.length; i++)
            System.out.println("  " + ingles[i]);

        System.out.println("\nReprobados en AMBAS:");
        if (ambas.length == 0)
            System.out.println("  Ninguno");
        for (int i = 0; i < ambas.length; i++)
            System.out.println("  " + ambas[i]);
    }
}
