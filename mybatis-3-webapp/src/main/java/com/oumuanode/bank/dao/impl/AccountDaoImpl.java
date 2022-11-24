package com.oumuanode.bank.dao.impl;

import com.oumuanode.bank.dao.AccountDao;
import com.oumuanode.bank.pojo.Account;
import com.oumuanode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        Account account = (Account) sqlSession.selectOne("account.selectByActno",actno);
//        sqlSession.close();
//        return account;
        return (Account) sqlSession.selectOne("account.selectByActno",actno);
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
//        int count = sqlSession.update("account.updateByActno",act);
//        sqlSession.close();
//        return count;
        return sqlSession.update("account.updateByActno",act);
    }
}
