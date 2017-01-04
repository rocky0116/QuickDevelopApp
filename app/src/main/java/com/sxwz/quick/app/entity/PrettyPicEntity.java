package com.sxwz.quick.app.entity;

import java.io.Serializable;
import java.util.List;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/20 12:27
 * description: 美图实体类
 *****************************************************/

public class PrettyPicEntity implements Serializable {


    /**
     * error : false
     * results : [{"_id":"58569ab6421aa97237bca8c5","createdAt":"2016-12-18T22:18:30.807Z","desc":"12-18","publishedAt":"2016-12-19T11:57:16.232Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1favb116hm2j20u00u0gqi.jpg","used":true,"who":"daimajia"},{"_id":"585331db421aa9723d29b95c","createdAt":"2016-12-16T08:14:19.281Z","desc":"12-17","publishedAt":"2016-12-16T11:47:53.776Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1fasakfvqe1j20u00mhgn2.jpg","used":true,"who":"代码家"},{"_id":"585212b4421aa97240ef9ed7","createdAt":"2016-12-15T11:49:08.132Z","desc":"12-15","publishedAt":"2016-12-15T11:54:38.900Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1farbzjliclj20u00u076w.jpg","used":true,"who":"daimajia"},{"_id":"585096f2421aa93437406727","createdAt":"2016-12-14T08:48:50.506Z","desc":"12-14","publishedAt":"2016-12-14T11:39:22.686Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034gw1faq15nnc0xj20u00u0wlq.jpg","used":true,"who":"代码家"},{"_id":"584f3bd6421aa934405ccfa7","createdAt":"2016-12-13T08:07:50.411Z","desc":"12-13","publishedAt":"2016-12-13T11:42:38.536Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1faoucp1idej20u011h0va.jpg","used":true,"who":"daimajia"},{"_id":"584dffdd421aa963eaaee172","createdAt":"2016-12-12T09:39:41.294Z","desc":"12-12","publishedAt":"2016-12-12T11:30:54.254Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fanrdyaxi6j20u00k1ta9.jpg","used":true,"who":"daimajia"},{"_id":"584a0130421aa963f321b040","createdAt":"2016-12-09T08:56:16.913Z","desc":"12-9","publishedAt":"2016-12-09T11:33:12.481Z","source":"chrome","type":"福利","url":"http://ww2.sinaimg.cn/large/610dc034jw1fak99uh554j20u00u0n09.jpg","used":true,"who":"代码家"},{"_id":"5848c92e421aa963efd90da4","createdAt":"2016-12-08T10:45:02.271Z","desc":"12-8","publishedAt":"2016-12-08T11:42:08.186Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1faj6sozkluj20u00nt75p.jpg","used":true,"who":"代码家"},{"_id":"58476013421aa963ed5064da","createdAt":"2016-12-07T09:04:19.739Z","desc":"12-7","publishedAt":"2016-12-07T11:43:57.460Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034jw1fahy9m7xw0j20u00u042l.jpg","used":true,"who":"daimajia"},{"_id":"58460694421aa939b58d31e3","createdAt":"2016-12-06T08:30:12.824Z","desc":"12-6","publishedAt":"2016-12-06T11:33:36.433Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fagrnmiqm1j20u011hanr.jpg","used":true,"who":"daimajia "}]
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
         * _id : 58569ab6421aa97237bca8c5
         * createdAt : 2016-12-18T22:18:30.807Z
         * desc : 12-18
         * publishedAt : 2016-12-19T11:57:16.232Z
         * source : chrome
         * type : 福利
         * url : http://ww4.sinaimg.cn/large/610dc034jw1favb116hm2j20u00u0gqi.jpg
         * used : true
         * who : daimajia
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
    }
}
