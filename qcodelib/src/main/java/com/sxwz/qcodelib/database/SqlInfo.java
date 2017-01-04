
package com.sxwz.qcodelib.database;

import java.util.LinkedList;

/**
 * sql语句的全部信息<br>
 * 
 * <b>创建时间</b> 2014-8-15
 *
 * @author wz
 * @version 1.0
 */
public class SqlInfo {

    private String sql;
    private LinkedList<Object> bindArgs;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public LinkedList<Object> getBindArgs() {
        return bindArgs;
    }

    public void setBindArgs(LinkedList<Object> bindArgs) {
        this.bindArgs = bindArgs;
    }

    public Object[] getBindArgsAsArray() {
        if (bindArgs != null)
            return bindArgs.toArray();
        return null;
    }

    public String[] getBindArgsAsStringArray() {
        if (bindArgs != null) {
            String[] strings = new String[bindArgs.size()];
            for (int i = 0; i < bindArgs.size(); i++) {
                strings[i] = bindArgs.get(i).toString();
            }
            return strings;
        }
        return null;
    }

    public void addValue(Object obj) {
        if (bindArgs == null)
            bindArgs = new LinkedList<Object>();

        bindArgs.add(obj);
    }

}
