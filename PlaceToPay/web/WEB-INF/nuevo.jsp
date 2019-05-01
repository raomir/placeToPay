<%-- 
    Document   : nuevo
    Created on : 29/04/2019, 03:22:00 PM
    Author     : CUSPIDE4
--%>
<%@page import="com.placetopay.cad.AnswerRequestCad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.placetopay.model.Answer"%>
<html>
    <head>
        <title>title</title>
        <%@include file="../WEB-INF/css.jsp" %>
    </head>
    <body>

        <form class="form-nuevo form-group card" method="post" action="createRequest" target="_blank">
            <div class="card-header card-title">
                Nueva Facturación
            </div>
            <div class="row card-body">
                <div class="form-group col-sm-3">
                    <label>Nombre</label>
                    <input type="text" name="name" class="form-control"  placeholder="Nombre" required>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleInputPassword1">Apellido</label>
                    <input type="text" name="surname" class="form-control" id="exampleInputPassword1" placeholder="Apellido" required>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleInputPassword1">Email</label>
                    <input type="email" name="email" class="form-control" id="exampleInputPassword1" placeholder="Email" required>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleInputPassword1">Dirección</label>
                    <input type="text" name="address" class="form-control" id="exampleInputPassword1" placeholder="Dirección" required>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleInputPassword1">Tipo de documento </label>
                    <select class="form-control" id="exampleFormControlSelect1" name="documentType">
                        <option>CC</option>
                        <option>CE</option>
                        <option>TI</option>
                        <option>RC</option>
                        <option>NIT</option>
                        <option>RUT</option>
                    </select>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleInputPassword1">Documento</label>
                    <input type="number" name="document" class="form-control" id="exampleInputPassword1" placeholder="Documento" required>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleInputPassword1">Ciudad</label>
                    <input type="text" name="city" class="form-control" id="exampleInputPassword1" placeholder="Ciudad" required>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleInputPassword1">País</label>
                    <input type="text" name="country" class="form-control" id="exampleInputPassword1" placeholder="País" required>
                </div>
                <div class="form-group col-sm-6">
                    <label for="exampleInputPassword1">Descripción</label>
                    <input type="text" name="description" class="form-control" id="exampleInputPassword1" placeholder="Descripción" required>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleFormControlSelect1">Tipo de moneda</label>
                    <select class="form-control" id="exampleFormControlSelect1" name="currency">
                        <option>COP</option>
                        <option>USD</option>
                        <option>MX</option>
                    </select>
                </div>
                <div class="form-group col-sm-3">
                    <label for="exampleInputPassword1">Total</label>
                    <input type="number" name="total" class="form-control" id="exampleInputPassword1" placeholder="total" required>
                </div>
                <div class="form-group col-sm-4">
                    <label for="exampleInputPassword1">Referencia</label>
                    <input type="number" name="reference" class="form-control" id="exampleInputPassword1" placeholder="Número de tarjeta" required>
                </div>
                <div class="form-group col-sm-9">
                    <button type="enviar" class="btn btn-primary" >Enviar</button>
                    <button type="reset" class="btn btn-primary" >Limpiar Campos</button>
                    <a href="/PlaceToPay/Home" class="btn btn-primary">Regresar</a>
                </div>
            </div>
        </form>
    </body>
</html>



