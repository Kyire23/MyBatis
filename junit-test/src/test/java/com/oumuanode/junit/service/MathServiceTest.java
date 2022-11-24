package com.oumuanode.junit.service;

import org.junit.Assert;
import org.junit.Test;

/**
 * 单元测试类 规范：测试类名+test
 */
public class MathServiceTest {
    @Test
    public void testSum(){
        MathService mathService = new MathService();
        //获取实际值
        int actual = mathService.sum(1,2);
        //期望值
        int expected = 3;
        //加断言进行测试
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSub(){
        //同理
    }

}
