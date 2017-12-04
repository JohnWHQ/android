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
    //声明变量
	private MapView mapView;
    private AMap aMap;
    
    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
   //声明定位回调监听器
	public AMapLocationListener mLocationListener = new AMapLocationListener() {
	
	@Override
	public void onLocationChanged(AMapLocation amapLocation) {
		// TODO Auto-generated method stub
		 if (amapLocation != null) {
		        if (amapLocation.getErrorCode() == 0) {
		        //定位成功回调信息，设置相关消息
		        amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
		        amapLocation.getLatitude();//获取纬度
		        amapLocation.getLongitude();//获取经度
		        amapLocation.getAccuracy();//获取精度信息
		        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        Date date = new Date(amapLocation.getTime());
		        df.format(date);//定位时间
		        amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果
		        amapLocation.getCountry();//国家信息
		        amapLocation.getProvince();//省信息
		        amapLocation.getCity();//城市信息
		        amapLocation.getDistrict();//城区信息
		        amapLocation.getRoad();//街道信息
		        amapLocation.getCityCode();//城市编码
		        amapLocation.getAdCode();//地区编码
		        Log.d("msgsssssssssssssssss", amapLocation.getAddress());
		    } else {
		              //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
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
		 * AMapV2地图中介绍如何使用mapview显示地图
		 */
		//在onCreat方法中给aMap对象赋值
		mapView = (MapView) v.findViewById(R.id.map);
		mapView.onCreate(savedInstanceState);// 必须要写
	    aMap = mapView.getMap();
	   
	   
	    mLocationClient = new AMapLocationClient(getActivity().getApplicationContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        
        
      //声明mLocationOption对象
        AMapLocationClientOption mLocationOption = null;
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationMode.Hight_Accuracy);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否只定位一次,默认为false
        mLocationOption.setOnceLocation(false);
        //设置是否强制刷新WIFI，默认为强制刷新
        mLocationOption.setWifiActiveScan(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();
         
        
       
        
	    
	    return v;
//		return inflater.inflate(R.layout.mode1, container, false);
	}
	
	
	
	
	
	
	
//--------------------------------------------------重写方法部分------------------------------------------------------------------------
	/**
	 * 方法必须重写
	 */
	@Override
	public void onResume() {
		super.onResume();
		mapView.onResume();
	}

	/**
	 * 方法必须重写
	 */
	@Override
	public void onPause() {
		super.onPause();
		mapView.onPause();
	}

	/**
	 * 方法必须重写
	 */
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

	/**
	 * 方法必须重写
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		mapView.onDestroy();
	}

	//--------------------------------------------------重写方法部分------------------------------------------------------------------------  
  
	

}
