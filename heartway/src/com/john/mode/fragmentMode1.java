package com.john.mode;




import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationClientOption.AMapLocationMode;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.john.heartway.R;
public class fragmentMode1 extends Fragment{
    //��������
	private MapView mapView;
    private AMap aMap;
    
    //����AMapLocationClient�����
    public AMapLocationClient mLocationClient = null;
   //������λ�ص�������
	public AMapLocationListener mLocationListener = new AMapLocationListener() {
	
	@Override
	public void onLocationChanged(AMapLocation amapLocation) {
		// TODO Auto-generated method stub
		 if (amapLocation != null) {
		        if (amapLocation.getErrorCode() == 0) {
		        //��λ�ɹ��ص���Ϣ�����������Ϣ
		        amapLocation.getLocationType();//��ȡ��ǰ��λ�����Դ�������綨λ����������λ���ͱ�
		        amapLocation.getLatitude();//��ȡγ��
		        amapLocation.getLongitude();//��ȡ����
		        amapLocation.getAccuracy();//��ȡ������Ϣ
		        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date date = new Date(amapLocation.getTime());
		        df.format(date);//��λʱ��
		        amapLocation.getAddress();//��ַ�����option������isNeedAddressΪfalse����û�д˽��
		        amapLocation.getCountry();//������Ϣ
		        amapLocation.getProvince();//ʡ��Ϣ
		        amapLocation.getCity();//������Ϣ
		        amapLocation.getDistrict();//������Ϣ
		        amapLocation.getRoad();//�ֵ���Ϣ
		        amapLocation.getCityCode();//���б���
		        amapLocation.getAdCode();//��������
		        Log.d("msgsssssssssssssssss", amapLocation.getAddress());
		    } else {
		              //��ʾ������ϢErrCode�Ǵ����룬errInfo�Ǵ�����Ϣ������������
		        Log.e("AmapError","location Error, ErrCode:"
		            + amapLocation.getErrorCode() + ", errInfo:"
		            + amapLocation.getErrorInfo());
		        }
		    }
		
	}
};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
	  View v=inflater.inflate(R.layout.mode1, container, false);
		/**
		 * AMapV2��ͼ�н������ʹ��mapview��ʾ��ͼ
		 */
		//��onCreat�����и�aMap����ֵ
		mapView = (MapView) v.findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);// ����Ҫд
	    aMap = mapView.getMap();
	   
	   
	    mLocationClient = new AMapLocationClient(getActivity().getApplicationContext());
        //���ö�λ�ص�����
        mLocationClient.setLocationListener(mLocationListener);
        
        
      //����mLocationOption����
        AMapLocationClientOption mLocationOption = null;
        //��ʼ����λ����
        mLocationOption = new AMapLocationClientOption();
        //���ö�λģʽΪ�߾���ģʽ��Battery_SavingΪ�͹���ģʽ��Device_Sensors�ǽ��豸ģʽ
        mLocationOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
        //�����Ƿ񷵻ص�ַ��Ϣ��Ĭ�Ϸ��ص�ַ��Ϣ��
        mLocationOption.setNeedAddress(true);
        //�����Ƿ�ֻ��λһ��,Ĭ��Ϊfalse
        mLocationOption.setOnceLocation(false);
        //�����Ƿ�ǿ��ˢ��WIFI��Ĭ��Ϊǿ��ˢ��
        mLocationOption.setWifiActiveScan(true);
        //�����Ƿ�����ģ��λ��,Ĭ��Ϊfalse��������ģ��λ��
        mLocationOption.setMockEnable(false);
        //���ö�λ���,��λ����,Ĭ��Ϊ2000ms
        mLocationOption.setInterval(2000);
        //����λ�ͻ��˶������ö�λ����
        mLocationClient.setLocationOption(mLocationOption);
        //������λ
        mLocationClient.startLocation();
         
        
       
        
	    
	    return v;
//		return inflater.inflate(R.layout.mode1, container, false);
	}
	
	
	
	
	
	
	
//--------------------------------------------------��д��������------------------------------------------------------------------------
	/**
	 * ����������д
	 */
	@Override
	public void onResume() {
		super.onResume();
		mapView.onResume();
	}

	/**
	 * ����������д
	 */
	@Override
	public void onPause() {
		super.onPause();
		mapView.onPause();
	}

	/**
	 * ����������д
	 */
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

	/**
	 * ����������д
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}

	//--------------------------------------------------��д��������------------------------------------------------------------------------  
  
	

}
