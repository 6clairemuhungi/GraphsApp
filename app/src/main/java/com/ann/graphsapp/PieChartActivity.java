package com.ann.graphsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    PieChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        chart = findViewById(R.id.chart_phones);
        Description desc=new Description();
        desc.setText("Phone MarketShare in Kenya");
        chart.setDescription(desc);

        chart.setRotationEnabled(true);
        chart.setHoleRadius(25f);
        chart.setCenterText("Phones");

        ArrayList<PieEntry> yEntries= new ArrayList<>();
        yEntries.add(new PieEntry(0f, 20f));
        yEntries.add(new PieEntry(1f, 31f));
        yEntries.add(new PieEntry(2f, 42f));
        yEntries.add(new PieEntry(3f, 53f));
        yEntries.add(new PieEntry(4f, 64f));
        yEntries.add(new PieEntry(5f, 75f));

        ArrayList<String> xEntries=new ArrayList<>();
        xEntries.add("IPhone");
        xEntries.add("Sumsung");
        xEntries.add("Huawei");
        xEntries.add("Tekno");
        xEntries.add("Infinix");
        xEntries.add("Nokia");

        PieDataSet dataSet=new PieDataSet(yEntries,"Share By Phones");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setSliceSpace(2);
        dataSet.setValueTextSize(12);

        PieData data =new PieData(dataSet);

        chart.setData(data);
        chart.animateXY(3000,3000);
        chart.invalidate();
    }
}
