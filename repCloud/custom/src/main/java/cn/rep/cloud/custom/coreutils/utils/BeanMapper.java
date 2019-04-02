package cn.rep.cloud.custom.coreutils.utils;

import org.dozer.DozerBeanMapper;

import java.util.*;


/**
 * 简单封装Dozer, 实现深度转换Bean<->Bean的Mapper.实现:
 *
 * 1. 持有Mapper的单例.
 * 2. 返回值类型转换.
 * 3. 批量转换Collection中的所有对象.
 * 4. 区分创建新的B对象与将对象A值复制到已存在的B对象两种函数.
 *
 * @author calvin
 */
public class BeanMapper {

	/**
	 * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
	 */
	private static DozerBeanMapper dozer = new DozerBeanMapper();

	/**
	 * 基于Dozer转换对象的类型.
	 */
	public static <T> T map(Object source, Class<T> destinationClass) {
		return dozer.map(source, destinationClass);
	}

	/**
	 * 基于Dozer转换Collection中对象的类型.
	 */
	public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
		List<T> destinationList = new ArrayList<>();
		for (Object sourceObject : sourceList) {
			T destinationObject = dozer.map(sourceObject, destinationClass);
			destinationList.add(destinationObject);
		}
		return destinationList;
	}

	/**
	 * 基于Dozer将对象A的值拷贝到对象B中.
	 */
	public static void copy(Object source, Object destinationObject) {
		dozer.map(source, destinationObject);
	}

	/**
	 * 将一个里面是map对象的集合转化为所需要的bean的集合
	 * @param map
	 * @param destClass
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> fromMaptoBean(List<Map> map, Class<T> destClass) throws Exception {
		List<T> list = new ArrayList<>();
		for(Map m1 : map) {
			Map m = new HashMap();
			Iterator it = m1.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				m.put(key.toString().toLowerCase(), value);
			}
			list.add(BeanMapper.map(m,destClass));
		}
		return list;
	}
}