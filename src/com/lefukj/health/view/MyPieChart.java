package com.lefukj.health.view;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.lefukj.health.R;

public class MyPieChart {
	static PieChart mPieChart;
	static Context mContext;
	public static void initPieChart(View view,Context context){
		mContext=context;
		mPieChart=(PieChart) view.findViewById(R.id.view_pieChart);
		showChart(mPieChart, getPieData(20, 30));
	}
	
	 private static void showChart(PieChart pieChart, PieData pieData) {    
	        pieChart.setHoleColorTransparent(true);    
	    
	        pieChart.setHoleRadius(0);  //半径    
	        pieChart.setTransparentCircleRadius(0); // 半透明圈    
	        //pieChart.setHoleRadius(0)  //实心圆    
	    
	        pieChart.setDescription("老龄人统计图");    
	    
	        // mChart.setDrawYValues(true);    
	        //pieChart.setDrawCenterText(true);  //饼状图中间可以添加文字    
	    
	        pieChart.setDrawHoleEnabled(true);    
	    
	        pieChart.setRotationAngle(90); // 初始旋转角度    
	    
	        // draws the corresponding description value into the slice    
	        // mChart.setDrawXValues(true);    
	    
	        // enable rotation of the chart by touch    
	        pieChart.setRotationEnabled(true); // 可以手动旋转    
	    
	        // display percentage values    
	        pieChart.setUsePercentValues(true);  //显示成百分比    
	        // mChart.setUnit(" €");    
	        // mChart.setDrawUnitsInChart(true);    
	    
	        // add a selection listener    
//	      mChart.setOnChartValueSelectedListener(this);    
	        // mChart.setTouchEnabled(false);    
	    
//	      mChart.setOnAnimationListener(this);    
	    
	        //pieChart.setCenterText("");  //饼状图中间的文字    
	    
	        //设置数据    
	        pieChart.setData(pieData);     
	            
	        // undo all highlights    
//	      pieChart.highlightValues(null);    
//	      pieChart.invalidate();    
	    
	        Legend mLegend = pieChart.getLegend();  //设置比例图    
	        mLegend.setPosition(LegendPosition.BELOW_CHART_CENTER);  //最右边显示    
//	      mLegend.setForm(LegendForm.LINE);  //设置比例图的形状，默认是方形    
	        mLegend.setXEntrySpace(7f);    
	        mLegend.setYEntrySpace(1f);    
	            
	        pieChart.animateXY(1000, 1000);  //设置动画    
	        // mChart.spin(2000, 0, 360);    
	    }    
	    
	    /**  
	     *   
	     * @param count 分成几部分  
	     * @param range  
	     */    
	    private static PieData getPieData(int count, float range) {    
	            
	        ArrayList<String> xValues = new ArrayList<String>();  //xVals用来表示每个饼块上的内容    
	    
	        for (int i = 0; i < count; i++) {    
	            xValues.add("Quarterly" + (i + 1));  //饼块上显示成Quarterly1, Quarterly2, Quarterly3, Quarterly4    
	        }    
	    
	        ArrayList<Entry> yValues = new ArrayList<Entry>();  //yVals用来表示封装每个饼块的实际数据    
	    
	        // 饼图数据    
	        /**  
	         * 将一个饼形图分成四部分， 四部分的数值比例为14:14:34:38  
	         * 所以 14代表的百分比就是14%   
	         */    
	        float quarterly1 = 14;    
	        float quarterly2 = 14;    
	        float quarterly3 = 34;    
	        float quarterly4 = 38;    
	    
	        yValues.add(new Entry(quarterly1, 0));    
	        yValues.add(new Entry(quarterly2, 1));    
	        yValues.add(new Entry(quarterly3, 2));    
	        yValues.add(new Entry(quarterly4, 3));    
	    
	        //y轴的集合    
	        PieDataSet pieDataSet = new PieDataSet(yValues, ""/*显示在比例图上*/);   
	        
	        pieDataSet.setSliceSpace(1f); //设置个饼状图之间的距离    
	    
	        ArrayList<Integer> colors = new ArrayList<Integer>();    
	    
	        // 饼图颜色    
	        colors.add(Color.rgb(205, 205, 205));    
	        colors.add(Color.rgb(114, 188, 223));    
	        colors.add(Color.rgb(255, 123, 124));    
	        colors.add(Color.rgb(57, 135, 200));    
	    
	        pieDataSet.setColors(colors);    
	   
	        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();    
	        float px = 5 * (metrics.densityDpi / 160f);    
	        pieDataSet.setSelectionShift(px); // 选中态多出的长度    
	    
	        PieData pieData = new PieData(xValues, pieDataSet);    
	            
	        return pieData;    
	    }    
}
