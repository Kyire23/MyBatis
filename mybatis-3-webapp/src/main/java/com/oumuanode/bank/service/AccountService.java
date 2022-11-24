package com.oumuanode.bank.service;

import com.oumuanode.bank.exceptions.MoneyNotEnoughException;
import com.oumuanode.bank.exceptions.TransferException;

/**
 * 账户业务类
 */
public interface AccountService {
    // TODO: 2022/11/14

    /**
     *
     * @param fromActno 转出账号
     * @param toActno 转入账号
     * @param money 转出金额
     */
    void transfer(String fromActno,String toActno,double money) throws MoneyNotEnoughException, TransferException;
}
