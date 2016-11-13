package com.mycompany.banking_webclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javax.ws.rs.core.MultivaluedMap;
/**
 *
 * @author nathan
 */
public class AccountsMethods {
    String baseUrl;
    Integer port;
    
    public AccountsMethods(){
        port = 49000;
        baseUrl = "http://localhost:" + port + "/api/accounts/";
    }
    
     /*
     * getBalance       - Read Account Details        - Input type is query params (enter customer ID)
     * addAccount       - Create Account              - Input type is String input (enter customer ID, sort_code)
     * deleteAccount    - Delete Account              - Input type is PATH params (enter customer ID, account_no)
     */
    
        public String getBalance(int id){
        try {
            Client client = Client.create();
            String url = baseUrl+"balance/"+id;
            WebResource target = client.resource(url);

            ClientResponse response = target
                    .queryParam("id", id+"")
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

            return response.getEntity(String.class);
            

        } catch (ClientHandlerException | UniformInterfaceException e) {}
         
        return "Error";
    }
}