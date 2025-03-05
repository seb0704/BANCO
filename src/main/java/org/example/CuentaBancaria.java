package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class CuentaBancaria {
    String titular;
    double saldo;
    String numeroCuenta;

    CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
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

class bancosebas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<cuentaBancaria> cuentas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear cuenta bancaria");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Mostrar información de una cuenta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre para crear cuenta:");
                    String titular = scanner.nextLine();
                    System.out.println("Ingrese el número de cuenta que desea:");
                    String numeroCuenta = scanner.nextLine();
                    System.out.println("Ingrese el saldo inicial de tu cuenta:");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine();
                    cuentas.add(new cuentaBancaria(titular, numeroCuenta, saldoInicial));
                    System.out.println("Cuenta creada con éxito!");
                    break;
                case 2:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numDep = scanner.nextLine();
                    for (cuentaBancaria cuenta : cuentas) {
                        if (cuenta.numeroCuenta.equals(numDep)) {
                            System.out.print("Ingrese la cantidad a depositar: ");
                            double deposito = scanner.nextDouble();
                            cuenta.depositar(deposito);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numRet = scanner.nextLine();
                    for (cuentaBancaria cuenta : cuentas) {
                        if (cuenta.numeroCuenta.equals(numRet)) {
                            System.out.print("Ingrese la cantidad a retirar: ");
                            double retiro = scanner.nextDouble();
                            cuenta.retirar(retiro);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el número de cuenta: ");
                    String numInfo = scanner.nextLine();
                    for (cuentaBancaria cuenta : cuentas) {
                        if (cuenta.numeroCuenta.equals(numInfo)) {
                            cuenta.mostrarInformacion();
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
