package com.gl.employee.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.gl.employee.R;
import com.gl.employee.authentication.AuthenticateUser;
import com.gl.employee.model.Admin;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private Button loginButton;
    public Admin admin = new Admin();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(AuthenticateUser.isValidUser(createAdminUser())) {
                            Intent intent = new Intent(MainActivity.this , ListViewActivity.class);
                            startActivity(intent);
                        }
                        else {
                            final AlertDialog.Builder alertBox = new AlertDialog.Builder(MainActivity.this);
                            alertBox.setTitle("Login Failed");
                            alertBox.setMessage("User Name or Password is Wrong");

                            alertBox.setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });
                            alertBox.setNegativeButton("Reset",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(MainActivity.this , ResetActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                            alertBox.show();
                        }
                    }
                }
        );
    }

    public Admin createAdminUser() {

        userName  = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        admin.setUserName(userName.getText().toString());
        admin.setPassWord(password.getText().toString());
        return admin;
    }
}
