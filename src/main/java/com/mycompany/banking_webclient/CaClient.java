/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking_webclient;

/**
 *
 * @author Conor
 * Student No. x13343806
 */
public class CaClient {
    
    public static void main(String[] args){
       
        //WebClientGui myGui = new WebClientGui();
        CustomersGUI myGui = new CustomersGUI();
        myGui.setVisible(true);

        
        HttpMethods method = new HttpMethods();
        System.out.println("=========================================");
        System.out.println("================Test Data================");
        int num1, num2;
        num1 = 3;
        num2 = 2;
        System.out.println("    Number 1: "+num1+"\t\tNumber 2: "+num2);
        System.out.println("=========================================");
        System.out.println("Add\t\tGet method:\t\t"+method.get(num1,num2));
        System.out.println("Subtract\tPostJson method:\t"+method.postJson(num1,num2));
        System.out.println("Subtract\tPostForm method:\t"+method.postForm(num1,num2));
        System.out.println("Divide\t\tDelete method:\t\t"+method.delete(num1,num2));
        System.out.println("Multiply\tPut method:\t\t"+method.put(num1,num2));
        System.out.println("=========================================");
        System.out.println("=========== End of Test Data=============");
        System.out.println("=========================================\n");

       
    }
    
}
