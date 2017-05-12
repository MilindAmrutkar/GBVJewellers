package com.onestechsolution.gbvjewellers.Asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.onestechsolution.gbvjewellers.Modal.Loan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import static android.content.ContentValues.TAG;

/**
 * Created by PSGanesh on 5/6/17.
 */

public class SendLoanDetails extends AsyncTask<String, String, String> {
    private ProgressDialog progressDialog;
    private Context context;
    private String loginId, password;
   Loan loan = new Loan();

    public SendLoanDetails(Context context, Loan loan) {
        this.context = context;
        this.loan = loan;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Please wait..","Uploading details..");
        progressDialog.setCancelable(true);
    }

    @Override
    protected String doInBackground(String[] params) {

        try {
            loginId =  params[0];
            password =  params[1];

            String uniqueId = loan.getUniqueLoanId();
            String name = loan.getCustomerName();
            String contact = loan.getCustomerContactNumber();
            double amount = loan.getAmount();
            double percentage =loan.getPercentage();
            int totalItemTypes = loan.getNoOfTypesOfItems();
            String description = loan.getDescription();
            String personPhoto = loan.getCustomerPhoto();

            double itemWeight1 = loan.getItem1Weight();
            String photoPath1 = loan.getItem1PhotoPath();
            String item1Type = loan.getItem1Type();
            int item1Count = loan.getItem1Count();

            double itemWeight2 = loan.getItem2Weight();
            String photoPath2 = loan.getItem2PhotoPath();
            String item2Type = loan.getItem2Type();
            int item2Count = loan.getItem2Count();

            double itemWeight3 = loan.getItem3Weight();
            String photoPath3 = loan.getItem3PhotoPath();
            String item3Type = loan.getItem3Type();
            int item3Count = loan.getItem3Count();

            double itemWeight4 = loan.getItem4Weight();
            String photoPath4 = loan.getItem4PhotoPath();
            String item4Type = loan.getItem4Type();
            int item4Count = loan.getItem4Count();

            double itemWeight5 = loan.getItem5Weight();
            String photoPath5 = loan.getItem5PhotoPath();
            String item5Type = loan.getItem5Type();
            int item5Count = loan.getItem5Count();

            double itemWeight6 = loan.getItem6Weight();
            String photoPath6 = loan.getItem6PhotoPath();
            String item6Type = loan.getItem6Type();
            int item6Count = loan.getItem6Count();

            double itemWeight7 = loan.getItem7Weight();
            String photoPath7 = loan.getItem7PhotoPath();
            String item7Type = loan.getItem7Type();
            int item7Count = loan.getItem7Count();

            double itemWeight8 = loan.getItem8Weight();
            String photoPath8 = loan.getItem8PhotoPath();
            String item8Type = loan.getItem8Type();
            int item8Count = loan.getItem8Count();



            Log.i(TAG, "doInBackground: username: "+loginId+" password: "+password);
            String link = "http://onestechsolution.com/gbvjewellers/insertLoanRecords.php";
            String data = URLEncoder.encode("username", "UTF-8") + "=" +
                    URLEncoder.encode(loginId, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                    URLEncoder.encode(password, "UTF-8");
            data += "&" + URLEncoder.encode("uniqueId", "UTF-8") + "=" +
                    URLEncoder.encode(uniqueId, "UTF-8");
            data += "&" + URLEncoder.encode("name", "UTF-8") + "=" +
                    URLEncoder.encode(name, "UTF-8");
            data += "&" + URLEncoder.encode("contact", "UTF-8") + "=" +
                    URLEncoder.encode(contact, "UTF-8");
            data += "&" +URLEncoder.encode("amount", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(amount), "UTF-8");
            data += "&" + URLEncoder.encode("percentage", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(percentage), "UTF-8");
            data += "&" + URLEncoder.encode("totalItemTypes", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(totalItemTypes), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight1", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight1), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight2", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight2), "UTF-8");
            data += "&" + URLEncoder.encode("description", "UTF-8") + "=" +
                    URLEncoder.encode(description, "UTF-8");

            Log.i(TAG, "doInBackground: data: "+data);

            URL url = new URL(link);
            URLConnection conn = url.openConnection();

            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.write(data);
            wr.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = reader.readLine()) !=null) {
                sb.append(line);
                break;
            }
            Log.i(TAG, "doInBackground: Response: "+sb.toString());
            return sb.toString();

        } catch(Exception e) {
            return new String("Exception: "+e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result) {
        progressDialog.dismiss();
        Log.i(TAG, "onPostExecute: Result: "+result);
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
    }
}


