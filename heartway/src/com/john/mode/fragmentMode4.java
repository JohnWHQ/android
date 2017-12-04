package com.john.mode;



import com.joh.utils.Utils;
import com.john.heartway.LoginActivity;
import com.john.heartway.MainActivity;
import com.john.heartway.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class fragmentMode4 extends Fragment implements OnClickListener{

	RelativeLayout function_total;
	RelativeLayout function_personalInformation;
	RelativeLayout function_setting;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.mode4, container, false);
		function_total=(RelativeLayout) v.findViewById(R.id.controlcenter_relativeLayout1);
		function_personalInformation=(RelativeLayout) v.findViewById(R.id.controlcenter_mode1);
		function_setting=(RelativeLayout) v.findViewById(R.id.controlcenter_mode2);
		setEvent();
		return v;
	}
	private void setEvent() {
		// TODO Auto-generated method stub
		function_total.setOnClickListener(this);
		function_personalInformation.setOnClickListener(this);
		function_setting.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.controlcenter_relativeLayout1:
			  
			   AlertDialog.Builder builder1 =new Builder(this.getActivity());
			   builder1.setTitle("��ʾ");
			  // builder1.setMessage("�����������ڽ��裬��δ���ţ�");
			   builder1.setMessage(Utils.getExternalStorageInfo(getActivity())+"\n"+Utils.getInternalStorageInfo(getActivity()));
			   builder1.setPositiveButton("ȷ��", null);
			   builder1.create().show();
			
			break;
		case R.id.controlcenter_mode1:
			  
			   AlertDialog.Builder builder2 =new Builder(this.getActivity());
			   builder2.setTitle("��ʾ");
			   builder2.setMessage("�ҵ��������ڽ��裬��δ���ţ�");
			   builder2.setPositiveButton("ȷ��", null);
			   builder2.create().show();
			
			break;
		case R.id.controlcenter_mode2:
			  
			   AlertDialog.Builder builder3 =new Builder(this.getActivity());
			   builder3.setTitle("��ʾ");
			   builder3.setMessage("�����������ڽ��裬��δ���ţ�");
			   builder3.setPositiveButton("ȷ��", null);
			   builder3.create().show();
			
			break;

		default:
			break;
		}
		
	}

}
