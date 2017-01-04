                                                Android Quick Developer Framework
    (Android 快速开发框架————————致力于让Android开发更简单)
	在此非常感谢github的一些大神们，给了我很多帮助，同时也参考了很多大神的代码，在平时的运用中总结
  开源才能让我们共同进步，欢迎大家fork，如果有不到位的地方，还希望大家给与建议和帮助。此框架持续更新中......
### 效果图
<img src="/Image/QQ图片20170104195319.jpg"/>
<img src="/Image/QQ图片20170104195345.jpg"/>
<img src="/Image/QQ图片20170104195325.jpg"/>

(1)、对android api的封装，使其调用更方便(一些公共属性组件如：存储，sdcard，intent，网络)
	
	(2)、基类的封装（如：Activity，Fragment,ListView-Adapter,RecycleView-Adapter,PullUp-Adapter）
	
	(3)、使用mvp设计模式，降低耦合度，极限封装，公用一套公共部分
			所谓的mvp，即是（model-处理业务逻辑（主要是数据读写，或者与后台通信（其实也是读写数据）），
			view-处理ui控件，presenter-主导器，操作model和view）
				
	(4)、使用RxJava+Retrofit+OkHttp请求 （网络请求框架简单封装，缓存）
			compile 'com.squareup.retrofit2:retrofit:2.1.0'
			compile 'com.squareup.retrofit2:converter-gson:2.1.0'
			compile 'com.squareup.retrofit2:adapter-rxjava:2.1.0'
			compile 'com.squareup.okhttp3:okhttp:3.4.1'
			compile 'com.squareup.okhttp3:logging-interceptor:3.4.1'
			compile 'io.reactivex:rxjava:1.2.0'
			compile 'io.reactivex:rxandroid:1.2.1'
			
	(5)、Butterknife注解，已封装入Activity，Fragment，基类中。
		compile 'com.jakewharton:butterknife:7.0.1'
			（1#使用注解的目的不是为了让程序速度更快，如果了解spring原理的朋友，应该都明白
			  2#为了开发更加快速，让代码更加简洁，清晰。没有必要写一大堆findview
			  3#注解反而会影响一部分性能，速度，对于现在的硬件配置来说，完全不用担心这个问题）
	
	(6)、glide 图片处理，在adapter里面已封装进去，一句话就可以调用
	    compile 'com.github.bumptech.glide:glide:3.7.0'
		compile 'jp.wasabeef:glide-transformations:1.3.1'       //为了实现圆角图片
		
	(7)、对于自定义view给用户更好的体现的总结
	     如： 弹性ScrollView控件，通用上拉加载，下拉刷新GroupView控件，Loading Dialog控件
	
	(8)、Log日志的封装，让其打印更加直观
	
	(9)、anim动画   ==侧滑返回
	
	(10)、其他：
	       事件总线程（compile 'org.greenrobot:eventbus:3.0.0'）
	       数据库部分（GreenDAO ）
		   解析：（Gson）
