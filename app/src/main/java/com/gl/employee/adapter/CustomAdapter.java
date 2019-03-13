package com.gl.employee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gl.employee.R;
import com.gl.employee.model.Employee;

import java.util.List;


public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Employee> employeeList;
    int imgs[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<Employee> employeeList, int[] imgs) {
        this.context = context;
        this.employeeList = employeeList;
        this.imgs = imgs;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return employeeList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_employee, null);
        TextView employeeName = (TextView) view.findViewById(R.id.employeeName);
        ImageView icon = (ImageView) view.findViewById(R.id.imageDp);
        employeeName.setText(employeeList.get(i).getName());
        icon.setImageResource(imgs[i]);
        return view;
    }
}