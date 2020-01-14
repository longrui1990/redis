package com.bean;

import java.io.Serializable;

public class QueryVO implements Serializable {

    private Account account;


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "QueryVO{" +
                "account=" + account +
                '}';
    }
}
