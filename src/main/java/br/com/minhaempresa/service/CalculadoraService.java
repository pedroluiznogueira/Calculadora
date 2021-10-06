package br.com.minhaempresa.service;

public class CalculadoraService {

    // processando o dado vindo do Servlet
    public double calcular(double operandoA, double operandoB, int operacao) {
        double resultado = 0;

        switch (operacao) {
            case 0: {
                resultado = somar(operandoA, operandoB);
                break;
            }
            case 1: {
                resultado = subtrair(operandoA, operandoB);
                break;
            }
            case 2: {
                resultado = multiplicar(operandoA, operandoB);
                break;
            }
            case 3: {
                resultado = dividir(operandoA, operandoB);
                break;
            }
            default: {}
        }

        return resultado;
    }

    private double somar(double operandoA, double operandoB) {
        return operandoA + operandoB;
    }

    private double subtrair(double operandoA, double operandoB) {
        return operandoA - operandoB;
    }

    private double multiplicar(double operandoA, double operandoB) {
        return operandoA * operandoB;
    }

    private double dividir(double operandoA, double operandoB) {
        return operandoA / operandoB;
    }
}
