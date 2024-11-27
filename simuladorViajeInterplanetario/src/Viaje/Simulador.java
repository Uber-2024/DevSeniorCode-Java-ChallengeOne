package Viaje;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    // Definimos el tamaño máximo de la barra de carga
    private static final int max_bar_size = 50; // 50 es el tamaño de la barra de carga




    // metodos principales
    public static void menuSelection() throws InterruptedException {
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
            System.out.println("3. INICIAR VIAJE");
            System.out.println("4. Salir");
            System.out.println("Elija una de las opciones por favor");
            int option = scanner.nextInt();
            switch (option) {
                case 1:

                    planetSelection();

                    break;
                case 2:
                    // menú eleccion de naves
                    System.out.println("\n---Menú de selección de Naves---");
                    System.out.println("1. Seleccionar nave espacial para viajar a Marte");
                    System.out.println("2. Seleccionar nave espacial para viajar a Jupiter");
                    System.out.println("3. Seleccionar nave espacial para viajar a Saturno");
                    System.out.println("Elija una de las opciones por favor");
                    int optionnave = scanner.nextInt();
                    if (optionnave == 1)
                        shipSelectionMarte();
                    if (optionnave == 2)
                        shipSelectionJupiter();
                    if (optionnave == 3)
                        shipSelectionSaturno();
                    break;
                case 3:
                System.out.println("¡¡Antes de despegar, ingrese la cantidad de tripulantes de la nave para el viaje por favor!!!");
                var cantidad = scanner.nextInt();
                System.out.println("¡Muchas gracias por confirmar cuantos tripulantes van a viajar!. ¡¡Feliz Viaje!!!!");
                travelStart();

                    break;

                case 4:
                    salir = true;
                    System.out.println("Usted ha decidido salir del programa. Muchas gracias!!!");

                    break;

                default:

                    if (option <= 0 || option > 4) {
                        System.out.println("Usted ha ingresado una opción invalida, intente de nuevo por favor");
                    }

            }

        }
        
    }

    public static void planetSelection() throws InterruptedException {

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

                    if (selection > 0 && selection <= planets.size()) {
                        planets.add(planets.get(selection-1));
                        distances.add(distances.get(selection-1));
                        System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                        System.out.println(InfoPlanet(
                                "C:\\Programacion\\Java\\Modulo1\\SimuladorViaje\\simuladorViajeInterplanetario\\infoplanetas\\Marte.txt"));

                    }
                    shipSelectionMarte();
                    break;
                case 2:

                    if (selection > 0 && selection <= planets.size()) {
                        planets.add(planets.get(selection - 1));
                        distances.add(distances.get(selection - 1));
                        System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                        System.out.println(InfoPlanet(
                                "C:\\Programacion\\Java\\Modulo1\\SimuladorViaje\\simuladorViajeInterplanetario\\infoplanetas\\Jupiter.txt"));

                    }
                    shipSelectionJupiter();
                    break;

                case 3:

                    if (selection > 0 && selection <= planets.size()) {
                        planets.add(planets.get(selection - 1));
                        distances.add(distances.get(selection - 1));
                        System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                        System.out.println(InfoPlanet(
                                "C:\\Programacion\\Java\\Modulo1\\SimuladorViaje\\simuladorViajeInterplanetario\\infoplanetas\\Saturno.txt"));
                    }
                    shipSelectionSaturno();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Usted ha decidido salir del programa, gracias!!!");

                default:
                    if (selection <= 0) {
                        System.out.println("Usted ha ingresado una opción invalida, intente de nuevo por favor");
                    }

            }
        }

    }
    //Método para seleccionar nave para viajar a Marte y calcular recursos para el viaje
    public static void shipSelectionMarte() throws InterruptedException {

        // Agregamos las naves y sus velocidades

        ships.add("Argos");
        speeds.add(80.0000);
        ships.add("Horizon");
        speeds.add(120.0000);
        ships.add("Starlite");
        speeds.add(200.0000);

        boolean salir = false;
        // Menú elegir nave para viajar a Marte
        while (!salir) {
            System.out.println("\n---Menú de Selección Nave---");
            System.out.println(
                    "1. Argos: se trata de una nave de gran tamaño, transportará 50 tripulante, es la de menor velocidad, pero economiza combustible solo gasta 5000Kg por dia");
            System.out.println(
                    "2. Horizon: se trata de una nave de tamaño medio, transportará 25 tripulantes, su velocidad es intermedia y gasta unos 8000Kg de combustible diarios");
            System.out.println(
                    "3. Starlite: se trata de una nave ligera, transportará 10 tripulantes, su velocidad es muy alta pero es la de mayor consumo, gasta unos 10000Kg de combustible diarios");            
            System.out.println("Elija una de las opciones por favor");
            int selectionShip = scanner.nextInt();

            switch (selectionShip) {

                case 1:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 80.000;//Velocidad máxima de la nave 1
                        distance = 225; // Distancia media desde la tierra a Marte
                        double calculateTime = distance / velocity;
                        double tripDuration = calculateTime / 24;//Calcula cuanto demora el viaje hasta Marte con la nave 1
                        DecimalFormat df = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Marte" + df.format(tripDuration) + " dias");
                        double totalfuel = tripDuration * 5000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat def = new DecimalFormat(".##");
                        System.out.println("El combustible necesario para llegar a Marte viajando en la nave Argos es: "
                                + def.format(totalfuel) + "Kg");

                        double oxigentotal = 1 * 50 *tripDuration;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 1
                        System.out.println(
                                "El oxigeno necesario para llegar a Marte en la nave Argos es: " + oxigentotal
                                        + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!. Usted está listo para iniciar el viaje. Elija la opcion 3: INICIAR VIAJE del menú principal por favor");
                    }
                    menuSelection();
                    break;

                case 2:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 120.000;//Velocidad máxima de la nave 2
                        distance = 225;// Distancia media desde la tierra a Marte
                        double calculateTimej = distance / velocity;
                        double tripDurationj = calculateTimej / 24;//Calcula cuanto demora el viaje hasta Marte con la nave 2
                        DecimalFormat dfj = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Marte" + dfj.format(tripDurationj) + " dias");
                        double totalfuelj = tripDurationj * 8000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat defj = new DecimalFormat(".##");
                        System.out.println(
                                "El combustible necesario para llegar a Marte viajando en la nave Horizon es: "
                                        + defj.format(totalfuelj) + "Kg");

                        double oxigentotalj = 2 * 25 * tripDurationj;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 2
                        System.out.println(
                                "El oxigeno necesario para llegar a Marte en la nave Horizon es: " + oxigentotalj
                                        + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!. Usted está listo para iniciar el viaje. Elija la opcion 3: INICIAR VIAJE del menú principal por favor");
                    }
                    menuSelection();
                    break;
                case 3:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 200.000;//Velocidad máxima de la nave 3
                        distance = 225;// Distancia media desde la tierra a Marte
                        double calculateTimes = distance / velocity;
                        double tripDurations = calculateTimes / 24;//Calcula cuanto demora el viaje hasta Marte con la nave 3
                        DecimalFormat dfs = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Marte" + dfs.format(tripDurations) + " dias");
                        double totalfuels = tripDurations * 10000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat defs = new DecimalFormat(".##");
                        System.out.println(
                                "El combustible necesario para llegar a Marte viajando en la nave Starlite es: "
                                        + defs.format(totalfuels) + "Kg");

                        Double oxigentotals = 3 * 10 *tripDurations;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 3
                        System.out.println("El oxigeno necesario para llegar a Marte en la nave Starlite es: "
                                + oxigentotals + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!. Usted está listo para iniciar el viaje. Elija la opcion 3: INICIAR VIAJE del menú principal por favor");
                    }
                    menuSelection();
                    break;
                default:
                    if (selectionShip <= 0 || selectionShip>3) {
                        System.out.println("Usted ha ingresado una opción invalida, intente de nuevo por favor");
                    }
            }
            scanner.close();
        }salir=true;

    }
    //Método para seleccionar nave para viajar a Jupíter y calcular recursos para el viaje
    public static void shipSelectionJupiter() throws InterruptedException {

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
            System.out.println("Elija una de las opciones por favor");
            int selectionShip = scanner.nextInt();

            switch (selectionShip) {

                case 1:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 80.000;//Velocidad máxima de la nave 1
                        distance = 968; // Distancia media desde la tierra a Jupíter
                        double calculateTime = distance / velocity;
                        double tripDuration = calculateTime / 24;//Calcula cuanto demora el viaje hasta Jupíter con la nave 1
                        DecimalFormat df = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Jupiter" + df.format(tripDuration) + " dias");
                        double totalfuel = tripDuration * 5000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat def = new DecimalFormat(".##");
                        System.out
                                .println("El combustible necesario para llegar a Jupiter viajando en la nave Argos es: "
                                        + def.format(totalfuel) + "Kg");

                        double oxigentotal = 1 * 50 * tripDuration;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 1
                        System.out.println(
                                "El oxigeno necesario para llegar a Jupiter en la nave Argos es: " + oxigentotal
                                        + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!. Usted está listo para iniciar el viaje. Elija la opcion 3: INICIAR VIAJE del menú principal por favor");
                    }
                    menuSelection();
                    break;

                case 2:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 120.000;//Velocidad máxima de la nave 2
                        distance = 968;// Distancia media desde la tierra a Jupíter
                        double calculateTimej = distance / velocity;
                        double tripDurationj = calculateTimej / 24;//Calcula cuanto demora el viaje hasta Jupíter con la nave 2
                        DecimalFormat dfj = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Jupiter" + dfj.format(tripDurationj) + " dias");
                        double totalfuelj = tripDurationj * 8000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat defj = new DecimalFormat(".##");
                        System.out.println(
                                "El combustible necesario para llegar a Jupiter viajando en la nave Horizon es: "
                                        + defj.format(totalfuelj) + "Kg");

                        double oxigentotalj = 2 * 25 * tripDurationj;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 2
                        System.out.println(
                                "El oxigeno necesario para llegar a Júpiter en la nave Horizon es: " + oxigentotalj
                                        + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!. Usted está listo para iniciar el viaje. Elija la opcion 3: INICIAR VIAJE del menú principal por favor");
                    }
                    menuSelection();
                    break;
                case 3:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 200.000;//Velocidad máxima de la nave 3
                        distance = 968;// Distancia media desde la tierra a Jupíter
                        double calculateTimes = distance / velocity;
                        double tripDurations = calculateTimes / 24;//Calcula cuanto demora el viaje hasta Jupíter con la nave 3
                        DecimalFormat dfs = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Jupiter" + dfs.format(tripDurations) + " dias");
                        double totalfuels = tripDurations * 10000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat defs = new DecimalFormat(".##");
                        System.out.println(
                                "El combustible necesario para llegar a Jupiter viajando en la nave Starlite es: "
                                        + defs.format(totalfuels) + "Kg");

                        double oxigentotals = 3 * 10 * tripDurations;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 3
                        System.out.println("El oxigeno necesario para llegar a jupiter en la nave Starlite es: "
                                + oxigentotals + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!. Usted está listo para iniciar el viaje. Elija la opcion 3: INICIAR VIAJE del menú principal por favor");
                    }
                    menuSelection();
                    break;

                default:
                    if (selectionShip <= 0 || selectionShip>3) {
                        System.out.println("Usted ha ingresado una opción invalida, intente de nuevo por favor");
                    }
            }
            scanner.close();
        }salir=true;

    }
    //Método para seleccionar nave para viajar a Jupíter y calcular recursos para el viaje
    public static void shipSelectionSaturno() throws InterruptedException {

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
            System.out.println("Elija una de las opciones por favor");
            int selectionShip = scanner.nextInt();

            switch (selectionShip) {

                case 1:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 80.000;//Velocidad máxima de la nave 1
                        distance = 1275;// Distancia media desde la tierra a Saturno
                        double calculateTime = distance / velocity;
                        double tripDuration = calculateTime / 24;//Calcula cuanto demora el viaje hasta Saturno con la nave 1
                        DecimalFormat df = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Marte" + df.format(tripDuration) + " dias");
                        double totalfuel = tripDuration * 5000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat def = new DecimalFormat(".##");
                        System.out.println("El combustible necesario para llegar a Marte viajando en la nave Argos es: "
                                + def.format(totalfuel) + "Kg");

                        double oxigentotal = 1 * 50 * tripDuration;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 1
                        System.out.println(
                                "El oxigeno necesario para llegar a Marte en la nave Argos es: " + oxigentotal
                                        + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!. Usted está listo para iniciar el viaje. Elija la opcion 3: INICIAR VIAJE del menú principal por favor");
                    }
                    menuSelection();
                    break;

                case 2:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 120.000;//Velocidad máxima de la nave 2
                        distance = 1275;// Distancia media desde la tierra a Saturno
                        double calculateTimej = distance / velocity;
                        double tripDurationj = calculateTimej / 24;//Calcula cuanto demora el viaje hasta Saturno con la nave 2
                        DecimalFormat dfj = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Júpiter" + dfj.format(tripDurationj) + " dias");
                        double totalfuelj = tripDurationj * 8000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat defj = new DecimalFormat(".##");
                        System.out.println(
                                "El combustible necesario para llegar a Júpiter viajando en la nave Horizon es: "
                                        + defj.format(totalfuelj) + "Kg");

                        double oxigentotalj = 2 * 25 * tripDurationj;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 2
                        System.out.println(
                                "El oxigeno necesario para llegar a Júpiter en la nave Horizon es: " + oxigentotalj
                                        + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!. Usted está listo para iniciar el viaje, elija la opcion 3 INICIAR VIAJE, del menú principal por favor");
                    }
                    menuSelection();
                    break;
                case 3:
                    if (selectionShip > 0 && selectionShip <= ships.size()) {
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));

                        velocity = 200.000;//Velocidad máxima de la nave 3
                        distance = 1275;// Distancia media desde la tierra a Saturno
                        double calculateTimes = distance / velocity;
                        double tripDurations = calculateTimes / 24;//Calcula cuanto demora el viaje hasta Saturno con la nave 3
                        DecimalFormat dfs = new DecimalFormat(".###");
                        System.out.println("Usted tardará en llegar a Saturno" + dfs.format(tripDurations) + " dias");
                        double totalfuels = tripDurations * 10000;//Calcula el gasto de combustible durante el viaje en Kg
                        DecimalFormat defs = new DecimalFormat(".##");
                        System.out.println(
                                "El combustible necesario para llegar a Saturno viajando en la nave Starlite es: "
                                        + defs.format(totalfuels) + "Kg");

                        Double oxigentotals = 3 * 10 * tripDurations;//Calcula el oxígeno necesario para realizar el viaje completo en la nave 3
                        System.out.println("El oxigeno necesario para llegar a Saturno en la nave Starlite es: "
                                + oxigentotals + "Kg diarios");
                        System.out.println(
                                "¡¡Felicidades!!!.Usted está listo para iniciar el viaje. Elija la opcion 3: INICIAR VIAJE, del menú principal por favor");
                    }
                    menuSelection();
                    break;
                default:
                    if (selectionShip <= 0 || selectionShip>3) {
                        System.out.println("Usted ha ingresado una opción invalida, intente de nuevo por favor");
                    }
            }
            scanner.close();
        }salir=true;

    }

    public static void travelStart() throws InterruptedException {
// Llamada al evento de simulación de avance del viaje
       
       showLoadBar(max_bar_size);
         // Método para simular el progreso de una tarea
        for (int i = 0; i <= max_bar_size; i++) {
            showLoadBar(i); // Mostramos el progreso en la barra de carga
            Thread.sleep(300); // Espera de 1000ms entre actualizaciones (simula el trabajo)
        }
        System.out.println("\n¡¡Felicitaciones usted ha completado el viaje con éxito..");
       
        
        System.out.println("le gustaría viajar de nuevo?(sí/no)");
        boolean salir=false;
        while (true) {
        String respuesta = scanner.next();
        
                if (!respuesta.equalsIgnoreCase("si")){ 
             // Salir del bucle si el usuario no quiere continuar
             System.out.println("Usted ha decidido salir del programa. Muchas gracias por viajar, regrese pronto!!!");
             salir = true;
             
                }else {
                menuSelection();
            
            }
             
            }
            
    }
          

    
     
   
    public static void main(String[] args) throws InterruptedException {
        
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

    // Método para simular el progreso de la barra de carga
    public static void showLoadBar(int progress) {
        // Lista que representa el estado de la barra de carga
        List<String> barra = new ArrayList<>();

        // Llenamos la barra con espacio vacío hasta el progreso actual
        for (int i = 0; i < progress; i++) {
            barra.add("#"); // El símbolo "#" representa una parte cargada
        }

        // Llenamos el resto con espacios en blanco
        for (int i = progress; i < max_bar_size; i++) {
            barra.add(" ");
        }

        // Imprimimos la barra en consola
        System.out.print("\r[");
        for (String segmento : barra) {
            System.out.print(segmento);
        }
        System.out.print("] " + (progress * 100 / max_bar_size) + "%");
    }

    





    public static void lanzarEvento() {
        //Lista de Eventos
        var events= List.of("Lluvia de meteoritos","Baja de oxígeno", "Daño catastrófico en motor","Tormenta solar", "Enfermedad de tripulante" );
        var sc = new Scanner(System.in);
        var rnd= new Random();

        var unexpected=false;
        do {
            var event=events.get(rnd.nextInt(events.size()));
            System.out.print("¿Desea Continuar?(s/n): ");
            var option= sc.nextLine();
            unexpected= !option.equalsIgnoreCase("N");
        } while (unexpected);
        System.out.println("Sue viaje ha terminado, usted ha regresado a la Tierra");
    }

    public static void detenerNave() {

    }

}

