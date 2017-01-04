
package com.sxwz.qcodelib.database.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识多对一的属性列<br>
 * 
 * <b>创建时间</b> 2014-8-15
 *
 * @author wz
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ManyToOne {
    public String column() default "";
}
