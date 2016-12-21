/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking_webclient;

/**
 *
 * @author ianarbuckle
 */
public class AccountsModel {
    
    
private Integer accountNo;
private Integer balance;
private Integer cid;
private Integer sortCode;

public Integer getAccountNo() {
return accountNo;
}

public void setAccountNo(Integer accountNo) {
this.accountNo = accountNo;
}

public Integer getBalance() {
return balance;
}

public void setBalance(Integer balance) {
this.balance = balance;
}

public Integer getCid() {
return cid;
}

public void setCid(Integer cid) {
this.cid = cid;
}

public Integer getSortCode() {
return sortCode;
}

public void setSortCode(Integer sortCode) {
this.sortCode = sortCode;
}
    
}
