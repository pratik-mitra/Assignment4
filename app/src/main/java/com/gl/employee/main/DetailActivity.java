package com.gl.employee.main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.gl.employee.R;
import com.gl.employee.model.Employee;

public class DetailActivity extends AppCompatActivity {

    private TextView mTextView;
    private ImageView imageView;
    private TextView mDesignation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util);
        mTextView = (TextView) findViewById(R.id.employeeNameTextView);
        imageView = (ImageView) findViewById(R.id.imageEmployee);
        mDesignation = (TextView) findViewById(R.id.employeeDesignationTextView);
        Intent intent = getIntent();

        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("image");

        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);

        String empName = intent.getStringExtra("name");
        String empDesignation = intent.getStringExtra("designation");
        if(empName!=null){
            mTextView.setText(empName);
            imageView.setImageBitmap(bmp);
            mDesignation.setText(empDesignation);
        }
    }
}
