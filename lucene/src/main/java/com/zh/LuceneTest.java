package com.zh;

import java.io.File;

public class LuceneTest {

    public static void main(String[] args) {
        //指定索引库的位置
        File destFile = new File("D:\\lucene");
        //1.创建Directory对象，并指定索引保存的位置
        //2.基于Directory对象创建IndexWriter对象
        //3.读取磁盘上的文件，对应每个文件创建一个文档对象
        //4.向文档对象中添加域


        //5.把文档对象添加到索引库
        //6.关闭IndexWriter对象

    }
}
