/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placetopay.cad;

import com.placetopay.authentication.Authentication;
import com.placetopay.model.Amount;
import com.placetopay.model.Answer;
import com.placetopay.model.Person;
import com.placetopay.util.RestClient;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author CUSPIDE4
 */
public class AnswerRequestCad {

    public static StringBuilder guardarPeticion(Answer a, Person p, Amount am) throws JSONException {
        Answer ans = new Answer();
        try {
            String url = "http://localhost:8090/api/answer";

            // Construyendo manualmente el JSON, para compararlo por objeto
            JSONObject answer = new JSONObject();
            answer.put("status", a.getStatus());
            answer.put("name", p.getName());
            answer.put("document", p.getDocument());
            answer.put("total", am.getTotal());
            answer.put("reason", a.getReason());
            answer.put("message", a.getMessage());
            answer.put("date", a.getDate());
            answer.put("processUrl", a.getProcessUrl());
            answer.put("requestId", a.getRequestId());

            return RestClient.clientPost(answer, url);
        } catch (IOException ex) {
            Logger.getLogger(AnswerRequestCad.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static StringBuilder guardarRespuesta(Long id) {
        try {
            Answer ans = new Answer();
            String login = "6dd490faf9cb87a9862245da41170ff2";
            String tranKey = "024h1IlD";

            String url = "http://redirection.dnetix.co/api/session/";
            String ids = String.valueOf(id);
            String urls = url + ids;

            Authentication auths = new Authentication(login, tranKey);
            org.json.JSONObject auth = new org.json.JSONObject();
            org.json.JSONObject a = new org.json.JSONObject();

            auth.put("login", auths.getLogin());
            auth.put("seed", auths.getSeed());
            auth.put("nonce", auths.getNonce());
            auth.put("tranKey", auths.getTranKey());

            a.put("auth", auth);

            return RestClient.clientPost(a, urls);
        } catch (JSONException | IOException ex) {
            Logger.getLogger(AnswerRequestCad.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static ArrayList mostrarTransaccion() {
        JSONParser parser = new JSONParser();
        ArrayList<Object> lista = new ArrayList<>();

        try {
            URL url = new URL("http://localhost:8090/api/answer");
            String clientGet = RestClient.clientGet(url);
            Object obj = parser.parse(clientGet);
            JSONArray jsonArray = (JSONArray) obj;

            for (int i = 0; i < jsonArray.size(); i++) {
                Answer a = new Answer();
                org.json.simple.JSONObject json = (org.json.simple.JSONObject) jsonArray.get(i);
                String message = (String) json.get("message");
                //Regresamos el texto a tildes
                String an = Normalizer.normalize(message, Normalizer.Form.NFC);

                a.setName((String) json.get("name"));
                a.setDocument((String) json.get("document"));
                a.setRequestId((Long) json.get("requestId"));
                a.setStatus((String) json.get("status"));

                a.setMessage(an);
                a.setDate((String) json.get("date"));
                a.setReason((String) json.get("reason"));

                a.setTotal((String) json.get("total"));
                lista.add(a);
            }
            return lista;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        } catch (MalformedURLException ex) {
            Logger.getLogger(AnswerRequestCad.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void updateTransaccion() {
        ArrayList<Answer> lista = new ArrayList<>();
        JSONParser parser = new JSONParser();

        String url = "http://localhost:8090/api/answer/";
        Answer ans = new Answer();
        lista = mostrarTransaccion();

        for (Answer answer : lista) {

            try {
                Long id = answer.getRequestId();
                String urls = url + String.valueOf(id);

                StringBuilder sb = guardarRespuesta(id);

                org.json.JSONObject respuesta = new org.json.JSONObject();
                Object obj = parser.parse(sb.toString());
                org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) obj;
                org.json.simple.JSONObject statu = (org.json.simple.JSONObject) jsonObject.get("status");
                org.json.simple.JSONObject jsonObject2 = (org.json.simple.JSONObject) statu;

                String status = (String) jsonObject2.get("status");
                String message = (String) jsonObject2.get("message");
                String date = (String) jsonObject2.get("date");
                
                String an = Normalizer.normalize(message, Normalizer.Form.NFD);
                
                respuesta.put("status", status);
                respuesta.put("message", an);
                respuesta.put("date", date);

                StringBuilder a = RestClient.clientPost(respuesta, urls);
            } catch (JSONException | IOException ex) {
                Logger.getLogger(AnswerRequestCad.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            } catch (ParseException ex) {
                Logger.getLogger(AnswerRequestCad.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
