package com.sxwz.qcodelib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/*****************************************************
 * author:      wz
 * email:       wangzhong0116@foxmail.com
 * version:     1.0
 * date:        2016/12/28 09:52
 * description: 在scollview 里显示不完整的解决方案
 *****************************************************/
public class ExpandGridView extends GridView {

	public ExpandGridView(Context context) {
		super(context);
	}
	
	public ExpandGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ExpandGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}


}
