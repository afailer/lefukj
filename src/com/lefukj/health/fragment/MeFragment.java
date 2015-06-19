package com.lefukj.health.fragment;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.lefukj.health.R;
import com.lefukj.health.util.LfkjUtils;
import com.lefukj.health.util.SpUtils;
import com.lidroid.xutils.HttpUtils;

public class MeFragment extends BaseFragment{
	String login="login";
	Button btn;
	Button btn_quite,sign;
	View view;
	RelativeLayout rl;
	LinearLayout ll_login,ll_quite;
	EditText edi_username,edi_password;
	HttpUtils httpUtils=new HttpUtils();
	PopupWindow popwindow;
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				View popupView=View.inflate(getActivity(), R.layout.popwindow, null);
				popwindow=new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
				popwindow.showAtLocation(view.findViewById(R.id.rl_me), Gravity.CENTER, 0, 0);
			}else if(msg.what==2){
				popwindow.dismiss();
				setLoginGone();
			}
		};
	};
	@Override
	public View initView() {
		// TODO Auto-generated method stub
		view=View.inflate(getActivity(), R.layout.me, null);
		sign=(Button) view.findViewById(R.id.sign);
		sign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivityForResult(new Intent(getActivity(), cls), requestCode)
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.old, new BlankFragment());
				transaction.commit();
			}
		});
		rl=(RelativeLayout) view.findViewById(R.id.rl_me);
		ll_login=(LinearLayout) view.findViewById(R.id.ll_login);
		ll_quite=(LinearLayout) view.findViewById(R.id.ll_quite);
		
		if(SpUtils.getInstance(getActivity()).getUser().equals(SpUtils.LOGINE_OK)){
			setLoginGone();
		}else{
			setLoginVisible();
		}
		login();
		quite();
		return view;
	}
	private void setLoginVisible(){
		ll_login.setVisibility(View.VISIBLE);
		ll_quite.setVisibility(View.GONE);
	}
	private void setLoginGone(){
		ll_login.setVisibility(View.GONE);
		ll_quite.setVisibility(View.VISIBLE);
	}
	private void quite() {
		// TODO Auto-generated method stub
		btn_quite=(Button) view.findViewById(R.id.btn_quite);
		btn_quite.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				setLoginVisible();
			}
		});
	}
	
	public void login(){
		btn=(Button) view.findViewById(R.id.login);
		edi_username=(EditText) view.findViewById(R.id.user_name);
		edi_password=(EditText) view.findViewById(R.id.user_password);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean isUsernameEmpty = LfkjUtils.IsEmpty(edi_username);
				boolean isPassWordEmpty=LfkjUtils.IsEmpty(edi_password);
				if(isUsernameEmpty||isPassWordEmpty){
					Toast.makeText(getActivity(), "请输入正确用户名或密码", 1).show();
				}else{
					String url="";
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							handler.sendEmptyMessage(2);
							
						}
					}).start();
					handler.sendEmptyMessage(1);
				/*	httpUtils.send(HttpMethod.GET, url, new RequestCallBack<String>() {

						@Override
						public void onSuccess(ResponseInfo<String> responseInfo) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onFailure(HttpException error, String msg) {
							// TODO Auto-generated method stub
							
						}
					});*/
				}
				
			}
		});
		
	}

}
