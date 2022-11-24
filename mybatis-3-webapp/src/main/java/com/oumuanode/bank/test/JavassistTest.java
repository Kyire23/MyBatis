package com.oumuanode.bank.test;

import javassist.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavassistTest {
    public static void main(String[] args) throws Exception{
        // 获取类池
        ClassPool pool = ClassPool.getDefault();
        // 创建类
        CtClass ctClass = pool.makeClass("com.oumuanode.bank.test");
        // 创建方法
        // 1.返回值类型  2.方法名  3.形式参数列表  4.所属类
        CtMethod ctMethod = new CtMethod(CtClass.voidType,"execute",new CtClass[]{},ctClass);
        // 设置方法的修饰符列表
        ctMethod.setModifiers(Modifier.PUBLIC);
        // 设置方法体
        ctMethod.setBody("{System.out.println(\"Hello world!\");}");
        // 给类添加方法
        ctClass.addMethod(ctMethod);
        // 调用方法
        Class aClass = ctClass.toClass();
        Object o = aClass.newInstance();
        Method execute = aClass.getDeclaredMethod("execute");
        execute.invoke(o);

    }

    @Test
    public void testGenerateFirstClass() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.oumuanode.bank.dao.impl.AccountDaoImpl");
        String methodCode = "public void insert(){System.out.println(123);}";
        CtMethod ctMethod = CtMethod.make(methodCode,ctClass);

        ctClass.addMethod(ctMethod);
        ctClass.toClass();

        Class<?> clazz = Class.forName("com.oumuanode.bank.dao.impl.AccountDaoImpl");
        Object obj = clazz.newInstance();
        Method insertMethod = clazz.getDeclaredMethod("insert");
        insertMethod.invoke(obj);
    }
}
