package com.sh.ssm.taotao.controller;

import com.sh.ssm.common.pojo.PictureResult;
import com.sh.ssm.taotao.service.PictureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/3/3.
 * 图片上传处理器
 */
@Controller
public class PictureController {
    private static Logger logger = Logger.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;
    @RequestMapping("/rest/pic/upload")
    @ResponseBody
    public PictureResult uploadPicture(MultipartFile uploadFile) {
        return pictureService.uploadPictureToLocal(uploadFile);
    }

    private void getAllPath(HttpServletRequest request) {
        String p0 = request.getRequestURI();// /rest/pic/upload
        String p1 = request.getContextPath();//当前jsp的路径
        String p2 = System.getProperty("user.dir");//E:\Program Files\apache-tomcat-8.0.28\bin
        //获取当前的classpath路径
        String p3 = this.getClass().getResource("").toString();//file:/E:/IntellijWorkspace/taotao/target/taotao/WEB-INF/classes/com/sh/ssm/taotao/controller/
        String p4 = this.getClass().getResource("/").toString();//file:/E:/IntellijWorkspace/taotao/target/taotao/WEB-INF/classes/
        String p5 = this.getClass().getClassLoader().getResource("").toString();//file:/E:/IntellijWorkspace/taotao/target/taotao/WEB-INF/classes/
        String p6 = Thread.currentThread().getContextClassLoader().getResource("").getPath();///E:/IntellijWorkspace/taotao/target/taotao/WEB-INF/classes/

        String p7 = request.getServletPath();// /rest/pic/upload
        String p8 = request.getSession().getServletContext().getRealPath("");//E:\IntellijWorkspace\taotao\target\taotao\
        String p9 = request.getRequestURL().toString();//http://localhost:8080/rest/pic/upload

        String p10 = request.getRemoteAddr();//127.0.0.1
        logger.debug("p0: " + p0 + "\n" +
                     "p1: " + p1 + "\n" +
                     "p2: " + p2 + "\n" +
                     "p3: " + p3 + "\n" +
                     "p4: " + p4 + "\n" +
                     "p5: " + p5 + "\n" +
                     "p6: " + p6 + "\n" +
                     "p7: " + p7 + "\n" +
                     "p8: " + p8 + "\n" +
                     "p9: " + p9 + "\n" +
                     "p10: " + p10);


    }


}
