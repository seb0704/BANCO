package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=========================================");
            System.out.println("===== Menú Ruleta Rusa Sebastian Rojas ====");
            System.out.println("===========================================");
            System.out.println("============= 1. Iniciar juego ============");
            System.out.println("============= 2️. Salir         ============");
            System.out.println("===========================================");
            System.out.print("===========>>> Elige una opción: ");

            String opcion = scanner.nextLine().trim();
            if (opcion.equals("2")) {
                System.out.println("Gracias por jugar a la ruleta SEBAS");
                System.out.println("====================================");
                break;
            } else if (opcion.equals("1")) {
                System.out.print("Cuántos jugadores: ");
                int numJugadores;
                try {
                    numJugadores = Integer.parseInt(scanner.nextLine().trim());
                    if (numJugadores < 1) {
                        System.out.println("Al menos un jugador.");
                        System.out.println("==============================");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Intente de nuevo.");
                    continue;
                }
                ArrayList<String> jugadores = new ArrayList<>();
                for (int i = 1; i <= numJugadores; i++) {
                    System.out.print("Nombre Jugador " + i + ": ");
                    jugadores.add(scanner.nextLine().trim());
                }
                jugar(scanner, jugadores);
            }
        }
    }
    public static void jugar(Scanner scanner, ArrayList<String> jugadores) {
        RuletaRusa juego = new RuletaRusa();
        Random random = new Random();
        int turno = random.nextInt(jugadores.size());

        System.out.println("\nEl juego comenzó, buena suerte bro.");
        System.out.println("Empieza el jugador: " + jugadores.get(turno));

        while (true) {
            String jugadorActual = jugadores.get(turno);
            System.out.println("\nTurno de: " + jugadorActual);
            System.out.println("1️. Dispara Bro");
            System.out.println("2. Salir del juego");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1":
                    if (juego.disparar()) {
                        System.out.println("Te mataron, " + jugadorActual + " perdió bro.");
                        return;
                    } else {
                        System.out.println("Qué de buenas, " + jugadorActual + " sobrevivió... siguiente turno!");
                        turno = (turno + 1) % jugadores.size();
                    }
                    break;
                case "2":
                    System.out.println("El juego ha terminado.");
                    return;
                default:
                    System.out.println("Intente de nuevo.");
            }
        }
    }
}
