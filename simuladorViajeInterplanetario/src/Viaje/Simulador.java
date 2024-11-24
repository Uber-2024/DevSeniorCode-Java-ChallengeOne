package Viaje;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulador {
    // Declaración de variables y listas necesarias en los métodos
    static Scanner scanner = new Scanner(System.in);
    static List<String> planets = new ArrayList<>();
    static List<Double> distances = new ArrayList<>();
    static List<String> ships = new ArrayList<>();
    static List<Double> speeds = new ArrayList<>();
    static List<String> event = new ArrayList<>();
    static List<Double> avance = new ArrayList<>();
    static List<String> fuel = new ArrayList<>();
    static List<Double> resources = new ArrayList<>();

    static String Destiny;

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
            System.out.println("3. Iniciar simulación del viaje");
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
                        System.out.println(InfoPlanet("C:\\Programacion\\Java\\Modulo1\\infoMarte\\Marte.txt"));
                        naveSelection();
                
                    break;
                    case 2:

                    if (selection > 0 && selection <= planets.size()) 
                        planets.add(planets.get(selection));
                        distances.add(distances.get(selection));
                        System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                        
                        naveSelection();
                    
                    break;

                    case 3:

                    if (selection > 0 && selection <= planets.size()) 
                        planets.add(planets.get(selection));
                        distances.add(distances.get(selection));
                        System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                        
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

    public static void calculateResources() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n---Menú de cálculo de recursos para el viaje---");
            System.out.println("1. Combustible disponible viaje a Marte: 86.456Kg");
            System.out.println("2. Combustible disponible viaje a Júpiter: 145.112Kg");
            System.out.println("3. Combustible disponible viaje a Saturno: 193.486Kg");
            System.out.println("4. Salir");
            System.out.println("Elija una de las opciones por favor");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:

                    if (selection > 0 && selection <= fuel.size()) 
                        planets.add(fuel.get(selection));
                        resources.add(resources.get(selection));
                        System.out.println("El planeta seleccionado fue: " + fuel.get(selection - 1));
                        
                
                    break;
                    case 2:

                    if (selection > 0 && selection <= planets.size()) 
                        planets.add(planets.get(selection));
                        distances.add(distances.get(selection));
                        System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                        
                        naveSelection();
                    
                    break;

                    case 3:

                    if (selection > 0 && selection <= planets.size()) 
                        planets.add(planets.get(selection));
                        distances.add(distances.get(selection));
                        System.out.println("El planeta seleccionado fue: " + planets.get(selection - 1));
                        
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

    public static void travelStart() {

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
         
        while (!salir){
            System.out.println("\n---Menú de Selección Nave---");
            System.out.println("1. Argos: se trata de una nave de gran tamaño, pero es la de menor velocidad");
            System.out.println("2. Horizon: se trata de una nave de tamaño medio, su velocidad es intermedia");
            System.out.println("3. Starlite: se trata de una nave ligera, pero su velocidad es muy alta");
            System.out.println("4. Salir");
            System.out.println("Elija una de las opciones por favor");
            int selectionShip = scanner.nextInt();

            switch (selectionShip){
                
                case 1:
                    if (selectionShip > 0 && selectionShip <= ships.size()) 
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));
                        menuSelection();
                    break;

                    case 2:
                    if (selectionShip > 0 && selectionShip <= ships.size()) 
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));
                        menuSelection();
                    break;
                    case 3:
                    if (selectionShip > 0 && selectionShip <= ships.size()) 
                        ships.add(ships.get(selectionShip - 1));
                        speeds.add(speeds.get(selectionShip - 1));
                        System.out.println("La nave seleccionada fue: " + ships.get(selectionShip - 1));
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

    // metodos auxiliares
    public static String InfoPlanet(String direction) {//mandar la direccion del archivo
        String texto = "";
        try {//Programar el try
            BufferedReader bf = new BufferedReader(new FileReader(direction));
            String temp= "";
            String bfRead;
            while ((bfRead = bf.readLine())!=null) {
            // Realizar el ciclo mientras que bfRead tenga datos
            temp = temp+bfRead;//Guarda el texto obtenido
                
            }
            texto = temp;
        } catch (Exception e) {System.err.println("No se encontró el archivo");
            
        }
        return texto;

    }

    public static void lanzarEvento() {

    }

    public static void detenerNave() {

    }

}
