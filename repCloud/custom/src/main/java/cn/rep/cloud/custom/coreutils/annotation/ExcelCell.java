package cn.rep.cloud.custom.coreutils.annotation;

import java.lang.annotation.*;

/**
 * @ClassName: ExcelCell
 * @Description: 实体字段与excel列号关联的注解
 * @author hyg
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelCell {
    String colValue(); //列名
    int col(); //列号 从0开始
}
