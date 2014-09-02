<%-- 
    Document   : index
    Created on : 30/08/2014, 19:57:05
    Author     : Samuel Santos Silva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Calculo</title>
    </head>
    <body>
        <form action="CalculoData" method="get">
            <h1>Padrao Datas -- dd/MM/yyyy</h1>
            Data Inicial:<input type="text" name="data1"/><br>        
            Data Final: <input type="text" name="data2"/><br>
            Total Dias:<output type="text" name="dataSoma"/><br>
            <input type="submit" value="calculo">            
        </form>
    </body>
</html>
