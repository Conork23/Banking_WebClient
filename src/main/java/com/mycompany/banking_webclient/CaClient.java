/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking_webclient;

import com.mycompany.banking_webclient.UI.BankMenu;

/**
 *
 * @author Conor
 * Student No. x13343806
 */
public class CaClient {
    
    public static void main(String[] args){
       
        BankMenu myGui = new BankMenu();
        myGui.setVisible(true);
        myGui.setLocationRelativeTo(null); 
    }
    
}
