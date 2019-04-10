package com.ann.graphsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chart= findViewById(R.id.sales_chart);

        ArrayList<BarEntry> entries=new ArrayList<>();
        entries.add(new BarEntry(0f,78f));
        entries.add(new BarEntry(1f,45f));
        entries.add(new BarEntry(2f,20f));
        entries.add(new BarEntry(3f,41f));
        entries.add(new BarEntry(4f,56f));
        entries.add(new BarEntry(5f,12f));
        entries.add(new BarEntry(6f,35f));

        BarDataSet dataSet= new BarDataSet(entries,"Sales Per Day");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        final String[] days={"MON","TUE","WED","THUR","FRI","SAT","SUN"};

        ValueFormatter formatter=new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return days[(int)value];
            }
        };
        XAxis x = chart.getXAxis();
        x.setGranularity(1F);
        x.setValueFormatter(formatter);
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);

        BarData data=new BarData(dataSet);

        chart .setData(data);
        chart.animateXY(6000,6000);
        chart.invalidate();
    }
}
