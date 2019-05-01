/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.placetopay.cad;

import com.placetopay.authentication.Authentication;
import com.placetopay.model.Amount;
import com.placetopay.model.Payment;
import com.placetopay.model.Person;
import com.placetopay.util.RestClient;
import java.io.IOException;
import java.net.InetAddress;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author CUSPIDE4
 */
public class CreateRequestcad {

    public StringBuilder procesoPago(String url, Person p, Payment py, Amount a) throws JSONException {

        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            String login = "6dd490faf9cb87a9862245da41170ff2";
            String tranKey = "024h1IlD";        
            
            Authentication auths = new Authentication(login, tranKey);

            //Construimos el json manualmente, para comprobar de objeto en objeto
            JSONObject data = new JSONObject();
            JSONObject auth = new JSONObject();
            JSONObject payment = new JSONObject();
            JSONObject amount = new JSONObject();
            JSONObject buyer = new JSONObject();
            JSONObject address = new JSONObject();

            auth.put("login", auths.getLogin());
            auth.put("seed", auths.getSeed());
            auth.put("nonce", auths.getNonce());
            auth.put("tranKey", auths.getTranKey());
            
            buyer.put("document", p.getDocument());
            buyer.put("documentType", p.getDocumentType());
            buyer.put("name", p.getName());
            buyer.put("surname", p.getSurname());
            buyer.put("email", p.getEmail());
            buyer.put("address", address);

            address.put("street", p.getStreet());
            address.put("city", p.getCity());
            address.put("country", p.getCountry());

            payment.put("reference", py.getReference());
            payment.put("description", py.getDescription());
            payment.put("amount", amount);

            amount.put("currency", a.getCurrency());
            amount.put("total", a.getTotal());

            data.put("auth", auth);
            data.put("locale", "es_CO");
            data.put("buyer", buyer);
            data.put("payment", payment);
            data.put("expiration", "2019-05-15T15:50:29-05:00");
            data.put("returnUrl", "https://dev.placetopay.com/redirection/sandbox/session/5976030f5575d");
            data.put("userAgent", "PlacetoPay Sandbox");
            data.put("ipAddress", ip);

            return RestClient.clientPost(data, url);
        } catch (IOException ex) {
            System.out.println( ex);
            return null;
        }
    }
    
}
