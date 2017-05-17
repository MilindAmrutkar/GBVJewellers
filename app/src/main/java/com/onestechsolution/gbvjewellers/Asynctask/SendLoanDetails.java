package com.onestechsolution.gbvjewellers.Asynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.onestechsolution.gbvjewellers.Modal.Loan;
import com.onestechsolution.gbvjewellers.Utilities.Utilities;

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
    //private static final String UPLOAD_URL = "http://onestechsolution.com/gbvjewellers/upload.php";
    //private static final String UPLOAD_URL = "http://192.168.0.102:8080/Photoupload/upload.php";
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
            String personPhoto = Utilities.getStringImage(loan.getBmpPersonPhoto());

            //For Item1
            double itemWeight1 = loan.getItem1Weight();
            //String photoPath1 = loan.getItem1PhotoPath();
            String photoPath1 = Utilities.getStringImage(loan.getBmpItem1());
            String item1Type = loan.getItem1Type();
            int item1Count = loan.getItem1Count();

            //For Item2
            double itemWeight2 = loan.getItem2Weight();
            String photoPath2 = Utilities.getStringImage(loan.getBmpItem2());
            String item2Type = loan.getItem2Type();
            int item2Count = loan.getItem2Count();

            //For Item3
            double itemWeight3 = loan.getItem3Weight();
            String photoPath3 = Utilities.getStringImage(loan.getBmpItem3());
            String item3Type = loan.getItem3Type();
            int item3Count = loan.getItem3Count();

            //For Item4
            double itemWeight4 = loan.getItem4Weight();
            String photoPath4 = Utilities.getStringImage(loan.getBmpItem4());
            String item4Type = loan.getItem4Type();
            int item4Count = loan.getItem4Count();

            //For Item5
            double itemWeight5 = loan.getItem5Weight();
            String photoPath5 = Utilities.getStringImage(loan.getBmpItem5());
            String item5Type = loan.getItem5Type();
            int item5Count = loan.getItem5Count();

            //For Item6
            double itemWeight6 = loan.getItem6Weight();
            String photoPath6 = Utilities.getStringImage(loan.getBmpItem6());
            String item6Type = loan.getItem6Type();
            int item6Count = loan.getItem6Count();

            //For Item7
            double itemWeight7 = loan.getItem7Weight();
            String photoPath7 = Utilities.getStringImage(loan.getBmpItem7());
            String item7Type = loan.getItem7Type();
            int item7Count = loan.getItem7Count();

            //For Item8
            double itemWeight8 = loan.getItem8Weight();
            String photoPath8 = Utilities.getStringImage(loan.getBmpItem8());
            String item8Type = loan.getItem8Type();
            int item8Count = loan.getItem8Count();



            Log.i(TAG, "doInBackground: username: "+loginId+" password: "+password);
            //String link = "http://onestechsolution.com/gbvjewellers/insertLoanRecords.php";
            String link = "http://192.168.0.102:8080/Photoupload/insertLoanRecords.php";
            String data = URLEncoder.encode("username", "UTF-8") + "=" +
                    URLEncoder.encode(loginId, "UTF-8");    //1
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                    URLEncoder.encode(password, "UTF-8");   //2

            data += "&" + URLEncoder.encode("uniqueId", "UTF-8") + "=" +
                    URLEncoder.encode(uniqueId, "UTF-8");   //3

            data += "&" + URLEncoder.encode("name", "UTF-8") + "=" +
                    URLEncoder.encode(name, "UTF-8");   //4
            data += "&" + URLEncoder.encode("contact", "UTF-8") + "=" +
                    URLEncoder.encode(contact, "UTF-8");   //5
            data += "&" + URLEncoder.encode("personPhoto", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(personPhoto),"UTF-8");   //6
            data += "&" +URLEncoder.encode("amount", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(amount), "UTF-8");   //7
            data += "&" + URLEncoder.encode("percentage", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(percentage), "UTF-8");   //8
            data += "&" + URLEncoder.encode("totalItemTypes", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(totalItemTypes), "UTF-8");   //9
            data += "&" + URLEncoder.encode("description", "UTF-8") + "=" +
                    URLEncoder.encode(description, "UTF-8");   //10

            data += "&" + URLEncoder.encode("photoPath1", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(photoPath1), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight1", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight1), "UTF-8");
            data += "&" + URLEncoder.encode("item1Type", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item1Type), "UTF-8");
            data += "&" + URLEncoder.encode("item1Count", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item1Count), "UTF-8");

            data += "&" + URLEncoder.encode("photoPath2", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(photoPath2), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight2", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight2), "UTF-8");
            data += "&" + URLEncoder.encode("item2Type", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item2Type), "UTF-8");
            data += "&" + URLEncoder.encode("item2Count", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item2Count), "UTF-8");

            data += "&" + URLEncoder.encode("photoPath3", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(photoPath3), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight3", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight3), "UTF-8");
            data += "&" + URLEncoder.encode("item3Type", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item3Type), "UTF-8");
            data += "&" + URLEncoder.encode("item3Count", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item3Count), "UTF-8");

            data += "&" + URLEncoder.encode("photoPath4", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(photoPath4), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight4", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight4), "UTF-8");
            data += "&" + URLEncoder.encode("item4Type", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item4Type), "UTF-8");
            data += "&" + URLEncoder.encode("item4Count", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item4Count), "UTF-8");

            data += "&" + URLEncoder.encode("photoPath5", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(photoPath5), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight5", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight5), "UTF-8");
            data += "&" + URLEncoder.encode("item5Type", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item5Type), "UTF-8");
            data += "&" + URLEncoder.encode("item5Count", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item5Count), "UTF-8");

            data += "&" + URLEncoder.encode("photoPath6", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(photoPath6), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight6", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight6), "UTF-8");
            data += "&" + URLEncoder.encode("item6Type", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item6Type), "UTF-8");
            data += "&" + URLEncoder.encode("item6Count", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item6Count), "UTF-8");

            data += "&" + URLEncoder.encode("photoPath7", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(photoPath7), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight7", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight7), "UTF-8");
            data += "&" + URLEncoder.encode("item7Type", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item7Type), "UTF-8");
            data += "&" + URLEncoder.encode("item7Count", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item7Count), "UTF-8");

            data += "&" + URLEncoder.encode("photoPath8", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(photoPath8), "UTF-8");
            data += "&" + URLEncoder.encode("itemWeight8", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(itemWeight8), "UTF-8");
            data += "&" + URLEncoder.encode("item8Type", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item8Type), "UTF-8");
            data += "&" + URLEncoder.encode("item8Count", "UTF-8") + "=" +
                    URLEncoder.encode(String.valueOf(item8Count), "UTF-8");

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


