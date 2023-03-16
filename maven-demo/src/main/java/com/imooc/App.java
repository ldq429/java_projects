package com.imooc;

import com.imooc.i18n.I18n;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        Properties properties = new Properties();
        String configPath = App.class.getResource("/config.properties").getPath();
        try {
            configPath = URLDecoder.decode(configPath, "UTF-8");
            properties.load(new FileInputStream(configPath));
            String languageRul = properties.getProperty("language");
            Class i18nClass = Class.forName(languageRul);
            I18n i18nInstance = (I18n) i18nClass.newInstance();
            Method method = i18nClass.getMethod("say");
            String res = (String) method.invoke(i18nInstance);
            System.out.println(res);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
