package com.oumuanode.bank.service;

import com.oumuanode.bank.dao.AccountDao;
import com.oumuanode.bank.dao.impl.AccountDaoImpl;
import com.oumuanode.bank.exceptions.MoneyNotEnoughException;
import com.oumuanode.bank.exceptions.TransferException;
import com.oumuanode.bank.pojo.Account;
import com.oumuanode.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {
        //开启会话
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //1.判断转出账户余额是否充足(select)
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance()<money) {
            //2. 不足 提示用户
                throw new MoneyNotEnoughException("余额不足");
        }
        //3 充足 更新转出账户(update)
        //先更新内存中java对象account的余额
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() +money);
        int i = accountDao.updateByActno(fromAct);
        //4 更新转入账户金额(update)
        i += accountDao.updateByActno(toAct);
        if (i != 2){
            throw new TransferException("转账异常，未知原因");
        }

        //提交事务
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }

    //
}
