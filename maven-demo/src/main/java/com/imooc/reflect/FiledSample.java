package com.imooc.reflect;

import com.imooc.reflect.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FiledSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.imooc.reflect.entity.Employee");
            Class[] paramsType = new Class[]{Integer.class, String.class, String.class};
            Constructor constructor = employeeClass.getConstructor(paramsType);
            Employee employee = (Employee) constructor.newInstance(new Object[]{100, "张三", "销售部"});
            System.out.println(employee);
            Field enameField = employeeClass.getField("ename");
            String ename = (String) enameField.get(employee);
            System.out.println(ename);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

    }
}
