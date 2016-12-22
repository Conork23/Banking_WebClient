/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banking_webclient.Models;

/**
 *
 * @author ianarbuckle
 */
public class AccountsModel {

    private Integer account_no;
    private Integer balance;
    private Integer cid;
    private Integer sortCode;

    public AccountsModel(Integer account_no, Integer balance, Integer cid, Integer sortCode) {
        this.account_no = account_no;
        this.balance = balance;
        this.cid = cid;
        this.sortCode = sortCode;
    }

    public Integer getAccountNo() {
        return account_no;
    }

    public void setAccountNo(Integer account_no) {
        this.account_no = account_no;
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
