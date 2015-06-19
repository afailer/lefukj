package com.lefukj.health.fragment;

import com.lefukj.health.R;

import android.view.View;

public class HeadFragment extends BaseFragment{

	View view;
	@Override
	public View initView() {
		// TODO Auto-generated method stub
		view=View.inflate(getActivity(), R.layout.headfragment, null);
		return view;
	}

}
