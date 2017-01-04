package com.sxwz.quick.app.http;


import com.sxwz.quick.app.entity.AllListEntity;
import com.sxwz.quick.app.entity.PrettyPicEntity;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/19 16:41
 * description:
 *****************************************************/

public interface ApiService {
//    @GET("top250")
//    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

    //http://gank.io/api/data/福利/10/1
    //http://gank.io/api/data/all/20/2
    @GET("all/{pageSize}/{pageNumber}")
    Observable<AllListEntity> getAllTypeList(@Path("pageSize") int pageSize,
                                             @Path("pageNumber") int pageNumber);


    @GET("福利/{pageSize}/{pageNumber}")
    Observable<PrettyPicEntity> getPrettyPic(@Path("pageSize") int pageSize,
                                             @Path("pageNumber") int pageNumber);
}
