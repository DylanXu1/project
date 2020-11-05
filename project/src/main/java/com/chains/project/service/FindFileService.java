package com.chains.project.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xdx
 * @version 1.0
 * @date 2020/9/4
 */
public interface FindFileService {

    ArrayList<String> getFiles(String path) throws Exception;
    /*void traverseFolder(String path);*/
}
