
package com.sxwz.qcodelib.database;


import com.sxwz.qcodelib.ZDB;

/**
 * 多对一延迟加载类<br>
 * <b>创建时间</b> 2014-8-15
 * 
 * @param <O>
 *            宿主实体的class
 * @param <M>
 *            多放实体class
 *
 * @author wz
 * @version 1.0
 */
public class ManyToOneLazyLoader<M, O> {
    M manyEntity;
    Class<M> manyClazz;
    Class<O> oneClazz;
    ZDB db;

    public ManyToOneLazyLoader(M manyEntity, Class<M> manyClazz,
                               Class<O> oneClazz, ZDB db) {
        this.manyEntity = manyEntity;
        this.manyClazz = manyClazz;
        this.oneClazz = oneClazz;
        this.db = db;
    }

    O oneEntity;
    boolean hasLoaded = false;

    /**
     * 如果数据未加载，则调用loadManyToOne填充数据
     * 
     * @return
     */
    public O get() {
        if (oneEntity == null && !hasLoaded) {
            this.db.loadManyToOne(this.manyEntity, this.manyClazz,
                    this.oneClazz);
            hasLoaded = true;
        }
        return oneEntity;
    }

    public void set(O value) {
        oneEntity = value;
    }

}
