//package cn.rep.cloud.custom.utils;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.lang.StringUtils;
//
//public class VeCollUtils {
//	/**
//	 * <功能详细描述>
//	 * 给对象集合排序，只支持bean和map的集合
//	 * @param list
//	 * @param orderBys 排序内容: ["payfee,desc","worktime,asc"]
//	 * @param nullHigh true表示空值为大，false表示空值为小
//	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static void sortList(List list,String[] orderBys,boolean nullHigh){
//		ArrayList<Object> beanComparators=new ArrayList<Object>();
//		Comparator comparator= ComparableComparator.getInstance();
//		for (String orderBy : orderBys) {
//			String[] orderByArr=orderBy.split(",");
//			if("desc".equals(orderByArr[1].toLowerCase())){
//				comparator=ComparatorUtils.reversedComparator(comparator);
//			}
//			if(nullHigh){
//				comparator=ComparatorUtils.nullHighComparator(comparator);
//			}else{
//				comparator=ComparatorUtils.nullLowComparator(comparator);
//			}
//			beanComparators.add(new BeanComparator(orderByArr[0],comparator));
//		}
//		ComparatorChain comparatorChain=new ComparatorChain(beanComparators);
//		Collections.sort(list, comparatorChain);
//	}
//	/**
//	 * 给装有bean或map的集合按指定属性分组
//	 * 注意：此处分组如果分组属性值为null，则这部分数据分组key为""空字符串
//	 * @param list
//	 * @param groupKey 分组属性
//	 * @return
//	 * @throws Exception [参数说明]
//	 *
//	 * @return Map<String,List<Object>> [返回类型说明]
//	 */
//	public static <T>Map<String, List<T>> group(List<T> list,String groupKey) throws Exception{
//		if(list==null){
//			return null;
//		}
//		Map<String, List<T>> result=new LinkedHashMap<String, List<T>>();
//		for (T bean : list) {
//			String key=BeanUtils.getProperty(bean, groupKey);
//			key=key==null ? "" : key;
//			List<T> groupList=null;
//			if(result.containsKey(key)){
//				groupList=result.get(key);
//			}else {
//				groupList=new ArrayList<T>();
//				result.put(key, groupList);
//			}
//			groupList.add(bean);
//		}
//		return result;
//	}
//	/**
//	 * 给装有bean或map的集合按指定属性分组
//	 * 注意：此处分组如果分组属性值为null，则会丢失这部分数据
//	 * @param list
//	 * @param groupKey 分组属性
//	 * @param keyDefualt 当key值为空时则以keyDefualt做key值
//	 * @return
//	 * @throws Exception [参数说明]
//	 *
//	 * @return Map<String,List<Object>> [返回类型说明]
//	 */
//	public static <T>Map<String, List<T>> group(List<T> list,String groupKey,String keyDefualt) throws Exception{
//		if(list==null){
//			return null;
//		}
//		Map<String, List<T>> result=new LinkedHashMap<String, List<T>>();
//		keyDefualt= keyDefualt==null ? "" : keyDefualt;
//		for (T bean : list) {
//			String key=BeanUtils.getProperty(bean, groupKey);
//			key=StringUtils.isBlank(key) ? keyDefualt : key;
//			List<T> groupList=null;
//			if(result.containsKey(key)){
//				groupList=result.get(key);
//			}else {
//				groupList=new ArrayList<T>();
//				result.put(key, groupList);
//			}
//			groupList.add(bean);
//		}
//		return result;
//	}
//	/**
//	 * 给装有bean或map的集合按多个属性分组
//	 *
//	 * @param list
//	 * @param groupKeys 分组属性
//	 * @param keySplit 分组的key以什么分隔符拼接,空的话以空字符串拼接
//	 * @return
//	 * @throws Exception [参数说明]
//	 *
//	 * @return Map<String,List<Object>> [返回类型说明]
//	 */
//	public static <T>Map<String, List<T>> group(List<T> list,String[] groupKeys,String keySplit) throws Exception{
//		if(list==null){
//			return null;
//		}
//		Map<String, List<T>> result=new LinkedHashMap<String, List<T>>();
//		if(keySplit==null){
//			keySplit="";
//		}
//		for (T bean : list) {
//			String[] keyArr=new String[groupKeys.length];
//			for(int i=0;i<groupKeys.length;i++){
//				keyArr[i]=BeanUtils.getProperty(bean, groupKeys[i]);
//				keyArr[i]=keyArr[i]==null ? "" : keyArr[i];
//			}
//			String key=StringUtils.join(keyArr, keySplit);
//			List<T> groupList=null;
//			if(result.containsKey(key)){
//				groupList=result.get(key);
//			}else {
//				groupList=new ArrayList<T>();
//				result.put(key, groupList);
//			}
//			groupList.add(bean);
//		}
//		return result;
//	}
//	/**
//	 * 给装有bean或map的集合按多个属性分组
//	 *
//	 * @param list
//	 * @param groupKeys 分组属性
//	 * @param keySplit 分组的key以什么分隔符拼接,空的话以空字符串拼接
//	 * @param keyDefualt 当key值为空时则以keyDefualt做key值
//	 * @return
//	 * @throws Exception [参数说明]
//	 *
//	 * @return Map<String,List<Object>> [返回类型说明]
//	 */
//	public static <T>Map<String, List<T>> group(List<T> list,String[] groupKeys,String keySplit,String keyDefualt) throws Exception{
//		if(list==null){
//			return null;
//		}
//		Map<String, List<T>> result=new LinkedHashMap<String, List<T>>();
//		keySplit=keySplit==null ? "" : keySplit;
//		keyDefualt= keyDefualt==null ? "" : keyDefualt;
//		for (T bean : list) {
//			String[] keyArr=new String[groupKeys.length];
//			for(int i=0;i<groupKeys.length;i++){
//				String keyVal=BeanUtils.getProperty(bean, groupKeys[i]);
//				keyArr[i]=StringUtils.isBlank(keyVal) ? keyDefualt : keyVal;
//			}
//			String key=StringUtils.join(keyArr, keySplit);
//			List<T> groupList=null;
//			if(result.containsKey(key)){
//				groupList=result.get(key);
//			}else {
//				groupList=new ArrayList<T>();
//				result.put(key, groupList);
//			}
//			groupList.add(bean);
//		}
//		return result;
//	}
//}
