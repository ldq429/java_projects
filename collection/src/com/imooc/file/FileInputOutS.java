package com.imooc.file;

import java.io.*;

public class FileInputOutS {
    //    复制
    public static void main(String[] args) {
        String filePath = "D:/java_projects/collection/src/com/imooc/file/";
        File source = new File(filePath + "a.txt");
        File target = new File(filePath + "imageSrc.txt");
//        InputStream fis = null;
//        OutputStream fos = null;
//        try {
//            fis = new FileInputStream(source);
//            fos = new FileOutputStream(target);
//            byte[] bs = new byte[1024];
//            int len;
//            while ((len = fis.read(bs)) != -1) { // 利用while同时读取并判断
//                fos.write(bs, 0, len);
//            }
//        } finally {
//            if (fos != null) fos.close();
//            if (fis != null) fis.close();
//        }


//        利用try来自动关闭流
        try (InputStream fis = new FileInputStream(source); OutputStream fos = new FileOutputStream(target);) {
            byte[] bs = new byte[1024];
            int len;
            while ((len = fis.read(bs)) != -1) { // 利用while同时读取并判断
                fos.write(bs, 0, len);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
