
package com.sxwz.qcodelib.database.utils;

/**
 * 一对多的字段<br>
 * 
 * <b>创建时间</b> 2014-8-15
 *
 * @author wz
 * @version 1.0
 */
public class OneToMany extends Property {

    private Class<?> oneClass;

    public Class<?> getOneClass() {
        return oneClass;
    }

    public void setOneClass(Class<?> oneClass) {
        this.oneClass = oneClass;
    }

}
