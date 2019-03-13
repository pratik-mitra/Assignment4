package com.gl.employee.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gl.employee.R;
import com.gl.employee.authentication.AuthenticateUser;
import com.gl.employee.validation.FieldValidation;

public class ResetActivity extends AppCompatActivity {

    private EditText newPassword;
    private EditText reNewPassword;
    private Button resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        newPassword = (EditText) findViewById(R.id.newPassword);
        reNewPassword = (EditText) findViewById(R.id.reNewPassword);

        resetButton = (Button)findViewById(R.id.resetButton);
        resetButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(FieldValidation.isValidatePasswordEntry(newPassword.getText().toString(), reNewPassword.getText().toString())) {
                            String password = newPassword.getText().toString();
                            Log.i("new Password is:::",password);
                            AuthenticateUser.changePassword(password);
                            Intent intent = new Intent(ResetActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast t = Toast.makeText(getApplicationContext(), "Both Fields must be same", Toast.LENGTH_SHORT);
                            t.show();
                        }
                    }
                }
        );
    }
}
