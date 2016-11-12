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
     * getCustomer       - Read Customer Details        - Input type is query params (enter customer ID)
     * addCustomer       - Create Customer              - Input type is String input (enter customer name, address, email, phone)
     * deleteCustomer    - Delete Customer              - Input type is query params (enter customer ID)
     * updateCustomer    - Update Customer Details      - Input type is String input (enter customer id, name, address, email, phone)
     */
    
    public String getCustomer(int id){
        try {
        Client client = Client.create();
        WebResource target = client.resource(baseUrl);

        ClientResponse response = target
                .queryParam("id", id+"")
                .get(ClientResponse.class);
        
        return response.getEntity(String.class);
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
    
     public String addCustomer(String name, String address, String email, String phone){
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(baseUrl);
            
            String input = "{\""
                    + "name\":\""+name+"\","
                    + "\"address\":\""+address+"\","
                    + "\"email\":\""+email+"\","
                    + "\"phone\":\""+phone+"\""
                    + "}"; 

            //POST 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
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
      
      public String updateCustomer(int id, String name, String address, String email, String phone){
        try {
            Client client = Client.create();
            String url = baseUrl+id;
            WebResource webResource = client.resource(url);

            String input = "{\""
                    + "name\":\""+name+"\","
                    + "\"address\":\""+address+"\","
                    + "\"email\":\""+email+"\","
                    + "\"phone\":\""+phone+"\""
                    + "}"; 

            //PUT 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .put(ClientResponse.class, input);
            
            /*
            String input = "{\""
                    + "id\":\""+id+"\","
                    + "\name\":\""+name+"\","
                    + "\"address\":\""+address+"\","
                    + "\"email\":\""+email+"\","
                    + "\"phone\":\""+phone+"\""
                    + "}"; 

            //PUT 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .put(ClientResponse.class, input);
            
            
            ClientResponse response = webResource
                .queryParam("id", id+"")
                .queryParam("name", name+"")
                .queryParam("address", address+"")
                .queryParam("email", email+"")
                .queryParam("phone", phone+"")
                .put(ClientResponse.class);
            */
            
            return response.getEntity(String.class);

        } catch (ClientHandlerException | UniformInterfaceException e) {}
        return "Error";
    }
    
}
