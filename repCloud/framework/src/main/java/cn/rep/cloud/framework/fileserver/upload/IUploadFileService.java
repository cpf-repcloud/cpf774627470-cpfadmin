package cn.rep.cloud.framework.fileserver.upload;

import cn.rep.cloud.framework.common.FileRequest;
import cn.rep.cloud.framework.common.FileResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/api/feign/upload")
public interface IUploadFileService {

    @PostMapping("/uploadFile")
    FileResult uploadFile(MultipartFile multipart, @RequestParam String childFile,@RequestParam String extension) throws IOException;
}
