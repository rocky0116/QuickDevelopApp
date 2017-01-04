package com.sxwz.quick.app.entity;

import java.io.Serializable;
import java.util.List;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/20 15:00
 * description: 全部分类实体类
 *****************************************************/

public class AllListEntity implements Serializable {


    /**
     * error : false
     * results : [{"_id":"584d7a36421aa963eaaee16f","createdAt":"2016-12-12T00:09:26.762Z","desc":"文章主要介绍freeline是如何实现快速增量编译的","images":["http://img.gank.io/d5e2e665-a8d5-4943-ac82-278b99361843"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"web","type":"Android","url":"http://www.jianshu.com/p/37e31d924be9","used":true,"who":"梧桐"},{"_id":"584f5506421aa934405ccfac","createdAt":"2016-12-13T09:55:18.309Z","desc":"内容非常详细，浅显易懂，苹果2017年1月1日起强制使用HTTPS，这篇文章非常非常有用","images":["http://img.gank.io/e6c7b9c9-6fbf-46bd-ac1e-d830c19d931b"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"前端","url":"http://www.imlifengfeng.com/blog/?p=268","used":true,"who":"猿星人"},{"_id":"584f7ca6421aa93437406720","createdAt":"2016-12-13T12:44:22.461Z","desc":"非常详细的TCP与UDP详解，原创文章","images":["http://img.gank.io/438895f5-094e-4f45-bfff-37bf4335d29a"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"瞎推荐","url":"http://www.imlifengfeng.com/blog/?p=270","used":true,"who":"猿星人"},{"_id":"58501466421aa9343afb7106","createdAt":"2016-12-13T23:31:50.447Z","desc":"暖心广告短片《今年圣诞，愿望成真》","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"休息视频","url":"http://v.youku.com/v_show/id_XMTg1Mjg1OTEwOA==.html","used":true,"who":"lxxself"},{"_id":"585217a3421aa9723d29b955","createdAt":"2016-12-15T12:10:11.280Z","desc":"3D 视差效果的多选按钮","images":["http://img.gank.io/413149f4-5b69-44d0-80d7-93a200e1cd11"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"web","type":"Android","url":"https://github.com/gjiazhe/MultiChoicesCircleButton","used":true,"who":"郭佳哲"},{"_id":"5852e1d5421aa97240ef9edc","createdAt":"2016-12-16T02:32:53.816Z","desc":"史上最详细的教程：iOS难点之内存管理","images":["http://img.gank.io/60fa5a49-55c4-4909-84f0-5edf9164499a"],"publishedAt":"2016-12-16T11:47:53.776Z","source":"web","type":"iOS","url":"http://www.imlifengfeng.com/blog/?p=302","used":true,"who":"李峰峰"},{"_id":"585331db421aa9723d29b95c","createdAt":"2016-12-16T08:14:19.281Z","desc":"12-17","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg","used":true,"who":"代码家"},{"_id":"585353a4421aa97240ef9ede","createdAt":"2016-12-16T10:38:28.505Z","desc":"一个第三方组织，正在全力打造全平台的 Material Design 风格的组件集合。","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"拓展资源","url":"https://github.com/material-components","used":true,"who":"代码家"},{"_id":"5850157f421aa93437406726","createdAt":"2016-12-13T23:36:31.434Z","desc":"你身在何方 【Faded X 你的名字】","publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"休息视频","url":"http://www.bilibili.com/video/av7449411/","used":true,"who":"lxxself"},{"_id":"5850cea7421aa9723d29b94a","createdAt":"2016-12-14T12:46:31.332Z","desc":"显示富文本的TextView","images":["http://img.gank.io/945ec385-c69b-4445-8faf-b657a27e3e60"],"publishedAt":"2016-12-15T11:54:38.900Z","source":"web","type":"Android","url":"https://github.com/limedroid/XRichText","used":true,"who":null},{"_id":"585111e4421aa9723d29b94e","createdAt":"2016-12-14T17:33:24.978Z","desc":"Android 密钥保护和 C/S 网络传输安全理论指南","images":["http://img.gank.io/fd3bd333-ed2b-45e9-9645-7407a188b490"],"publishedAt":"2016-12-15T11:54:38.900Z","source":"web","type":"Android","url":"https://drakeet.me/android-security-guide","used":true,"who":"drakeet"},{"_id":"585187ec421aa9723a5a7763","createdAt":"2016-12-15T01:57:00.914Z","desc":"当你看到这的时候,想必心理一阵恶寒:模块化?组件化?到底是什么鬼?有啥区别. 来看史上讲解Android组件化开发最好的文章.\n","publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"拓展资源","url":"http://blog.csdn.net/dd864140130/article/details/53645290","used":true,"who":"我的名字叫小颜"},{"_id":"5851ef24421aa9723d29b951","createdAt":"2016-12-15T09:17:24.370Z","desc":"DragVideo，一种在播放视频时，可以任意拖拽视频的方案","images":["http://img.gank.io/45985b26-8230-40d8-9337-80b5b5e56103"],"publishedAt":"2016-12-15T11:54:38.900Z","source":"web","type":"Android","url":"https://github.com/hejunlin2013/DragVideo","used":true,"who":"hejunlin"},{"_id":"5851fda0421aa97237bca8a7","createdAt":"2016-12-15T10:19:12.195Z","desc":"kickstarter 开源了 iOS App 的代码","images":["http://img.gank.io/6b79c562-d570-4ceb-9820-dd17344e95ab"],"publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"iOS","url":"https://github.com/kickstarter/ios-oss","used":true,"who":"代码家"},{"_id":"5851fddf421aa97240ef9ed4","createdAt":"2016-12-15T10:20:15.934Z","desc":"MD 风格的 EditText，精致。","images":["http://img.gank.io/da9efb85-8678-4823-928b-e53071ed5007"],"publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"Android","url":"https://github.com/bufferapp/BufferTextInputLayout","used":true,"who":"代码家"},{"_id":"5851fe0c421aa9723d29b953","createdAt":"2016-12-15T10:21:00.66Z","desc":"Kickstarter Android 源码开源啦！","images":["http://img.gank.io/45b63f42-de46-4761-b35e-b6f3ec9f983f"],"publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"Android","url":"https://github.com/kickstarter/android-oss","used":true,"who":"代码家"},{"_id":"5851ff1e421aa9723d29b954","createdAt":"2016-12-15T10:25:34.692Z","desc":"一个仿探探上传相片的widget，基于xmuSistone的demo, 提供gradle import，添加上传照片功能以及各种回调，api，方便使用","images":["http://img.gank.io/fc777bcc-dba6-4e48-a00e-5028f0ea36b6"],"publishedAt":"2016-12-15T11:54:38.900Z","source":"web","type":"Android","url":"https://github.com/SwiftyWang/android-drag-square","used":true,"who":null},{"_id":"58520187421aa9723a5a7767","createdAt":"2016-12-15T10:35:51.43Z","desc":"类似 QQ 一样的，通知 Bar 效果","images":["http://img.gank.io/a7f5a627-fd35-4565-96bf-f327b6823ac5","http://img.gank.io/badb06af-a9ac-47ac-86b5-1bbcb82384c6"],"publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"iOS","url":"https://github.com/qiuncheng/NoticeBar","used":true,"who":"代码家"},{"_id":"585212b4421aa97240ef9ed7","createdAt":"2016-12-15T11:49:08.132Z","desc":"12-15","publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1farbzjliclj20u00u076w.jpg","used":true,"who":"daimajia"},{"_id":"584fbd41421aa93437406724","createdAt":"2016-12-13T17:20:01.704Z","desc":"简单的Android社会化分享登录库，一行代码搞定","images":["http://img.gank.io/f0e08927-9797-4728-821e-ebe36c3b95fc","http://img.gank.io/72fc2885-b61a-42fc-8a3a-cf8d4706fa8d"],"publishedAt":"2016-12-14T11:39:22.686Z","source":"web","type":"Android","url":"https://github.com/shaohui10086/ShareUtil","used":true,"who":"邵辉Vista"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 584d7a36421aa963eaaee16f
         * createdAt : 2016-12-12T00:09:26.762Z
         * desc : 文章主要介绍freeline是如何实现快速增量编译的
         * images : ["http://img.gank.io/d5e2e665-a8d5-4943-ac82-278b99361843"]
         * publishedAt : 2016-12-16T11:47:53.776Z
         * source : web
         * type : Android
         * url : http://www.jianshu.com/p/37e31d924be9
         * used : true
         * who : 梧桐
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
