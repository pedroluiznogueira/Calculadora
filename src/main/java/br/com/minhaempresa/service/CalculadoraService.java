package br.com.minhaempresa.service;

import br.com.minhaempresa.domain.Operacao;

public class CalculadoraService {

    // processando o dado vindo do Servlet
    public double calcular(double operandoA, double operandoB, Operacao operacao) {
        double resultado = 0;

        switch (operacao) {
            case SOMA: {
                resultado = somar(operandoA, operandoB);
                break;
            }
            case SUBTRACAO: {
                resultado = subtrair(operandoA, operandoB);
                break;
            }
            case MULTIPLICACAO: {
                resultado = multiplicar(operandoA, operandoB);
                break;
            }
            case DIVISAO: {
                if (operandoB == 0) {
                    // aqui eu estou disparando uma excessão perante determinada condição
                    throw new IllegalArgumentException("operandoB nao pode valer 0");
                }
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
