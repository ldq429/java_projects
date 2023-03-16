package com.imooc.reflect;

import com.imooc.reflect.entity.Employee;
import org.bouncycastle.bcpg.BCPGOutputStream;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.imooc.reflect.entity.Employee");
            Class[] paramsType = new Class[]{Integer.class, String.class, String.class};
            Constructor constructor = employeeClass.getConstructor(paramsType);
            Object[] params = new Object[]{100, "张三", "研发部"};
            Employee employee = (Employee) constructor.newInstance(params);
            System.out.println(employee);
            Method method = employeeClass.getMethod("updateEName", String.class);
//            两个参数，被执行的对象、 Object参数数组
            System.out.println(method.invoke(employee, new Object[]{"馬雲"}));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
