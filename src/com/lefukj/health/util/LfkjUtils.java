package com.lefukj.health.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.lefukj.health.receiver.MyAdminReceiver;


import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.widget.Toast;

public class LfkjUtils {
	public static void installAPK(Context context, File apkFile) {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
		context.startActivity(intent);
	}
	public static void showMsg(Context context,String Msg){
		Toast.makeText(context, Msg, Toast.LENGTH_SHORT).show();
	}
	public static void activeDevince(Context context) {
		DevicePolicyManager manager = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
		ComponentName componentName = new ComponentName(context, MyAdminReceiver.class);
		if (!manager.isAdminActive(componentName)) {
			Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
			intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
			context.startActivity(intent);
		}
	}
	public static boolean isNetConnected(Context context) {
		boolean connected = false;
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getActiveNetworkInfo();
		if (networkInfo != null) {
			connected = networkInfo.isConnected();
		}
		return connected;
	}
	public static String getVersion(Context context) {
		String version = null;
		PackageManager pm = (PackageManager) context.getPackageManager();
		try {
			PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
			version = packageInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			version = "未知";
		}
		return version;
	}
	/**
	 * 将一个inputStream读取成一个字符串
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String readString(InputStream is) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = -1;
		while ((len = is.read(buffer)) > 0) {
			bos.write(buffer, 0, len);
		}
		bos.close();

		return bos.toString();
	}
}
