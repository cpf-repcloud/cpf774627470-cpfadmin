package cn.rep.cloud.custom.coreutils.fileupload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DefaultDirectoryProviderConfig {

	/**
	 * 目录层级
	 */
	@Value("${fileStorage.dirDepth}")
	private Integer dirDepth;

	public Integer getDirDepth() {
		return dirDepth;
	}

	public void setDirDepth(Integer dirDepth) {
		this.dirDepth = dirDepth;
	}
}
