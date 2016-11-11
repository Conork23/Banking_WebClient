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
 * @author nathan
 */
public class CustomersMethods {
    
    String baseUrl;
    Integer port;
    
    public CustomersMethods(){
        port = 49000;
        baseUrl = "http://localhost:" + port + "/api/customers/";
    }
    
     /*
     * getCustomer       - Get Customer Details          - Input type is query params (enter customer ID)
     */
    
    public String getCustomer(int id){
        Client client = Client.create();
        WebResource target = client.resource(baseUrl);

        ClientResponse response = target
                .queryParam("id", id+"")
                .get(ClientResponse.class);
        
        return response.getEntity(String.class);
    }
    
     public String addCustomer(String name, String address, String email, String phone){
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(baseUrl);

            String input = "{\""
                    + "name\":\""+name+"\","
                    + "\"address\":\""+address+"\""
                    + "email\":\""+email+"\","
                    + "\"phone\":\""+phone+"\""
                    + "}";

            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON_TYPE)
                    .post(ClientResponse.class, input);

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
     
      public String deleteCustomer(int id){
        try {
            Client client = Client.create();         
            String url = baseUrl+id;

            WebResource webResource = client.resource(url);

            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .delete(ClientResponse.class);

            return response.getEntity(String.class);
            

        } catch (ClientHandlerException | UniformInterfaceException e) {}
         
        return "Error";
    }
    
}
