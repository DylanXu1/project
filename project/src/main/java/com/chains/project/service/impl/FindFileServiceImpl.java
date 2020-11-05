package com.chains.project.service.impl;

import com.chains.project.service.FindFileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

/**
 * @author xdx
 * @date 2020/9/4
 * @version 1.0
 */

@Service
public class FindFileServiceImpl implements FindFileService {
   /* @Resource
    private ImageMapepr imageMapepr;*/

    public ArrayList<String> getFiles(String path) throws Exception {
        //目标集合fileNameList
        ArrayList<String> fileList = new ArrayList<String>();  /*将类型换成File将返回文件对象（文件的绝对路径）*/
        File file = new File(path);
        if(file.isDirectory()){
            //listFiles();返回某个目录下的所有文件名和文件夹名的绝对路径，返回的是File数组
            File[] files = file.listFiles();
            for(File fileIndex:files){
            //如果这个文件是目录，则进行递归搜索
                if(fileIndex.isDirectory()){ //检查一个对象是否是文件夹
                    getFiles(fileIndex.getPath());  //递归循环遍历
                }else {
                    //如果文件是普通文件，则将文件句柄放入集合中
                    fileList.add(fileIndex.getName());
                }
            }
        }
            return fileList;
    }

    /*public int addImage(Image image){
        getFiles(path)
        return imageMapepr.addImage(image);
    }
*/



   /* //返回void
    public void traverseFolder(String path) {
        File file = new File(path);
        File[] files = file.listFiles(); //listFiles();返回某个目录下的所有文件名和文件夹名的绝对路径，返回的是File数组
        if(!file.exists()){
            System.out.println("文件不存在!");
        }else {
            if (null != files && files.length > 0) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {  //检查一个对象是否是文件夹
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        file2.getAbsolutePath();   //文件的绝对路径
                        traverseFolder(file2.getAbsolutePath());
                    } else {
                        System.out.println( file2.getName());  //打印当前文件夹下的所有文件名
                    }
                }
            }
        }
    }*/




}
