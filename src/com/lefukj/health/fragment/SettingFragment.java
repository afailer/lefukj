package com.lefukj.health.fragment;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.lefukj.health.R;
import com.lefukj.health.view.MyBarChart;
import com.lefukj.health.view.MyBarCharts;
import com.lefukj.health.view.MyPieChart;

public class SettingFragment extends BaseFragment{
	
	RelativeLayout rl_setting;
	LineChart mLineChart;
	View view;
	Button btn;
	LineData mLineData;
	
	BarChart mBarChart;
	
	@Override
	public View initView() {
		// TODO Auto-generated method stub
		view=View.inflate(getActivity(), R.layout.settingfragment, null);
		//rl_setting=(RelativeLayout) view.findViewById(R.id.rl_setting);
		//rl_setting.addView(xyChart.getLineChartView(getActivity()));
		initChart();
		initBarChart();
		return view;
	}
	
	private void initBarChart(){
		MyBarChart.initBarChart(view);
		MyPieChart.initPieChart(view,getActivity());
		new MyBarCharts().initBarChart(view, getActivity());
	}
	
	private void initChart() {
		// TODO Auto-generated method stub
		mLineChart=(LineChart) view.findViewById(R.id.view_lineChart);
		mLineData=getLineData(60,100);
		btn=(Button) view.findViewById(R.id.refresh);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showChart(mLineChart, mLineData, Color.rgb(84, 188, 223));
			}
		});
		showChart(mLineChart, mLineData, Color.rgb(114, 188, 223));
	}
	private void showChart(LineChart lineChart, LineData mLineData, int rgb) {
		// TODO Auto-generated method stub
		lineChart.setDrawBorders(true);
		//lineChart.setDescription("心跳");//对图表的描述
		lineChart.setDrawGridBackground(false);//是否显示表格颜色
		
		lineChart.setDragEnabled(true);//是否可以拖拽
		lineChart.setScaleEnabled(false);//设置是否可以缩放
		lineChart.setBackgroundColor(rgb);//设置颜色
		
		
	/*	YLabels y = chart.getYLabels(); // y轴的标示
	    y.setTextColor(Color.WHITE);
	    y.setTypeface(mTf);
	    y.setLabelCount(4); // y轴上的标签的显示的个数
*/		
		lineChart.setData(mLineData);
		Legend legend=lineChart.getLegend();//设置比例图标示，就是那个一组y的value的 
		legend.setForm(LegendForm.CIRCLE);// 样式    
		legend.setFormSize(6f);// 字体    
		legend.setTextColor(Color.BLACK);// 颜色    
		lineChart.animateX(5000);
		
	}
	/**  
     * 生成一个数据  
     * @param count 表示图表中有多少个坐标点  
     * @param range 用来生成range以内的随机数  
     * @return  
     */   
	int t=1;
	private LineData getLineData(int count,float range) {
		// TODO Auto-generated method stub
		ArrayList<String> xValues = new ArrayList<String>();
		 for (int i = 0; i < count; i++) {    
	            // x轴显示的数据，这里默认使用数字下标显示    
	            xValues.add("时间" + i);    
	     }  
		 
	 // y轴的数据    
        ArrayList<Entry> yValues = new ArrayList<Entry>();    
        for (int i = 0; i < count; i++) {    
            float value = (float) (Math.random() * range);    
            yValues.add(new Entry(value, i));    
        }  
        
        LineDataSet lineDataSet = new LineDataSet(yValues, "心跳折线图" /*显示在比例图上*/);
        
        
        //用y轴的集合来设置参数    
        
        if(t%2==1){
        	showBg(lineDataSet);
        	t++;
        }
        
        
        lineDataSet.setLineWidth(2.75f); // 线宽    
        lineDataSet.setCircleSize(5f);// 显示的圆形大小    
        lineDataSet.setColor(Color.WHITE);// 显示颜色    
        lineDataSet.setCircleColor(Color.RED);// 圆形的颜色    
        lineDataSet.setHighLightColor(Color.BLUE); // 高亮的线的颜色    
        
        
        ArrayList<LineDataSet> lineDataSets = new ArrayList<LineDataSet>();    
        lineDataSets.add(lineDataSet); // add the datasets    
        
        LineData lineData=new LineData(xValues, lineDataSets);
		
		return lineData;
	}
	private void showBg(LineDataSet lineDataSet) {
		lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawCubic(true);
        lineDataSet.setCubicIntensity(0.6f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.rgb(0, 255, 255));
	}
	

}
