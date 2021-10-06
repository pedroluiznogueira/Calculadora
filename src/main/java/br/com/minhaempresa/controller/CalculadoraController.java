package br.com.minhaempresa.controller;

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
        // acessando os parâmetros da requisição que vem como string então preciso de casting
        double operandoA = Double.valueOf(req.getParameter("operandoA"));
        double operandoB = Double.valueOf(req.getParameter("operandoB"));
        int operador = Integer.valueOf(req.getParameter("operador"));

        resp.getWriter().println("funcionando");

        double resultado = 0;

        // instanciar o calculadora service, para pegar informações do form
        CalculadoraService calculadoraService =  new CalculadoraService();
        resultado = calculadoraService.calcular(operandoA, operandoB, operador);

        resp.getWriter().println(resultado);

    }

    // testando o funcionamento do servlet ao chamar a url do servlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("servlet no ar");
    }

}
