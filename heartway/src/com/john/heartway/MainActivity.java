package com.john.heartway;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.john.mode.fragmentMode1;
import com.john.mode.fragmentMode2;
import com.john.mode.fragmentMode3;
import com.john.mode.fragmentMode4;

public class MainActivity extends FragmentActivity implements OnClickListener{
	//初始化 底部四个线性布局
	private LinearLayout linearfunction1;
	private LinearLayout linearfunction2;
	private LinearLayout linearfunction3;
	private LinearLayout linearfunction4;
    //初始化四个底部button
	private ImageButton Ibfunction1;
	private ImageButton Ibfunction2;
	private ImageButton Ibfunction3;
	private ImageButton Ibfunction4;
    //初始化fragment
	private Fragment mode1;
	private Fragment mode2;
	private Fragment mode3;
	private Fragment mode4;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏  
        setContentView(R.layout.main_index);
        
		//初始化布局
		initView();
		//初始化事件
		initEvent();

		modeController(0);
		//location

			
	}
       



//重写退出键  禁止退出键
	@Override
    public void onBackPressed() {
            // TODO Auto-generated method stub
            return;
            //super.onBackPressed();
    }
	
	
//初始化布局   初始化四个LinearLayout 四个ImageButton
	/**
	 * 初始化布局   初始化四个LinearLayout 四个ImageButton
	 * @author John
	 * 
	 */
	private void initView() {
		// TODO Auto-generated method stub
		        //初始化 底部四个线性布局
				linearfunction1=(LinearLayout) findViewById(R.id.linearfunction1);
				linearfunction2=(LinearLayout) findViewById(R.id.linearfunction2);
				linearfunction3=(LinearLayout) findViewById(R.id.linearfunction3);
				linearfunction4=(LinearLayout) findViewById(R.id.linearfunction4);
				//初始化四个底部button
				Ibfunction1=(ImageButton) findViewById(R.id.Ibfunction1);
				Ibfunction2=(ImageButton) findViewById(R.id.Ibfunction2);
				Ibfunction3=(ImageButton) findViewById(R.id.Ibfunction3);
				Ibfunction4=(ImageButton) findViewById(R.id.Ibfunction4);
	}

//初始化事件 为底部模块绑定点击事件	
		/**
		 * @author John
		 * 初始化事件 为底部模块绑定点击事件
		 */
		private void initEvent() {
			// TODO Auto-generated method stub
			linearfunction1.setOnClickListener(this);
			linearfunction2.setOnClickListener(this);
			linearfunction3.setOnClickListener(this);
			linearfunction4.setOnClickListener(this);
		}
	

		
//底部四个模块的点击事件
	/* 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * 
	 * 底部四个模块的点击事件
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		resetImage();
		switch (v.getId()) {
		case R.id.linearfunction1:
		     modeController(0);
			break;
		case R.id.linearfunction2:
			 modeController(1);
			break;
		case R.id.linearfunction3:
			 modeController(2);
			break;
		case R.id.linearfunction4:
			 modeController(3);
			break;

		default:
			break;
		}
	}
//恢复默认Button样式	
	/**@author John
	 * 恢复默认时底部ImageButton图片
	 * 
	 */
	private void resetImage() {
		// TODO Auto-generated method stub
		Ibfunction1.setImageResource(R.drawable.ibfunction1_normal);
		Ibfunction2.setImageResource(R.drawable.ibfunction2_normal);
		Ibfunction3.setImageResource(R.drawable.ibfunction3_normal);
		Ibfunction4.setImageResource(R.drawable.ibfunction4_normal);
	}


//模块选择器
	
	/**
	 * @param i 点击触发的模块ID 0 1 2 3
	 */
	private void modeController(int i) {
		// TODO Auto-generated method stub
		//管理fragment 定义事务
		FragmentManager fm = getSupportFragmentManager();
		//定义事务
		FragmentTransaction transaction = fm.beginTransaction();
		//重置Fragment
		hideFragment(transaction);
		
		//判断点击的哪个tab 做出响应 
		// tab为null 则new（） 并且 事务add（） 否则 直接显示   将图标变为按下状态
		switch (i) {
		case 0:
			if (mode1 == null)
			{
				mode1 = new fragmentMode1();
				transaction.add(R.id.main_context, mode1);
			} 
			else
			{
				transaction.show(mode1);
			}
			Ibfunction1.setImageResource(R.drawable.ibfunction1_pressed);
			
			break;
		case 1:
			if (mode2 == null)
			{
				mode2 = new fragmentMode2();
				transaction.add(R.id.main_context, mode2);
			} 
			else
			{
				transaction.show(mode2);
			}
			Ibfunction2.setImageResource(R.drawable.ibfunction2_pressed);
			
			break;
			
		case 2:
			if (mode3 == null)
			{
				mode3 = new fragmentMode3();
				transaction.add(R.id.main_context, mode3);
			} 
			else
			{
				transaction.show(mode3);
			}
			Ibfunction3.setImageResource(R.drawable.ibfunction3_pressed);
			break;
			
		case 3:
			if (mode4 == null)
			{
				mode4 = new fragmentMode4();
				transaction.add(R.id.main_context, mode4);
			} 
			else
			{
				transaction.show(mode4);
			}
			Ibfunction4.setImageResource(R.drawable.ibfunction4_pressed);
			break;

		default:
			break;
		}
	    //提交事务
		transaction.commit();
	}
	//全部隐藏TAB
	private void hideFragment(FragmentTransaction transaction) {
		// TODO Auto-generated method stub
		if (mode1 != null)
		{
			transaction.hide(mode1);
		}
		if (mode2!= null)
		{
			transaction.hide(mode2);
		}
		if (mode3 != null)
		{
			transaction.hide(mode3);
		}
		if (mode4 != null)
		{
			transaction.hide(mode4);
		}
		
	}
}
