package org.example;

class cuentaBancaria {
    String titular;
    double saldo;
    String numeroCuenta;

    cuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        saldo += cantidad;
        System.out.println("Has depositado $" + cantidad);
    }

    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("No tienes suficiente saldo.");
        } else {
            saldo -= cantidad;
            System.out.println("Has retirado $" + cantidad);
        }
    }

    public void mostrarInformacion() {
        System.out.println("\n--- Información de la Cuenta ---");
        System.out.println("Titular: " + titular);
        System.out.println("Número de Cuenta: " + numeroCuenta);
        System.out.println("Saldo Actual: $" + saldo);
    }
}

public class Bancosebas {
    public static void main(String[] args) {
        cuentaBancaria cuenta1 = new cuentaBancaria("Sebastian Rojas", "1888755666", 1000);

        cuenta1.mostrarInformacion();
        cuenta1.depositar(500);
        cuenta1.retirar(300);
        cuenta1.retirar(150);
        cuenta1.mostrarInformacion();
    }
}
