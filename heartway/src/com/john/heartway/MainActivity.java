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
	//��ʼ�� �ײ��ĸ����Բ���
	private LinearLayout linearfunction1;
	private LinearLayout linearfunction2;
	private LinearLayout linearfunction3;
	private LinearLayout linearfunction4;
    //��ʼ���ĸ��ײ�button
	private ImageButton Ibfunction1;
	private ImageButton Ibfunction2;
	private ImageButton Ibfunction3;
	private ImageButton Ibfunction4;
    //��ʼ��fragment
	private Fragment mode1;
	private Fragment mode2;
	private Fragment mode3;
	private Fragment mode4;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������  
        setContentView(R.layout.main_index);
        
		//��ʼ������
		initView();
		//��ʼ���¼�
		initEvent();

		modeController(0);
		//location

			
	}
       



//��д�˳���  ��ֹ�˳���
	@Override
    public void onBackPressed() {
            // TODO Auto-generated method stub
            return;
            //super.onBackPressed();
    }
	
	
//��ʼ������   ��ʼ���ĸ�LinearLayout �ĸ�ImageButton
	/**
	 * ��ʼ������   ��ʼ���ĸ�LinearLayout �ĸ�ImageButton
	 * @author John
	 * 
	 */
	private void initView() {
		// TODO Auto-generated method stub
		        //��ʼ�� �ײ��ĸ����Բ���
				linearfunction1=(LinearLayout) findViewById(R.id.linearfunction1);
				linearfunction2=(LinearLayout) findViewById(R.id.linearfunction2);
				linearfunction3=(LinearLayout) findViewById(R.id.linearfunction3);
				linearfunction4=(LinearLayout) findViewById(R.id.linearfunction4);
				//��ʼ���ĸ��ײ�button
				Ibfunction1=(ImageButton) findViewById(R.id.Ibfunction1);
				Ibfunction2=(ImageButton) findViewById(R.id.Ibfunction2);
				Ibfunction3=(ImageButton) findViewById(R.id.Ibfunction3);
				Ibfunction4=(ImageButton) findViewById(R.id.Ibfunction4);
	}

//��ʼ���¼� Ϊ�ײ�ģ��󶨵���¼�	
		/**
		 * @author John
		 * ��ʼ���¼� Ϊ�ײ�ģ��󶨵���¼�
		 */
		private void initEvent() {
			// TODO Auto-generated method stub
			linearfunction1.setOnClickListener(this);
			linearfunction2.setOnClickListener(this);
			linearfunction3.setOnClickListener(this);
			linearfunction4.setOnClickListener(this);
		}
	

		
//�ײ��ĸ�ģ��ĵ���¼�
	/* 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * 
	 * �ײ��ĸ�ģ��ĵ���¼�
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
//�ָ�Ĭ��Button��ʽ	
	/**@author John
	 * �ָ�Ĭ��ʱ�ײ�ImageButtonͼƬ
	 * 
	 */
	private void resetImage() {
		// TODO Auto-generated method stub
		Ibfunction1.setImageResource(R.drawable.ibfunction1_normal);
		Ibfunction2.setImageResource(R.drawable.ibfunction2_normal);
		Ibfunction3.setImageResource(R.drawable.ibfunction3_normal);
		Ibfunction4.setImageResource(R.drawable.ibfunction4_normal);
	}


//ģ��ѡ����
	
	/**
	 * @param i ���������ģ��ID 0 1 2 3
	 */
	private void modeController(int i) {
		// TODO Auto-generated method stub
		//����fragment ��������
		FragmentManager fm = getSupportFragmentManager();
		//��������
		FragmentTransaction transaction = fm.beginTransaction();
		//����Fragment
		hideFragment(transaction);
		
		//�жϵ�����ĸ�tab ������Ӧ 
		// tabΪnull ��new���� ���� ����add���� ���� ֱ����ʾ   ��ͼ���Ϊ����״̬
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
	    //�ύ����
		transaction.commit();
	}
	//ȫ������TAB
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
