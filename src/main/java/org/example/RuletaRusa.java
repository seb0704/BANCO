package org.example;

import java.util.Random;

public class RuletaRusa {
    private int[] tambor = {0, 1, 2, 3, 4, 5};
    private int bala;
    private int posicionActual;
    private Random random;

    public RuletaRusa() {
        random = new Random();
        reiniciarJuego();
    }
    public boolean disparar() {
        System.out.println("------------------------------------------");
        System.out.println("poscion actual del tambor: " + posicionActual );
        System.out.println("------------------------------------------");
        System.out.println("poscion actual del bala: " + bala );
        if (posicionActual == bala) {
            System.out.println("la posicion de la bala: " + bala);
            return true;
        }
        bala = random.nextInt(2);
                posicionActual = (posicionActual + 1) % tambor.length;
        return false;
    }
    public void reiniciarJuego() {
        bala = random.nextInt(6);
        posicionActual = 0;
    }
}