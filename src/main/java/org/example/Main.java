package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1 -> Auto.agregarAuto();
                case 2 -> Auto.mostrarTodos();
                case 3 -> Auto.busquedaPorPlaca();
                case 4 -> Auto.actualizarKilometraje();
                case 5 -> Auto.verificarAntiguedad();
                case 6 -> Auto.verificarMantenimiento();
                case 7 -> {
                    System.out.println("Saliendo del taller...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }

            if (!salir) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n---- TALLER MECÁNICO UNIMINUTO ----");
        System.out.println("1. Agregar un nuevo auto");
        System.out.println("2. Mostrar todos los autos");
        System.out.println("3. Buscar auto por placa");
        System.out.println("4. Actualizar kilometraje de un auto");
        System.out.println("5. Verificar si un auto es antiguo");
        System.out.println("6. Verificar si un auto necesita mantenimiento");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
