package com.lefukj.health.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.lefukj.health.R;

public class GuideActivity extends Activity {

	ViewPager guide_viewPager;
	ArrayList<RelativeLayout> layouts=new ArrayList<>();
	LinearLayout ll_point_group;
	int[] imgs={R.drawable.guide1,R.drawable.guide2,R.drawable.guide3};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_guide);
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		guide_viewPager=(ViewPager) findViewById(R.id.guide_viewpager);
		initguide();
		mAdapter adapter=new mAdapter();
		guide_viewPager.setAdapter(adapter);
		ll_point_group=(LinearLayout) findViewById(R.id.ll_point_group);
		for(int i=0;i<imgs.length;i++){
			View point_normal = new View(this);
			if(i==0){
				point_normal.setBackgroundResource(R.drawable.guide_red_point);
			}
			LayoutParams params = new LayoutParams(15, 15);
			if(i!=0){
				 params.leftMargin = 10;
			}
			point_normal.setLayoutParams(params);
			ll_point_group.addView(point_normal);
		}
		guide_viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				for(int i=0;i<imgs.length;i++){
					if(i==position){
						View view = ll_point_group.getChildAt(i);
						view.setBackgroundResource(R.drawable.guide_red_point);
					}else{
						View view = ll_point_group.getChildAt(i);
						view.setBackgroundResource(R.drawable.guide_point);
					}
					
				}
				
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
	private void initguide() {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++){
			RelativeLayout layout = (RelativeLayout) View.inflate(getApplicationContext(), R.layout.guide_page,null);
			if(i==imgs.length-1){
				View btn = layout.findViewById(R.id.btn_start);
				btn.setVisibility(View.VISIBLE);
				btn.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						startActivity(new Intent(getApplicationContext(), MainActivity.class));
					}
				});
			}
			ImageView img=(ImageView) layout.findViewById(R.id.img_guide);
			img.setBackgroundResource(imgs[i]);
			layouts.add(layout);
		}
				
	}
	class mAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return layouts.size();
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view==object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			RelativeLayout layout=layouts.get(position);
			container.addView(layout);
			return layout;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView((ViewGroup)object);
		}

		
	}
	
}
