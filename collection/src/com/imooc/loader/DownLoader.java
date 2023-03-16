package com.imooc.loader;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 网络下载器
 */
public class DownLoader {

    public String dir;
    public String threadNum;

    /**
     * @param source    源网络地址
     * @param targetDir 保存目标文件（必须存在）
     */
    public void downLoad(String source, String targetDir) {
        try {
            URL url = new URL(source); // 地址对象
            URLConnection urlConnection = null; // 打开url网络连接
            urlConnection = url.openConnection();
            String fileName = source.substring(source.lastIndexOf("/") + 1); //文件名
            File targetFile = new File(targetDir + "/" + fileName);
            if (!targetFile.exists()) targetFile.createNewFile();
            try (InputStream is = urlConnection.getInputStream(); OutputStream os = new FileOutputStream(targetFile);) {
                byte[] bs = new byte[1024];
                int len = 0;
                while ((len = is.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void start(String src) {
        File configFile = new File(src + "\\config.properties");
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(configFile);) {
            properties.load(fileReader);
            dir = properties.getProperty("target-dir");
            threadNum = properties.getProperty("thread-num");
            this.multiDownloadFromFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void multiDownloadFromFile() {
        File dir = new File(this.dir);
        if (!dir.exists()) dir.mkdir();
        List<String> list = new ArrayList();
        try (
                BufferedReader reader = new BufferedReader(new FileReader("D:\\java_projects\\collection\\src\\imageSrc.txt"));
                ExecutorService threadPool = Executors.newFixedThreadPool(Integer.parseInt(this.threadNum));
        ) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            DownLoader that = this;
            list.forEach(src -> {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(src);
                        that.downLoad(src, that.dir);
                    }
                });
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        DownLoader downLoader = new DownLoader();
        downLoader.start("D:\\java_projects\\collection\\src");
    }
}
