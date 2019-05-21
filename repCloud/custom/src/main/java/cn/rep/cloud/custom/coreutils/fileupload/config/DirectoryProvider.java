package cn.rep.cloud.custom.coreutils.fileupload.config;

/**
 * 生成文件存放目录
 * 
 * @author lemon
 * @since 20190305
 *
 */
public interface DirectoryProvider {

	/**
	 * 生成文件存放的子目录
	 * 
	 * @return
	 */
	public String build();

}
