package com.chains.project.controller;

import com.chains.project.model.pojo.Introduce;
import com.chains.project.model.pojo.SysMenu;
import com.chains.project.model.vo.ItemVo;
import com.chains.project.model.vo.SysMenuVo;
import com.chains.project.service.FindFileService;
import com.chains.project.service.IntroduceService;
import com.chains.project.service.ItemService;
import com.chains.project.service.UserService;
import com.chains.project.util.FindFile;
import com.chains.project.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import  java.util.UUID;

/**
 * @author xdx
 * @date 2020/8/27
 * @version 1.0
 */

//@MultipartConfig
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private ItemService itemService;
    @Resource
    private IntroduceService introduceService;
    @Resource
    private FindFileService findFileService;
    @Resource
    private UserService userService;

    @GetMapping(value = "/file")
    public String file() {
        return "file";
    }

    //多文件上传
    @PostMapping("/batchUpload")
    public String fileUpload(@RequestParam(value = "files")MultipartFile[] files, @RequestParam(value = "mainFile")MultipartFile mainFile ,
                             ItemVo itemVo) throws Exception {
        System.out.println("后台收到的多个文件是："+files);
        System.out.println("接收到的项目字段"+itemVo);

        String itemId = itemVo.getItemId();

        // 主图上传
        String mainFileName = mainFile.getOriginalFilename();  // 文件名
        String mainSuffixName = mainFileName.substring(mainFileName.lastIndexOf("."));  // 后缀名
        String mainFilePath = "C:/OTA/image/"+ itemId +"/"; // 上传后的路径
        mainFileName = UUID.randomUUID() + mainSuffixName; // 新文件名
        File mainDest = new File(mainFilePath + mainFileName);  //新建文件
        //判断路径是否存在，如果不存在就创建一个
        if (!mainDest.getParentFile().exists()) {
            mainDest.getParentFile().mkdirs();
        }
        try {
            //写入文件
            mainFile.transferTo(mainDest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 多文件上传
        for (MultipartFile file : files){
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String filePath = "C:/OTA/image/"+ itemId +"/"; // 上传后的路径
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);  //新建文件
            //判断路径是否存在，如果不存在就创建一个
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                //写入文件
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /*上传完文件再添加项目*/
        // ItemVo itemVo1 = new ItemVo();
        itemVo.setImgMain(mainFileName); /*将主图url添加到项目中*/
        itemService.addItem(itemVo);
        String parentId = itemVo.getParentId();
        String menuName = itemVo.getItemName();
        String url = "detail.html?itemId="+itemId;
        SysMenu sysMenu = new SysMenu();
        sysMenu.setParentId(Integer.parseInt(parentId));
        sysMenu.setMenuName(menuName);
        sysMenu.setUrl(url);
         //将项目加入菜单树
        itemService.addSysMenu(sysMenu);
        return files.toString();
    }


    @PostMapping("/getFileName")
    public Result getFileName(String path) throws Exception {
        //path = "F:/OTA/image/89535";
        List file = findFileService.getFiles(path);
        return Result.success(null,file);
    }

    //单文件上传
    @PostMapping("/introduceUpload")
    public String introduceUpload( @RequestParam(value = "introImgFile")MultipartFile introImgFile , Introduce introduce) throws Exception {
        System.out.println("后台收到的多个文件是："+introImgFile);
        System.out.println("接收到的项目字段"+introduce);
        int itemId = introduce.getItemId();
        // 介绍图上传
        String introduceFileName = introImgFile.getOriginalFilename();  // 文件名
        String introduceSuffixName = introduceFileName.substring(introduceFileName.lastIndexOf("."));  // 后缀名
        String introFilePath = "C:/OTA/image/"+ itemId +"/"; // 上传后的路径
        introduceFileName = UUID.randomUUID() + introduceSuffixName; // 新文件名
        File introDest = new File(introFilePath + introduceFileName);  //新建文件
        //判断路径是否存在，如果不存在就创建一个
        if (!introDest.getParentFile().exists()) {
            introDest.getParentFile().mkdirs();
        }
        try {
            //写入文件
            introImgFile.transferTo(introDest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*上传完文件再添加项目*/
        Introduce introduce1 = new Introduce();
        introduce1.setItemId(introduce.getItemId());
        introduce1.setIntroTitle(introduce.getIntroTitle());
        introduce1.setContent(introduce.getContent());
        introduce1.setImg(introduceFileName);
        System.out.println(introduce1);
        introduceService.addIntroduce(introduce1);
        return introImgFile.toString();
    }

    //图像上传
    @PostMapping("/userImgUpload")/*,required = false*/
    public Result userImgUpload( @RequestParam(value = "personImg" )MultipartFile personImg ,String userId) throws Exception {
        System.out.println("后台收到的图像文件是："+personImg);
        System.out.println("后台收到的参数是："+userId);

        // 介绍图上传
        String personImgName = personImg.getOriginalFilename();  // 文件名
        String personImgSuffixName = personImgName.substring(personImgName.lastIndexOf("."));  // 后缀名
        String personImgFilePath = "C:/OTA/user/"+ userId +"/"; // 上传后的路径
        personImgName = UUID.randomUUID() + personImgSuffixName; // 新文件名
        File personImgDest = new File(personImgFilePath + personImgName);  //新建文件
        //判断路径是否存在，如果不存在就创建一个
        if (!personImgDest.getParentFile().exists()) {
            personImgDest.getParentFile().mkdirs();
        }
        try {
            //写入文件
            personImg.transferTo(personImgDest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*上传完文件再添加到数据库*/
        userService.changeImg(userId,personImgName);
        return Result.success("图像修改成功");
    }






}
