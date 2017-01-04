
package com.sxwz.qcodelib.database.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 检测 字段是否已经被标注为 非数据库字段<br>
 * 
 * <b>创建时间</b> 2014-8-15
 * 
 *
 * @author wz
 * @version 1.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transient {

}
