package com.mycompany.banking_webclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author nathan ryan x13448212
 */
public class AccountsMethods {
    String baseUrl;
    Integer port;
    
    public AccountsMethods(){
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
    
    public String getBalance(int id){
        try {
            Client client = Client.create();
            String url = baseUrl+"balance/"+id;
            WebResource target = client.resource(url);
            
            //GET
            ClientResponse response = target
                    .queryParam("cust_id", id+"")
                    .accept(MediaType.APPLICATION_JSON)
                    .get(ClientResponse.class);

            return response.getEntity(String.class);
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        return "Error";
    }
        
    public String addAccount(int id, int sort_code){
        try {
            Client client = Client.create();
            WebResource webResource = client.resource(baseUrl);
            
            String input = "{\""
                    + "cust_id\":\""+id+"\","
                    + "\"sort_code\":\""+sort_code+"\""
                    + "}"; 

            //POST 
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, input);                   

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
        
    public String deleteAccount(int id, int account_no){
        try {
            Client client = Client.create();         
            String url = baseUrl+id+"/"+account_no;
            WebResource webResource = client.resource(url);

            //DELETE
            ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
                    .delete(ClientResponse.class);

            return "Account Deleted";
            

        } catch (ClientHandlerException | UniformInterfaceException e) {}
         
        return "Error";
    }
        
    public String withdrawTransaction(int id, int account_no, int amount){
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
                    .post(ClientResponse.class, input);                   

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
    
    public String transferTransaction(int cust_to, int account_to, int id, int account_no, int amount){
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
                    .post(ClientResponse.class, input);                   

            return response.getEntity(String.class);
           
        } catch (ClientHandlerException | UniformInterfaceException e) {}
        
        return "Error";
    }
}
