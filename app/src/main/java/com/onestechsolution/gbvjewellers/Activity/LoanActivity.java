package com.onestechsolution.gbvjewellers.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.onestechsolution.gbvjewellers.R;

public class LoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
    }

    public void openNewLoanActivity(View view) {
        Intent intent = new Intent(this, NewLoanActivity.class);
        startActivity(intent);
    }

    public void openExistingLoanActivity(View view) {
        Intent intent = new Intent(this, ExistingLoanActivity.class);
        startActivity(intent);
    }
}
