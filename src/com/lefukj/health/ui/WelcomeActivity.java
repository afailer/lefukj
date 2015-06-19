package com.lefukj.health.ui;

import java.io.File;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.mapapi.SDKInitializer;
import com.github.mikephil.charting.utils.Utils;
import com.lefukj.health.R;
import com.lefukj.health.api.APIClient;
import com.lefukj.health.bean.UpdateInfo;
import com.lefukj.health.util.Constant;
import com.lefukj.health.util.LfkjUtils;
import com.lidroid.xutils.HttpUtils;

public class WelcomeActivity extends Activity {
	File apkFile;
	HttpUtils httpUtils;
	Constant constant;
	Bitmap welcomeImg;
	ImageView img;
	UpdateInfo updateInfo;
	ProgressDialog pd;
	String version;
	public static final int REQUEST_UPDATE_ERROR = 1; // 代表请求更新信息出错
	public static final int REQUEST_UDPATE_SUCCESS = 2; // 代表请求更新信息成功
	protected static final int DOWNLOAD_APK_ERROR = 3; //代表下载最新版本APK出错
	protected static final int DOWNLOAD_APK_SUCCESS = 4;//代表下载最新版本APK成功
	protected static final int TO_MAIN=5;
	private Handler handler = new Handler() {
		//private File apkFile;

		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case TO_MAIN:
				toMain();
				break;
			case REQUEST_UPDATE_ERROR:
				LfkjUtils.showMsg(WelcomeActivity.this, "请求最新apk网络异常!");
				toMain();
				break;
			case REQUEST_UDPATE_SUCCESS:
				if(updateInfo.getVersion().equals(version)) {//当前就为最新版本
					LfkjUtils.showMsg(WelcomeActivity.this, "当前是最新版本!");
					toMain();
				} else {
					showDowloadDialog();//显示提示下载最新版本的dialog
				}
				break;
			case DOWNLOAD_APK_ERROR:
				LfkjUtils.showMsg(WelcomeActivity.this, "下载最新apk网络异常!");
				toMain();
				break;
			case DOWNLOAD_APK_SUCCESS:
				LfkjUtils.installAPK(WelcomeActivity.this, apkFile);
				finish();
				break;
			default:
				break;
			}
		}
	};
	private void showVersion() {
		version = LfkjUtils.getVersion(this);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext()); 
		setContentView(R.layout.activity_welcome);
		handler.sendEmptyMessageDelayed(5, 2000);
		//init();
		constant=new Constant(getApplicationContext());
		//init();
		
	}
	private void showDowloadDialog() {
		new AlertDialog.Builder(this).setTitle("版本更新").setMessage(updateInfo.getDesc())
				.setPositiveButton("下载", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						//开始下载apk
						startDownloadApk();
					}
				}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						toMain();
					}
				})
				.setCancelable(false)
				.show();
	}
	
	private void init() {
		// TODO Auto-generated method stub
		showAnimation();
		checkUpdate();
	}

	private void checkUpdate() {
		// 检查手机是否联网?
		boolean isConnected = LfkjUtils.isNetConnected(this);
		if (!isConnected) {// 如果没有联网, 显示提示
			LfkjUtils.showMsg(this, "手机没有连接网络!");
			toMain();
			return;
		}
		// 联网了, 开启分线程获取服务器端的最新版本信息数据
		try {
			updateInfo =APIClient.getUpdateInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void toMain(){
		startActivity(new Intent(getApplicationContext(), GuideActivity.class));
		finish();
	}
	/**
	 * 开始下载apk(开启分线程)
	 */
	private void startDownloadApk() {
		//下载的url
		final String apkUrl = updateInfo.getApkUrl();
		
		//准备用来保存apk的File对象
		
		apkFile = createApkFile();
		
		//显示一个dialog提示下载
		//showDownloadProgress();
		
		//启动分线程下载
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					APIClient.downloadFile(apkUrl, apkFile, pd);
					handler.sendEmptyMessage(DOWNLOAD_APK_SUCCESS);
				} catch (Exception e) {
					e.printStackTrace();
					handler.sendEmptyMessage(DOWNLOAD_APK_ERROR);
				}
			}
		}).start();
	}
	/**
	 * 准备用来保存apk的File对象
	 * @return
	 */
	private File createApkFile() {
		File file = null;
		if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File dir = getExternalFilesDir(null);
			file = new File(dir, "lefukj.apk");
		} else {
			File dir = getFilesDir();
			file = new File(dir, "lefukj.apk");
		}
		return file;
	}
	private void showAnimation() {
		// TODO Auto-generated method stub
		img=(ImageView) findViewById(R.id.img);
		welcomeImg=constant.getWelcomeBitmap();
		img.setImageBitmap(welcomeImg);
	}
}
