package com.onestechsolution.gbvjewellers.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.onestechsolution.gbvjewellers.Adapters.LoanListAdapter;
import com.onestechsolution.gbvjewellers.Modal.Loan;
import com.onestechsolution.gbvjewellers.R;

import java.util.ArrayList;

public class ExistingLoanActivity extends AppCompatActivity {
    ArrayList<Loan> loanArrayList;
    ListView listView;
    private static LoanListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_existing_loan);

        listView = (ListView) findViewById(R.id.lv_customer_loan_existing_loan_activity);
        loanArrayList = new ArrayList<>();

        loanArrayList.add(new Loan("L1_20170412_123456", "Mohit Jadhav", "photo1","9823493600",1234234));
        loanArrayList.add(new Loan("L2_20170412_123456", "Mangal Bind", "photo2","97223434600",100000));
        loanArrayList.add(new Loan("L3_20170412_123456", "Ganesh Achary", "photo3","902349323430",123424334));
        loanArrayList.add(new Loan("L4_20170412_123456", "Srinivas Cheruku", "photo4","925340",903629364));

        adapter = new LoanListAdapter(loanArrayList, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CustomerOrEmiActivity.class);
                startActivity(intent);
            }
        });
    }
}
