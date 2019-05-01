/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placetopay.controller;

import com.placetopay.authentication.Authentication;
import com.placetopay.cad.AnswerRequestCad;
import com.placetopay.cad.CreateRequestcad;
import com.placetopay.model.Amount;
import com.placetopay.model.Answer;
import com.placetopay.model.Payment;
import com.placetopay.model.Person;
import com.placetopay.util.RestClient;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.buf.StringUtils;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author CUSPIDE4
 */
public class CreateRequestServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        StringBuilder sb = null;
        Answer ans = new Answer();
        
        try {

            String url = "http://redirection.dnetix.co/api/session";

            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String documentType = request.getParameter("documentType");
            String document = request.getParameter("document");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String currency = request.getParameter("currency");
            String description = request.getParameter("description");
            String total = request.getParameter("total");
            String reference = request.getParameter("reference");
            

            Person p = new Person();
            p.setCity(city);
            p.setCountry(country);
            p.setDocument(document);
            p.setDocumentType(documentType);
            p.setEmail(email);
            p.setLocale("es_CO");
            p.setName(name);
            p.setStreet(address);
            p.setSurname(surname);

            Payment py = new Payment();
            py.setReference(reference);
            py.setDescription(description);

            Amount a = new Amount();
            a.setCurrency(currency);
            a.setTotal(total);

            CreateRequestcad cr = new CreateRequestcad();
            

            sb = cr.procesoPago(url, p, py, a);
            ans = guardarRespuesta(sb);
            AnswerRequestCad.guardarPeticion(ans, p, a);
            AnswerRequestCad.updateTransaccion();

        } catch (JSONException ex) {
            Logger.getLogger(CreateRequestServelet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        response.sendRedirect(ans.getProcessUrl());
        //request.getRequestDispatcher("nuevo").forward(request, response);
    }

    public Answer guardarRespuesta(StringBuilder sb) {
        Answer ans = new Answer();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(sb.toString());
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject status = (JSONObject) jsonObject.get("status");
            JSONObject jsonObject2 = (JSONObject) status;

            Long requestId = (Long) jsonObject.get("requestId");
            String processUrl = (String) jsonObject.get("processUrl");
            String reason = (String) jsonObject2.get("reason");
            
            StringBuilder sbs = AnswerRequestCad.guardarRespuesta(requestId);
            Object objs = parser.parse(sbs.toString());
            
            JSONObject jsonObjects = (JSONObject) objs;
            JSONObject statu = (JSONObject) jsonObjects.get("status");
            JSONObject jsonObject3 = (JSONObject) statu;

            String statuss = (String) jsonObject3.get("status");
            String message = (String) jsonObject3.get("message");
            String date = (String) jsonObject3.get("date");
            String quitarTilde = Normalizer.normalize(message, Normalizer.Form.NFD);

            ans.setStatus(statuss);
            ans.setDate(date);
            ans.setMessage(quitarTilde);
            ans.setRequestId(requestId);
            ans.setProcessUrl(processUrl);
            ans.setReason(reason);
            return ans;
        } catch (ParseException ex) {
            Logger.getLogger(CreateRequestServelet.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public void limpiarCampos(){
        
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
