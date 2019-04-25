package cn.rep.cloud.custom.coreutils.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.*;

@Slf4j
public class DownloadFileUtil {

    /**
     * 下载模板
     * @param filePath 文件目录
     * @param newName  下载的文件名
     * @return 响应
     */
    public static ResponseEntity<InputStreamResource> download(String filePath, String newName) {
        String path = null;
        ResponseEntity<InputStreamResource> response = null;
        try {
            path = filePath+newName+".xlsx";
            ClassPathResource cpr = new ClassPathResource(path);
            InputStream inputStream = cpr.getInputStream();
            //File file = new File(path);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition",
                    "attachment; filename="
                            + new String(newName.getBytes("gbk"), "iso8859-1") + ".xlsx");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            response = ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(inputStream));
        } catch (FileNotFoundException e1) {
            log.error("找不到指定的文件", e1);
        } catch (IOException e) {
            log.error("获取不到文件流", e);
        }
        return response;
    }
}
