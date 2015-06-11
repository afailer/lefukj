package com.lefukj.health.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.LargeValueFormatter;
import com.lefukj.health.R;

public class MyBarCharts {
	BarChart mBarCharts;
	Typeface tf;
	Context mContext;
	public void initBarChart(View view,Context context){
		mContext=context;
		
		mBarCharts=(BarChart) view.findViewById(R.id.view_barCharts);
		mBarCharts.setPinchZoom(false);

        mBarCharts.setDrawBarShadow(false);

        mBarCharts.setDrawGridBackground(false);
        tf=Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");
        
        Legend legend = mBarCharts.getLegend();
        legend.setPosition(LegendPosition.RIGHT_OF_CHART_INSIDE);
        legend.setTypeface(tf);
        
        YAxis leftAxis = mBarCharts.getAxisLeft();
        leftAxis.setTypeface(tf);
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(false);
        leftAxis.setSpaceTop(25f);
        mBarCharts.setData(getBarData());
        mBarCharts.getAxisRight().setEnabled(false);

	}
	private BarData getBarData(){
		  ArrayList<String> xVals = new ArrayList<String>();
	        for (int i = 0; i < 4; i++) {
	            xVals.add((i+1990) + "");
	        }

	        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
	        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
	        ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();

	        float mult = 10f;

	        for (int i = 0; i < 4; i++) {
	            float val = (float) (Math.random() * mult) + 3;
	            yVals1.add(new BarEntry(val, i));
	        }

	        for (int i = 0; i < 4; i++) {
	            float val = (float) (Math.random() * mult) + 3;
	            yVals2.add(new BarEntry(val, i));
	        }

	        for (int i = 0; i < 4; i++) {
	            float val = (float) (Math.random() * mult) + 3;
	            yVals3.add(new BarEntry(val, i));
	        }

	        // create 3 datasets with different types
	        BarDataSet set1 = new BarDataSet(yVals1, "养老院 A");
	        // set1.setColors(ColorTemplate.createColors(getApplicationContext(),
	        // ColorTemplate.FRESH_COLORS));
	        set1.setColor(Color.rgb(104, 241, 175));
	        BarDataSet set2 = new BarDataSet(yVals2, "养老院 B");
	        set2.setColor(Color.rgb(164, 228, 251));
	        BarDataSet set3 = new BarDataSet(yVals3, "养老院 C");
	        set3.setColor(Color.rgb(242, 247, 158));

	        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
	        dataSets.add(set1);
	        dataSets.add(set2);
	        dataSets.add(set3);

	        BarData data = new BarData(xVals, dataSets);
	        //data.setValueFormatter(new LargeValueFormatter());
	        // add space between the dataset groups in percent of bar-width
	        data.setGroupSpace(80f);
	        data.setValueTypeface(tf);
	        return data;
	}
	
}
