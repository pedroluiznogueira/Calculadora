package br.com.minhaempresa.controller;

import br.com.minhaempresa.domain.Operacao;
import br.com.minhaempresa.service.CalculadoraService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// passando a uri do servlet
@WebServlet(urlPatterns = "/calcular")
public class CalculadoraController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // acessando os parâmetros da requisição que vem como string então preciso de casting
            double operandoA = Double.valueOf(req.getParameter("operandoA"));
            double operandoB = Double.valueOf(req.getParameter("operandoB"));
            int operador = Integer.valueOf(req.getParameter("operador"));

            resp.getWriter().println("funcionando");

            double resultado = 0;

            // instanciar o calculadora service, para pegar informações do form, aqui está a relação entre quem trata os dados (controller) e quem os processa (service)
            CalculadoraService calculadoraService =  new CalculadoraService();
            // inicializando como null para o intelliJ não reclamar
            Operacao operacao = null;

            // fazendo como se fosse um casting, pois a operação chega como inteiro, então preciso para cada situação de inteiro, referenciar a operação relacionada do enum
            switch (operador) {
                case 0: {
                    operacao = Operacao.SOMA;
                    break;
                }
                case 1: {
                    operacao = Operacao.SUBTRACAO;
                    break;
                }
                case 2: {
                    operacao = Operacao.MULTIPLICACAO;
                    break;
                }
                case 3: {
                    operacao = Operacao.DIVISAO;
                    break;
                }
                default: {}
            }

            resultado = calculadoraService.calcular(operandoA, operandoB, operacao);

            resp.getWriter().println(resultado);

        } catch (NumberFormatException e) {
            resp.getWriter().println("Error NumberFormatException: " + e.getMessage());
        }
        // aqui estou tratando a excessão que está sendo disparada caso a condição seja verdadeira e usando a menssagem passada como parâmetro para a exception
        catch (IllegalArgumentException e) {
            resp.getWriter().println("Error IllegalArgumentException: " + e.getMessage());
        } catch (Exception e) {
            resp.getWriter().println("Error Exception: " + e.getMessage());
        }

    }

    // testando o funcionamento do servlet ao chamar a url do servlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("servlet no ar");
    }

}
