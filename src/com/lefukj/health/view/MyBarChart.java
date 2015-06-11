package com.lefukj.health.view;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.lefukj.health.R;

public class MyBarChart {
	static BarChart mBarChart;
	public static void initBarChart(View view) {
		// TODO Auto-generated method stub
		mBarChart=(BarChart) view.findViewById(R.id.view_barChart);
		mBarChart.setDrawBorders(false);
        
        mBarChart.setDescription("");// 数据描述      
          
        // 如果没有数据的时候，会显示这个，类似ListView的EmptyView      
        mBarChart.setNoDataTextDescription("You need to provide data for the chart.");      
                 
        mBarChart.setDrawGridBackground(true); // 是否显示表格颜色      
        mBarChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度      
        
        mBarChart.setTouchEnabled(true); // 设置是否可以触摸      
       
        mBarChart.setDragEnabled(true);// 是否可以拖拽      
        mBarChart.setScaleEnabled(true);// 是否可以缩放      
        mBarChart.setPinchZoom(false);
        
//      barChart.setBackgroundColor();// 设置背景      
        
        mBarChart.setDrawBarShadow(true);  
         
        mBarChart.setData(getBarData(5, 20)); // 设置数据      
  
        Legend mLegend = mBarChart.getLegend(); // 设置比例图标示  
      
        mLegend.setForm(LegendForm.LINE);// 样式      
        mLegend.setFormSize(6f);// 字体      
        mLegend.setTextColor(Color.BLACK);// 颜色      
          
//      X轴设定  
//      XAxis xAxis = mBarChart.getXAxis();  
//      xAxis.setPosition(XAxisPosition.BOTTOM);  
      
        mBarChart.animateX(2500); // 立即执行的动画,x轴  
	}
	
	private static  BarData getBarData(int count, float range) {  
        ArrayList<String> xValues = new ArrayList<String>();  
        for (int i = 0; i < count; i++) {  
            xValues.add("第" + (i + 1) + "养老院");  
        }  
          
        ArrayList<BarEntry> yValues = new ArrayList<BarEntry>();  
          
        for (int i = 0; i < count; i++) {      
            float value = (float) (Math.random() * range/*100以内的随机数*/) + 3;  
            yValues.add(new BarEntry(value, i));      
        }  
          
        // y轴的数据集合      
        BarDataSet barDataSet = new BarDataSet(yValues, "柱状图");   
          
        barDataSet.setColor(Color.rgb(114, 188, 223));  
      
        ArrayList<BarDataSet> barDataSets = new ArrayList<BarDataSet>();      
        barDataSets.add(barDataSet); // add the datasets      
      
        BarData barData = new BarData(xValues, barDataSets);  
          
        return barData;  
    } 
}
