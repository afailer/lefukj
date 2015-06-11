package com.lefukj.health.util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import android.content.Context;

public class NetWorkUtil {
	Context mContext;
	public NetWorkUtil(Context context){
		this.mContext=context;
	}
	public NetWorkUtil(){
		
	}
	
	
	public void getNextWelcomeImgFromNet(String path) {
		// TODO Auto-generated method stub
		URL url;
		try {
			url=new URL(Constant.WELCOME_IMG_URL);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getBarChartFromNet(ArrayList<String> xValue,ArrayList<String> yValue){
		
	}
}
