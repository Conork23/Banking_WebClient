/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking_webclient.Models;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ianarbuckle
 */
@XmlRootElement 
public class CustomerModel {
    
private String address;

private Integer cust_id;

private String email;

private String name;

private String phone;

public CustomerModel() {
    
}

public CustomerModel(String address, Integer cust_id, String email, String phone) {
    this.address = address;
    this.cust_id = cust_id;
    this.email = email;
    this.phone = phone;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public Integer getCustId() {
return cust_id;
}

public void setCustId(Integer cust_id) {
this.cust_id = cust_id;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}
    
}
