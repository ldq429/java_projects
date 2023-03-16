package com.imooc.reflect;

import com.imooc.reflect.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeclaredSample {
    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.imooc.reflect.entity.Employee");
            Class[] paramsType = new Class[]{Integer.class, String.class, String.class};
            Constructor constructor = employeeClass.getConstructor(paramsType);
            Employee employee = (Employee) constructor.newInstance(new Object[]{100, "张三", "销售部"});
            Field[] fields =  employeeClass.getDeclaredFields();
            for (Field field: fields) {
                String fieldKey = field.getName();
                switch (field.getModifiers()){
                    case 1: // public
                        Object f = field.get(employee);
                        System.out.println(fieldKey + "=" + f);
                        break;
                    case 2: // private
                        String key = "get" + fieldKey.substring(0, 1).toUpperCase() + fieldKey.substring(1);
                        Method method = employeeClass.getMethod(key);
                        var v = method.invoke(employee);
                        System.out.println(fieldKey + "=" + v);
                        break;
                }


            }

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
        }

    }
}
