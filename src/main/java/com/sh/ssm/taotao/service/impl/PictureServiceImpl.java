package com.sh.ssm.taotao.service.impl;

import com.sh.ssm.common.pojo.PictureResult;
import com.sh.ssm.taotao.service.PictureService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2017/3/3.
 * 图片上传业务逻辑处理：（待完成）
 *  两种方式：
 *      1、上传图片到本地服务器
 *      2、上传图片到图片服务器：fastDNS+Nignx
 */
@Service
public class PictureServiceImpl implements PictureService {

    private static Logger logger = Logger.getLogger(PictureServiceImpl.class);

    /**
     * 将图片上传到Nginx服务器
     * @param uploadFile
     * @return
     */
    public PictureResult uploadPictrueToNignx(MultipartFile uploadFile) {
        /**
         * 0-上传成功，1-上传失败
         */

        PictureResult pictureResult = new PictureResult();
        if (uploadFile == null) {
            pictureResult.setError(1);
            pictureResult.setMessage("请添加图片");

        }
        /**
         * 图片上传处理:待补充
         * 使用FastDNSUtil工具类
         *
         */
        /**
         * //取图片扩展名
         String originalFilename = picFile.getOriginalFilename();
         //取扩展名不要“.”
         String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
         FastDFSClient client = new FastDFSClient("classpath:properties/client.conf");
         String url = client.uploadFile(picFile.getBytes(), extName);
         //把url响应给客户端
         */
        pictureResult.setError(0);
        pictureResult.setUrl("");
        return pictureResult;
    }

    /**
     * 将图片上传到本地服务器
     * @param uploadFile
     * @return
     */
    public PictureResult uploadPictureToLocal(MultipartFile uploadFile) {
        PictureResult pictureResult = new PictureResult();
        if (uploadFile == null) {
            pictureResult.setError(1);
            pictureResult.setMessage("请添加图片");

        }

        String localpath = "E:\\IntellijWorkspace\\taotao\\src\\main\\webapp\\upload\\image\\";
        String serverPath = "http://localhost:8080/taotao/image/";
        String oldFileName = uploadFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString() + oldFileName.substring(oldFileName.lastIndexOf("."));
        logger.debug("测试路径" + localpath);
        File uploadPictureFile = new File(localpath + newFileName);
        if (!uploadPictureFile.exists()) {
            uploadPictureFile.mkdirs();
        }
        try {
            uploadFile.transferTo(uploadPictureFile);
            pictureResult.setError(0);
            pictureResult.setMessage("上传成功");
            pictureResult.setUrl(serverPath + newFileName);
            logger.debug("上传图片地址" + serverPath + newFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pictureResult;
    }
}
