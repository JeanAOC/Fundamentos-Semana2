package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {

    static Scanner sc = new Scanner(System.in);
    static final int MATERIAS = 8;

    static double[][] ingresarNotas(int n) {
        double[][] notas = new double[n][MATERIAS];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");
            for (int j = 0; j < MATERIAS; j++) {
                System.out.print("  Calificación Materia " + (j + 1) + ": ");
                notas[i][j] = sc.nextDouble();
            }
        }
        return notas;
    }

    static void promedioPorEstudiante(double[][] notas, int n) {
        System.out.println("\n===== PROMEDIO POR ESTUDIANTE =====");
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < MATERIAS; j++)
                suma += notas[i][j];
            System.out.printf("  Estudiante %d: %.2f%n", (i + 1), suma / MATERIAS);
        }
    }

    static void promedioPorMateria(double[][] notas, int n) {
        System.out.println("\n===== PROMEDIO POR MATERIA =====");
        for (int j = 0; j < MATERIAS; j++) {
            double suma = 0;
            for (int i = 0; i < n; i++)
                suma += notas[i][j];
            System.out.printf("  Calificación Materia %d: %.2f%n", (j + 1), suma / n);
        }
    }

    static void estudianteMayorPromedio(double[][] notas, int n) {
        int mejorEstudiante = 0;
        double mejorPromedio = 0;
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < MATERIAS; j++)
                suma += notas[i][j];
            double promedio = suma / MATERIAS;
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorEstudiante = i;
            }
        }
        System.out.printf("%n===== ESTUDIANTE CON MAYOR PROMEDIO =====%n");
        System.out.printf("  Estudiante %d con promedio %.2f%n", (mejorEstudiante + 1), mejorPromedio);
    }

    static void aprobadosReprobadosPorMateria(double[][] notas, int n) {
        System.out.println("\n===== APROBADOS Y REPROBADOS POR MATERIA =====");
        for (int j = 0; j < MATERIAS; j++) {
            int aprobados = 0;
            int reprobados = 0;
            for (int i = 0; i < n; i++) {
                if (notas[i][j] >= 7 && notas[i][j] <= 10)
                    aprobados++;
                else
                    reprobados++;
            }
            System.out.println("  Calificación Materia " + (j + 1) + " -> Aprobados: " + aprobados + "  Reprobados: " + reprobados);
        }
    }

    public static void main(String[] args) {
        System.out.print("Cuantos estudiantes hay (N): ");
        int n = sc.nextInt();

        double[][] notas = ingresarNotas(n);

        promedioPorEstudiante(notas, n);
        promedioPorMateria(notas, n);
        estudianteMayorPromedio(notas, n);
        aprobadosReprobadosPorMateria(notas, n);
    }
}
