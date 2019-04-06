package cn.rep.cloud.framework.common;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileuploadUtil {

    /**
     * 属性配置
     */
    private static PropertiesUtils pro = PropertiesUtils.getInstance();

    /**
     * 方法描述：根据文件的绝对路径创建一个文件对象.
     *
     * @param filePath 文件的绝对路径
     * @return 返回创建的这个文件对象
     */
    public static File createFile(String filePath) throws IOException{
        // 获取文件的完整目录
        String fileDir = FilenameUtils.getFullPath(filePath);
        // 判断目录是否存在，不存在就创建一个目录
        File file = new File(fileDir);
        if (!file.isDirectory()) {
            //创建失败返回null
            if (!file.mkdirs()) {
                throw new IOException("文件目录创建失败...");
            }
        }
        // 判断这个文件是否存在，不存在就创建
        file = new File(filePath);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("目标文件创建失败...");
            }
        }
        return file;
    }

    /**
     * 方法描述：判断extension中是否存在extName
     *
     * @param extension 使用逗号隔开的字符串，精确匹配例如：txt,jpg,png,zip
     * @param extName   文件的后缀名
     */
    private static void isContains(String extension, String extName) {
        if (StringUtils.isNotEmpty(extension)) {
            // 切割文件扩展名
            String[] exts = StringUtils.split(extension, ",");
            if (ArrayUtils.isNotEmpty(exts)) {
                assert exts != null;
                List<String> extList = Arrays.asList(exts);
                //判断
                if (!extList.contains(extName)) {
                    throw new RuntimeException("上传文件的类型只能是：" + extension);
                }
            } else {
                // 判断文件的后缀名是否为extension
                if (!extension.equalsIgnoreCase(extName)) {
                    throw new RuntimeException("上传文件的类型只能是：" + extension);
                }
            }
        }
    }

    /**
     * 方法描述：处理上传的图片 (是否需要压缩？)
     *
     * @param serverPath 图片的绝对路径
     * @param childFile  子文件夹
     * @param extName    文件的后缀
     */
    private static String thumbnails(String serverPath, String childFile, String extName)
            throws IOException {
        // 压缩后的相对路径文件名
        String toFilePath = getDestPath(childFile, extName);

        // scale：图片缩放比例
        // outputQuality：图片压缩比例
        // toFile：图片位置
        // outputFormat：文件输出后缀名
        // Thumbnails 如果用来压缩 png 格式的文件，会越压越大，
        // 得把png格式的图片转换为jpg格式
//        if ("png".equalsIgnoreCase(extName)) {
//            // 由于outputFormat会自动在路径后加上后缀名，所以移除以前的后缀名
//            String removeExtensionFilePath = FilenameUtils.removeExtension(toFilePath);
//            Thumbnails.of(serverPath).scale(1f)
//                    .outputQuality(0.5f)
//                    .outputFormat("jpg")
//                    .toFile(getServerPath(removeExtensionFilePath));
//            toFilePath = removeExtensionFilePath + ".jpg";
//        } else {
//            Thumbnails.of(serverPath).scale(1f).outputQuality(0.5f)
//                    .toFile(getServerPath(toFilePath));
//        }

        // 删除被压缩的文件
        //FileUtils.forceDelete(new File(serverPath));

        return toFilePath;
    }

    /**
     * 方法描述：生成文件文件名
     *
     * @param childFile 子目录
     * @param extName   后缀名
     */
    private static String getDestPath(String childFile, String extName) {
        //规则：  uuid + 后缀名
        String sb = childFile + "/"+IdGenerator.uuid()+"." + extName;
        return sb;
    }

    /**
     * 方法描述：生成文件在的实际的路径
     *
     * @param destPath 文件的相对路径
     */
    private static String getServerPath(String destPath) {
        // 文件分隔符转化为当前系统的格式
        return FilenameUtils.separatorsToSystem(pro.getAttachmentGainPpath() + destPath);
    }

    /**
     * 方法描述：上传文件
     *
     * @param multipartFile 上传的文件对象，必传
     * @param childFile     上传的父目录，为空直接上传到指定目录 （会在指定的目录下新建该目录，例如：/user/1023）
     * @param extension     允许上传的文件后缀名，为空不限定上传的文件类型 （使用逗号隔开的字符串，精确匹配例如：txt,jpg,png,zip）
     * @param isImage       上传的是否是图片，如果是就会进行图片压缩；如果不希望图片被压缩，则传false，让其以文件的形式来保存
     * @return the file result
     * @throws IOException 异常信息应返回
     */
    private static FileResult saveFile(MultipartFile multipartFile, String childFile, String extension, Boolean isImage) throws IOException {
        if (null == multipartFile || multipartFile.isEmpty()) {
            throw new IOException("上传的文件对象不存在...");
        }
        // 文件名
        String fileName = multipartFile.getOriginalFilename();
        // 文件后缀名
        String extName = FilenameUtils.getExtension(fileName);
        if (StringUtils.isEmpty(extName)) {
            throw new RuntimeException("文件类型未定义不能上传...");
        }
        // 判断文件的后缀名是否符合规则
        isContains(extension, extName);
        // 创建目标文件的名称，规则请看destPath方法
        String destPath = getDestPath(childFile, extName);
        // 文件的实际路径
        String serverPath = getServerPath(destPath);
        // 创建文件
        File destFile = createFile(serverPath);
        // 保存文件
        multipartFile.transferTo(destFile);

        // 拼装返回的数据
        FileResult result = new FileResult();
        //如果是图片，就进行图片处理
        if (BooleanUtils.isTrue(isImage)) {
            // 图片处理
            String toFilePath = thumbnails(serverPath, childFile, extName);
            // 得到处理后的图片文件对象
            File file = new File(getServerPath(toFilePath));
            // 压缩后的文件后缀名
            String extExtName = FilenameUtils.getExtension(toFilePath);
            // 源文件=源文件名.压缩后的后缀名
            String extFileName = FilenameUtils.getBaseName(fileName) + "." + FilenameUtils.getExtension(toFilePath);
            result.setFileSize(file.length());
            result.setServerPath(toFilePath);
            result.setFileName(extFileName);
            result.setExtName(extExtName);
            if (null == destFile){
                result.setErrorDode("-1");
            }else{
                result.setErrorDode("1");
            }
        } else {
            result.setFileSize(multipartFile.getSize());
            result.setFileName(fileName);
            result.setExtName(extName);
            result.setServerPath(destPath);
        }
        return result;
    }

    /**
     * 方法描述：上传文件.
     *
     * @param multipartFile 上传的文件对象，必传
     * @param childFile     上传的父目录，为空直接上传到指定目录 （会在指定的目录下新建该目录，例如：/user/1023）
     * @param extension     允许上传的文件后缀名，为空不限定上传的文件类型 （使用逗号隔开的字符串，精确匹配例如：txt,jpg,png,zip）
     * @return the file result
     * @throws IOException 异常信息应返回
     */
    public static FileResult saveFile(MultipartFile multipartFile, String childFile, String extension) throws IOException {
        return saveFile(multipartFile, childFile, extension, false);
    }

    /**
     * 方法描述：上传图片
     *
     * @param multipartFile 上传的文件对象，必传
     * @param childFile     上传的父目录，为空直接上传到指定目录 （会在指定的目录下新建该目录，例如：/user/1023）
     * @param extension     允许上传的文件后缀名，为空不限定上传的文件类型 （使用逗号隔开的字符串，精确匹配例如：txt,jpg,png,zip）
     * @return the file result
     * @throws IOException 异常信息应返回
     */
    public static FileResult saveImage(MultipartFile multipartFile, String childFile, String extension) throws IOException {
        return saveFile(multipartFile, childFile, extension, true);
    }
}
