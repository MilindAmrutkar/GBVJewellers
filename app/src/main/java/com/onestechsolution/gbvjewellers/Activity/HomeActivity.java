package com.onestechsolution.gbvjewellers.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.onestechsolution.gbvjewellers.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void openLoanActivity(View view) {
        Intent intent = new Intent(this, LoanActivity.class);
        startActivity(intent);
    }

    public void openOrderActivity(View view) {
        Toast.makeText(this, "Coming soon....", Toast.LENGTH_SHORT).show();
    }

    public void openWorkerActivity(View view) {
        Toast.makeText(this, "Coming soon....", Toast.LENGTH_SHORT).show();
    }

    public void openQRCodeActivity(View view) {
        Toast.makeText(this, "Coming soon....", Toast.LENGTH_SHORT).show();
    }
}
