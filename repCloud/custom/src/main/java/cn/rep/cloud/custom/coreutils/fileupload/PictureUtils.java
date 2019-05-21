package cn.rep.cloud.custom.coreutils.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author: Mike_cao@enable-ets.com
 * @Date: 2019/4/11 18:03
 * @Description:
 */
public class PictureUtils {


    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PictureUtils.class);


    /**
     * 获取文件后缀名
     *
     * @param fileFullName 文件全名
     * @return 后缀名
     */
    public static String getFileExt(String fileFullName) {
        String fileExt = null;
        if (fileFullName != null && fileFullName.indexOf(".") != -1) {
            fileExt = fileFullName.substring(fileFullName.lastIndexOf(".") + 1).toLowerCase();
        }
        return fileExt;
    }

    public static ByteArrayInputStream parse(OutputStream out) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos = (ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream;
    }


    /**
     * 创建文件夹
     *
     * @param path
     */
    public static File makeDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir;
    }



    public static void inputStream2File(InputStream is, File file) {
        OutputStream os = null;

        try {
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = is.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {

            try {
                if (null != os) {
                    os.close();
                }
            } catch (IOException ex) {
            } finally {
                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException ex) {
                    }
                }
            }
        }
    }


    /**
     * 传输文件流
     * @param zin
     * @param out
     * @throws IOException
     */

    public static void response(InputStream zin, OutputStream out) throws IOException {
        byte[] bytes = new byte[1024];
        int bytesRead = -1;
        while ((bytesRead = zin.read(bytes)) != -1) {
            out.write(bytes, 0, bytesRead);
        }
    }






}