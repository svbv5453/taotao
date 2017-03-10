package com.sh.ssm.taotao.service;

import com.sh.ssm.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/3/3.
 */
public interface PictureService {

    public PictureResult uploadPictrueToNignx(MultipartFile uploadFile);

    public PictureResult uploadPictureToLocal(MultipartFile uploadFile);
}
