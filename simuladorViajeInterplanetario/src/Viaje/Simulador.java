package Viaje;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {
    // Declaración de variables y ArrayList necesarias en los métodos
    static Scanner scanner = new Scanner(System.in);
    static List<String> planets = new ArrayList<>();
    static List<Double> distances = new ArrayList<>();
    static List<String> ships = new ArrayList<>();
    static List<Double> speeds = new ArrayList<>();
    static List<String> event = new ArrayList<>();
    static List<Double> avance = new ArrayList<>();    
    static double tripDuration;
    static double velocity;
    static double distance;

    public static void main(String[] args) {

    }

    // metodos principales
    public static void menuSelection() {
        // Agregamos los planetas y las distancias desde la Tierra de cada uno

        planets.add("Marte");
        distances.add(225.000000);
        planets.add("Júpiter");
        distances.add(965.000000);
        planets.add("Saturno");
        distances.add(1345.000000);

        boolean salir = false;

        while (!salir) {

            // menú de opciones generales
            System.out.println("\n---MENÚ DE SELECCIÓN PRINCIPAL---");
            System.out.println("1. Seleccionar planeta de destino");
            System.out.println("2. Seleccionar nave espacial");
            System.out.println("3. Iniciar viaje");
            System.out.println("4. Salir");
            System.out.println("Elija una de las opciones por favor");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if (option == 1) {
                        planetSelection();
                    }

                    break;
                case 2:
                    if (option == 2) {
                        naveSelection();
                    }
                    break;
                case 3:
                    if (option == 3) {
                        travelStart();
                    }
                    break;
                case 4:
                    salir = true;
                    System.out.println("Usted ha decidido salir del programa, gracias!!!");

                default:
                    System.out.println("Usted ha ingresado una opción invalida, intente de nuevo por favor");
                    break;
            }
            scanner.close();
        }
    }

    public static void planetSelection() {

        boolean salir = false;
        while (!salir) {
            System.out.println("\n---Menú de Selección Planeta de Destino---");
            System.out.println("1. Marte:");
            System.out.println("2. Júpiter");
            System.out.println("3. Saturno ");
            System.out.println("4. Salir");
            System.out.println("Elija una de las opciones por favor");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:

                    if (selection > 0 && selection <= planets.size())
                        planets.add(planets.get(selection));
                    distances.add(distances.get(selection));
                    System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                    System.out.println(InfoPlanet(
                            "C:\\Programacion\\Java\\Modulo1\\SimuladorViaje\\simuladorViajeInterplanetario\\infoplanetas\\Marte.txt"));
                    naveSelection();

                    break;
                case 2:

                    if (selection > 0 && selection <= planets.size())
                        planets.add(planets.get(selection));
                    distances.add(distances.get(selection));
                    System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                    System.out.println(InfoPlanet(
                            "C:\\Programacion\\Java\\Modulo1\\SimuladorViaje\\simuladorViajeInterplanetario\\infoplanetas\\Jupiter.txt"));
                    naveSelection();

                    break;

                case 3:

                    if (selection > 0 && selection <= planets.size())
                        planets.add(planets.get(selection));
                    distances.add(distances.get(selection));
                    System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                    System.out.println(InfoPlanet(
                            "C:\\Programacion\\Java\\Modulo1\\SimuladorViaje\\simuladorViajeInterplanetario\\infoplanetas\\Saturno.txt"));
                    naveSelection();

                    break;

                case 4:
                    salir = true;

                    System.out.println("Usted ha decidido salir del programa, gracias!!!");
                    break;

                default:

                    System.out.println("Usted ha ingresado una opción invalida, intente de nuevo por favor");
            }
        }

        scanner.close();

    }

    public static void naveSelection() {

        // Agregamos las naves y sus velocidades

        ships.add("Argos");
        speeds.add(80.0000);
        ships.add("Horizon");
        speeds.add(120.0000);
        ships.add("Starlite");
        speeds.add(200.0000);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n---Menú de Selección Nave---");
            System.out.println(
                    "1. Argos: se trata de una nave de gran tamaño, transportará 50 tripulante, es la de menor velocidad, pero economiza combustible solo gasta 5000Kg por dia");
            System.out.println(
                    "2. Horizon: se trata de una nave de tamaño medio, transportará 25 tripulantes, su velocidad es intermedia y gasta unos 8000Kg de combustible diarios");
            System.out.println(
                    "3. Starlite: se trata de una nave ligera, transportará 10 tripulantes, su velocidad es muy alta pero es la de mayor consumo, gasta unos 10000Kg de combustible diarios");
            System.out.println("4. Salir");
            System.out.println("Elija una de las opciones por favor");
            int selectionShip = scanner.nextInt();

            switch (selectionShip) {

                case 1:
                    if (selectionShip > 0 && selectionShip <= ships.size())
                        ships.add(ships.get(selectionShip - 1));
                    speeds.add(speeds.get(selectionShip - 1));
                    System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                    velocity = 80.000;
                    distance = 225;
                    double calculateTime = distance / velocity;
                    double tripDuration = calculateTime / 24;
                    DecimalFormat df = new DecimalFormat(".###");
                    System.out.println("Usted tardará en llegar a Marte" + df.format(tripDuration) + " dias");
                    double totalfuel = tripDuration * 5000;
                    DecimalFormat def = new DecimalFormat(".##");
                    System.out.println("El combustible necesario para llegar a Marte viajando en la nave Argos es: "
                            + def.format(totalfuel) + "Kg");

                    int oxigentotal = 1 * 50;
                    System.out.println(
                            "El oxigeno necesario para llegar a Marte en la nave Argos es: " + oxigentotal + "Kg");
                    System.out.println(
                            "Usted está listo para iniciar el viaje, elija la opcion 3. Iniciar viaje del menú por favor");

                    menuSelection();
                    break;

                case 2:
                    if (selectionShip > 0 && selectionShip <= ships.size())
                        ships.add(ships.get(selectionShip - 1));
                    speeds.add(speeds.get(selectionShip - 1));
                    System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                    velocity = 120.000;
                    distance = 968;
                    double calculateTimej = distance / velocity;
                    double tripDurationj = calculateTimej / 24;
                    DecimalFormat dfj = new DecimalFormat(".###");
                    System.out.println("Usted tardará en llegar a Júpiter" + dfj.format(tripDurationj) + " dias");
                    double totalfuelj = tripDurationj * 8000;
                    DecimalFormat defj = new DecimalFormat(".##");
                    System.out.println("El combustible necesario para llegar a Júpiter viajando en la nave Horizon es: "
                            + defj.format(totalfuelj) + "Kg");

                    int oxigentotalj = 1 * 25;
                    System.out.println(
                            "El oxigeno necesario para llegar a Júpiter en la nave Horizon es: " + oxigentotalj + "Kg");
                    System.out.println(
                            "Usted está listo para iniciar el viaje, elija la opcion 3. Iniciar viaje del menú por favor");

                    menuSelection();
                    break;
                case 3:
                    if (selectionShip > 0 && selectionShip <= ships.size())
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 200.000;
                        distance = 1275;
                        double calculateTimes = distance / velocity;
                        double tripDurations = calculateTimes / 24;
                        DecimalFormat dfs = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Saturno" + dfs.format(tripDurations) + " dias");
                        double totalfuels = tripDurations * 10000;
                        DecimalFormat defs = new DecimalFormat(".##");
                        System.out.println("El combustible necesario para llegar a Saturno viajando en la nave Starlite es: "
                        + defs.format(totalfuels) + "Kg");

                        int oxigentotals = 1 * 10;
                        System.out.println("El oxigeno necesario para llegar a Saturno en la nave Starlite es: " + oxigentotals + "Kg");
                        System.out.println("Usted está listo para iniciar el viaje, elija la opcion 3. Iniciar viaje del menú por favor");

                    menuSelection();
                    break;

                case 4:
                    salir = true;
                    System.out.println("Usted ha decidido salir del programa, gracias!!!");
                    break;

                default:

                    System.out.println("Usted ha ingresado una opción invalida, intente de nuevo por favor");

            }
        }

        scanner.close();

    }

    public static void travelStart() {

    }

    // metodos auxiliares
    public static String InfoPlanet(String direction) {// mandar la direccion del archivo
        String texto = "";
        try {// Programar el try
            BufferedReader bf = new BufferedReader(new FileReader(direction));
            String temp = "";
            String bfRead;
            while ((bfRead = bf.readLine()) != null) {
                // Realizar el ciclo mientras que bfRead tenga datos
                temp = temp + bfRead;// Guarda el texto obtenido

            }
            texto = temp;
        } catch (Exception e) {
            System.err.println("No se encontró el archivo");

        }
        return texto;

    }

    public static void lanzarEvento() {

    }

    public static void detenerNave() {

    }

}
