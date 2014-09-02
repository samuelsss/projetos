package br.com.simova.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samuel Santos Silva
 */
@WebServlet(urlPatterns = {"/CalculoData"})
public class CalculoData extends HttpServlet {

    private Date dataInicial;
    private Date dataFinal;
    private long diaSoma;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String inicialData = request.getParameter("data1");
        String finalData = request.getParameter("data2");
        dataInicial = formataData(inicialData);
        dataFinal = formataData(finalData);

        diaSoma = diaTrabalhado(dataInicial, dataFinal);

        escreveResultado(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void escreveResultado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculo Data</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Calculo dias " + diaSoma + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    public int diaTrabalhado(Date dataInicial, Date dataFinal) {

        int diaTrabalhado = 0;
        int totalDia = calculoData(dataInicial, dataFinal);

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(dataInicial);

        for (int i = 0; i <= totalDia; i++) {

            if (!(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) && !(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
                diaTrabalhado++;
            }
            calendar.add(Calendar.DATE, 1);

        }
        return diaTrabalhado;
    }

    private int calculoData(Date initialDate, Date finalDate) {

        if (initialDate == null || finalDate == null) {
            return 0;
        }

        int dias = (int) ((finalDate.getTime() - initialDate.getTime()) / (24 * 60 * 60 * 1000));
        return (dias > 0 ? dias : 0);
    }

    private Date formataData(String stringDate) {

        Date date = null;

        try {
            SimpleDateFormat sdf
                    = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt_BR"));
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
