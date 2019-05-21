package cn.rep.cloud.custom.coreutils.fileupload;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import cn.rep.cloud.custom.basecommon.common.Constants;
import cn.rep.cloud.custom.coreutils.fileupload.config.DirectoryProvider;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class FileUploadService {


    @Value("${fileStorage.uploadFileUrl}")
    public String uploadFileUrl;

    /*临时文件存放地址*/
    @Value("${fileStorage.tempFileUrl}")
    public String tempFileUrl;

    @Value("${fileStorage.downloadFileUrl}")
    public String downloadFileUrl;

    @Autowired
    private DirectoryProvider directoryProvider;

    /**
     * 获取临时文件存储目录
     *
     * @return
     */
    public String getPath() {
        String path = directoryProvider.build();
        return path;
    }

    /**
     * 返回文件存储目录
     *
     * @return
     */
    public String getStorePath() {
        //创建文件根目录
        File repository = PictureUtils.makeDir(tempFileUrl);
        String path =  getPath();
        // 文件存储完整目录
        File dir = new File(repository, path);
        if (!dir.exists()) {
            dir.mkdirs();

        }
        return dir.getPath();
    }

    public Boolean deleteFile(File file) {
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }


    /*多个文件上传*/
    public List<FileInfoBean> uploadFile(List<MultipartFile>  fileList){
        List<FileInfoBean> fileInfoBeanList = new ArrayList<>();
        try {
            if (CollectionUtils.isNotEmpty(fileList)) {
                for (MultipartFile multipartFile : fileList) {
                    HashMap<String, Object> paramMap = new HashMap<>();
                    String orageName=multipartFile.getOriginalFilename();
                    File file=new File(getStorePath()+"\\" + orageName);
                    multipartFile.transferTo(file);
                    paramMap.put("file", file);
                    String result= HttpUtil.post(uploadFileUrl, paramMap);
                    if (StringUtils.isNotBlank(result)) {
                        FileUploadResponse responseBO = JSONUtil.toBean(result, FileUploadResponse.class);
                        if (null != responseBO) {
                            FileInfoBean fileInfoBean = responseBO.getData();
                            fileInfoBeanList.add(fileInfoBean);
                        }
                    }
                    System.out.println(result);
                    System.out.println("删除临时文件"+deleteFile(file));
                }
            }
        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
        return fileInfoBeanList;
    }


    /**
     * 上传文件 返回文件信息
     *
     * @param uploadFile
     * @return
     */

    public FileInfoBean uploadFile(File uploadFile) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("file", uploadFile);
        //上传文件
        String result = HttpUtil.post(uploadFileUrl, paramMap);
        if (StringUtils.isNoneBlank(result)) {
            FileUploadResponse responseBO = JSONUtil.toBean(result, FileUploadResponse.class);
            if (null != responseBO && StringUtils.equals(responseBO.getStatusCode(), "200")) {
                FileInfoBean fileInfoBean = responseBO.getData();
                fileInfoBean.setDownloadUrl(downloadFileUrl+"?fileId="+fileInfoBean.getFileId());
                return fileInfoBean;
            }
        }
        return null;
    }


}
