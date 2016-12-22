/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking_webclient.logic;

import com.mycompany.banking_webclient.Models.CustomerModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.util.ArrayList;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nathan ryan x13448212
 */
public class CustomerMethods {

    String baseUrl;
    Integer port;

    public CustomerMethods() {
        port = 49000;
        baseUrl = "http://localhost:" + port + "/api/customers/";
    }

    /*
     * getCustomer       - Read Customer Details        - Input type is query params (enter customer ID)
     * addCustomer       - Create Customer              - Input type is Json (enter customer name, address, email, phone)
     * deleteCustomer    - Delete Customer              - Input type is query params (enter customer ID)
     * updateCustomer    - Update Customer Details      - Input type is Json (enter customer id, name, address, email, phone)
     */
    public String getCustomer(int id) {
        try {
            Client client = Client.create();
             String s_id = (id != -1)? id+"" : "";
            WebResource target = client.resource(baseUrl+s_id);

            //GET 
            ClientResponse response = target
                    .accept(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .get(ClientResponse.class);

            
        String body = response.getEntity(String.class);
        if(id > -1){
            //returns a single customer
            CustomerModel customer = new Gson().fromJson(body, CustomerModel.class);
            return " Name: "+customer.getName()+
                    "\n Address: "+ customer.getAddress()+
                    "\n Phone: "+ customer.getPhone()+
                    "\n Email: "+ customer.getEmail() +
                    "\n ID: "+ customer.getCustId()
                    ;
        }else{
            //returns multiple customers
            JsonArray arr = new Gson().fromJson(body, JsonArray.class);
            ArrayList<CustomerModel> list = new ArrayList<>();
            for(JsonElement elem: arr){
                CustomerModel c = new Gson().fromJson(elem, CustomerModel.class);
                list.add(c);            
            }
            
            String customers = "";
            
            for(CustomerModel cust: list){
              customers = customers + "Name: "+cust.getName()+"\n" + "ID: " + cust.getCustId();
            }
            
            return customers;
        }
            

        } catch (ClientHandlerException | UniformInterfaceException e) {
            System.out.println(e.getMessage());
        }

        return "Error";
    }

    public String addCustomer(String name, String address, String email, String phone) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(baseUrl);

            String input = "{\""
                    + "name\":\"" + name + "\","
                    + "\"address\":\"" + address + "\","
                    + "\"email\":\"" + email + "\","
                    + "\"phone\":\"" + phone + "\""
                    + "}";

            //POST 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .post(ClientResponse.class, input);

            return response.getEntity(String.class);

        } catch (ClientHandlerException | UniformInterfaceException e) {
        }

        return "Error";
    }

    public String deleteCustomer(int id) {
        try {
            Client client = Client.create();
            String url = baseUrl + id;
            WebResource webResource = client.resource(url);

            //DELETE
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .delete(ClientResponse.class);

            return "Customer Deleted";

        } catch (ClientHandlerException | UniformInterfaceException e) {
        }

        return "Error";
    }

    public String updateCustomer(int id, String name, String address, String email, String phone) {
        try {
            Client client = Client.create();
            String url = baseUrl + id;
            WebResource webResource = client.resource(url);

            String input = "{\""
                    + "name\":\"" + name + "\","
                    + "\"address\":\"" + address + "\","
                    + "\"email\":\"" + email + "\","
                    + "\"phone\":\"" + phone + "\""
                    + "}";

            //PUT 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .put(ClientResponse.class, input);
            
        String body = response.getEntity(String.class);
        if(id > -1){
            //returns a single customer
            CustomerModel customer = new Gson().fromJson(body, CustomerModel.class);
            return " Name: "+customer.getName()+
                    "\n Address: "+ customer.getAddress()+
                    "\n Phone: "+ customer.getPhone()+
                    "\n Email: "+ customer.getEmail() +
                    "\n ID: "+ customer.getCustId()
                    ;
        }

//            return response.getEntity(String.class);

        } catch (ClientHandlerException | UniformInterfaceException e) {
        }
        return "Error";
    }

}
