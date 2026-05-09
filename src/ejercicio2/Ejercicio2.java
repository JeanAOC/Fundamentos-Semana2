package ejercicio2;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio2 {

    static Scanner sc = new Scanner(System.in);

    static int[] generarVector() {
        Random rand = new Random();
        int[] vector = new int[20];
        for (int i = 0; i < 20; i++) {
            vector[i] = rand.nextInt(50) + 1;
        }
        return vector;
    }

    static void buscarNumero(int[] vector) {
        System.out.print("Ingrese el numero a buscar: ");
        int num = sc.nextInt();
        boolean encontrado = false;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == num) {
                System.out.println("El numero " + num + " se encuentra en la posicion " + i);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El numero " + num + " no se encuentra en el vector.");
        }
    }

    static int[] vectorIndicesImpares(int[] vector) {
        int[] impares = new int[10];
        int cont = 0;
        for (int i = 1; i < vector.length; i += 2) {
            impares[cont] = vector[i];
            cont++;
        }
        return impares;
    }

    static void contarMayoresA20(int[] vector) {
        int cont = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > 20) {
                cont++;
            }
        }
        System.out.println("Elementos mayores a 20 en el segundo vector: " + cont);
    }

    public static void main(String[] args) {
        int[] vector = generarVector();

        System.out.println("Vector original:");
        for (int i = 0; i < vector.length; i++)
            System.out.print(vector[i] + " ");

        System.out.println("\n");
        buscarNumero(vector);

        int[] vectorImpares = vectorIndicesImpares(vector);
        System.out.println("\nVector con indices impares:");
        for (int i = 0; i < vectorImpares.length; i++)
            System.out.print(vectorImpares[i] + " ");

        System.out.println("\n");
        contarMayoresA20(vectorImpares);
    }
}
