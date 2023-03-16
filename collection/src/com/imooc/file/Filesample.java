package com.imooc.file;

import java.io.File;
import java.io.IOException;

public class Filesample {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/java_projects/collection/src/com/imooc/file/a.txt");
        boolean res = file.createNewFile();
        System.out.println("创建结果：" + res);

    }
}
