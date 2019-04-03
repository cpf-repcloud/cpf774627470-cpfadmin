package cn.rep.cloud.framework.fileserver.upload;

import cn.rep.cloud.framework.common.FileResult;
import cn.rep.cloud.framework.common.FileuploadUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/feign/upload")
public class UploadFileClien {
    /**
     * 方法描述：文件上传，图片也可以使用，但是图片不会被压缩.
     * 创建时间：2018-10-19 14:10:32
     *
     * @param childFile 上传的父目录
     * @param extension 允许上传的文件后缀名
     * @author "lixingwu"
     */
    @PostMapping("/uploadFile")
    public FileResult uploadFile(
            MultipartFile multipart,
            @RequestParam(value = "childFile", required = false, defaultValue = "") String childFile,
            @RequestParam(value = "extension", required = false, defaultValue = "") String extension
    ) throws IOException {
        return FileuploadUtil.saveFile(multipart, childFile, extension);
    }

    /**
     * 方法描述：图片上传，只能给图片使用，其他文件调用会异常.
     * 创建时间：2018-10-19 14:10:32
     *
     * @param childFile 上传的父目录
     * @param extension 允许上传的文件后缀名
     * @author "lixingwu"
     */
    @PostMapping("/uploadImage")
    public FileResult uploadImage(
            MultipartFile multipart,
            @RequestParam(value = "childFile", required = false, defaultValue = "") String childFile,
            @RequestParam(value = "extension", required = false, defaultValue = "") String extension
    ) throws IOException {
        return FileuploadUtil.saveImage(multipart, childFile, extension);
    }
}
