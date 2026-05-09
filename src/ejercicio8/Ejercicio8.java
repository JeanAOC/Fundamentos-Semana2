package ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {

    static Scanner sc = new Scanner(System.in);

    static int calcularGrado(int horasAusencia, int defectuosos, int producidos) {
        boolean c1 = horasAusencia <= 3;
        boolean c2 = defectuosos < 300;
        boolean c3 = producidos > 10000;

        if (c1 && c2 && c3) return 20;
        if (c1 && c3) return 13;
        if (c2 && c3) return 15;
        if (c1 && c2) return 12;
        if (c3) return 9;
        if (c2) return 8;
        if (c1) return 7;
        return 5;
    }

    static void ingresarYMostrarOperarios(int n) {
        System.out.println("\n===== RESULTADO POR OPERARIO =====");
        for (int i = 0; i < n; i++) {
            System.out.println("\nOperario " + (i + 1) + ":");
            System.out.print("  Codigo: ");
            int codigo = sc.nextInt();
            System.out.print("  Horas de ausencia: ");
            int horas = sc.nextInt();
            System.out.print("  Pupitres defectuosos: ");
            int defectuosos = sc.nextInt();
            System.out.print("  Pupitres producidos: ");
            int producidos = sc.nextInt();

            int grado = calcularGrado(horas, defectuosos, producidos);

            System.out.println("  --- Informacion ---");
            System.out.println("  Codigo: " + codigo);
            System.out.println("  Horas de ausencia: " + horas);
            System.out.println("  Pupitres defectuosos: " + defectuosos);
            System.out.println("  Pupitres producidos: " + producidos);
            System.out.println("  Grado de eficiencia: " + grado);
        }
    }

    public static void main(String[] args) {
        System.out.print("Cuantos operarios hay (N): ");
        int n = sc.nextInt();

        ingresarYMostrarOperarios(n);
    }
}
