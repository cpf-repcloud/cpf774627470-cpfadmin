package cn.rep.cloud.custom.openapi.feignclient.fileupload;

import cn.rep.cloud.custom.openapi.feignclient.fileupload.vo.UploadFileVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "framework")
public interface IUploadFileServiceClient {

    @PostMapping(value = "/api/feign/upload/uploadFile")
    UploadFileVO uploadFile(MultipartFile multipart, @RequestParam String childFile, @RequestParam String extension);
}
