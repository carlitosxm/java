package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class CalculadoraAmortizacion {

    public static double calcularCuota(Prestamo prestamo) {
        double monto = prestamo.getMonto();
        double tasaAnual = prestamo.getInteres();
        int plazo = prestamo.getPlazo();

        double tasaMensual = tasaAnual / 12 / 100;

        double cuota = (monto * tasaMensual) / (1 - Math.pow(1 + tasaMensual, -plazo));
        cuota = Math.round(cuota * 100.0) / 100.0;
        return cuota;
    }

    public static void generarTabla(Prestamo prestamo) {
        double cuotaValor = calcularCuota(prestamo);
        int plazo = prestamo.getPlazo();

        prestamo.getCuotas().clear();

        for (int i = 1; i <= plazo; i++) {
            Cuota cuota = new Cuota(i);
            cuota.setCuota(cuotaValor);
            prestamo.getCuotas().add(cuota);
        }

        prestamo.getCuotas().get(0).setInicio(prestamo.getMonto());

        for (int i = 0; i < plazo; i++) {
            Cuota actual = prestamo.getCuotas().get(i);
            Cuota siguiente = (i < plazo - 1) ? prestamo.getCuotas().get(i + 1) : null;
            calcularValoresCuota(prestamo.getInteres(), actual, siguiente);
        }

        Cuota ultima = prestamo.getCuotas().get(plazo - 1);
        if (ultima.getSaldo() != 0) {
            double ajuste = ultima.getSaldo();
            ultima.setAbonoCapital(ultima.getAbonoCapital() + ajuste);
            ultima.setSaldo(0);
        }
    }

    public static void calcularValoresCuota(double interesAnual, Cuota actual, Cuota siguiente) {
        double tasaMensual = interesAnual / 12 / 100;

        double inicio = actual.getInicio();
        double valorInteres = inicio * tasaMensual;
        double abonoCapital = actual.getCuota() - valorInteres;
        double saldo = inicio - abonoCapital;

        valorInteres = Math.round(valorInteres * 100.0) / 100.0;
        abonoCapital = Math.round(abonoCapital * 100.0) / 100.0;
        saldo = Math.round(saldo * 100.0) / 100.0;

        actual.setInteres(valorInteres);
        actual.setAbonoCapital(abonoCapital);
        actual.setSaldo(saldo);

        if (siguiente != null) {
            siguiente.setInicio(saldo);
        }
    }

    public static void mostrarTabla(Prestamo prestamo) {
        System.out.printf("%-3s | %-10s | %-10s | %-10s | %-10s | %-10s%n",
                          "N°", "Cuota", "Inicio", "Interés", "Abono", "Saldo");
        System.out.println("-------------------------------------------------------------");

        for (Cuota cuota : prestamo.getCuotas()) {
            cuota.mostrarPrestamo();
        }
    }
}