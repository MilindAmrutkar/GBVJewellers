package com.onestechsolution.gbvjewellers.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.onestechsolution.gbvjewellers.Modal.Loan;
import com.onestechsolution.gbvjewellers.R;

import java.util.ArrayList;

/**
 * Created by Admin on 5/13/2017.
 */

public class LoanListAdapter extends ArrayAdapter<Loan> implements View.OnClickListener {

    private ArrayList<Loan> loanSet;
    Context mContext;

    private static class ViewHolder {
        ImageView ivCustomerPhoto;
        TextView tvCustName;
        TextView tvAmount;
        TextView tvLoanId;
        TextView tvContactNumber;
    }

    public LoanListAdapter(ArrayList<Loan> loan, Context context) {
        super(context, R.layout.loan_list, loan);
        this.loanSet = loan;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Loan loan = (Loan) object;

        switch(v.getId()) {

        }

    }

    private int lastPosition = -1;

    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        Loan loan = getItem(position);

        ViewHolder viewHolder;
        final View result;

        if(convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.loan_list, parent, false);

            viewHolder.ivCustomerPhoto = (ImageView) convertView.findViewById(R.id.iv_customer_photo_loan_activity);
            viewHolder.tvCustName = (TextView) convertView.findViewById(R.id.tv_cust_name_loan_list);
            viewHolder.tvAmount = (TextView) convertView.findViewById(R.id.tv_amount_loan_list);
            viewHolder.tvContactNumber = (TextView) convertView.findViewById(R.id.tv_contact_loan_list);
            viewHolder.tvLoanId = (TextView) convertView.findViewById(R.id.tv_loan_id_loan_list);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        result.setOnClickListener(this);
        result.setTag(position);

        viewHolder.tvCustName.setText(loan.getCustomerName());
        viewHolder.tvLoanId.setText(loan.getUniqueLoanId());
        viewHolder.tvContactNumber.setText(loan.getCustomerContactNumber());
        viewHolder.tvAmount.setText((int) loan.getAmount());
        return convertView;
    }
}
