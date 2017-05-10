package com.onestechsolution.gbvjewellers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.onestechsolution.gbvjewellers.Activity.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    String userName, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText) findViewById(R.id.et_username_login_activity);
        etPassword = (EditText) findViewById(R.id.et_password_login_activity);
    }

    public void openForgetPasswordActivity(View view) {
    }


    public void openHomeActivity(View view) {
        userName = etUsername.getText().toString();
        password = etPassword.getText().toString();

        if(userName!=null && !userName.isEmpty() && password!=null && !password.isEmpty())
        {
            if (userName.equalsIgnoreCase("admin") && (password.equalsIgnoreCase("admin"))) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        LoginActivity.this.finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
