<%-- 
    Document   : index.jsp
    Created on : 28/04/2019, 02:38:43 PM
    Author     : CUSPIDE4
--%>

<%@page import="com.placetopay.model.Answer"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.placetopay.model.Person"%>
<%@page import="com.placetopay.cad.AnswerRequestCad"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/css.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="hola card">
            <form class="card-header card-title" action="nuevo" >
                <button type="submit" class="btn btn-primary" >Nueva Transferencia</button>
                <a href="/PlaceToPay/a" class="btn btn-primary">Actualizar tabla</a>
            </form>
            <table class="table table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">RequesId</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">CC</th>
                        <th scope="col">Status</th>
                        <th scope="col">Mensaje</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Reason</th>
                        <th scope="col">Total</th>
                    </tr>
                </thead>
                <tbody> 
                    <%
                        ArrayList<Answer> lista = new ArrayList<>();
                        lista = AnswerRequestCad.mostrarTransaccion();
                        for (Answer a : lista) {
                    %>
                    <tr>
                        <th scope="row"><%=a.getRequestId()%></th>
                        <td><%=a.getName()%></td>
                        <td><%=a.getDocument()%></td>
                        <td><%=a.getStatus()%></td>
                        <td><%=a.getMessage()%></td>
                        <td><%=a.getDate()%></td>
                        <td><%=a.getReason()%></td>
                        <td><%=a.getTotal()%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        

        <%@include file="../WEB-INF/js.jsp" %>
    </body>
</html>
