package com.lefukj.health.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.lefukj.health.R;
import com.lefukj.health.fragment.GuideFragment;
import com.lefukj.health.fragment.LfMapFragment;
import com.lefukj.health.fragment.SettingFragment;

public class MainActivity extends FragmentActivity {

	ViewPager pager;
	ArrayList<Fragment> fmList=new ArrayList<>();
	RadioGroup radioGroup;
	String TAG="tag";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		pager=(ViewPager) findViewById(R.id.mpager);
		fmList.add(new GuideFragment());
		fmList.add(new SettingFragment());
		fmList.add(new LfMapFragment());
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		radioGroup=(RadioGroup) findViewById(R.id.rg_content_fragment);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				Log.e(TAG, "msg");
				switch (arg1) {
				case R.id.rb_content_fragment_home:
					pager.setCurrentItem(0,false);
					Log.e("pager", "first");
					break;
				case R.id.rb_content_fragment_setting:
					pager.setCurrentItem(1,false);
					Log.e("page", "setting");
					break;
				case R.id.rb_content_fragment_map:
					pager.setCurrentItem(2, false);
				default:
					break;
				}
			}
		});
		RadioButton btn_first=(RadioButton) findViewById(R.id.rb_content_fragment_home);
		RadioButton btn_setting=(RadioButton) findViewById(R.id.rb_content_fragment_setting);
		RadioButton btn_map=(RadioButton) findViewById(R.id.rb_content_fragment_map);
		btn_first.setChecked(true);
		final ArrayList<RadioButton> btns=new ArrayList<>();
		btns.add(btn_first);
		btns.add(btn_setting);
		btns.add(btn_map);
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				btns.get(position).setChecked(true);
			}
			
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
		});
	}
		
	class MyPagerAdapter extends FragmentPagerAdapter{

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return fmList.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fmList.size();
		}
	
		
	}

}
