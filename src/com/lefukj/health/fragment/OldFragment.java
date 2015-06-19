package com.lefukj.health.fragment;

import android.util.Log;
import android.view.View;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.lefukj.health.R;

public class OldFragment extends BaseFragment{

	/*MapView mMapView;
	
	BaiduMap mBaiduMap;
	PoiSearch mpoiSearch;
	String TAG="tag";
	LocationClient mLocationClient;
	//MyLocationListener mLocationListener;
	boolean isFirstIn=true;*/
	View view;
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		//mMapView.onDestroy();
	}
	@Override
	public View initView() {
		// TODO Auto-generated method stub
		view= View.inflate(getActivity(), R.layout.baidumap, null);
		//initMap();
		//initNavi();
		return view;
	}
	/*private void initNavi(){
		boolean mIsEngineInitSuccess=false;
		
	}

	private void initMap() {
		// TODO Auto-generated method stub
		mMapView=(MapView) view.findViewById(R.id.mMapView);
		mBaiduMap= mMapView.getMap();
		mBaiduMap.setTrafficEnabled(true);
		mBaiduMap.setMaxAndMinZoomLevel(mBaiduMap.getMaxZoomLevel(), mBaiduMap.getMaxZoomLevel());
		mBaiduMap.setMyLocationEnabled(true);
		//addOverLay(new LatLng(39.860711, 116.374734));
		setMyPosition();
		//poisearch();
		
	}
	
	private void setMyPosition() {
		// TODO Auto-generated method stub
		mLocationClient=new LocationClient(getActivity());
		mLocationListener=new MyLocationListener();
		mLocationClient.registerLocationListener(mLocationListener);
		LocationClientOption option=new LocationClientOption();
		option.setCoorType("bd09ll");
		option.setIsNeedAddress(true);
		option.setScanSpan(5000);
		option.setOpenGps(true);
		mLocationClient.setLocOption(option);
		//mLocationClient.requestLocation();
		mLocationClient.start();
		Log.e(TAG, "mLocationClient");
	}
	LatLng latLng = null;
	class MyLocationListener implements BDLocationListener{

		@Override
		public void onReceiveLocation(BDLocation location) {
			// TODO Auto-generated method stub
			Log.e(TAG, "BDLocation");
			MyLocationData data=new MyLocationData.Builder()//
				.accuracy(location.getRadius()).latitude(location.getLatitude())//
				.longitude(location.getLongitude()).build();
			
			if(isFirstIn){
				latLng=new LatLng(location.getLatitude(), location.getLongitude());
				MapStatusUpdate msu=MapStatusUpdateFactory.newLatLng(latLng);
				mBaiduMap.animateMapStatus(msu);
				isFirstIn=false;
			}
			//MyLocationConfiguration config=new MyLocationConfiguration(LocationMode.NORMAL, false, BitmapDescriptorFactory.fromResource(R.drawable.icon_geo));
			Log.e("TAG", location.getLatitude()+" "+location.getLongitude());
			mBaiduMap.setMyLocationData(data);
			//addOverLay(latLng);
			mMapView.refreshDrawableState();
		}
		
	}
	private void addOverLay(LatLng point){
		//116.374734,39.860711
		//LatLng point =   
		//构建Marker图标  
		BitmapDescriptor bitmap = BitmapDescriptorFactory  
		    .fromResource(R.drawable.icon_marka);  
		//构建MarkerOption，用于在地图上添加Marker  
		OverlayOptions option = new MarkerOptions()  
		    .position(point)  
		    .icon(bitmap).zIndex(9).draggable(true);  
		
		
		//在地图上添加Marker，并显示  
		mBaiduMap.addOverlay(option);
	}
	
	private void poisearch(){
		mpoiSearch=PoiSearch.newInstance();
		OnGetPoiSearchResultListener poiListener = new OnGetPoiSearchResultListener(){  
		    public void onGetPoiResult(PoiResult result){  
		    //获取POI检索结果  
		    	for(PoiInfo info:result.getAllPoi()){
		    		Log.e(TAG, info.uid+" "+info.name);
		    	}
		    }  
		    public void onGetPoiDetailResult(PoiDetailResult result){  
		    	//获取Place详情页检索结果  
		    	
		    }  
		};
		mpoiSearch.setOnGetPoiSearchResultListener(poiListener);
		boolean searchInCity = mpoiSearch.searchInCity(new PoiCitySearchOption().city("北京").keyword("洗浴").pageNum(10));
		Log.e(TAG, searchInCity+"");
		mpoiSearch.destroy();
	}

	private void myLocationSerarch(){
		// 开启定位图层  
		mBaiduMap.setMyLocationEnabled(true);  
		// 构造定位数据  
		MyLocationData locData = new MyLocationData.Builder()  
		    .accuracy(location.getRadius())  
		    // 此处设置开发者获取到的方向信息，顺时针0-360  
		    .direction(100).latitude(location.getLatitude())  
		    .longitude(location.getLongitude()).build();  
		// 设置定位数据  
		mBaiduMap.setMyLocationData(locData);  
		// 设置定位图层的配置（定位模式，是否允许方向信息，用户自定义定位图标）  
		mCurrentMarker = BitmapDescriptorFactory  
		    .fromResource(R.drawable.icon_geo);  
		MyLocationConfiguration config = new MyLocationConfiguration(mCurrentMode, true, mCurrentMarker);  
		mBaiduMap.setMyLocationConfiguration();  
		// 当不需要定位图层时关闭定位图层  
		mBaiduMap.setMyLocationEnabled(false);
	}*/
}
