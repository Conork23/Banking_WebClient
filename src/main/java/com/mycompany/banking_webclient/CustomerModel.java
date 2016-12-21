/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking_webclient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ianarbuckle
 */
@XmlRootElement 
public class CustomerModel {
    
private String address;

private Integer custId;

private String email;

private String name;

private String phone;

public CustomerModel() {
    
}

public CustomerModel(String address, Integer custId, String email, String phone) {
    this.address = address;
    this.custId = custId;
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
return custId;
}

public void setCustId(Integer custId) {
this.custId = custId;
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
