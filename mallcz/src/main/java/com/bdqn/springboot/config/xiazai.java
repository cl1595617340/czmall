package com.bdqn.springboot.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 多线程下载文件
 * @author Administrator
 *
 */
public class xiazai {


    public final static int threadcount=3;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        //获取服务器上的文件长度，在本地创建一个和服务器上的文件一样大的临时文件
        String pathString="https://dsfs.oppo.com/cn/product/findx/files/sec-3-video-2.mp4?v=20180620032316";
        URL url=new URL(pathString);
        HttpURLConnection connection=(HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(5000);
        connection.setRequestMethod("GET");
        int code=connection.getResponseCode();
        if(code==200){  //请求成功
            int length=connection.getContentLength();
            System.out.println("文件长度:"+length);
            RandomAccessFile ref=new RandomAccessFile("test.mkv","rwd");
            //指定创建的临时文件的长度
            ref.setLength(length);
            ref.close();

            int blocksize=length/threadcount;
            for(int threadId=1;threadId<=threadcount;threadId++){
                int startIndex=(threadId-1)*blocksize;  //线程开始位置
                int endIndex=threadId*blocksize-1;
                if(threadId==threadcount){
                    endIndex=length;
                }
                System.out.println("线程"+threadId+"下载---"+startIndex+"-->"+endIndex);
                new Downhread(threadId, startIndex, endIndex, pathString).start();;

            }
        }else{
            System.out.println("服务器错误");
        }

    }

    /**
     * 下载文件子线程
     * @author Administrator
     *
     */
    public static class Downhread  extends Thread {
        private int threadId;
        private int startIndex;
        private int endIndex;
        private String path;



        /**
         *
         * @param threadId  线程id
         * @param startIndex    线程下载的开始位置
         * @param endIndex
         * @param path  下载文件在服务器上的位置
         */
        public Downhread(int threadId, int startIndex, int endIndex, String path) {
            super();
            this.threadId = threadId;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.path = path;
        }




        @Override
        public void run() {
            // TODO Auto-generated method stub
            //super.run();
            try {
                URL url=new URL(path);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Range", "bytes="+startIndex+"-"+endIndex);
                int code=connection.getResponseCode();
                System.out.println("code:"+code);
//              if(code==200){  //请求成功
//
//              }
                InputStream is=connection.getInputStream();
                RandomAccessFile raf=new RandomAccessFile("test.mkv","rwd");
                //写文件的时候指定从哪个位置开始写
                raf.seek(startIndex);

                int len=0;
                byte [] buffer=new byte[1024];
                while((len=is.read(buffer))!=-1){
                    raf.write(buffer, 0, len);

                }
                is.close();
                raf.close();
                System.out.println("线程:"+threadId+"下载完毕了...");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}