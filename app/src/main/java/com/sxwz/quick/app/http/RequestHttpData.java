package com.sxwz.quick.app.http;

import android.content.Context;

import com.sxwz.qcodelib.utils.NetworkUtils;
import com.sxwz.quick.app.MyApp;
import com.sxwz.quick.app.entity.AllListEntity;
import com.sxwz.quick.app.entity.PrettyPicEntity;
import com.sxwz.quick.app.utils.SdCardUtil;
import com.sxwz.quick.app.utils.UIHelper;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/19 16:36
 * description:
 *****************************************************/

public class RequestHttpData {

    public static final String BASE_URL = "http://gank.io/api/data/";
    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit retrofit;
    private ApiService apiService;

    //构造方法私有
    private RequestHttpData() {
        //手动创建一个OkHttpClient并设置缓存超时时间
        //String sdCd = SdCardUtil.getSavedDir(UIHelper.SAVE_RESPONSE);
        //Context context=MyApp.getContext();
        //File sss=context.getCacheDir();
        File httpCacheDirectory = new File(MyApp.getContext().getCacheDir(), UIHelper.SAVE_RESPONSE);
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RequestHttpData INSTANCE = new RequestHttpData();
    }

    //获取单例
    public static RequestHttpData getInstance() {
        return SingletonHolder.INSTANCE;
    }


    Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();

            Request request = chain.request();
            if (!NetworkUtils.checkNet(MyApp.getContext())) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();

            }
            Response originalResponse = chain.proceed(request);
            if (NetworkUtils.checkNet(MyApp.getContext())) {
                int maxAge = 0; // read from cache
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };


    public void getAllList(Subscriber<AllListEntity> subscriber, int start, int count) {
        apiService.getAllTypeList(start, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getPrettyPic(Subscriber<PrettyPicEntity> subscriber,
                             int pageSize, int pageNumber) {
        apiService.getPrettyPic(pageSize, pageNumber)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
