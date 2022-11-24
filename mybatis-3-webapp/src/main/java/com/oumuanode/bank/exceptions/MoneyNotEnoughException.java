package com.oumuanode.bank.exceptions;

public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String s) {
        super(s);
    }
}
