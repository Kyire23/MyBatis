package com.oumuanode.bank.dao;

import com.oumuanode.bank.pojo.Account;

public interface AccountDao {

    Account selectByActno(String actno);

    int updateByActno(Account act);
}
