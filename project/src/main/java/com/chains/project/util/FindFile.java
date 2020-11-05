package com.chains.project.util;

import java.io.File;
import java.util.List;

/**
 * @author xdx
 * @date 2020/9/4
 * @version 1.0
 */
        /*此页面作废*/
public class FindFile {

    public List<File> traverseFolder(String path) {
        File file = new File(path);
        if(!file.exists()){
            System.out.println("文件不存在!");
        }else {
            File[] files = file.listFiles(); /*listFiles();返回某个目录下的所有文件名和文件夹名的绝对路径，返回的是File数组*/
            if (null != files && files.length > 0) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {  //检查一个对象是否是文件夹
                        /*System.out.println("文件夹:" + file2.getAbsolutePath());   file2.getAbsolutePath()文件的绝对路径 */
                        traverseFolder(file2.getAbsolutePath());
                    } else {
                        file2.getName();
                    }
                }

            }

        }
        return (List<File>) file;
    }

}
