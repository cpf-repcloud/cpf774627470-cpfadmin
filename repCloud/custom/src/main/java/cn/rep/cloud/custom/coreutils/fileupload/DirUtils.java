package cn.rep.cloud.custom.coreutils.fileupload;

import java.util.Calendar;
import java.util.Random;

/**
 * 目录相关工具类
 * 
 * @author lemon
 * @since 2018/6/1
 */
public class DirUtils {

	// 组成路径的字符
	private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyz";

	// 路径分隔符
	private static final String SEPARATOR = "/";

	/**
	 * 随机生成相对目录
	 * 
	 *            起始目录
	 * @param level
	 *            子目录层级
	 *            是否生成生成的目录
	 * @return 完整的目录
	 */
	public static String randDir(int level) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < level; i++) {
			sb.append(SEPARATOR);
			String p = String.valueOf(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
			sb.append(p);
		}
		sb.append(SEPARATOR);
		return sb.toString();
	}

	/**
	 * 根据年月日生成文件存放目录
	 * 
	 * @return
	 */
	public static String timeBasedDir() {
		StringBuffer sb = new StringBuffer();
		Calendar currentDate = Calendar.getInstance();
		Integer year = currentDate.get(Calendar.YEAR);
		Integer month = currentDate.get(Calendar.MONTH) + 1;
		Integer day = currentDate.get(Calendar.DAY_OF_MONTH);
		sb.append(SEPARATOR);
		sb.append(String.valueOf(year));
		sb.append(SEPARATOR);
		sb.append(String.valueOf(month));
		sb.append(SEPARATOR);
		sb.append(String.valueOf(day));
		sb.append(randDir(2));
		return sb.toString();
	}

	/**
	 * 匹配字符串生成文件存放目录
	 * 
	 * @param parttenUrl
	 * @return
	 */
	public static String parttenDir(String parttenUrl) {
		StringBuffer sb = new StringBuffer();
		Calendar currentDate = Calendar.getInstance();
		Integer year = currentDate.get(Calendar.YEAR);
		Integer month = currentDate.get(Calendar.MONTH) + 1;
		Integer day = currentDate.get(Calendar.DAY_OF_MONTH);
		Integer hour = currentDate.get(Calendar.HOUR_OF_DAY);
		Integer minute = currentDate.get(Calendar.MINUTE);
		Integer second = currentDate.get(Calendar.SECOND);
		sb.append(SEPARATOR);
		sb.append(parttenUrl.replace("yyyy", year + "").replace("MM", month + "").replace("dd", day + "")
				.replace("hh", hour + "").replace("mm", minute + "").replace("ss", second + ""));
		sb.append(SEPARATOR);
		return sb.toString();
	}

}
