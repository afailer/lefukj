package com.lefukj.health.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.lefukj.health.R;
import com.lefukj.health.ui.MapClientActivity;
import com.lefukj.health.view.BarChartItem;
import com.lefukj.health.view.ChartItem;
import com.lefukj.health.view.LineChartItem;
import com.lefukj.health.view.PieChartItem;

public class GuideFragment extends BaseFragment{
	/*Button btn,barchart;
	
	RelativeLayout relativeLayout,rl_barChart;
	BlackBackground back;
	ArrayList<ChartPoint> cps=new ArrayList<>();
	BudgetChart budget=new BudgetChart();
	HorizontalScrollView hsv;*/
	ListView lv;
	Button btn;
	@Override
	public View initView() {
		// TODO Auto-generated method stub
		View view=View.inflate(getActivity(), R.layout.firstfragment, null);
		btn=(Button) view.findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), MapClientActivity.class));
			}
		});
		lv=(ListView) view.findViewById(R.id.lv);
		ArrayList<ChartItem> list = new ArrayList<ChartItem>();
		for (int i = 0; i < 30; i++) {
            
            if(i % 3 == 0) {
                list.add(new LineChartItem(generateDataLine(i + 1), getActivity()));
            } else if(i % 3 == 1) {
                list.add(new BarChartItem(generateDataBar(i + 1), getActivity()));
            } else if(i % 3 == 2) {
                list.add(new PieChartItem(generateDataPie(i + 1), getActivity()));
            }
        }

        ChartDataAdapter cda = new ChartDataAdapter(getActivity(), list);
        lv.setAdapter(cda);
		
		
	/*	btn=(Button) view.findViewById(R.id.btn_first);
		relativeLayout=(RelativeLayout) view.findViewById(R.id.myChart);
		rl_barChart=(RelativeLayout) view.findViewById(R.id.barChart);
		//relativeLayout.addView(barChart.execute(getActivity()));
		
		final BudgetChart budget=new BudgetChart();
		View executes = budget.executes(getActivity());
		
		executes.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getActivity(), "text", 1).show();
			}
		});
		relativeLayout.addView(executes);
		//back=(BlackBackground) view.findViewById(R.id.back_ground);
		for(int i=0;i<100;i++){
			ChartPoint cp=new ChartPoint();
			cp.setX(0);
			cp.setY((int)(Math.random()*50));
			cps.add(cp);
		}
		//back.getDataFromNet(cps);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//startActivity(budget.execute(getActivity()));
				startActivity(new Intent(getActivity(), ChartActivity.class));
				
			}
		});*/
		return view;
	}
	
	private LineData generateDataLine(int cnt) {

        ArrayList<Entry> e1 = new ArrayList<Entry>();

        for (int i = 0; i < 12; i++) {
            e1.add(new Entry((int) (Math.random() * 65) + 40, i));
        }

        LineDataSet d1 = new LineDataSet(e1, "New DataSet " + cnt + ", (1)");
        d1.setLineWidth(2.5f);
        d1.setCircleSize(4.5f);
        d1.setHighLightColor(Color.rgb(244, 117, 117));
        d1.setDrawValues(false);
        
        ArrayList<Entry> e2 = new ArrayList<Entry>();

        for (int i = 0; i < 12; i++) {
            e2.add(new Entry(e1.get(i).getVal() - 30, i));
        }

        LineDataSet d2 = new LineDataSet(e2, "New DataSet " + cnt + ", (2)");
        d2.setLineWidth(2.5f);
        d2.setCircleSize(4.5f);
        d2.setHighLightColor(Color.rgb(244, 117, 117));
        d2.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setCircleColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        d2.setDrawValues(false);
        
        ArrayList<LineDataSet> sets = new ArrayList<LineDataSet>();
        sets.add(d1);
        sets.add(d2);
        
        LineData cd = new LineData(getMonths(), sets);
        return cd;
    }
    
    
    private BarData generateDataBar(int cnt) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < 12; i++) {
            entries.add(new BarEntry((int) (Math.random() * 70) + 30, i));
        }

        BarDataSet d = new BarDataSet(entries, "New DataSet " + cnt);
        d.setBarSpacePercent(20f);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setHighLightAlpha(255);
        
        BarData cd = new BarData(getMonths(), d);
        return cd;
    }
    
    /**
     * generates a random ChartData object with just one DataSet
     * 
     * @return
     */
    private PieData generateDataPie(int cnt) {

        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (int i = 0; i < 4; i++) {
            entries.add(new Entry((int) (Math.random() * 70) + 30, i));
        }

        PieDataSet d = new PieDataSet(entries, "");
        
        // space between slices
        d.setSliceSpace(2f);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        
        PieData cd = new PieData(getQuarters(), d);
        return cd;
    }
	
	   private class ChartDataAdapter extends ArrayAdapter<ChartItem> {
	        
	        public ChartDataAdapter(Context context, List<ChartItem> objects) {
	            super(context, 0, objects);
	        }

	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            return getItem(position).getView(position, convertView, getContext());
	        }
	        
	        @Override
	        public int getItemViewType(int position) {           
	            // return the views type
	            return getItem(position).getItemType();
	        }
	        
	        @Override
	        public int getViewTypeCount() {
	            return 3; // we have 3 different item-types
	        }
	    }
	   private ArrayList<String> getQuarters() {
	        
	        ArrayList<String> q = new ArrayList<String>();
	        q.add("1st Quarter");
	        q.add("2nd Quarter");
	        q.add("3rd Quarter");
	        q.add("4th Quarter");
	        
	        return q;
	    }

	    private ArrayList<String> getMonths() {

	        ArrayList<String> m = new ArrayList<String>();
	        m.add("Jan");
	        m.add("Feb");
	        m.add("Mar");
	        m.add("Apr");
	        m.add("May");
	        m.add("Jun");
	        m.add("Jul");
	        m.add("Aug");
	        m.add("Sep");
	        m.add("Okt");
	        m.add("Nov");
	        m.add("Dec");

	        return m;
	    }

}
