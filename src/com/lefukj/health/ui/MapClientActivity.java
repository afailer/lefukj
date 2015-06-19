package com.lefukj.health.ui;

import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.lefukj.health.R;
import com.lefukj.health.R.id;
import com.lefukj.health.R.layout;
import com.lefukj.health.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class MapClientActivity extends Activity implements OnGetRoutePlanResultListener {

	
	RoutePlanSearch mSearch;
	PopupWindow pw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_client);
		mSearch=RoutePlanSearch.newInstance();
		mSearch.setOnGetRoutePlanResultListener(this);
		pw=new PopupWindow(getLayoutInflater().inflate(R.layout.popwindow, null), LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);
		pw.setOutsideTouchable(true);
		pw.showAsDropDown(findViewById(R.id.et), 0, 0);
	}

	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGetTransitRouteResult(TransitRouteResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
