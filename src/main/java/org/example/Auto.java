package org.example;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

public class Auto {
    private String Marca;
    private String Modelo;
    private int Anio;
    private Double Kilometraje;
    private String EstadodelVehiculo;
    private String Placa;

    private static ArrayList<Auto> listaAutos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Auto() {
    }

    public Auto(String marca, String modelo, int anio, Double kilometraje, String estadodelVehiculo, String placa) {
        this.Marca = marca;
        this.Modelo = modelo;
        this.Anio = anio;
        this.Kilometraje = kilometraje;
        this.EstadodelVehiculo = estadodelVehiculo;
        this.Placa = placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int anio) {
        Anio = anio;
    }

    public Double getKilometraje() {
        return Kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        Kilometraje = kilometraje;
    }

    public String getEstadodelVehiculo() {
        return EstadodelVehiculo;
    }

    public void setEstadodelVehiculo(String estadodelVehiculo) {
        EstadodelVehiculo = estadodelVehiculo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public void mostrar_Detalles() {
        System.out.println("Marca: " + Marca);
        System.out.println("Modelo: " + Modelo);
        System.out.println("Año: " + Anio);
        System.out.println("Kilometraje: " + Kilometraje);
        System.out.println("Estado del Vehiculo: " + EstadodelVehiculo);
        System.out.println("Placa del Vehiculo: " + Placa);
    }

    public static void agregarAuto() {
        System.out.println("Agregar Nuevo Auto");

        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        if (buscarAutoPorPlaca(placa) != null) {
            System.out.println("Error: Ya existe un auto con esa placa.");
            return;
        }

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Año: ");
        int anio = Integer.parseInt(scanner.nextLine());

        System.out.print("Kilometraje: ");
        double kilometraje = Double.parseDouble(scanner.nextLine());

        System.out.print("Estado del vehículo: ");
        String estado = scanner.nextLine();

        Auto nuevoAuto = new Auto(marca, modelo, anio, kilometraje, estado, placa);
        listaAutos.add(nuevoAuto);
        System.out.println("Auto agregado correctamente.");
    }

    public static void mostrarTodos() {
        if (listaAutos.isEmpty()) {
            System.out.println("No hay autos registrados.");
            return;
        }

        System.out.println("\nLista de Autos Registrados:");
        for (Auto auto : listaAutos) {
            auto.mostrar_Detalles();
            System.out.println("-----------------------------");
        }
    }

    public static void busquedaPorPlaca() {
        System.out.print("Ingrese la placa a buscar: ");
        String placa = scanner.nextLine();
        Auto auto = buscarAutoPorPlaca(placa);

        if (auto != null) {
            System.out.println("\nAuto Encontrado:");
            auto.mostrar_Detalles();
        } else {
            System.out.println("No se encontró ningún auto con la placa: " + placa);
        }
    }

    private static Auto buscarAutoPorPlaca(String placa) {
        for (Auto auto : listaAutos) {
            if (auto.getPlaca().equalsIgnoreCase(placa)) {
                return auto;
            }
        }
        return null;
    }

    public static void actualizarKilometraje() {
        System.out.print("Ingrese la placa del auto: ");
        Auto auto = buscarAutoPorPlaca(scanner.nextLine());
        if (auto == null) {
            System.out.println("Auto no encontrado.");
            return;
        }

        System.out.print("Ingrese el nuevo kilometraje: ");
        double nuevoKilometraje = Double.parseDouble(scanner.nextLine());
        auto.setKilometraje(nuevoKilometraje);
        System.out.println("Kilometraje actualizado correctamente.");
    }

    public static void verificarAntiguedad() {
        System.out.print("Ingrese la placa del auto: ");
        Auto auto = buscarAutoPorPlaca(scanner.nextLine());
        if (auto == null) {
            System.out.println("Auto no encontrado.");
            return;
        }

        int anioActual = Year.now().getValue();
        boolean esAntiguo = (anioActual - auto.getAnio()) > 15;

        System.out.println("El auto con placa " + auto.getPlaca() +
                (esAntiguo ? " es antiguo." : " no es antiguo."));
    }

    public static void verificarMantenimiento() {
        System.out.print("Ingrese la placa del auto: ");
        Auto auto = buscarAutoPorPlaca(scanner.nextLine());
        if (auto == null) {
            System.out.println("Auto no encontrado.");
            return;
        }

        boolean necesitaMantenimiento = auto.getKilometraje() > 100000;
        System.out.println("El auto con placa " + auto.getPlaca() +
                (necesitaMantenimiento ? " necesita mantenimiento." : " no necesita mantenimiento."));
    }
}
