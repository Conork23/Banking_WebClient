/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking_webclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author Conor
 * Student No. x13343806
 */
public class HttpMethods {
    String baseUrl;
    Integer port;
    
    public HttpMethods(){
        port = 49000;
        baseUrl = "http://localhost:" + port + "/api/calculate/";
    }
    
    /*
     *
     * Get       - Adds          - Input type is query params
     * PostJson  - Subtracts     - Input type is Json
     * PostForm  - Subtracts     - Input type is urlencoded Form data
     * Delete    - Divides       - Input type is url params
     * Put       - Multiplys     - Input type is query params
     * 
     * These are not the conventional ways that the methods should be used but
     * it demonstrats some of the different kind of functionality that a Jersey
     * client can perform.
     */
    
    public String get(int num1, int num2){
         Client client = Client.create();
        WebResource target = client.resource(baseUrl);

        ClientResponse response = target
                .queryParam("num1", num1+"")
                .queryParam("num2", num2+"")
                .get(ClientResponse.class);
        
        return response.getEntity(String.class);
    }
    
    public String postJson(int num1, int num2){
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(baseUrl);

            String input = "{\""
                    + "num1\":\""+num1+"\","
                    + "\"num2\":\""+num2+"\""
                    + "}";

            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE)
                    .post(ClientResponse.class, input);

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
    
    public String postForm(int num1, int num2){
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(baseUrl);

            MultivaluedMap map = new MultivaluedMapImpl();
            map.add("num1", num1+"");
            map.add("num2", num2+"");

            ClientResponse response = webResource
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .post(ClientResponse.class, map);

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
    
    public String delete(int num1, int num2){
        try {
            Client client = Client.create();         
            String url = baseUrl+num1+"/"+num2;

            WebResource webResource = client.resource(url);

            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .delete(ClientResponse.class);

            return response.getEntity(String.class);
            

        } catch (ClientHandlerException | UniformInterfaceException e) {}
         
        return "Error";
    }
    
    public String put(int num1, int num2){
        
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(baseUrl);

            ClientResponse response = webResource
                .queryParam("num1", num1+"")
                .queryParam("num2", num2+"")
                .put(ClientResponse.class);
            
            return response.getEntity(String.class);

        } catch (ClientHandlerException | UniformInterfaceException e) {}
        return "Error";
    }
}
