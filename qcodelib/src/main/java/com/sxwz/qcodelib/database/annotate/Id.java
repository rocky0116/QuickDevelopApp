
package com.sxwz.qcodelib.database.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Id主键配置,不配置的时候默认找类的id或_id字段作为主键，column不配置的是默认为字段名 <br>
 * 
 * <b>创建时间</b> 2014-8-15
 *
 * @author wz
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    /**
     * 设置为主键
     * 
     * @return
     */
    public String column() default "";
}
