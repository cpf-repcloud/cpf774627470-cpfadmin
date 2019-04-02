package cn.rep.cloud.custom.coreutils.common;

import com.baomidou.mybatisplus.toolkit.SqlReservedWords;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class PageDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 定义
     */
    private final int sizet = 10;

    /**
     * 分页页码
     */
    private int current = 1;
    /**
     * 每页记录数
     */
    private int size = sizet;
    /**
     * 总条数
     */
    private int total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 实体数据
     */
    private T data;


    /**
     * 排序的字段 防止注入
     */
    private String orderByField;
    /**
     * 是否升序 默认为倒序 true为升序  false为倒序
     */
    @JsonProperty("isAsc")
    private boolean isAsc;

    /**
     * java 属性转成数据库字段
     *
     * @param entityProperty java 属性
     *
     * @return 数据库字段名称
     */
    private static String convert(String entityProperty) {
        if (StringUtils.isNotBlank(entityProperty)&& validateSqlInject(entityProperty)) {
            entityProperty = entityProperty.replaceAll("[A-Z]", "_$0");
            return entityProperty.toLowerCase();
        }
        return null;
    }

    /**
     * 防止SQL 注入 验证 排序 字段 中 是否 包含 数据库 关键字
     * @param entityProperty 排序 字段
     * @return 排序 字段
     */
    private static boolean validateSqlInject(String entityProperty) {
        String[] keyWords = entityProperty.split("\\s+");
        if(keyWords != null){
            for(String keyWord : keyWords){
                if(SqlReservedWords.containsWord(keyWord) || keyWord.contains("'")){
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }
    /**
     * 按数据库字段 排序
     *
     * @return 排序字段名
     */
    public String getOrderByField() {
        return convert(orderByField);
    }

    /**
     * 用于 ES 使用 java 属性排序
     *
     * @return 排序java 名
     */
    public String getOrderByProperty() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }

    public T getData() {
        return data;
    }


    public void setData(T data) {
        this.data = data;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
