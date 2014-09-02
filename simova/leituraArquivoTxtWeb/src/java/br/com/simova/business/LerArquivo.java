/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.simova.business;

import br.com.simova.model.Cliente;
import br.com.simova.model.Item;
import br.com.simova.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel Santos Silva
 */
@WebServlet(name = "LerArquivo", urlPatterns = {""})
public class LerArquivo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            LerArquivoBO lerArquivoBO = new LerArquivoBO();

            Collection<String[]> parameterNames = request.getParameterMap().values();
            String urlRequest = null;
            float valorTotal = 0;

            for (Object object : parameterNames) {
                String[] strings = (String[]) object;
                for (String string : strings) {
                    urlRequest = string;
                }
                break;
            }

            URL url = new URL(urlRequest);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            Cliente cliente = lerArquivoBO.lerPorNomeCliente(bufferedReader);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>SIMOVA</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>------------ Dados Cadastrais ------------</h1>");
            out.println("<h1>Nome Cliente:" + cliente.getNome() + "</h1>");
            out.println("<h1>CPF:" + cliente.getCpf() + "</h1>");
            out.println("<h1>Telefone:" + cliente.getTelefone() + "</h1><br/>");

            out.println("<h1>------------ Pedidos Cliente -------------</h1>");
            for (Item item : cliente.getItems()) {
                out.println("<h1>Produto:" + item.getNomeProduto() + "Valor: R$" + item.getValor() + "</h1>");
                valorTotal += item.getValor();
            }
            out.println("<h1>Total da compra: R$" + valorTotal + "</h1>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
