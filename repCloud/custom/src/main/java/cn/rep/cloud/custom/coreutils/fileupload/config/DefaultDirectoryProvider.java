package cn.rep.cloud.custom.coreutils.fileupload.config;


import cn.rep.cloud.custom.coreutils.fileupload.DirUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 随机生成文件存放目录
 * 
 * @author lemon
 * @since 20190305
 *
 */
@Service
public class DefaultDirectoryProvider implements DirectoryProvider {
	@Autowired
	private DefaultDirectoryProviderConfig config;

	@Override
	public String build() {
		return DirUtils.randDir(config.getDirDepth());
	}

	public DefaultDirectoryProviderConfig getConfig() {
		return config;
	}

	public void setConfig(DefaultDirectoryProviderConfig config) {
		this.config = config;
	}

}
