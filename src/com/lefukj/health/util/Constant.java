package com.lefukj.health.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

public class Constant {
	public static String UPDATE_URL="";
	public static String WELCOME_IMG_URL="";
	public static String WELCOMEPNG="welcome.png";
	public static String WELCOMEURL="";
	public static final String URL_CHECK_APK_UPDATE_JSON="";
	Context mContext;
	NetWorkUtil netUtil;
	public Constant(Context context){
		this.mContext=context;
		this.netUtil=new NetWorkUtil(context);
	}
	public Bitmap getWelcomeBitmap(){
		Bitmap bitmap = null;
		String path="";
		File file;
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			path = Environment.getExternalStorageDirectory().getAbsolutePath()+WELCOMEPNG;
			file=new File(path);
			if(file.isFile()){
				try {
					bitmap=BitmapFactory.decodeStream(new FileInputStream(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					InputStream open = mContext.getAssets().open(WELCOMEPNG);
					bitmap=BitmapFactory.decodeStream(open);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			netUtil.getNextWelcomeImgFromNet(path);
		}else{
			path=mContext.getFilesDir().getAbsolutePath()+WELCOMEPNG;
			file=new File(path);
			if(file.isFile()){
				try {
					bitmap=BitmapFactory.decodeStream(new FileInputStream(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					InputStream open = mContext.getAssets().open(WELCOMEPNG);
					bitmap=BitmapFactory.decodeStream(open);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			netUtil.getNextWelcomeImgFromNet(path);
		}
		/*FileInputStream in = null;
		try {
			in=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bitmap=BitmapFactory.decodeStream(in);*/
		return bitmap;
	}
	
	
}
