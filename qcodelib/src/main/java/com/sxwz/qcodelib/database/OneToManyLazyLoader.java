

package com.sxwz.qcodelib.database;

import com.sxwz.qcodelib.ZDB;

import java.util.ArrayList;
import java.util.List;

/**
 * 一对多延迟加载类<br>
 * <b>创建时间</b> 2014-8-15
 * 
 * @param <O>
 *            宿主实体的class
 * @param <M>
 *            多放实体class
 * @author wz
 * @version 1.0
 */
public class OneToManyLazyLoader<O, M> {
    O ownerEntity;
    Class<O> ownerClazz;
    Class<M> listItemClazz;
    ZDB db;

    public OneToManyLazyLoader(O ownerEntity, Class<O> ownerClazz,
                               Class<M> listItemclazz, ZDB db) {
        this.ownerEntity = ownerEntity;
        this.ownerClazz = ownerClazz;
        this.listItemClazz = listItemclazz;
        this.db = db;
    }

    List<M> entities;

    /**
     * 如果数据未加载，则调用loadOneToMany填充数据
     * 
     * @return
     */
    public List<M> getList() {
        if (entities == null) {
            this.db.loadOneToMany(this.ownerEntity, this.ownerClazz,
                    this.listItemClazz);
        }
        if (entities == null) {
            entities = new ArrayList<M>();
        }
        return entities;
    }

    public void setList(List<M> value) {
        entities = value;
    }

}
