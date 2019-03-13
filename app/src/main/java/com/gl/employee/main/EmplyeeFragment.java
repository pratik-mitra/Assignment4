package com.gl.employee.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gl.employee.R;
import com.gl.employee.adapter.CustomAdapter;
import com.gl.employee.model.Employee;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmplyeeFragment extends Fragment {

    private ListView employeeList;
    public static List<Employee> listEmployee = new ArrayList<>();
    public static int imgs[] = {R.drawable.employee_1, R.drawable.employee_2, R.drawable.employee_3};

    public EmplyeeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_emplyee, container, false);
        employeeList = (ListView) view.findViewById(R.id.simpleListView);
        listEmployee.add(createEmployee("pratik", "Software Engineer", imgs[0]));
        listEmployee.add(createEmployee("parshuram", "Software Tester", imgs[1]));
        listEmployee.add(createEmployee("pranay", "Software Developer", imgs[2]));

        CustomAdapter customAdapter = new CustomAdapter(getContext(), listEmployee, imgs);
        employeeList.setAdapter(customAdapter);

        employeeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs[position]);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("image", b);
                intent.putExtra("name", listEmployee.get(position).getName());
                intent.putExtra("designation", listEmployee.get(position).getDesignation());


                /*Bundle bundle = new Bundle();
                bundle.putString("name", listEmployee.get(position).getName());
                bundle.putInt("image", imgs[position]);
                DetailActivity detailActivity = new DetailActivity();*/
                startActivity(intent);
            }
        });
        return view;
    }

    private Employee createEmployee(String name , String designation, int img) {
        return new Employee(name, designation, img);
    }
}
