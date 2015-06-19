package com.lefukj.health.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SpUtils {
	public static String LOGINE_OK="login_ok";
	public static String QUITE="quite";
	private static SharedPreferences sp;
	private static SpUtils instance = new SpUtils();
	private SpUtils() {
	}
	public static SpUtils getInstance(Context context) {
		if (sp == null){
			sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		}
		return instance;
	}
	public void saveUser(){
		sp.edit().putString(LOGINE_OK, LOGINE_OK);
	}
	public String getUser(){
		return sp.getString(LOGINE_OK, QUITE);
	}
	public void userQuite(){
		sp.edit().putString(LOGINE_OK, QUITE);
	}
}
