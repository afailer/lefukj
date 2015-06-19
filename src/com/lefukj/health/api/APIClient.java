package com.lefukj.health.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.app.ProgressDialog;
import android.util.Log;

import com.google.gson.Gson;
import com.lefukj.health.R;
import com.lefukj.health.bean.LoginResult;
import com.lefukj.health.bean.UpdateInfo;
import com.lefukj.health.util.Constant;
import com.lefukj.health.util.LfkjUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class APIClient {
	static HttpUtils httpUtils=new HttpUtils();
	static UpdateInfo version = null;
	/**
	 * 得到最新版本的相关信息对象
	 * 
	 * @param urlPath
	 * @return
	 * @throws Exception
	 */
	public static UpdateInfo getUpdateInfo() throws Exception {
		
		// URL url = new URL(Constant.URL_CHECK_APK_UPDATE_XML);
		httpUtils.send(HttpMethod.GET, Constant.URL_CHECK_APK_UPDATE_JSON, new RequestCallBack<String>() {

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				// TODO Auto-generated method stub
				String versionInfo = responseInfo.result;
				Gson gson=new Gson();
				version = gson.fromJson(versionInfo, UpdateInfo.class);
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				// TODO Auto-generated method stub
				
			}
		});
		return version;
	}

	
	public static void downloadFile(String apkUrl, File file, ProgressDialog pd) throws Exception {
		
		Log.i("TAG", "apkUrl=" + apkUrl);
		URL url = new URL(apkUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setConnectTimeout(5000);
		int responseCode = connection.getResponseCode();
		if(responseCode==200) {
			InputStream is = connection.getInputStream();
			int total = connection.getContentLength();
			Log.e("TAG", "total="+total);
			pd.setMax(total);
			OutputStream os = new FileOutputStream(file);
			byte[] buffer = new byte[2048];
			int len = -1;
			while ((len = is.read(buffer)) > 0) {
				os.write(buffer, 0, len);
				pd.incrementProgressBy(len);
				//模拟网速慢
				//Thread.sleep(100);
			}
			os.close();
			is.close();
		}
		pd.dismiss();
		connection.disconnect();
	}
	private static String logineInfo;
	public static void login(String url){
		
		httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				// TODO Auto-generated method stub
				String result = responseInfo.result;
				Gson gson=new Gson();
				LoginResult res = gson.fromJson(result, LoginResult.class);
				if(res.getRole().equals("error")){
					logineInfo="error";
				}else{
					logineInfo=res.getRole();
				}
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}

