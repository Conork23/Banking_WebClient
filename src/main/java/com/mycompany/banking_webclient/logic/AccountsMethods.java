package com.mycompany.banking_webclient.logic;

import com.mycompany.banking_webclient.Models.AccountsModel;
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
public class AccountsMethods {
    String baseUrl;
    Integer port;
    
    public AccountsMethods() {
        port = 49000;
        baseUrl = "http://localhost:" + port + "/api/accounts/";
    }
    
     /*
     * getBalance           - Read Account Details        - Input type is query params (enter customer ID)
     * addAccount           - Create Account              - Input type is Json (enter customer ID, sort_code)
     * deleteAccount        - Delete Account              - Input type is PATH params (enter customer ID, account_no)
     *
     *withdrawTransaction   - Take money from account                   - Input type is Json (enter customer ID, account_no, amount)
     *lodgementTransaction  - Add money to account                      - Input type is Json (enter customer ID, account_no, amount)
     *transferTransaction   - Transfer money from account to another    - Input type is Json (enter customer to, account_to, cust_id, account_no, amount)
     */
    
    public String getBalance(int id) {
        try {
            Client client = Client.create();
            String s_id = (id != -1)? id+"" : "";
            WebResource target = client.resource(baseUrl+"balance/"+s_id);

            
            //GET
            ClientResponse response = target
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .accept(MediaType.APPLICATION_JSON)
                    .get(ClientResponse.class);
            
             
        String body = response.getEntity(String.class);
        if(id > -1){
            //returns multiple customers
            JsonArray arr = new Gson().fromJson(body, JsonArray.class);
            ArrayList<AccountsModel> list = new ArrayList<>();
            for(JsonElement elem: arr){
                AccountsModel acc = new Gson().fromJson(elem, AccountsModel.class);
                list.add(acc);            
            }
            
            String accounts = "";
            
            for(AccountsModel acc: list){
              accounts = accounts + "Account: "+acc.getAccountNo()+" Balance: "+acc.getBalance()+"\n";
            }
            
            return accounts;
        }
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        return "Error";
    }
        
    public String addAccount(int id, int balance, int sort_code) {
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(baseUrl);
            balance = 0;
            
            String input = "{\""
                    + "cid\": " + id + ","
                     + "\"address\":\"" + sort_code + "\","
                    + "\"balance\":\"" + balance + "\""
                    + "}"; 

            //POST 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .post(ClientResponse.class, input);                   

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
        
    public String deleteAccount(int id, int account_no) {
        try {
            Client client = Client.create();         
            String url = baseUrl+account_no;
            WebResource webResource = client.resource(url);

            //DELETE
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .delete(ClientResponse.class);

            return "Account Deleted: " + account_no;
            

        } catch (ClientHandlerException | UniformInterfaceException e) {}
         
        return "Error";
    }
        
    public String withdrawTransaction(int id, int account_no, int amount) {
        try {
            Client client = Client.create();
            String url = baseUrl+"withdrawal";
            WebResource webResource = client.resource(url);
            
            String input = "{\""
                    + "cust_id\":\""+id+"\","
                    + "\"account_no\":\""+account_no+"\","
                    + "\"amount\":\""+amount+"\""
                    + "}"; 

            //POST 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .post(ClientResponse.class, input);                   

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
        
    public String lodgementTransaction(int id, int account_no, int amount){
        try {
            Client client = Client.create();
            String url = baseUrl+"lodgement";
            WebResource webResource = client.resource(url);
            
            String input = "{\""
                    + "cust_id\":\""+id+"\","
                    + "\"account_no\":\""+account_no+"\","
                    + "\"amount\":\""+amount+"\""
                    + "}"; 

            //POST 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .post(ClientResponse.class, input);                   

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
    
    public String transferTransaction(int cust_to, int account_to, int id, int account_no, int amount) {
        try {
            Client client = Client.create();
            String url = baseUrl+"transfer";
            WebResource webResource = client.resource(url);
            
            String input = "{\""
                    + "cust_id_to\":\""+cust_to+"\","
                    + "\"account_no_to\":\""+account_to+"\","
                    + "\"cust_id\":\""+id+"\","
                    + "\"account_no\":\""+account_no+"\","
                    + "\"amount\":\""+amount+"\""
                    + "}"; 

            //POST 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .header("API_KEY", "API_KEY: 521197c4-bb29-11e6-a4a6-cec0c932ce01")
                    .post(ClientResponse.class, input);                   

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
}
